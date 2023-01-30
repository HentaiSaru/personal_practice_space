import java.util.*;
public class RandomNhentai{
    public static void main(String[] argv){

        try (Scanner H = new Scanner(System.in)){
			boolean t = true;
			System.out.println("輸入任意數字自動給予指定數量本本,輸入數字-1停止該程式\n");

			while(t){
			    System.out.print("請輸入 : ");
			    int enter = H.nextInt();
                if(enter >= 1){
                    for(int i=1;i<=enter;i++){
                        long hentai = (long)(Math.random()*388999+1);
                        System.out.println("https://nhentai.net/g/"+hentai+"/");
                    }
                }
                else if(enter == -1){
                    System.out.println("程式已終止...");
                    break;
                }
			}
            
		}catch(Exception e){System.out.println("請輸入數字\n程式已終止...");}
    }
}