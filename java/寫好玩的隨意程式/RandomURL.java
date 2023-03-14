/*
 * Versions 1.1
 * [+] 變數修正
 * [+] 新增驗證功能待測試
 * [+] 新增方法待測試
~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.*;
import java.io.*;
import java.net.*;
public class RandomURL {
    public static void main(String[] argv) {

        try (Scanner url = new Scanner(System.in)) {
            Random random = new Random();
            boolean Cycle_State = true;
            boolean OutStatus = false;
            FileWriter bat = new FileWriter("網址測試.bat", false);

            while (Cycle_State) {
                System.out.print("輸入數量: ");
                int enter = url.nextInt();

                if (enter >= 1) {
                    for (int i = 0; i < enter; i++) {
                        String URL = Random_URL(random);
                        if (VerifyURL(URL)) {
                            bat.write("start https://reurl.cc/" + URL + "\n");
                            OutStatus = true;
                        } else {
                            i--;
                        }
                    }
                    bat.close();
                    success_or_failure_judgment(OutStatus);
                } else {
                    throw new Exception();
                }
                Cycle_State = false;
            }
        } catch (Exception e) {
            System.out.println("錯誤");
            return;
        }
    }

    public static String Random_URL(Random random) {
        String URL = "";
        for (int j = 0; j < 6; j++) {
            URL += get(random);
        }
        return URL;
    }

    public static boolean VerifyURL(String URL) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://reurl.cc/" + URL).openConnection();
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        return responseCode == HttpURLConnection.HTTP_OK;
    }

    public static void success_or_failure_judgment(boolean OutStatus) {
        if (OutStatus) {
            System.out.println("成功輸出");
        } else {
            System.out.println("無輸出");
        }
    }

    public static char get(Random random) {
        int i = random.nextInt(3);
        switch (i) {
            case 0:
                return (char) (random.nextInt(26) + 'A');
            case 1:
                return (char) (random.nextInt(26) + 'a');
            case 2:
                return (char) (random.nextInt(10) + '0');
        }
        return ' ';
    }
}