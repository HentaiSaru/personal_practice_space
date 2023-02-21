/***
 @
 * todo 末三碼發票兌獎程式碼
 * ! 預計增加API連結,和UI介面
 @ 
*/
import java.io.*;
import java.util.*;
import java.time.*;
import java.text.*;
public class invoice_v3 implements Enter_a_description,save{
    public static void main(String[] argv){
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        File file = new File("中獎號碼.txt");
        bill comparison = new bill();
        String UserIn;
        boolean judge_input = true;
        int number_of_entries=0;
        file.delete();

        while(judge_input){
            try{
                System.out.print(illustrate[0]);
                UserIn = BR.readLine();
                if(enter(UserIn).equals("error"))System.out.print("輸入錯誤請重新");
                else judge_input=false;
            }catch(Exception e){}
        }judge_input = true;

        while(judge_input){
            try{
                System.out.print(illustrate[1]);
                UserIn = BR.readLine();
                if(enter(UserIn).equals("error"))System.out.print("輸入錯誤請重新");
                else judge_input=false;
            }catch(Exception e){}
        }judge_input = true;

        while(judge_input){
            try{
                System.out.print(illustrate[2]);
                UserIn = BR.readLine();
                if(enter(UserIn).equals("error"))System.out.print("輸入錯誤請重新");
                else{
                    number_of_entries++;
                    if(number_of_entries == 3)judge_input=false;
                }
            }catch(Exception e){}
        }judge_input = true;    
        
        while(judge_input){
            try{
                System.out.print(illustrate[3]);
                UserIn = BR.readLine();
                if(special_enter(UserIn).equals("error"))System.out.print("輸入錯誤請重新");
                else judge_input=false;
            }catch(Exception e){}
        }judge_input = true;
        for(int i=0;i<Exchange_Instructions.length;i++)System.out.println(Exchange_Instructions[i]);
        comparison.time();System.out.println();
        
        /*
        *---------------------------------------------------------------------------------------------
        *開始輸入 
        */
        while(judge_input){
            System.out.print(illustrate[4]);
            try{
                UserIn = BR.readLine();
                if(UserIn.equals("0")){System.out.println("程式結束");judge_input=false;}
                else{
                    if(UserIn.length() == 3 & UserIn.matches("[+-]?\\d*(\\.\\d+)?"))comparison.judge(UserIn);
                    else System.out.println("輸入錯誤,請輸入末3碼\n");
                }
            }catch(Exception e){}     
        }
    }

    /*
     * @param enter
     * @return
    todo @兩個判斷輸入字串的方法  
     */
    static String enter(String enter){
        if(enter.length() == 8 & enter.matches("[+-]?\\d*(\\.\\d+)?")){
            box.add(enter);
            return "";
        }
        else return "error";
    }
    static String special_enter(String enter){
        if(enter.length() == 3 & enter.matches("[+-]?\\d*(\\.\\d+)?")){
            box.add(enter);
            return "輸入成功\n";
        }
        else return "error";
    }
}
interface Enter_a_description{
    String[] illustrate = {"輸入當期特別獎號碼-->","輸入當期特獎號碼-->","輸入當期頭獎三組號碼-->","輸入當期增開號碼-->","輸入需兌獎末三碼(輸入0結束)-->"};
    String[] Exchange_Instructions = {"與頭獎末三碼相同 : 六獎 200 元","與頭獎末四碼相同 : 五獎 1000 元","與頭獎末五碼相同 : 四獎 4000 元","與頭獎末六碼相同 : 三獎 1萬 元","與頭獎末七碼相同 : 二獎 4萬 元"};
}
interface save{
    ArrayList<String> box = new ArrayList<String>();
}
class bill implements save{
    int prize;

    void time() {
        Date date = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("當前時間為 : yyyy年 MM月 dd日 E HH:mm:ss");
        System.out.println(Format.format(date));
    }

    void judge(String judge){

        try{
            FileWriter file = new FileWriter("中獎號碼.txt",true);
            for(int i=0;i<box.size();i++){
                if(box.get(i).endsWith(judge)){
                    file.write("中獎號碼:"+box.get(i)+" 末三碼為:"+judge+"\n");
                    System.out.println("\n恭喜中獎,請再確認中獎金額");
                    if(box.get(i).equals(box.get(0)))System.out.println("特別獎號碼確認(1000萬) => "+box.get(0)+"\n");
                    else if(box.get(i).equals(box.get(1)))System.out.println("特獎號碼確認(200萬) => "+box.get(1)+"\n");
                    else if(box.get(i).equals(box.get(5)))System.out.println("增開號碼確認(200元) => "+box.get(5)+"\n");
                    else System.out.println("頭獎號碼確認(20萬) => "+box.get(i)+"\n");
                    prize = 1;
                }
            }
            file.close();
        }catch(Exception e){System.out.print("發生不可預期的錯誤 , 程式已終止....");return;}

        if(prize == 0){System.out.println("沒有中獎請再接再厲\n");prize = 0;}
        else prize = 0;
    }
}