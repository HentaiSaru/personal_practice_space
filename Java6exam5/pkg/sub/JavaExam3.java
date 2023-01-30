package pkg.sub;
public class JavaExam3{
    private String s;
    private int a,b;

    public JavaExam3(String n,int n1,int n2){
        s = n;
        a = n1;
        b = n2;
    }

    public int getMath(){
        if(s.equals("power")){
            a = (int)Math.pow(a,b);
            return a;
        }else return 0;
    }
}