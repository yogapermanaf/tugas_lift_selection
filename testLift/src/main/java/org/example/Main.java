package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        // Input nama tamu
        System.out.print("Masukkan nama Anda (minimal 5 karakter): ");
        String name = input.nextLine();
        while (name.length() < 5) {
            System.out.print("Nama Anda kurang dari 5 karakter. Silakan masukkan lagi: ");
            name = input.nextLine();
        }

        // Input lantai penjemputan
        System.out.print("Masukkan lantai penjemputan (1-10): ");
        int pickupFloor = input.nextInt();
        while (pickupFloor < 1 || pickupFloor > 10) {
            System.out.print("Lantai penjemputan tidak valid. Masukkan lagi: ");
            pickupFloor = input.nextInt();
        }


        // Input lantai tujuan
        System.out.print("Masukkan lantai tujuan (1-10): ");
        int destinationFloor = input.nextInt();
        while (destinationFloor < 1 || destinationFloor > 10) {
            System.out.print("Lantai tujuan tidak valid. Masukkan lagi: ");
            destinationFloor = input.nextInt();
        }

        // Mengacak lantai awal lift
        int currentFloor = (int) (Math.random() * 10) + 1;
        System.out.println("Lift saat ini berada di lantai " + currentFloor);

        // Pergerakan lift dari lantai awal ke lantai penjemputan
        if (pickupFloor > currentFloor) {
            for (int i = currentFloor + 1; i <= pickupFloor; i++) {
                System.out.println("Lift naik ke lantai : " + i);
            }
        } else if (pickupFloor < currentFloor) {
            for (int i = currentFloor - 1; i >= pickupFloor; i--) {
                System.out.println("Lift turun ke lantai : " + i);
            }
        }

        // Pergerakan lift dari lantai penjemputan ke lantai tujuan
        if (pickupFloor != destinationFloor) {

            System.out.println("Lift sudah sampai di lokasi penjemputan, pintu lift terbuka");
            System.out.println("Silahkan masuk, anda akan diantar ke lantai tujuan");

            if (destinationFloor > pickupFloor) {
                for (int i = pickupFloor + 1; i <= destinationFloor; i++) {
                    System.out.println("Lift naik ke lantai : " + i);
                }
            } else if (destinationFloor < pickupFloor) {
                for (int i = pickupFloor - 1; i >= destinationFloor; i--) {
                    System.out.println("Lift turun ke lantai : " + i);
                }
            }
        } else {
            System.out.println("Anda sudah berada di lantai tujuan. Lift tidak perlu bergerak.");
        }

        System.out.println("Lift sudah sampai di lantai tujuan. Terima kasih " + name + "!");
    }
}