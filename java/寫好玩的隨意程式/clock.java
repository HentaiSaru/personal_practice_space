import java.time.*;
import java.time.format.*;
import java.util.*;
public class clock {
    public static void main(String[] argv) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        time t = new time();

        System.out.print("(�u����,���������п�J0) ��J�ɶ�: �� �� : ");
        int data_m = sc.nextInt();
        int data_s = sc.nextInt();

        if(data_m >= 0 & data_m <= 60 && data_s >= 0 & data_s <= 60)t._sava_data(data_m,data_s);
        else {System.out.print("��J���~,�����{��");System.exit(0);}
    
        while(true){
            System.out.println("");
            t.run();
            Thread.sleep(1000);
        }
    }
}
class time{
    private static int Timingtime = 0;  //�p�ɥ�

    void _sava_data(int m , int s){
        Timingtime = (m*60)+s;  //�N��J������� �[�`�ഫ����
    }

    public void run() {

        /*LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter my_time = DateTimeFormatter.ofPattern("�{�b�ɶ��� : HH ��: mm ��: ss �� \n");
        String formattedDate = time.format(my_time);
        System.out.println(formattedDate);*/

        if(Timingtime > 60){System.out.print("�Ѿl : "+(Timingtime/60)+"��"+(Timingtime%60)+"��\n");Timingtime--;}
        else if(Timingtime <= 60 && Timingtime >= 0){System.out.print("�Ѿl : "+Timingtime+"��\n");Timingtime--;}
        else {System.out.print("�ɶ���~");System.exit(0);}
    }
}