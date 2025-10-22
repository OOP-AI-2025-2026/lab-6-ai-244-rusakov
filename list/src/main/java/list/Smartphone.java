package ua.opnu.list;

class Smartphone implements GPS, Cellular {

    private String model;
    private double latitude;
    private double longitude;

    public Smartphone(String model, double latitude, double longitude) {
        this.model = model;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double[] getCoordinates() {
        return new double[]{latitude, longitude};
    }

    @Override
    public void makeCall() {
        System.out.println(model + " calling...");
    }

    @Override
    public void receiveCall() {
        System.out.println(model + " calling...");
    }

    public void showInfo() {
        System.out.println("model: " + model);
        System.out.println("Now coords: (" + latitude + ", " + longitude + ")");
    }
}
