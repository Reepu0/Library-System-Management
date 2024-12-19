package app;

public class BookFactory {
public Book createBook(String type, String title, String author) {
    switch (type) {
        case "Software":
            return new SoftwareEngineeringBook(title, author); // تمرير العنوان والمؤلف
        case "Management":
            return new ManagementBook(title, author); // تمرير العنوان والمؤلف
        case "AI":
            return new AIBook(title, author); // تمرير العنوان والمؤلف
        default:
            return null; // في حال كانت الفئة غير معروفة
    }
}
}