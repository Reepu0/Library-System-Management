package app;

public class RegularUser extends User {
    public RegularUser(String name) {
        super(name, "Regular");
    }

    @Override
    public void performActions() {
        System.out.println(name + " is performing regular user actions.");
    }
}
