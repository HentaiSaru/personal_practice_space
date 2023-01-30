public class BMI {
    int Height, Weight;
    static String Name;
    double bmi;

    static void setName(String Name1) {
        Name = Name1;
    }

    void setHW(int Height, int Weight) {
        this.Height = Height;
        this.Weight = Weight;
    }

    void setData(char choose, int data) {
        if (choose == 'w') {
            this.Weight = data;
        } else if (choose == 'h') {
            this.Height = data;
        }
    }

    void compare(BMI ibm) {
        if (this.bmi > ibm.bmi) {
            System.out.print("The higher BMI is" + Name + "!!");
        } else if (this.bmi < ibm.bmi) {
            System.out.print("The higher BMI is  " + Name + "!!");
        } else
            System.out.print("��Ӥ@�ˤj");
    }

    // ?-------------------------�L�X-------------------------------

    void show() {
        System.out.println(Name + " : ���� : " + (double) (Height / 100.0) + "�� �A �魫 : " + Weight + "����" + "�A BMI : " + bmi);
    }

    // ?---------------------bmi�p�⤽��--------------------------------

    void calculate() {
        bmi = Weight / ((Height / 100.0) * (Height / 100.0));
    }

    public static void main(String[] argv) {
        BMI bm = new BMI();
        BMI sb = new BMI();

        setName("Jacky");
        bm.setData('h', 178);
        bm.setData('w', 78);

        setName("Jenifer");
        sb.setHW(166, 48);

        bm.calculate();
        bm.show();

        sb.calculate();
        sb.show();

        sb.compare(bm);
    }
}