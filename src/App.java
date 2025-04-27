public class App {
    private String name;
    private String developer;
    private double version;
    private int price;

    public App() {
        this(null,null,0.0,0);
    }
    public App(String name, String developer, double version, int price) {
        this.name = name;
        this.developer = developer;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "App{" +
                "앱이름='" + name + '\'' +
                ", 개발자='" + developer + '\'' +
                ", 버전=" + version +
                ", 가격=" + price +
                '}';
    }
}
