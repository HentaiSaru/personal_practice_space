/***
 @
 * todo ���T�X�o���I���{���X
 * ! �H�U��N�Ĩ����c�����覡 �@���m�ߨϥ�
 @ 
*/
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.io.*;
public class invoice_v2 {
    public static void main(String[] argv) {
        String fp1 , fp2 , fp3 , fp4 , fp5 , fp6;
        bill fp = new bill();                   //  ?��Ҥ�
        Scanner sc = new Scanner(System.in);    //  ?���ϥΪ̿�J
        fp.run = true;

        try {
            File _txt = new File("��J������.txt"); //  ?�C�����s����� �|�N�O���ɧR��
            _txt.delete();
            FileWriter txt = new FileWriter("��J������.txt",true);

            fp._time(); //  !�I�s�ɶ�
            runLoop:while (fp.run) {
                if (fp.NumberOfEntries > 5)   //  !���J�p�ƾ��j��5���X
                    break;
                else {
                    switch (fp.NumberOfEntries) {
                        case 0:
                            System.out.print(fp._text(1));      //  ?�I�s�r��
                            fp1 = sc.next();
                            System.out.println(fp.enter(fp1));  //  ?�O�_���\��J
                            continue;
                        case 1:
                            System.out.print(fp._text(2));
                            fp2 = sc.next();
                            System.out.println(fp.enter(fp2));
                            continue;
                        case 2:
                            System.out.print("�@ : "+ fp._text(3));
                            fp3 = sc.next();
                            System.out.println(fp.enter(fp3));
                            continue;
                        case 3:
                            System.out.print("�G : "+ fp._text(3));
                            fp4 = sc.next();
                            System.out.println(fp.enter(fp4));
                            continue;
                        case 4:
                            System.out.print("�T : "+ fp._text(3));
                            fp5 = sc.next();
                            System.out.println(fp.enter(fp5));
                            continue;
                        case 5:
                            System.out.print(fp._text(4));
                            fp6 = sc.next();
                            System.out.println(fp.enter(fp6));
                            continue;
                    }
                }continue runLoop; //   ?�^���J�}�Y�j��
            }

            System.out.println("\n�P�Y�����T�X�ۦP : ���� 200 ��\n�P�Y�����|�X�ۦP : ���� 1000 ��\n�P�Y�������X�ۦP : �|�� 4000 ��\n�P�Y�������X�ۦP : �T�� 1�U ��\n�P�Y�����C�X�ۦP : �G�� 4�U ��");
            run_1Loop: while (fp.run) {   //  ?�}�l��J

                System.out.print("\n��J�ݧI�����T�X(��J0����) : ");
                String Redeem = sc.next();
                if (Redeem.equals("0"))break; //  ?���X
                if (Redeem.length() == 3 & Redeem.matches("[+-]?\\d*(\\.\\d+)?") == true) {   //  ?�P�_���שM�O�_���Ʀr
                    fp.judge(Redeem);         //  ?�q�L���J�O�s
                    txt.write(Redeem+"\n");   //  ?�g�J������
                } else {
                    System.out.println("��J���~,�п�J��3�X");
                    continue run_1Loop; // ?��J���~���^���Y
                }
            }
            txt.close();
        } catch (Exception e){System.out.print("�o�ͤ��i�w�������~ , �{���w�פ�....");System.exit(0);} 
    }
}
abstract class preset {

    /**
     *?---�j��ϥ�---
     */int i;
    
    /**
     *?---�P�_����---
     */int prize;

    /**
     *?---�j��Ұ�---
     */boolean run;

    /**
     *?---�p���J---
     */int NumberOfEntries;
}

interface _Comparison {

    // ?---���X�O�s--- 

    ArrayList<String> box = new ArrayList<String>();

}

class bill extends preset implements _Comparison { /* ��J�ݤf */
    int NumberOfEntries = 0, prize = 0;

    void _time() {

        LocalDateTime time = LocalDateTime.now(); // ?���o�t�ήɶ�
        DateTimeFormatter my_time = DateTimeFormatter.ofPattern("��e�ɶ��� : yyyy�~ MM�� dd�� HH:mm:ss");   //? �ɶ��榡
        String formattedDate = time.format(my_time); // ?Ū���t�ήɶ�+�榡�r��
        System.out.println(formattedDate); // ?��X�ɶ�

    }

    /**
     * @param _text
     * 
     * !�r��^��
     */
    String _text(int _text) {

        switch (_text) {
            case 1:
                return "��J����S�O�����X : ";
            case 2:
                return "��J����S�����X : ";
            case 3:
                return "��J����Y�����X : ";
            case 4:
                return "��J����W�}���X : ";
            default:
                return "";
        }
    }

    /**
     * @param enter
     * 
     * !�ĤG�h�P�_
     */
    String enter(String enter){

            if(enter.length() == 8 & NumberOfEntries < 5 & enter.matches("[+-]?\\d*(\\.\\d+)?") == true){   //  ?����P�_�Ʀr����ܦ����O�h�l�� ��½m�ߥ�
                NumberOfEntries++;
                save(enter);
                return "��J���\\n";
            }
            else if(NumberOfEntries == 5 & enter.length() == 3 & enter.matches("[+-]?\\d*(\\.\\d+)?") == true){
                NumberOfEntries++;
                save(enter);
                return "��J���\\n";
            }
            else return "��J���~�Э��s��J...\n";
    }

	/**
     * @param save
     * 
     * !�x�s
     */

    void save(String save) {
        box.add(save);
    }

    /**
     * @param judge
     * 
     * !��J�P�_
     */
    void judge(String judge) {

    try{
        FileWriter winning = new FileWriter("��������.txt",true);
        StringWriter _winning = new StringWriter();
        for (i = 0; i <= 5; i++) {
            if (box.get(i).endsWith(judge) == true) {   //  ?�P�_�r��O�_�H��J�ȵ���
                System.out.println("\n���ߤ���,�ЦA�T�{�������B");  //?�����F�L�X  
                _winning.write(judge);
                winning.write(_winning.toString()+"\n\n");
                
                // *--�H�U�P�_���������X----------------------------------------
                if(box.get(i).equals(box.get(0)) == true)                       //  ?�P�_�r��P������Ƭ۵�
                    System.out.println("�S�O�����X�T�{(1000�U) => "+box.get(0));
                else if(box.get(i).equals(box.get(1)) == true)
                    System.out.println("�S�����X�T�{(200�U) => "+box.get(1));
                else if(box.get(i).equals(box.get(5)) == true)
                    System.out.println("�W�}���X�T�{(200��) => "+box.get(5));
                else
                    System.out.println("�Y�����X�T�{(20�U) => "+box.get(i));

                prize = 1;
                winning.close();
            } else continue;
        }
    }catch (Exception e){System.out.print("�o�ͤ��i�w�������~ , �{���w�פ�....");System.exit(0);}

        // *---�L����������b�P�_�j��~ , ���M�|�L�X6��������---   
        if(prize == 0) { // ?�j�鵲����P�_ �����ȬO�_��0 (0�N�O�S���� �������|�ܦ�1)
            System.out.println("�S�������ЦA���A�F");
            prize = 0;
        }else
            prize = 0; // ?�N���������������k0 �H�K�U�@���ϥ�
    }

}