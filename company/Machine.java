package com.company;

import java.util.Objects;

public abstract class Machine {
    private String brand;
    private String modelCode;

    private String energy;
    private int price;

    public Machine(){

    }

    public Machine(String brand, String modelCode, String energy, int price) {
        this.brand = brand;
        this.modelCode = modelCode;
        this.energy = energy;
        this.price = price;
    }



    public String getBrand() {
        return brand;
    }

    public String getModelCode() {
        return modelCode;
    }


    public String getEnergy() {
        return energy;
    }

    public int getPrice() {
        return price;
    }

    public String getType(){
        return "Machine ERROR";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }


    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Machine)) return false;
        Machine machine = (Machine) o;
        return getPrice() == machine.getPrice() &&
                getBrand().equals(machine.getBrand()) &&
                getModelCode().equals(machine.getModelCode()) &&
                getEnergy().equals(machine.getEnergy());
    }


}
