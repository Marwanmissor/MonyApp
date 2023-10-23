package org.Elboshy;

public class Mony {
    private final String Name;
    private float Oriinal; // الايراد الكلي
    private float Vodafone; // فودافون كاش
    private float Visa; // الفيزا
    private float Total;

    //Scanner s = new Scanner(System.in);
    Mony(String name) {
        this.Name = name;
    }
//    public float getOriinal() {
//        return Oriinal;
//    }

    public void setOriinal(float Oriinal) {
        this.Oriinal = Oriinal;
        setTotal();
    }

//    public float getVodafone() {
//        return Vodafone;
//    }

    public void setVodafone(float Vodafone) {
        this.Vodafone = Vodafone;
        setTotal();
    }

//    public float getVisa() {
//        return Visa;
//    }

    public void setVisa(float Visa) {
        this.Visa = Visa;
        setTotal();
    }

    private void setTotal() {
        this.Total = this.Oriinal - this.Visa - this.Vodafone;
    }

    public String getName() {
        return Name;
    }

    public float getTotal() {
        return Total;
    }

    @Override
    public String toString() {
        if (this.Visa == 0 && this.Vodafone != 0) {
            return " - فرع " + Name + "\n " + " - اجمالي الدخل اليومي قبل الخصم لفرع  " + Name +" = " + Oriinal + "\n" + " - فودافون كاش " + Name + " = " + Vodafone + "\n" + " - الاجمالي بعد الطرح = " + Total + "\n =========================================================== \n";
        } else if (this.Visa != 0 && this.Vodafone == 0) {
            return " - فرع " + Name + "\n " + " - اجمالي الدخل اليومي قبل الخصم لفرع " + Name +" = " + Oriinal + "\n" + " - فيزا " + Name + " = " + Visa + "\n" + " - الاجمالي بعد الطرح = " + Total+ "\n =========================================================== \n";
        } else if (this.Visa == 0 && this.Vodafone == 0) {
            return " - فرع " + Name + "\n " + " - اجمالي الدخل اليومي لفرع " + Name +" = " + Total+ "\n =========================================================== \n";
        } else {
            return " - فرع " + Name + "\n " + " - اجمالي الدخل اليومي قبل الخصم لفرع " + Name +" = " + Oriinal + "\n" + " - فيزا " + Name + " = " + Visa + "\n" + " - فودافون كاش " + Name + " = " + Vodafone + "\n" + " - الاجمالي بعد الطرح = " + Total+ "\n =========================================================== \n";
        }
    }
}