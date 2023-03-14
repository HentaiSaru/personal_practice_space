/*
 * Versions 1.1
 * [+] 新增輸出執行指令
 * [+] 變數修正
~~~~~~~~~~~~~~~~~~~~~~~*/
import java.util.*;
import java.io.*;
public class RandomNhentai{
    public static void main(String[] argv){

        try (Scanner NHentai = new Scanner(System.in)){
            FileWriter bat = new FileWriter("本本網址.bat",false);
			System.out.println("輸入任意數字自動給予指定數量本本,輸入數字-1停止該程式\n");
            boolean Cycle_State = true;

			while(Cycle_State){
			    System.out.print("請輸入數量 : ");
			    int enter = NHentai.nextInt();
                if(enter >= 1){
                    for(int i=1;i<=enter;i++){
                        long hentai = (long)(Math.random()*388999+1);
                        bat.write("start https://nhentai.net/g/"+hentai+"/\n");
                    }
                    bat.close();
                }
                else if(enter == -1){
                    System.out.println("程式已終止...");
                    break;
                }
			}
            
		}catch(Exception InputMismatchException){System.out.println("請輸入數字\n程式已終止...");}
    }
}