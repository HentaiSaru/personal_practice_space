import pkg.*;
import pkg.sub.*;
import java.util.*;
public class JavaExamMain{
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入power:");
        JavaExam2 j2 = new JavaExam2(sc.next());

        System.out.print("輸入要算的數字:");
        int a = sc.nextInt();

        System.out.print("輸入次方數:");
        int b = sc.nextInt();

        JavaExam3 j3 = new JavaExam3(j2.getString(),a,b);
        System.out.print(j3.getMath());
    }
}