package com.company;

public class Dishwasher extends Machine{
    private String capL;
    private String type;
    public Dishwasher() {
    }

    public Dishwasher(String brand, String modelCode, String capL, String energy, int price) {
        super(brand, modelCode, energy, price);
        this.capL = capL;
        this.type = "DISHWASHER";
    }

    public static Dishwasher read(String line) {
        String arr[] = line.split(", ");
        String arr2[] = arr[0].split(" ");

        String brand = arr2[1];
        String modelCode = arr[1];
        String capL = arr[2];
        String energyLabels = arr[3];
        String arr3[] = arr[4].split(" ");
        int price = Integer.parseInt(arr3[0]);
        return new Dishwasher(brand, modelCode, capL, energyLabels, price);
    }


    @Override
    public boolean equals(Object o) {
        if ((o instanceof Dishwasher) && super.equals(o)){
            Dishwasher k = (Dishwasher) o;
            return k.capL==this.capL;
        }
        else return false;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "DISHWASHER "+this.getBrand()+ ", " + this.getModelCode() +", " + capL + ", " + this.getEnergy() + ", " + this.getPrice() + " euros";

    }
}
