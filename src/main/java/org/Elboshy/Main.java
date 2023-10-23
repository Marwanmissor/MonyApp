package org.Elboshy;

import java.io.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException , IOException {
        char ans;
        Scanner t = new Scanner(System.in);
        File f = new File("test.txt");
        f.createNewFile();
        FileReader fr = new FileReader(f);
        FileWriter fw = new FileWriter(f);

        Mony Helwan1 = new Mony("حلوان 1");
        Mony Helwan2 = new Mony("حلوان 2");
        Mony Hhelwan = new Mony("حدايق حلوان");

        Orig(Helwan1);
        Orig(Helwan2);
        Orig(Hhelwan);

        while (true) {
            System.out.print("\n - Visa Or Vodafone Cash ? (Y\\N)");
            ans = t.next().charAt(0);

            if (ans == 'y' || ans == 'Y') {
                VCashandVisa("Helwan 1", Helwan1);
                VCashandVisa("Helwan 2", Helwan2);
                VCashandVisa("Hadayek Helwan", Hhelwan);
                break;
            } else if (ans == 'n' || ans == 'N') {
                System.out.print("\n- OK NO Visa Or Vodafone Cash\n");
                break;
            } else {
                System.out.println("\n- Wrong Choice");
            }
        }
        fw.write(Helwan1.toString());
        fw.write(Helwan2.toString());
        fw.write(Hhelwan.toString());
        fw.write(allTotal(Helwan1 , Helwan2 , Hhelwan));
        fw.flush();
        fw.close();
    }
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
    public static void Orig(Mony H){
        Scanner t = new Scanner(System.in);
        float m;
        System.out.print("\n - ادخل " + H.getName() + ": ");
        while (!t.hasNextFloat()) {
            System.out.println("\n ادخال خاطئ برجاء ادخال ارقام صحيحه او عشريه فقط");
            System.out.print("\n - ادخل " + H.getName() + " : ");
            t.next();
        }
        m = t.nextFloat();
        H.setOriinal(m);
    }
    private static String allTotal(Mony h1 , Mony h2 , Mony h3){
        if (h1.getVisa() + h2.getVisa() + h3.getVisa() == 0 && h1.getVodafone() + h2.getVodafone() + h3.getVodafone() != 0) {
            return "\n" + " - اجمالي كل الفروع قبل الخصم = " + (h1.getOriinal() + h2.getOriinal() + h3.getOriinal()) + "\n"
                    + " اجمالي فودافون كاش = " + (h1.getVodafone() + h2.getVodafone() + h3.getVodafone()) + "\n"
                    + " - اجمالي الكل بعد الطرح = " + (h1.getTotal() + h2.getTotal() + h3.getTotal());
        } else if (h1.getVisa() + h2.getVisa() + h3.getVisa() != 0 && h1.getVodafone() + h2.getVodafone() + h3.getVodafone() == 0) {
            return "\n" +  " - اجمالي كل الفروع قبل الخصم = " + (h1.getOriinal() + h2.getOriinal() + h3.getOriinal()) + "\n"
                    + "اجمالي الفيزا = " + (h1.getVisa() + h2.getVisa() + h3.getVisa()) + "\n"
                    + " - اجمالي الكل بعد الطرح = "+(h1.getTotal() + h2.getTotal() + h3.getTotal());
        } else if (h1.getVisa() + h2.getVisa() + h3.getVisa() == 0 && h1.getVodafone() + h2.getVodafone() + h3.getVodafone() == 0) {
            return "\n" +  " - اجمالي كل الفروع قبل الخصم = " + (h1.getOriinal() + h2.getOriinal() + h3.getOriinal()) + "\n"
                    + " - اجمالي الكل بعد الطرح = "+(h1.getTotal() + h2.getTotal() + h3.getTotal());
        }
        else {
            return "\n" +  " - اجمالي كل الفروع قبل الخصم = " + (h1.getOriinal() + h2.getOriinal() + h3.getOriinal()) + "\n"
                    + "اجمالي الفيزا = " + (h1.getVisa() + h2.getVisa() + h3.getVisa()) + "\n"
                    + " اجمالي فودافون كاش = " + (h1.getVodafone() + h2.getVodafone() + h3.getVodafone()) + "\n"
                    + " - اجمالي الكل بعد الطرح = "+(h1.getTotal() + h2.getTotal() + h3.getTotal());
        }
        }
    }

