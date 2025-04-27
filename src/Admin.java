public class Admin extends User{
    private String id = "admin";
    private String pwd = "1234";

    public Admin(String name, String phone) {
        super(name, phone);
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }
}
