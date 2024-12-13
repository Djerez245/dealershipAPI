package com.pluralsight.dealership_spring.model;




public abstract class Contract {
    protected int id;
    protected String dateOfContract;
    protected String firstName;
    protected String lastName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;


    public Contract(String dateOfContract, String firstName, String lastName, String customerEmail, Vehicle vehicleSold) {

        this.dateOfContract = dateOfContract;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }


    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    abstract public double getTotalPrice();

    abstract public double getMonthlyPayment();

    }

