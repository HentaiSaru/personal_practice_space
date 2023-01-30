import java.util.*;

class teamA extends Thread{
    int scend = 0;

    public void run(){

        try{
            sleep(100);
        }catch(InterruptedException e){}

        scend = team.game.runA();
    }

}
class teamB extends Thread{
    int scend = 0;

    public void run(){
        scend = team.game.runB();
    }
}
class team{
    public static team game = new team();
    private boolean AExecuted = false;

    public synchronized int runA(){

        int scend = 0;
        System.out.println("teamA 開始");
        scend = order();
        System.out.println("teamA 共跑了"+scend+"秒");
        System.out.println("teamA 結束");

        AExecuted = true;
        notify();
        return scend;
    }

    public synchronized int runB(){

        int scend = 0;
        System.out.println("teamB 等待中");

        while(!AExecuted) {
            try{
                wait();
            }catch(Exception e){}
        }

        System.out.println("teamB 開始");
        scend=order();
        System.out.println("teamB 共跑了"+scend+"秒" );
        System.out.println("teamB 結束");
        return scend; 

    }

    public int order(){
        int order = 2,running,scend=0;

        for(int i=1;i<=2;i++){
            running = (int)(Math.random() * 6)+5;
            scend += running;
            System.out.println( "第"+i+"棒跑了"+running+ "秒,");
        }
        return scend;
    }
}
public class j5test{
    public static void main(String argv[]) {
        int a,b;
        teamA A = new teamA();
        teamB B = new teamB();

        A.start();B.start();

        try{
            A.join();
            B.join();
        }catch(Exception e){}

        if(A.scend < B.scend)System.out.println("teamA 獲勝");
        else if(A.scend > B.scend)System.out.println("teamB 獲勝");
        else System.out.println("平");
    }
}