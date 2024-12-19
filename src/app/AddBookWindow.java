package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookWindow {
    private JFrame frame;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField categoryField;
    private BookManager bookManager;
    private BookFactory bookFactory;
    private MainWindow mainWindow;

    public AddBookWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        bookManager = BookManager.getInstance();
        bookFactory = new BookFactory(); // إنشاء مصنع الكتب

        frame = new JFrame("Add Book");
        frame.setSize(600, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(titleLabel);

        titleField = new JTextField();
        titleField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(authorLabel);

        authorField = new JTextField();
        authorField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(authorField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(categoryLabel);

        categoryField = new JTextField();
        categoryField.setFont(new Font("Arial", Font.PLAIN, 14));
        formPanel.add(categoryField);

        JButton addButton = new JButton("Add Book");
        addButton.setBackground(new Color(50, 150, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setPreferredSize(new Dimension(120, 40));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText().trim();
                String author = authorField.getText().trim();
                String category = categoryField.getText().trim();

                if (title.isEmpty() || author.isEmpty() || category.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!");
                    return;
                }

                try {
                    Book book = bookFactory.createBook(category, title, author);
                    if (book != null) {
                        bookManager.getBooks().add(book);
                        JOptionPane.showMessageDialog(frame, "Book added successfully!");
                        mainWindow.updateBookList();
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid category entered!");
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);

        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow mainWindow = new MainWindow(new RegularUser("TestUser"));
            new AddBookWindow(mainWindow);
        });
    }
}
