package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CoolRedApplication{


    public static void start(String fileName) throws InterruptedException {
            CoolRedCatalogue crc = CoolRedApplication.readFile(fileName);
            Scanner scan = new Scanner(System.in);
            int input = 0;

            while (input != 8) {
                System.out.println("Please make your choice:\n" +
                        "1 - Show the entire CoolRed catalogue\n" +
                        "2 – Add a new refrigerator\n" +
                        "3 – Add a new dishwasher\n" +
                        "4 – Add a new washing machine\n" +
                        "5 - Show the entire CoolRed catalogue sorted by appliance\n" +
                        "6 – Show the entire CoolRed catalogue sorted by brand\n" +
                        "(alphabetically)\n" +
                        "7 – Write to file\n" +
                        "8 – Stop the program");
                input = scan.nextInt();
                switch (input) {
                    case 1:
                        CoolRedApplication.showCatalogue(crc);
                        break;
                    case 2:
                        crc.addRef();
                        break;
                    case 3:
                        crc.addDish();
                        break;
                    case 4:
                        crc.addWash();
                        break;

                    case 5:
                        Thread t = new Thread(new Runnable() {
                        @Override
                            public void run(){
                            crc.sortByProduct();
                            System.out.println(crc.toString());
                        }

                        });
                        t.start();
                        break;

                    case 6:
                        Thread q = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                crc.sortByBrand();
                                System.out.println(crc.toString());
                                }
                            });

                        q.start();
                        break;

                    case 7:
                        CoolRedApplication.writeToFile(fileName,crc);
                        break;
                    case 8:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Please enter a valid input");
                        CoolRedApplication.start(fileName);
                        break;
                }
            }

    }
    public static CoolRedCatalogue readFile( String fileName){
        return CoolRedCatalogue.read(fileName);
    }
    public static void showCatalogue(CoolRedCatalogue crc){
        System.out.println(crc.toString());
    }
    public static void writeToFile(String fileName, CoolRedCatalogue crc){
        try {
            PrintWriter pw = new PrintWriter(new File(fileName));
            pw.write(crc.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the file that you want to read in the format of fileName.txt");
        String fileName = sc.nextLine();

        CoolRedApplication.start(fileName);
    }

}
