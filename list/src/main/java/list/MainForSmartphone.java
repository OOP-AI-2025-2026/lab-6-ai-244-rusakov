package ua.opnu.list;

public class MainForSmartphone {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone("Iphone 1292", 50.4101, 30.5434);

        phone.showInfo();
        phone.makeCall();
        phone.receiveCall();

        double[] coords = phone.getCoordinates();
        System.out.println("Coords BY GPS: " + coords[0] + ", " + coords[1]);
    }
}
