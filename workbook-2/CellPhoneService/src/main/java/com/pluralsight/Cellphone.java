package com.pluralsight;

public class Cellphone {
    private int serialNumber= 0;
    private String model = "", carrier = "", phoneNumber = "", owner = "";

    public Cellphone(){
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }
    public void setSerialNumber(int serialNumber){
        this.serialNumber = serialNumber;
    }

    public void setModel(String model){
        this.model = model;
    }
    public void setCarrier(String carrier){
        this.carrier = carrier;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }

    public String getModel(){
        return this.model;
    }

    public String getCarrier(){
        return this.carrier;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getOwner(){
        return this.owner;
    }

    public void dial(String phoneNumber){
        System.out.println(this.owner + "'s phone is calling " + phoneNumber);
    }

}
