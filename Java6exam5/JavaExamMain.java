import pkg.*;
import pkg.sub.*;
import java.util.*;
public class JavaExamMain{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);

        System.out.print("�п�Jpower:");
        JavaExam2 j2 = new JavaExam2(sc.next());

        System.out.print("��J�n�⪺�Ʀr:");
        int a = sc.nextInt();

        System.out.print("��J�����:");
        int b = sc.nextInt();

        JavaExam3 j3 = new JavaExam3(j2.getString(),a,b);
        System.out.print(j3.getMath());
    }
}