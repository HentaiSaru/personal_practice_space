import java.util.*;
class player extends Thread{
    String name;
    int delay;

    public player(String name,int delay){
        this.name = name;
        this.delay = delay;
    }

    public void run(){
        try{
            sleep(delay);
        }catch(Exception e){}

        System.out.println(name+"準備完成");
    }
}
public class quiz {
    public static void main(String[] argv) {
        player p1 = new player("王小明",200);
        player p2 = new player("陳小中",100);
        p1.start();
        p2.start();
        try{
            p1.join();
            p2.join();
        }catch(Exception e){}
        System.out.println("全部完成");
    }
}