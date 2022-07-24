class Car {
    private String brand;
    private String model;
    private Double fuelLeft;
    private Double averageConsumption;

    public Car(String brand, String model, Double fuelLeft, Double averageConsumption) {
        this.brand = brand;
        this.model = model;
        this.fuelLeft = fuelLeft;
        this.averageConsumption = averageConsumption;
    }


    public Double driveTrip(Integer distance) throws InsufficientFuelException{
        printCarInfo();
        System.out.printf("fuel before %.2f and distance to ride %d\t", getFuelLeft(), distance);
        try {
            if (fuelLeft < distance * averageConsumption / 100) {
                throw new InsufficientFuelException(-(fuelLeft - (distance * averageConsumption / 100)));
            } else {
                fuelLeft -= distance  * averageConsumption/100;
                System.out.printf("Fuel left after travel: %.2f\n", fuelLeft);
                return getFuelLeft();
            }
        } catch (InsufficientFuelException e) {
            System.out.printf("Distance cannot be reached since you are missing %.2f litres of fuel\n", e.getFuelShortage());
            return null;
        }
    }

    private void printCarInfo() {
        System.out.printf("Car brand %s, model %s, average consumption %.2f\t", getBrand(), getModel(), getAverageConsumption());
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getFuelLeft() {
        return fuelLeft;
    }

    public void setFuelLeft(Double fuelLeft) {
        this.fuelLeft = fuelLeft;
    }

    public Double getAverageConsumption() {
        return averageConsumption;
    }

    public void setAverageConsumption(Double averageConsumption) {
        this.averageConsumption = averageConsumption;
    }
}
