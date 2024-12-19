package app;

public class AdminUser extends User {
    public AdminUser(String name) {
        super(name, "Admin");
    }

    @Override
    public void performActions() {
        System.out.println(name + " is performing admin actions.");
    }
}
