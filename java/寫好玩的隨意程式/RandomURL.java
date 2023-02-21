import java.util.*;
import java.io.*;
public class RandomURL {
    public static void main(String[] argv) {

        try (Scanner url = new Scanner(System.in)) {
            Random random = new Random();
            boolean w = true;

            FileWriter bat = new FileWriter("網址測試.bat",false);
            while (w) {
                System.out.print("輸入數量: ");

                int enter = url.nextInt();

                if (enter >= 1) {
                    for (int i = 0; i < enter; i++) {
                        String URL = "";
                        for (int j = 0; j < 6; j++) {
                            URL += get(random);
                        }
                        bat.write("start https://reurl.cc/" + URL + "\n");
                    }
                    bat.close();
                } else {
                    throw new Exception();
                }
                w = false;
            }

        } catch (Exception e) {
            System.out.println("錯誤");
            return;
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