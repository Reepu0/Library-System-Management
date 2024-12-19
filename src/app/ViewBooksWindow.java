package app;

import javax.swing.*;
import java.awt.*;
import java.util.List;

// نافذة عرض الكتب
public class ViewBooksWindow {
    private JFrame frame;
    private BookManager bookManager;
    private DefaultListModel<String> bookListModel;
    private JList<String> bookList;

    public ViewBooksWindow() {
        bookManager = BookManager.getInstance();

        frame = new JFrame("View Books");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // إعداد القائمة والنموذج
        bookListModel = new DefaultListModel<>();
        updateBookList();

        bookList = new JList<>(bookListModel);
        bookList.setFont(new Font("Arial", Font.PLAIN, 14)); // ضبط خط العناصر
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane bookListScrollPane = new JScrollPane(bookList);
        bookListScrollPane.setPreferredSize(new Dimension(400, 300));

        // إعداد العنوان
        JPanel headerPanel = new JPanel();
        JLabel headerLabel = new JLabel("Available Books");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(new Color(34, 139, 34));
        headerPanel.add(headerLabel);

        // إعداد اللوحة الرئيسية
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(bookListScrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // تحديث قائمة الكتب بناءً على الكتب الحالية في المكتبة
    private void updateBookList() {
        bookListModel.clear();
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            bookListModel.addElement(book.toString());
        }
    }

    public static void main(String[] args) {
        new ViewBooksWindow();
    }
}
