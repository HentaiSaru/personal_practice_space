import java.util.*;
import java.io.*;
public class j6 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean con = true;
        String str , input;
        byte[] word;
        int a = 0, b = 0, p = 1, i, j;

        File fid = new File("test.txt");
        fid.delete();

        con: while (con) {

            try {
                FileOutputStream file = new FileOutputStream("test.txt",true);

                System.out.print("請輸入第一數:");
                str = bf.readLine();
                a = Integer.parseInt(str);

                System.out.print("請輸入乘法第二數:");
                str = bf.readLine();
                b = Integer.parseInt(str);

                input = "第"+p+"次\n";
                word = input.getBytes();
                file.write(word,0,word.length);

                for (i = 1; i <= a; i++) {
                    for (j = 1; j <= b; j++) {
                        System.out.printf("i = %d j = %d i*j= %d\t", i, j, i * j);
                        input = "i = "+i+" j = "+j+" i*j= "+(i*j)+"\t";
                        word = input.getBytes();
                        file.write(word,0,word.length);
                    }
                    System.out.println();
                    input = "\n";
                    word = input.getBytes();
                    file.write(word,0,word.length);
                }

                System.out.print("continue?");
                input = "continue?\n";
                word = input.getBytes();
                file.write(word,0,word.length);
                str = bf.readLine();

                if(str.equalsIgnoreCase("No")){
                    input = "你選擇了No\n結束...";
                    word = input.getBytes();
                    file.write(word,0,word.length);
                    file.close();
                    break;
                }
                else if(str.equalsIgnoreCase("Yes")){
                    p++;
                    input = "你選擇了Yes\n";
                    word = input.getBytes();
                    file.write(word,0,word.length);
                    continue con;
                }
                else System.exit(0);

            } catch (IOException e) {
                System.out.print("error");
                return;
            }     
        }
        System.out.print("=====================\n");
        try{
            Scanner sc = new Scanner(fid);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        }catch(Exception e){}
    }
}