class object{
    double volume(double r,double h){
       return 3.14 * (r * r) * h; 
    }
    double volume(double r1,double r2,double r3){
        return ((r1 * r2 * r3) / 3) * 4 * 3.14;
    }
    double volume(double p,double a,double b,double c){
        return Math.sqrt((a + b + c) / 2 * ((a + b + c)/2 -a) * ((a + b + c)/2 -b) * ((a + b + c)/2 -c)) * p / 3;
    }
    int volume(int l,int w,int h){
        return l * w * h;
    }
    double volume(double x1, double y1, double z1, double x2, double y2, double z2 ){
        return Math.abs((x1-x2)*(y1-y2)*(z1-z2));
    }
}
public class j3_1118 {
    public static void main(String[] argv){
        object ob = new object();
        System.out.println("半徑為4.8高為3.5的圓錐體體積為 "+ob.volume(4.8,3.5));
        System.out.println("一個底部三角形高4.7，邊長為4.8 、7.3、5.9,之三角錐體積為 "+ob.volume(4.7,4.8,7.3,5.9));
        System.out.println("一個三軸半徑為4.3 、3.6、3.2之橢球體積為 "+ob.volume(4.3,3.6,3.2));
        System.out.println("一個長為11 ,寬為9,高為12之長方體體積為 "+ob.volume(11,9,12));
        System.out.println("一個兩對角座標分別為 (13,-8,9),(2,5,-7)之長方體體積為 "+ob.volume(13,-8,9,2,5,-7));
    } 
}
