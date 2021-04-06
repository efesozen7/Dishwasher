package com.company;

import java.util.Objects;

public class Washer extends Machine{
    private String capKg;
    private int rotations;
    private String type;

    public Washer(String brand, String modelCode, String capKg, int rotations, String energy, int price) {
        super(brand, modelCode, energy, price);
        this.capKg = capKg;
        this.rotations = rotations;
        type = "WASHER";
    }

    public static Washer read(String line) {
        String arr[] = line.split(", ");
        String arr2[] = arr[0].split(" ");

        String brand = arr2[1];
        String modelCode = arr[1];
        String capK = arr[2];
        int numRot = Integer.parseInt(arr[3]);
        String energy = arr[4];
        String arr3[] = arr[5].split(" ");
        int price = Integer.parseInt(arr3[0]);

        return new Washer(brand, modelCode, capK, numRot, energy, price);
    }

    public String getType() {
        return type;
    }

    public int getRotations() {
        return rotations;
    }

    public String getCapKg() {
        return capKg;
    }

    public void setCapKg(String capKg) {
        this.capKg = capKg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Washer)) return false;
        if (!super.equals(o)) return false;
        Washer washer = (Washer) o;
        return getCapKg().equals(washer.getCapKg());
    }

    public String toString(){
        return "WASHER "+this.getBrand()+ ", " + this.getModelCode() +", " + this.getCapKg() + ", " +this.getRotations()+ ", "+ this.getEnergy() + ", " + this.getPrice() + " euros";
    }
}
