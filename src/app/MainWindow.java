package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow {
    private JFrame frame;
    private BookManager bookManager;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;
    private User currentUser;

    public MainWindow(User user) {
        currentUser = user;
        bookManager = BookManager.getInstance();

        frame = new JFrame("Library Management");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Create a list model and populate it with available books
        bookListModel = new DefaultListModel<>();
        updateBookList(); // Initially update the book list

        // Create the JList and add it to a scroll pane
        bookList = new JList<>(bookListModel);
        JScrollPane bookListScrollPane = new JScrollPane(bookList);
        bookListScrollPane.setPreferredSize(new Dimension(250, 300));

        // Buttons for borrowing or returning a book
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton borrowButton = new JButton("Borrow Book");
        JButton returnButton = new JButton("Return Book");
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton logoutButton = new JButton("Logout");

        // Add the appropriate buttons based on the user type
        if (currentUser instanceof AdminUser) {
            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
        } else if (currentUser instanceof RegularUser) {
            buttonPanel.add(borrowButton);
            buttonPanel.add(returnButton);
        }

        buttonPanel.add(logoutButton);

        // Button Actions
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = bookList.getSelectedValue();
                if (selectedBook != null) {
                    for (Book book : bookManager.getBooks()) {
                        if (book.toString().equals(selectedBook) && !book.isBorrowed()) {
                            book.setBorrowed(true);
                            JOptionPane.showMessageDialog(frame, "Book borrowed successfully!");
                            updateBookList(); // Update the book list
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a book to borrow.");
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = bookList.getSelectedValue();
                if (selectedBook != null) {
                    for (Book book : bookManager.getBooks()) {
                        if (book.toString().equals(selectedBook) && book.isBorrowed()) {
                            book.setBorrowed(false);
                            JOptionPane.showMessageDialog(frame, "Book returned successfully!");
                            updateBookList(); // Update the book list
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a book to return.");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookWindow(MainWindow.this); // Pass MainWindow reference
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBook = bookList.getSelectedValue();
                if (selectedBook != null) {
                    Book bookToRemove = null;
                    for (Book book : bookManager.getBooks()) {
                        if (book.toString().equals(selectedBook)) {
                            bookToRemove = book;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        try {
                            bookManager.removeBook(bookToRemove);
                            JOptionPane.showMessageDialog(frame, "Book removed successfully!");
                            updateBookList(); // Update the book list
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Selected book not found!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a book to remove.");
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginWindow();
            }
        });

        // Add a header panel
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Welcome to the Library Management System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerPanel.add(headerLabel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(bookListScrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Update the book list based on the current books in the library
    public void updateBookList() {
        bookListModel.clear();
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            bookListModel.addElement(book.toString()); // Display the updated list of books
        }
    }
}
