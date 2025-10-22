package ua.opnu.list;
public class Car implements Comparable {

    private int price;
    private int year; // рік виготовлення
    private int horsePower;

    // Конструктор з трьома аргументами
    public Car(int price, int year, int horsePower) {
        this.price = price;
        this.year = year;
        this.horsePower = horsePower;
    }

    // Гетери та сетери
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    // Реалізація методу compareTo() з логікою з умови
    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Car)) {
            throw new IllegalArgumentException("Object is not a Car");
        }

        Car other = (Car) obj;

        if (this.price != other.price) {
            return (this.price < other.price) ? 1 : -1;
        }

        if (this.year != other.year) {
            return (this.year > other.year) ? 1 : -1;
        }

        if (this.horsePower != other.horsePower) {
            return (this.horsePower > other.horsePower) ? 1 : -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Car{price=" + price + ", year=" + year + ", horsePower=" + horsePower + "}";
    }
}