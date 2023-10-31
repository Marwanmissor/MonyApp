package org.Elboshy;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException , IOException {
        char ans;
        LocalDate d = LocalDate.now();
        Scanner t = new Scanner(System.in);
        File f = new File("ايراد يوم " + d.minusDays(1) +".txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);

        Mony Helwan1 = new Mony("حلوان 1");
        Mony Helwan2 = new Mony("حلوان 2");
        Mony Hhelwan = new Mony("حدايق حلوان");

        Orig(Helwan1);
        Orig(Helwan2);
        Orig(Hhelwan);

        while (true) {
            System.out.print("\n فيزا او فودافون كاش ؟  (Y\\N)");
            ans = t.next().charAt(0);

            if (ans == 'y' || ans == 'Y') {
                VCashandVisa("حلوان 1", Helwan1);
                VCashandVisa("حلوان 2", Helwan2);
                VCashandVisa("حدايق حلوان", Hhelwan);
                break;
            } else if (ans == 'n' || ans == 'N') {
                System.out.print("\n تمام مفيش فيزا ولا فودافون كاش \n");
                break;
            } else {
                System.out.println("\n- اختيار خاطئ من فضلك اختار من جديد");
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
        System.out.print("\n - " + name + " فيزا : ");
        while (!s.hasNextFloat()) {
            System.out.println("ادخال خاطئ من فضلك ادخل ارقام صحيحه او عشريه فقط ");
            System.out.print("\n - " + name + " فيزا : ");
            s.next();
        }
        get = s.nextFloat();
        h.setVisa(get);
        System.out.print("\n - " + name + " فودافون كاش : ");
        while (!s.hasNextFloat()) {
            System.out.println("ادخال خاطئ من فضلك ادخل ارقام صحيحه او عشريه فقط ");
            System.out.print("\n - " + name + " فودافون كاش : ");
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
        float TotalVisa = h1.getVisa() + h2.getVisa() + h3.getVisa() ,
                TotalOrinal = h1.getOriinal() + h2.getOriinal() + h3.getOriinal(),
                    TotalVoda = h1.getVodafone() + h2.getVodafone() + h3.getVodafone(),
                        Ttotal = h1.getTotal() + h2.getTotal() + h3.getTotal();
        if (TotalVisa == 0 && TotalVoda == 0){
            return " - اجمالي الدخل اليومي للفروع = " + Ttotal;
        } else if (TotalVisa != 0 &&  TotalVoda == 0) {
            return " - اجمالي الدخل اليومي للفروع = " + TotalOrinal
                    + "\n - اجمالي الفيزا = " + TotalVisa
                    +"\n - الاجمالي بعد الطرح = " + Ttotal;
        } else if (TotalVisa == 0 && TotalVoda != 0) {
            return " - اجمالي الدخل اليومي للفروع = " + TotalOrinal
                    + "\n - اجمالي فودافون كاش = " + TotalVoda
                    +"\n - الاجمالي بعد الطرح = " + Ttotal;
        }else {
            return " - اجمالي الدخل اليومي للفروع = " + TotalOrinal
                    + "\n - اجمالي الفيزا = " + TotalVisa
                    +"\n - اجمالي فودافون كاش = " + TotalVoda
                    +"\n - الاجمالي بعد الطرح = " + Ttotal;
        }
    }
}

