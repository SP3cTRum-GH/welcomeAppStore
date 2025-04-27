public class User {
    private String name;
    private String phone;
    private String cardNumber;

    public User() {
        this(null,null);
    }

    public User(String name, String phone) {
        this(name,phone,null);
    }

    public User(String name, String phone, String cardNumber) {
        this.name = name;
        this.phone = phone;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
