import java.time.*;
import java.time.format.*;
import java.util.*;
public class clock {
    public static void main(String[] argv) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        time t = new time();

        System.out.print("(只有秒,分的部份請輸入0) 輸入時間: 分 秒 : ");
        int data_m = sc.nextInt();
        int data_s = sc.nextInt();

        if(data_m >= 0 & data_m <= 60 && data_s >= 0 & data_s <= 60)t._sava_data(data_m,data_s);
        else {System.out.print("輸入錯誤,結束程式");System.exit(0);}
    
        while(true){
            System.out.println("");
            t.run();
            Thread.sleep(1000);
        }
    }
}
class time{
    private static int Timingtime = 0;  //計時用

    void _sava_data(int m , int s){
        Timingtime = (m*60)+s;  //將輸入的分跟秒 加總轉換為秒
    }

    public void run() {

        /*LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter my_time = DateTimeFormatter.ofPattern("現在時間為 : HH 時: mm 分: ss 秒 \n");
        String formattedDate = time.format(my_time);
        System.out.println(formattedDate);*/

        if(Timingtime > 60){System.out.print("剩餘 : "+(Timingtime/60)+"分"+(Timingtime%60)+"秒\n");Timingtime--;}
        else if(Timingtime <= 60 && Timingtime >= 0){System.out.print("剩餘 : "+Timingtime+"秒\n");Timingtime--;}
        else {System.out.print("時間到~");System.exit(0);}
    }
}