package app;

public class UserFactory {
    public User createUser(String type, String name) {
        switch (type) {
            case "Admin":
                return new AdminUser(name);
            case "Regular":
                return new RegularUser(name);
            default:
                return null;
        }
    }
}
