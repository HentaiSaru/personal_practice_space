import java.time.*;
import java.time.format.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import _pack.My_package;

enum tt {
    t1, t2, t3, t4
}

//! Scanner �p���� next() �|�����ťժ��즳�Ŀ�J�~�}�lŪ�� nextLine() �|�s�ťէ���Ū��������Uenter

public class test {
    public static void main(String[] argv) throws InterruptedException {
        _run tm1 = new _run();

        /*@ �p��{���}�l�ɶ� @*/
        long timing1 = System.currentTimeMillis();

        tt me = tt.t3;
        System.out.println("�T�|�m�߿�X : " + me);

        for (tt me1 : tt.values()) {
            System.out.println("�T�|�m�߹M����X : " + me1);
        }

        System.out.println("\n----------------------\n");

        /*@ �ɶ���X @*/
        Date date = new Date(); //? ²���ɶ����o
        System.out.println(date); //? �w�]��X�� : �P�� ��� �� 24:00:00 CST 2022
        
        //!�榡�Ƥ��
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(Format.format(date));    //? �o��O�ϥΤF text �M�󲣥�
        
        //* boolean after(Date date) �Y��եΦ���k��Date��H�b���w��������^true,�_�h��^false�C
        //* boolean before(Date date) �Y��եΦ���k��Date��H�b���w������e��^true,�_�h��^false�C

        //! �S�O��X��k
        System.out.printf("HH:MM:SS�G%tT%n",date); //? 00:00:00 24�p�ɨ�
        /*
        * %tc ��������P�ɶ��T�� 
        * %tF 2000-07-05 �~���榡
        * %tD 07/05/2000 ���~�榡
        * %tr 02:25:51 �U�� (12�p�ɨ� �ɤ���)
        * %tT 14:25:51 (24�p�ɨ� �ɤ���)
        * %tR 14:18 (24�p�ɨ� �ɤ�)
        */

        //! ����榡 yyyy-mm-dd-E (�褸/��/��/�P��)
        /*
        *   G ����
        *   y �|��~�� 2000
        *   M ���
        *   d ��
        *   E �P���X
        *   h 12�p�ɨ�
        *   H 24�p�ɨ�
        *   a A.M/P.M �аO
        *   m ��
        *   s ��
        *   S �@��
        *   z �ɰ�
        *   boolean isLeapYear(int year) �T�w���w���~���O�_?�|�~�C
        */
        
        //! Calendar�����o�ɶ�
        Calendar testC = Calendar.getInstance();
        int year = testC.get(Calendar.YEAR);
        int month = testC.get(Calendar.MONTH);
        int _date = testC.get(Calendar.DATE);
        int hour = testC.get(Calendar.HOUR_OF_DAY);
        int minute = testC.get(Calendar.MINUTE);
        int second = testC.get(Calendar.SECOND);

        System.out.printf("%d�~-%d��-%d�� %d��-%d��-%d��", year,month,_date,hour,minute,second);

        System.out.println("\n----------------------\n");

        /*@ List @*/
        //! ���ӻP list �ۦ����F�� HashSet �ŧi�覡�@�� HashSet<String> cars = new HashSet<String>()
        //! ���ӯS��禡 cars.contains("Mazda"); contains ��k �i�����d�߸Ӷ��جO�_�b hash ��
        ArrayList<String> list = new ArrayList<String>(); //? list�ھ�<Integer><Boolean><Character><Double>�i�O�s���P��k
        list.add("List�m��1");
        list.add("List�m��2");
        list.add("List�m��3");
        list.add("List�m��4");
        list.add("List�m��5");

        System.out.println("�X�ݯ��� : " + list.get(4));
        System.out.println("�ק�e : " + list);

        list.set(0, "List�ק�1");
        list.set(4, "List�ק�5");

        System.out.println("�ק�� : " + list + "�j�p" + list.size());

        //! �R���y�k : list.remove(0);
        //! �M������ : list.clear();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("\n----------------------\n");

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(10);
        list1.add(50);
        list1.add(20);
        list1.add(40);
        list1.add(30);

        //! Collections �O�@�ӯS��禡 Collections.reverse(�}�C����)
        /*
        *   �������
        *   addFirst() �N�ƭȷs�W�� list �̶}�l
        *   addLast() �N�ƭȷs�W�� list �̧���
        *   removeFirst()   �R�� �̶}�l
        *   removeLast()    �R�� �̧���
        *   getFirst()  getLast() �H������ ���o get �]�i�H
        */

        Collections.sort(list1); // �Ƨ�
        for (int i : list1) {
            System.out.println("�۰ʱƧǻy�k : "+i);
        }

        System.out.println("\n----------------------\n");

        /*@ HashMap @*/
        HashMap<String,String> hashmap = new HashMap<String,String>();

        //? �K�[ <����,��> �ϥ� put �禡
        hashmap.put("�Ĥ@����","01");
        hashmap.put("�ĤG����","02");
        hashmap.put("�ĤT����","03");
        System.out.println(hashmap);

        //! �@�˯�ϥ� get / set / remove / clear / size ����k
        //! ���o�覡 hashmap.get(����) �N��o���

        System.out.println("\n----------------------\n");

        /*@ try�i��{���X�տ� @*/
        try {
            int[] myNumbers = { 1, 2, 3 };
            System.out.println(myNumbers[10]);
        } catch (Exception a) {
            System.out.println("�u�ntry�X�{exception �N�|�L�X�o��");
        } finally {
            System.out.println("�L�צ��\�P�_���|�ݨ�o��");
        }

        System.out.println("\n----------------------\n");

        /*@ ���N�� iterator @*/

        ArrayList<Integer> number = new ArrayList<Integer>();
        number.add(20);
        number.add(15);
        number.add(30);
        number.add(8);
        number.add(6);
        number.add(80);
        //? �b�� list ���K�[�o�ǭ�

        Iterator<Integer> nb = number.iterator();   //? �N��list��J���N����
        while(nb.hasNext()){     //? �]��̫�S�� �ܦ� false �ɰ���
            int i = nb.next();
            if(i < 10){
                nb.remove();    //? �N�p�� 10 ���ƭȧR��
            }
        }
        System.out.println(number);

        System.out.println("\n----------------------\n");

        /*@ throw �i�۩w�q���~��� @*/
        //! throw new ArithmeticException("�۩w�q���~���");  �i�Ω�۩w�q�ҥ~���

        /*@ �奻�g�J @*/
        try {
            FileWriter my_txt = new FileWriter("�m��.txt", true); // ! ���[true�O�����л\
            my_txt.write("�m�ߥε{���g�J�@�q��r,�o��r�|�V�g�V�h\n");
            my_txt.close();
        }catch (IOException e) {
            System.out.println("�g�J���~");
        }

        //System.out.println("\n----------------------\n");

        /*@ �奻Ū�� @*/
        try {
            File my_txt = new File("�m��.txt");
            System.out.println("�奻�O�_�s�b : " + my_txt.exists());
            System.out.println("�奻�O�_�iŪ : " + my_txt.canRead());
            System.out.println("�奻�O�_�i�g : " + my_txt.canWrite());
            System.out.println("�奻�W : " + my_txt.getName() + " �奻���| : " + my_txt.getAbsolutePath() + "\n�奻�j�p : "+ my_txt.length() + "�줸��");
            // ! delete() �奻�R�� - list() �d�߸�Ƨ����ɫ��ƶq - mkdir() �s�W��Ƨ�

            Scanner sc = new Scanner(my_txt);   //? �o��Ū���W��g�J�����
            String data = sc.nextLine();

            System.out.println(data);
            sc.close();

            /* -------------------------------------------------------------------------- */

            File my_Linux = new File("C:/Users/s3459/OneDrive/�ୱ/Linux�@�~�t�ΰ�¦���O");
            Scanner sh = new Scanner(my_Linux);

            while (sh.hasNextLine()) {
                System.out.println(sh.nextLine());
            }
            sh.close();

        } catch (FileNotFoundException e) {
            System.out.println("�ɮ׶}�ҥ���");
        }

        // ? �~��
        /**
         * todo �b�l���O�W���J extends (�����O)
         * todo �h���~�� �n�ϥΤ���
         * ! interface (�W) {}
         * ! �l���O�W���J extends (�����O) implements (����),(����),(����)
         * * super.x (���V�����O�o�Ѽ�) ���O this.x �o�˪��F��
         */

        tm1.start(); //todo ����Ƕ}�l
        Thread.sleep(10); //todo ����10�@��(1000�@�� = 1 ��)

        /* �{�����槹�ɶ� */
        long timing2 = System.currentTimeMillis();
        System.out.print("\n�{������ɶ� : " + (timing2 - timing1) + " �@��\n\n");
    }
}

class _run extends Thread { //? �o���~�ӤF Thread ���i��h�u�{�Ы�
    //! �]��� implements Runnable �h�� Runnable �����i���@

    /*
     *  �����Ұʽu�{���覡
     *  Main obj = new Main();
     *  Thread thread = new Thread(obj);
     *  thread.start();
     *  �ϥ� start() �Ұʽu�{
    */

    //! isAlive() �禡�קK�޵o�u�{���������D

    //todo  Thread.sleep(1000) util�����禡 ����1�� �n��5��N���� (1000*5)

    public void run() { //? �o��Ұʽu�{
    long timing1 = System.currentTimeMillis();
    String test = "�o�O�@�Ӵ��զr��";
    String test1 = "�o�O�@�Ӥ���δ��զr��";

    System.out.println("\n----------------------\n");

    System.out.println("�^�ǯ��ޭȪ��r�� : " + test.charAt(0)); // �^�� "�o" �NcharAt()�j���૬��int �Y�i������Xascii�X
    System.out.println("�^�ǯ��ޭȪ�Unicode : " + test.codePointAt(0)); // �^�� 36889
    System.out.println("�^�ǯ��ޭȤ��e��Unicode : " + test.codePointBefore(3));
    System.out.println("�^�ǯ��ޭȤ�����Unicode�ƶq : " + test.codePointCount(0, 7)); // �^��7
    System.out.println("�^�ǰ���r�ꤤ,�C�Ӧr����Unicode�� : " + test.compareTo(test1)); // �ۦP �^��0 / �p�� �^�ǭȤp��0 / �j�� �^�ǭȤj��0
    System.out.println("�^�Ǩ�r����,�����j�p�g�t����Unicode�� : " + test.compareToIgnoreCase(test1)); // �^�ǵ��G �P�W
    System.out.println("�^�Ǩ�r��O�_�۵� : " + test.equals(test1)); // �۵��^�� true �Ϥ� false
    System.out.println("�N�@�Ӧr�Ŧ���[��t�@�Ӧr�Ŧꪺ���� : " + test.concat(test1));
    System.out.println("�^�Ǥ@�Ӧr��O�_�]�t�@�Ӧr���ǦC : " + test.contains("����")); // �^��true contentEquals()�P�_�O�_�����۵�
    // ! copyValueOf(�r���}�C�ܼ� , �}�l���� , ��������) �N�Ӱ}�C���ޭȶ�,�r����X

    System.out.println("\n----------------------\n");

    System.out.println("�P�_�r��O�_�H���w�}�Y : " + test.startsWith("�o�O�@��")); // true
    System.out.println("�P�_�r��O�_�H���w���� : " + test.endsWith("�o�O�@��")); // false
    System.out.println("�^�Ǩ�r����,�����j�p�g : " + test.equalsIgnoreCase(test1)); // false �۵��|�^�� true
    System.out.println("�^�ǸӦr�ꤤ,���w�r��̤@�}�l�����ޭ� : " + test.indexOf("�r��")); //! indexOf�̤@�}�l�����ޭ� �M��̫�X�{�����ޭ� lastIndexOf
    System.out.println("�^�ǬO�_���Ŧr�� : " + test.isEmpty()); // false
    System.out.println("�^�Ǧr����� : " + test.length());
    System.out.println("�^�Ǧr�ꤤ�r��,�קאּ���w�r��,��X�s�r�� : " + test.replace('�@', '�G')); // �r�ꤤ �Ҧ��Ӧr�����|�Q�ק� replaceAll()�ק����

    System.out.println("\n----------------------\n");

    // ! toUpperCase(�ഫ�j�g) toLowerCase(�ഫ�p�g) toString(�ഫ���r�ꫬ�O) substring(�q0�}�l ������ӯ��ޭ� ��X�������r��) �]�i�H�u���@�ӯ��ޭ� ��X���򪺦r��
    /**
     * todo --- �r��P�_�ɥR ---
     * ? isDigit(�O�_�O�Ʀr,�u�P�_�r��) �^�� true/false
     * ? isLetter(�O�_�O�^���r) �^�� true/false
     * ? matches (�]�w��J�W�h)
     */

    System.out.println("\n----------------------\n");

    int a = 10, b = 100, c = -10, d;

    System.out.println("a �M b ���j���O : " + Math.max(a, b));
    System.out.println("a �M b ���p���O : " + Math.min(a, b));
    System.out.println("b �}�ڸ��� : " + Math.sqrt(b));
    System.out.println("c ������Ȭ� : " + Math.abs(c));
    //! Math.pow(�`��,�����) �Ҧp 2 �� 3 ���� �N�i�H�� Math.pow(2,3)

    for (int i = 0; i <= 5; i++) {
        d = (int) (Math.random() * 101);
        System.out.println("d 0~100���H���Ƭ� : " + d);
    }

    System.out.println("\n----------------------\n");

    System.out.println("�ϥΥ] : " + My_package._pa);
    System.out.println("�ϥΥ] : " + My_package._ap);

    long timing2 = System.currentTimeMillis();
    System.out.print("\n��k����ɶ� : " + (timing2 - timing1) + " �@��");
    }

    //System.out.println("\n----------------------\n");
}