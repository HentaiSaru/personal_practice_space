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
        System.out.println("teamA �}�l");
        scend = order();
        System.out.println("teamA �@�]�F"+scend+"��");
        System.out.println("teamA ����");

        AExecuted = true;
        notify();
        return scend;
    }

    public synchronized int runB(){

        int scend = 0;
        System.out.println("teamB ���ݤ�");

        while(!AExecuted) {
            try{
                wait();
            }catch(Exception e){}
        }

        System.out.println("teamB �}�l");
        scend=order();
        System.out.println("teamB �@�]�F"+scend+"��" );
        System.out.println("teamB ����");
        return scend; 

    }

    public int order(){
        int order = 2,running,scend=0;

        for(int i=1;i<=2;i++){
            running = (int)(Math.random() * 6)+5;
            scend += running;
            System.out.println( "��"+i+"�ζ]�F"+running+ "��,");
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

        if(A.scend < B.scend)System.out.println("teamA ���");
        else if(A.scend > B.scend)System.out.println("teamB ���");
        else System.out.println("��");
    }
}