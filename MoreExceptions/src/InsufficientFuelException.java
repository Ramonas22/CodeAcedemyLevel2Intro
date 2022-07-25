class InsufficientFuelException extends Exception{
    private Double fuelShortage;

    public InsufficientFuelException(double fuelShortage) {
        super("Missing " + fuelShortage +" fuel");
        this.fuelShortage = fuelShortage;

    }

    public Double getFuelShortage() {
        return fuelShortage;
    }

    public void setFuelShortage(Double fuelShortage) {
        this.fuelShortage = fuelShortage;
    }
}
