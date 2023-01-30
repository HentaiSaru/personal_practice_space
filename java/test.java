import java.time.*;
import java.time.format.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import _pack.My_package;

enum tt {
    t1, t2, t3, t4
}

//! Scanner 小知識 next() 會忽略空白直到有效輸入才開始讀取 nextLine() 會連空白完整讀取直到按下enter

public class test {
    public static void main(String[] argv) throws InterruptedException {
        _run tm1 = new _run();

        /*@ 計算程式開始時間 @*/
        long timing1 = System.currentTimeMillis();

        tt me = tt.t3;
        System.out.println("枚舉練習輸出 : " + me);

        for (tt me1 : tt.values()) {
            System.out.println("枚舉練習遍歷輸出 : " + me1);
        }

        System.out.println("\n----------------------\n");

        /*@ 時間輸出 @*/
        Date date = new Date(); //? 簡易時間取得
        System.out.println(date); //? 預設輸出為 : 星期 月份 天 24:00:00 CST 2022
        
        //!格式化日期
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(Format.format(date));    //? 這邊是使用了 text 套件產生
        
        //* boolean after(Date date) 若當調用此方法的Date對象在指定日期之後返回true,否則返回false。
        //* boolean before(Date date) 若當調用此方法的Date對象在指定日期之前返回true,否則返回false。

        //! 特別輸出方法
        System.out.printf("HH:MM:SS：%tT%n",date); //? 00:00:00 24小時制
        /*
        * %tc 全部日期與時間訊息 
        * %tF 2000-07-05 年月日格式
        * %tD 07/05/2000 月日年格式
        * %tr 02:25:51 下午 (12小時制 時分秒)
        * %tT 14:25:51 (24小時制 時分秒)
        * %tR 14:18 (24小時制 時分)
        */

        //! 日期格式 yyyy-mm-dd-E (西元/月/日/星期)
        /*
        *   G 紀元
        *   y 四位年份 2000
        *   M 月份
        *   d 日
        *   E 星期幾
        *   h 12小時制
        *   H 24小時制
        *   a A.M/P.M 標記
        *   m 分
        *   s 秒
        *   S 毫秒
        *   z 時區
        *   boolean isLeapYear(int year) 確定給定的年份是否?閏年。
        */
        
        //! Calendar類取得時間
        Calendar testC = Calendar.getInstance();
        int year = testC.get(Calendar.YEAR);
        int month = testC.get(Calendar.MONTH);
        int _date = testC.get(Calendar.DATE);
        int hour = testC.get(Calendar.HOUR_OF_DAY);
        int minute = testC.get(Calendar.MINUTE);
        int second = testC.get(Calendar.SECOND);

        System.out.printf("%d年-%d月-%d日 %d時-%d分-%d秒", year,month,_date,hour,minute,second);

        System.out.println("\n----------------------\n");

        /*@ List @*/
        //! 有個與 list 相似的東西 HashSet 宣告方式一樣 HashSet<String> cars = new HashSet<String>()
        //! 有個特殊函式 cars.contains("Mazda"); contains 方法 可直接查詢該項目是否在 hash 中
        ArrayList<String> list = new ArrayList<String>(); //? list根據<Integer><Boolean><Character><Double>可保存不同方法
        list.add("List練習1");
        list.add("List練習2");
        list.add("List練習3");
        list.add("List練習4");
        list.add("List練習5");

        System.out.println("訪問索引 : " + list.get(4));
        System.out.println("修改前 : " + list);

        list.set(0, "List修改1");
        list.set(4, "List修改5");

        System.out.println("修改後 : " + list + "大小" + list.size());

        //! 刪除語法 : list.remove(0);
        //! 清除全部 : list.clear();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\n----------------------\n");

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(50);
        list1.add(20);
        list1.add(40);
        list1.add(30);

        //! Collections 是一個特殊函式 Collections.reverse(陣列反轉)
        /*
        *   函示應用
        *   addFirst() 將數值新增到 list 最開始
        *   addLast() 將數值新增到 list 最尾端
        *   removeFirst()   刪除 最開始
        *   removeLast()    刪除 最尾端
        *   getFirst()  getLast() 以此類推 取得 get 也可以
        */

        Collections.sort(list1); // 排序
        for (int i : list1) {
            System.out.println("自動排序語法 : "+i);
        }

        System.out.println("\n----------------------\n");

        /*@ HashMap @*/
        HashMap<String,String> hashmap = new HashMap<String,String>();

        //? 添加 <指標,值> 使用 put 函式
        hashmap.put("第一測試","01");
        hashmap.put("第二測試","02");
        hashmap.put("第三測試","03");
        System.out.println(hashmap);

        //! 一樣能使用 get / set / remove / clear / size 等方法
        //! 取得方式 hashmap.get(指標) 就能得到值

        System.out.println("\n----------------------\n");

        /*@ try進行程式碼試錯 @*/
        try {
            int[] myNumbers = { 1, 2, 3 };
            System.out.println(myNumbers[10]);
        } catch (Exception a) {
            System.out.println("只要try出現exception 就會印出這行");
        } finally {
            System.out.println("無論成功與否都會看到這行");
        }

        System.out.println("\n----------------------\n");

        /*@ 迭代器 iterator @*/

        ArrayList<Integer> number = new ArrayList<Integer>();
        number.add(20);
        number.add(15);
        number.add(30);
        number.add(8);
        number.add(6);
        number.add(80);
        //? 在該 list 當中添加這些值

        Iterator<Integer> nb = number.iterator();   //? 將該list丟入迭代器中
        while(nb.hasNext()){     //? 跑到最後沒有 變成 false 時停止
            int i = nb.next();
            if(i < 10){
                nb.remove();    //? 將小於 10 的數值刪除
            }
        }
        System.out.println(number);

        System.out.println("\n----------------------\n");

        /*@ throw 可自定義錯誤顯示 @*/
        //! throw new ArithmeticException("自定義錯誤顯示");  可用於自定義例外顯示

        /*@ 文本寫入 @*/
        try {
            FileWriter my_txt = new FileWriter("練習.txt", true); // ! 不加true是直接覆蓋
            my_txt.write("練習用程式寫入一段文字,這文字會越寫越多\n");
            my_txt.close();
        }catch (IOException e) {
            System.out.println("寫入錯誤");
        }

        //System.out.println("\n----------------------\n");

        /*@ 文本讀取 @*/
        try {
            File my_txt = new File("練習.txt");
            System.out.println("文本是否存在 : " + my_txt.exists());
            System.out.println("文本是否可讀 : " + my_txt.canRead());
            System.out.println("文本是否可寫 : " + my_txt.canWrite());
            System.out.println("文本名 : " + my_txt.getName() + " 文本路徑 : " + my_txt.getAbsolutePath() + "\n文本大小 : "+ my_txt.length() + "位元組");
            // ! delete() 文本刪除 - list() 查詢資料夾內檔按數量 - mkdir() 新增資料夾

            Scanner sc = new Scanner(my_txt);   //? 這邊讀取上方寫入的資料
            String data = sc.nextLine();

            System.out.println(data);
            sc.close();

            /* -------------------------------------------------------------------------- */

            File my_Linux = new File("C:/Users/s3459/OneDrive/桌面/Linux作業系統基礎指令");
            Scanner sh = new Scanner(my_Linux);

            while (sh.hasNextLine()) {
                System.out.println(sh.nextLine());
            }
            sh.close();

        } catch (FileNotFoundException e) {
            System.out.println("檔案開啟失敗");
        }

        // ? 繼承
        /**
         * todo 在子類別名後輸入 extends (父類別)
         * todo 多重繼承 要使用介面
         * ! interface (名) {}
         * ! 子類別名後輸入 extends (父類別) implements (介面),(介面),(介面)
         * * super.x (指向父類別得參數) 像是 this.x 這樣的東西
         */

        tm1.start(); //todo 執行序開始
        Thread.sleep(10); //todo 延遲10毫秒(1000毫秒 = 1 秒)

        /* 程式執行完時間 */
        long timing2 = System.currentTimeMillis();
        System.out.print("\n程式執行時間 : " + (timing2 - timing1) + " 毫秒\n\n");
    }
}

class _run extends Thread { //? 這邊繼承了 Thread 類進行多線程創建
    //! 也能用 implements Runnable 去抓 Runnable 介面進行實作

    /*
     *  介面啟動線程的方式
     *  Main obj = new Main();
     *  Thread thread = new Thread(obj);
     *  thread.start();
     *  使用 start() 啟動線程
    */

    //! isAlive() 函式避免引發線程之間的問題

    //todo  Thread.sleep(1000) util內的函式 先休息1秒 要休息5秒就直接 (1000*5)

    public void run() { //? 這邊啟動線程
    long timing1 = System.currentTimeMillis();
    String test = "這是一個測試字串";
    String test1 = "這是一個比較用測試字串";

    System.out.println("\n----------------------\n");

    System.out.println("回傳索引值的字元 : " + test.charAt(0)); // 回傳 "這" 將charAt()強制轉型為int 即可直接輸出ascii碼
    System.out.println("回傳索引值的Unicode : " + test.codePointAt(0)); // 回傳 36889
    System.out.println("回傳索引值之前的Unicode : " + test.codePointBefore(3));
    System.out.println("回傳索引值之間的Unicode數量 : " + test.codePointCount(0, 7)); // 回傳7
    System.out.println("回傳基於兩字串中,每個字元的Unicode值 : " + test.compareTo(test1)); // 相同 回傳0 / 小於 回傳值小於0 / 大於 回傳值大於0
    System.out.println("回傳兩字串比較,忽略大小寫差異的Unicode值 : " + test.compareToIgnoreCase(test1)); // 回傳結果 同上
    System.out.println("回傳兩字串是否相等 : " + test.equals(test1)); // 相等回傳 true 反之 false
    System.out.println("將一個字符串附加到另一個字符串的尾端 : " + test.concat(test1));
    System.out.println("回傳一個字串是否包含一個字元序列 : " + test.contains("測試")); // 回傳true contentEquals()判斷是否完全相等
    // ! copyValueOf(字元陣列變數 , 開始索引 , 結束索引) 將該陣列索引值間,字元輸出

    System.out.println("\n----------------------\n");

    System.out.println("判斷字串是否以指定開頭 : " + test.startsWith("這是一個")); // true
    System.out.println("判斷字串是否以指定結尾 : " + test.endsWith("這是一個")); // false
    System.out.println("回傳兩字串比較,忽略大小寫 : " + test.equalsIgnoreCase(test1)); // false 相等會回傳 true
    System.out.println("回傳該字串中,指定字串最一開始的索引值 : " + test.indexOf("字串")); //! indexOf最一開始的索引值 尋找最後出現的索引值 lastIndexOf
    System.out.println("回傳是否為空字串 : " + test.isEmpty()); // false
    System.out.println("回傳字串長度 : " + test.length());
    System.out.println("回傳字串中字元,修改為指定字元,輸出新字串 : " + test.replace('一', '二')); // 字串中 所有該字元都會被修改 replaceAll()修改全部

    System.out.println("\n----------------------\n");

    // ! toUpperCase(轉換大寫) toLowerCase(轉換小寫) toString(轉換成字串型別) substring(從0開始 給予兩個索引值 輸出期間的字元) 也可以只給一個索引值 輸出後續的字串
    /**
     * todo --- 字串判斷補充 ---
     * ? isDigit(是否是數字,只判斷字元) 回傳 true/false
     * ? isLetter(是否是英文單字) 回傳 true/false
     * ? matches (設定輸入規則)
     */

    System.out.println("\n----------------------\n");

    int a = 10, b = 100, c = -10, d;

    System.out.println("a 和 b 較大的是 : " + Math.max(a, b));
    System.out.println("a 和 b 較小的是 : " + Math.min(a, b));
    System.out.println("b 開根號為 : " + Math.sqrt(b));
    System.out.println("c 的絕對值為 : " + Math.abs(c));
    //! Math.pow(常數,次方數) 例如 2 的 3 次方 就可以打 Math.pow(2,3)

    for (int i = 0; i <= 5; i++) {
        d = (int) (Math.random() * 101);
        System.out.println("d 0~100的隨機數為 : " + d);
    }

    System.out.println("\n----------------------\n");

    System.out.println("使用包 : " + My_package._pa);
    System.out.println("使用包 : " + My_package._ap);

    long timing2 = System.currentTimeMillis();
    System.out.print("\n方法執行時間 : " + (timing2 - timing1) + " 毫秒");
    }

    //System.out.println("\n----------------------\n");
}