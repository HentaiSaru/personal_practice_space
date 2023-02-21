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
public class invoice_v2 {
    public static void main(String[] argv) {
        String fp1 , fp2 , fp3 , fp4 , fp5 , fp6;
        bill fp = new bill();                   //  ?實例化
        Scanner sc = new Scanner(System.in);    //  ?取使用者輸入
        fp.run = true;

        try {
            File _txt = new File("輸入紀錄檔.txt"); //  ?每次重新執行時 會將記錄檔刪除
            _txt.delete();
            FileWriter txt = new FileWriter("輸入紀錄檔.txt",true);

            fp._time(); //  !呼叫時間
            runLoop:while (fp.run) {
                if (fp.NumberOfEntries > 5)   //  !當輸入計數器大於5跳出
                    break;
                else {
                    switch (fp.NumberOfEntries) {
                        case 0:
                            System.out.print(fp._text(1));      //  ?呼叫字串
                            fp1 = sc.next();
                            System.out.println(fp.enter(fp1));  //  ?是否成功輸入
                            continue;
                        case 1:
                            System.out.print(fp._text(2));
                            fp2 = sc.next();
                            System.out.println(fp.enter(fp2));
                            continue;
                        case 2:
                            System.out.print("一 : "+ fp._text(3));
                            fp3 = sc.next();
                            System.out.println(fp.enter(fp3));
                            continue;
                        case 3:
                            System.out.print("二 : "+ fp._text(3));
                            fp4 = sc.next();
                            System.out.println(fp.enter(fp4));
                            continue;
                        case 4:
                            System.out.print("三 : "+ fp._text(3));
                            fp5 = sc.next();
                            System.out.println(fp.enter(fp5));
                            continue;
                        case 5:
                            System.out.print(fp._text(4));
                            fp6 = sc.next();
                            System.out.println(fp.enter(fp6));
                            continue;
                    }
                }continue runLoop; //   ?回到輸入開頭迴圈
            }

            System.out.println("\n與頭獎末三碼相同 : 六獎 200 元\n與頭獎末四碼相同 : 五獎 1000 元\n與頭獎末五碼相同 : 四獎 4000 元\n與頭獎末六碼相同 : 三獎 1萬 元\n與頭獎末七碼相同 : 二獎 4萬 元");
            run_1Loop: while (fp.run) {   //  ?開始輸入

                System.out.print("\n輸入需兌獎末三碼(輸入0結束) : ");
                String Redeem = sc.next();
                if (Redeem.equals("0"))break; //  ?跳出
                if (Redeem.length() == 3 & Redeem.matches("[+-]?\\d*(\\.\\d+)?") == true) {   //  ?判斷長度和是否為數字
                    fp.judge(Redeem);         //  ?通過後輸入保存
                    txt.write(Redeem+"\n");   //  ?寫入紀錄檔
                } else {
                    System.out.println("輸入錯誤,請輸入末3碼");
                    continue run_1Loop; // ?輸入錯誤跳回標頭
                }
            }
            txt.close();
        } catch (Exception e){System.out.print("發生不可預期的錯誤 , 程式已終止....");System.exit(0);} 
    }
}
abstract class preset {

    /**
     *?---迴圈使用---
     */int i;
    
    /**
     *?---判斷中獎---
     */int prize;

    /**
     *?---迴圈啟動---
     */boolean run;

    /**
     *?---計算輸入---
     */int NumberOfEntries;
}

interface _Comparison {

    // ?---號碼保存--- 

    ArrayList<String> box = new ArrayList<String>();

}

class bill extends preset implements _Comparison { /* 輸入端口 */
    int NumberOfEntries = 0, prize = 0;

    void _time() {

        LocalDateTime time = LocalDateTime.now(); // ?取得系統時間
        DateTimeFormatter my_time = DateTimeFormatter.ofPattern("當前時間為 : yyyy年 MM月 dd日 HH:mm:ss");   //? 時間格式
        String formattedDate = time.format(my_time); // ?讀取系統時間+格式字串
        System.out.println(formattedDate); // ?輸出時間

    }

    /**
     * @param _text
     * 
     * !字串回傳
     */
    String _text(int _text) {

        switch (_text) {
            case 1:
                return "輸入當期特別獎號碼 : ";
            case 2:
                return "輸入當期特獎號碼 : ";
            case 3:
                return "輸入當期頭獎號碼 : ";
            case 4:
                return "輸入當期增開號碼 : ";
            default:
                return "";
        }
    }

    /**
     * @param enter
     * 
     * !第二層判斷
     */
    String enter(String enter){

            if(enter.length() == 8 & NumberOfEntries < 5 & enter.matches("[+-]?\\d*(\\.\\d+)?") == true){   //  ?關於判斷數字的表示式其實是多餘的 單純練習用
                NumberOfEntries++;
                save(enter);
                return "輸入成功\n";
            }
            else if(NumberOfEntries == 5 & enter.length() == 3 & enter.matches("[+-]?\\d*(\\.\\d+)?") == true){
                NumberOfEntries++;
                save(enter);
                return "輸入成功\n";
            }
            else return "輸入錯誤請重新輸入...\n";
    }

	/**
     * @param save
     * 
     * !儲存
     */

    void save(String save) {
        box.add(save);
    }

    /**
     * @param judge
     * 
     * !輸入判斷
     */
    void judge(String judge) {

    try{
        FileWriter winning = new FileWriter("中獎紀錄.txt",true);
        StringWriter _winning = new StringWriter();
        for (i = 0; i <= 5; i++) {
            if (box.get(i).endsWith(judge) == true) {   //  ?判斷字串是否以輸入值結尾
                System.out.println("\n恭喜中獎,請再確認中獎金額");  //?中獎了印出  
                _winning.write(judge);
                winning.write(_winning.toString()+"\n\n");
                
                // *--以下判斷中獎的號碼----------------------------------------
                if(box.get(i).equals(box.get(0)) == true)                       //  ?判斷字串與哪筆資料相等
                    System.out.println("特別獎號碼確認(1000萬) => "+box.get(0));
                else if(box.get(i).equals(box.get(1)) == true)
                    System.out.println("特獎號碼確認(200萬) => "+box.get(1));
                else if(box.get(i).equals(box.get(5)) == true)
                    System.out.println("增開號碼確認(200元) => "+box.get(5));
                else
                    System.out.println("頭獎號碼確認(20萬) => "+box.get(i));

                prize = 1;
                winning.close();
            } else continue;
        }
    }catch (Exception e){System.out.print("發生不可預期的錯誤 , 程式已終止....");System.exit(0);}

        // *---無中獎必須放在判斷迴圈外 , 不然會印出6次未中獎---   
        if(prize == 0) { // ?迴圈結束後判斷 偵測值是否為0 (0就是沒中獎 有中獎會變成1)
            System.out.println("沒有中獎請再接再厲");
            prize = 0;
        }else
            prize = 0; // ?將有中獎的偵測值歸0 以便下一輪使用
    }

}