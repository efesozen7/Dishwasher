package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CoolRedCatalogue {
    private List<Machine> ml;

    public CoolRedCatalogue() {
        ml = new ArrayList<Machine>();
    }

    public void addMachine(Machine m) {
        this.getMl().add(m);
    }

    public List<Machine> getMl() {
        return ml;
    }

    public static CoolRedCatalogue read(String fileName) {
        CoolRedCatalogue crc = new CoolRedCatalogue();
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String lineArr[] = line.split(", ");
                String brandArr[] = lineArr[0].split(" ");
                if (brandArr[0].equals("WASHER")) {
                    crc.addMachine(Washer.read(line));
                } else if ((brandArr[0].equals("REFRIGERATOR"))) {
                    crc.addMachine(Refrigerator.read(line));
                } else {
                    crc.addMachine(Dishwasher.read(line));
                }

            }
            return crc;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        String s = "";
        for (Machine m : this.getMl()) {
            s += m.toString() + "\n";
        }
        return s;

    }

   public synchronized void sortByProduct(){
        Collections.sort(this.getMl(), new Comparator<Machine>() {
           @Override
           public int compare(Machine o1, Machine o2) {
               return o1.getBrand().compareTo(o2.getBrand());
           }
        });
   }

    public synchronized void sortByBrand(){
        Collections.sort(this.getMl(), new Comparator<Machine>() {
            @Override
            public int compare(Machine o1, Machine o2) {
                return o1.getType().compareTo(o2.getType());
            }
        });
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CoolRedCatalogue)) return false;
        CoolRedCatalogue that = (CoolRedCatalogue) o;
        return getMl().equals(that.getMl());
    }
    public synchronized CoolRedCatalogue sortByProduct(Comparator<Machine> m){
        System.out.println("Sorting to be implemented");
        return null;
    }
    public synchronized CoolRedCatalogue sortByBrand(Comparator<Machine> m){
        System.out.println("Sorting to be implemented");
        return null;
    }

    public  String[] addMach() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What should be the brand?");
        String brand = sc.nextLine();
        System.out.println("What should be the model code?");
        String modelCode = sc.nextLine();
        System.out.println("What should be the energyLabel?");
        String elabel = sc.nextLine();
        System.out.println("What should be the price?");
        String price = sc.nextLine();
        String arr[] = {brand,modelCode,elabel,price};
        return arr;
    }
    public synchronized void addRef (){
        Scanner sc = new Scanner(System.in);
        System.out.println("What should be the capacity in liters?");
        String capacityInLiters = sc.nextLine();
        String arr[] = this.addMach();
        this.addMachine(new Refrigerator(arr[0],arr[1],arr[2],capacityInLiters,Integer.parseInt(arr[3])));
    }

    public synchronized void addDish (){
        Scanner sc = new Scanner(System.in);
        System.out.println("What should be the capacity in liters?");
        String capacityInLiters = sc.nextLine();
        String arr[] = this.addMach();
        this.addMachine(new Dishwasher(arr[0],arr[1],capacityInLiters,arr[2],Integer.parseInt(arr[3])));
    }
    public synchronized void addWash (){
        Scanner sc = new Scanner(System.in);
        String arr[] = this.addMach();
        System.out.println("What should be the capacity in kilograms?");
        String capKg = sc.nextLine();
        System.out.println("What should be the number of rotations per minute?");
        String rotations = sc.nextLine();
        this.addMachine(new Washer(arr[0],arr[1],capKg,Integer.parseInt(rotations),arr[2],Integer.parseInt(arr[3])));
    }


}
