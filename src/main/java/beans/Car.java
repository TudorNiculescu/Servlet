package beans;

public class Car {

    private String brand;
    private String type;
    private Integer year;
    private Double kilometers;

    public Car(String brand, String type, Integer year, Double kilometers) {
        this.brand = brand;
        this.type = type;
        this.year = year;
        this.kilometers = kilometers;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.append(brand + " " + type + " " + year + " " + kilometers).toString();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }
}
