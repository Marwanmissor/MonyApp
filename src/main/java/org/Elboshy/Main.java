package org.Elboshy;

import java.util.Scanner;

public class Main {

public static void VCashandVisa (String name ,Mony h ){
    float get;
    Scanner s = new Scanner(System.in);
    System.out.print("\n - " + name + " Visa : ");
    while (!s.hasNextFloat()) {
        System.out.println("Invalid input. Please enter a valid float value.");
        System.out.print("\n - " + name + " Visa : ");
        s.next();
    }
    get = s.nextFloat();
    h.setVisa(get);
    System.out.print("\n - " + name + " Vodafone Cash : ");
    while (!s.hasNextFloat()) {
        System.out.println("Invalid input. Please enter a valid float value.");
        System.out.print("\n - " + name + " Vodafone Cash : ");
        s.next();
    }
    get = s.nextFloat();
    h.setVodafone(get);
}
    public static void main(String[] args) {
        float m;
        char ans;
        boolean q = true;

        Scanner t = new Scanner(System.in);
        Mony Helwan1 = new Mony("Helwan 1");
        Mony Helwan2 = new Mony("Helwan 2");
        Mony Hhelwan = new Mony("Hadayek Helwan");

        System.out.print("\n - Enter " + Helwan1.getName() +": ");
        while (!t.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid float value.");
            System.out.print("\n - Enter " + Helwan1.getName() +" : ");
            t.next();
        }
        m = t.nextFloat();
        Helwan1.setOriinal(m);

        System.out.print("\n - Enter " + Helwan2.getName() + " : ");
        while (!t.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid float value.");
            System.out.print("\n - Enter " + Helwan2.getName() +" : ");
            t.next();
        }
        m = t.nextFloat();
        Helwan2.setOriinal(m);

        System.out.print("\n - Enter "+ Hhelwan.getName() + " : ");
        while (!t.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a valid float value.");
            System.out.print("\n - Enter " + Hhelwan.getName() +" : ");
            t.next();
        }
        m = t.nextFloat();
        Hhelwan.setOriinal(m);

        while (q) {
            System.out.print("\n - Visa Or Vodafone Cash ? (Y\\N)");
            ans = t.next().charAt(0);

            if (ans == 'y' || ans == 'Y') {
                VCashandVisa("Helwan 1" , Helwan1);
                VCashandVisa("Helwan 2" , Helwan2);
                VCashandVisa("Hadayek Helwan" , Hhelwan);
                q = false;
            } else if (ans == 'n' || ans == 'N') {
                System.out.print("\n- OK NO Visa Or Vodafone Cash");
                q = false;
            } else {
                System.out.println("\n- Wrong Choice");
            }
        }
    }
}
