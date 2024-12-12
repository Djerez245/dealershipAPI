package com.pluralsight.dealership_spring.model;



public class LeaseContract extends Contract {
double expectedEndingValue;
double leaseFee;

    public LeaseContract(String dateOfContract, String firstName, String lastName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, firstName, lastName, customerEmail, vehicleSold);
    }

    public double getExpectedEndingValue() {
        expectedEndingValue = vehicleSold.getPrice() / 2;
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        leaseFee = vehicleSold.getPrice() + (vehicleSold.getPrice() * .07);
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public String toString(){
        return String.format("LEASE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%.2f\n", dateOfContract, firstName, customerEmail, vehicleSold.getVin(),
                vehicleSold.getYear(), vehicleSold.getMake(), vehicleSold.getModel(), vehicleSold.getVehicleType(), vehicleSold.getColor(),
                vehicleSold.getOdometer(), vehicleSold.getPrice(), getExpectedEndingValue(), getLeaseFee(), getTotalPrice(), getMonthlyPayment());
    }

    @Override
    public double getTotalPrice() {
        totalPrice = (vehicleSold.getPrice() * .04) * 36;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        monthlyPayment = totalPrice / 36;
        return monthlyPayment;
    }
}
