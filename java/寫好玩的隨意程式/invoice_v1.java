/***
 @
 * todo 末三碼發票兌獎程式碼
 * ! 以下刻意採取較繁瑣的方式 作為練習使用
 @ 
*/
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.io.*;
abstract class _for{
    public int j; //?迴圈使用
}
interface arr{
    ArrayList<Integer> jd = new ArrayList<Integer>();
}
class FP extends _for implements arr{
    int f = 0;   //?f輸出判斷用;
//*--------------------------------------------------------------------------------------
    void save(int p){   //?儲存對獎號碼
        jd.add(p);
    }
//*--------------------------------------------------------------------------------------
    void judge(int p_1){    //?判斷是否中獎 
        for(j=0;j<=5;j++){
            if(p_1 == (jd.get(j) % 1000)){
                System.out.println("\n恭喜中獎,請再確認中獎金額");  //?中獎了印出
                //*--以下判斷中獎的號碼----------------------------------------
                if(jd.get(j) == jd.get(0))
                     System.out.println("特別獎號碼確認(1000萬) => "+jd.get(0));
                else if(jd.get(j) == jd.get(1))
                     System.out.println("特獎號碼確認(200萬) => "+jd.get(1));
                else if(jd.get(j) == jd.get(5))
                     System.out.println("增開號碼確認(200元) => "+jd.get(5));
                else System.out.println("頭獎號碼確認(20萬) => "+jd.get(j));

                f = 1;  //?如果有中獎 偵測值為1
            }else continue;
        }
        //*---無中獎必須放在判斷迴圈外 , 不然會印出6次未中獎---   
        if(f == 0){ //?迴圈結束後判斷 偵測值是否為0 (0就是沒中獎 有中獎會變成1)
            System.out.println("沒有中獎請再接再厲");
            f = 0;
        }
        else f = 0; //?將有中獎的偵測值歸0 以便下一輪使用
    }
    //*---範圍判斷---
    int max(){
        return 99999999;
    }
    int min(){
        return 10000000;
    }
}
public class invoice {
    public static void main(String[] argv){
        boolean w = true;  //?啟動輸入
        int j = 0;  //?計算丟入次數
        Scanner sc = new Scanner(System.in);    //?取使用者輸入
        FP f = new FP();    //?實例化方法

        LocalDateTime time = LocalDateTime.now();   //?取得系統時間
        DateTimeFormatter my_time = DateTimeFormatter.ofPattern("當前時間為 : yyyy年 MM月 dd日 HH:mm:ss"); //?轉換時間格式
        String formattedDate = time.format(my_time); //?讀取時間格式字串+系統時間
        System.out.println(formattedDate);  //?輸出時間

    try{   //?判斷輸入的值是否超過Int的範圍
        File _txt = new File("輸入紀錄檔.txt");
        _txt.delete();
        FileWriter txt = new FileWriter("輸入紀錄檔.txt",true);
//--------------------------------------------------------------------------------------

    run_1Loop:while(w){
        System.out.print("輸入當期特別獎號碼 : ");
        int fp_1 = sc.nextInt();    //?特別獎變數
        if(fp_1 >= f.min() && fp_1 <= f.max()){    //?判斷輸入為8碼
            f.save(fp_1);
            txt.write("當期特別獎號碼 : "+fp_1+"\n");
            break;
        }
        else{
            System.out.println("輸入錯誤請重新輸入");
            continue run_1Loop; //?輸入錯誤跳回標頭
        }
    }
//--------------------------------------------------------------------------------------

    run_2Loop:while(w){
        System.out.print("\n輸入當期特獎號碼 : ");
        int fp_2 = sc.nextInt();    //?特獎變數
        if(fp_2 >= f.min() && fp_2 <= f.max()){    //?判斷輸入為8碼
            f.save(fp_2);
            txt.write("當期特獎號碼 : "+fp_2+"\n");
            System.out.println("");
            break;
        }
        else{
            System.out.println("輸入錯誤請重新輸入");
            continue run_2Loop; //?輸入錯誤跳回標頭
        }
    }
//--------------------------------------------------------------------------------------

        run_3Loop:while(w){
            System.out.print("輸入當期頭獎號碼 : ");
            int fp_3 = sc.nextInt();    //?頭獎變數
            if(fp_3 >= f.min() && fp_3 <= f.max()){    //?判斷輸入為8碼
                f.save(fp_3);
                j += 1;
                txt.write("當期頭獎號碼 : "+fp_3+"\n");
                if(j == 3) break;
            }
            else{
                System.out.println("輸入錯誤請重新輸入\n");
                continue run_3Loop; //?輸入錯誤跳回標頭
            }
        }

//--------------------------------------------------------------------------------------

    run_4Loop:while(w){
        System.out.print("\n輸入當期增開號碼 : ");
        int fp_4 = sc.nextInt();    //?增開變數
        if(fp_4 >= 100 && fp_4 <= 999){  //?判斷輸入是否為3位數
            f.save(fp_4);
            txt.write("當期增開號碼 : "+fp_4+"\n");
            break;
        }
        else{
            System.out.println("輸入錯誤請重新輸入");
            continue run_4Loop; //?輸入錯誤跳回標頭
        }
    }

//--------------------------------------------------------------------------------------

        System.out.println("\n與頭獎末三碼相同 : 六獎 200 元\n與頭獎末四碼相同 : 五獎 1000 元\n與頭獎末五碼相同 : 四獎 4000 元\n與頭獎末六碼相同 : 三獎 1萬 元\n與頭獎末七碼相同 : 二獎 4萬 元");
        run_5Loop:while(w){
            System.out.print("\n輸入需兌獎末三碼(輸入-1結束) : ");
            int Redeem = sc.nextInt();
            if(Redeem == -1) break;
            if(Redeem <= 999 & Redeem > 0){
                f.judge(Redeem);  //?判斷輸入是否為3位數
                txt.write("\n輸入末3碼 : "+Redeem+"\n");
            }        
            else{
                System.out.println("輸入錯誤,請輸入末3碼");
                
                continue run_5Loop; //?輸入錯誤跳回標頭
            }
        }
    txt.close();
    }catch(Exception e){System.out.print("發生不可預期的錯誤 , 程式已終止....");System.exit(0);}
    }    
}