class Main {
    public static void main(String[] args) throws InsufficientFuelException {
        Car car1 = new Car("Mercedes", "C321", 20.0, 5.0);
        car1.driveTrip(100);

        Car car2 = new Car("Volkswagen", "Golf", 5.0, 5.0);
        car2.driveTrip(300);
    }
}
