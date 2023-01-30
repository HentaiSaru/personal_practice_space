import java.util.*;
public class KeyGenerator extends Thread{
    public static void main(String[] argv){
        Scanner scanner = new Scanner(System.in);
        InitialText InitialSetting = new InitialText();
        key_generation key = new key_generation();
        int i;

        //? 程式開始時畫面顯示
        try{
            for(i=0;i<InitialSetting.welcome.length;i++){
                System.out.print(InitialSetting._welcome(i));
                Thread.sleep(100);
            }
            System.out.println("\n");
        }catch(InterruptedException a){}

        /**
         **@輸入生成密鑰的長度
         */
        System.out.print(InitialSetting.KeyLength);
        try{
            InitialSetting._KeyLength = scanner.nextInt();
            System.out.println("\n");   
        }catch(Exception e){System.out.println("輸入錯誤請輸入數字,程式已終止...");return;}


        /**
         **@輸入生成密鑰的數量 
         */
        System.out.print(InitialSetting.NumberOfKeysToGenerate);
        try{
            InitialSetting._NumberOfKeysToGenerate = scanner.nextInt();
            System.out.println("\n");
        }catch(Exception e){System.out.println("輸入錯誤自動預設為1");scanner.next();System.out.println("\n");}


        /**
         **@選擇是否更改密鑰生成格式
         */
        System.out.print(InitialSetting.Formatting);
        try{
            InitialSetting.FormattingYesORNo = scanner.next();
            System.out.println("\n");
        }catch(Exception e){System.out.println("輸入錯誤請輸(Y/N),程式已終止...");return;}


        /**
         **@如果同意更改格式 
         */
        if(InitialSetting.RFormattingYesORNo().equals("y") == true){
            System.out.print(InitialSetting.FormatJudgment);
            try{
                InitialSetting._FormatJudgment = scanner.nextInt();
                System.out.println("\n");
            }catch(Exception e){InitialSetting._FormatJudgment = 3;System.out.print("你輸入的不是數字,將預設值改成你全都要...\n");scanner.close();}
        }key.ParameterPassing(InitialSetting._KeyLength,InitialSetting._NumberOfKeysToGenerate,InitialSetting._FormatJudgment);
        //! 上方呼叫方法進行傳值


        /**
         **@密鑰呼叫生成 
         */
        try{
            System.out.print("密鑰開始生成");
            for(i=0;i<3;i++){sleep(500);System.out.print(".");}
            System.out.println("\n");
            key.start();
        }catch(Exception e){}

    }
}
interface StringOutput{

    String[] welcome = {"歡","迎","來","到","密","鑰","產","生","器"};
    String KeyLength = "請輸入產生密鑰長度(數字)--> ";
    String Formatting = "是否要設定生成格式,預設格式為小寫英文+數字(Y/N)--> ";
    String FormatJudgment = "只增加大寫英文(1) 增加特殊符號和大寫英文(2)--> ";
    String NumberOfKeysToGenerate = "輸入需要生成的密鑰數量--> ";
}
class InitialText implements StringOutput{

    //! 判斷格式更改變數
    String FormattingYesORNo;

    //! 長度 - 更改格式確認 - 密鑰生成數量
    int _KeyLength,_FormatJudgment,_NumberOfKeysToGenerate=1;
    
    /**
     * @param value
     * @return
     **@程式開始字串回傳
     */
    String _welcome(int value){
        return welcome[value];
    }


    /**
     * @return
     **@判斷是否需要更改生成格式 將輸入轉換為小寫後回傳 
     */
    String RFormattingYesORNo(){
        return FormattingYesORNo.toLowerCase();
    }

}
class key_generation extends Thread {
    //! 密鑰生成保存庫
    ArrayList<Character> KeyArea = new ArrayList<>();

    //! 特殊符號模板
    char[] _KeyArea = {'!','-','?','_'};

    //! 長度 格式 數量 ...
    int _KeyLength_,_NumberOfKeysToGenerate_,_FormatJudgment_;

    //! 第一次判斷用變數
    int ASCIIrange;

    //! 判斷密碼強度
    int PasswordStrengthCheck,CheckNumbers,CheckLetters,CheckSymbol,CheckWord;
    String KeyStrength;

    /**
     **@傳值接口
     * @param _KeyLength
     * @param _NumberOfKeysToGenerate
     * @param _FormatJudgment
     */
    public void ParameterPassing(int _KeyLength,int _NumberOfKeysToGenerate,int _FormatJudgment){
        _KeyLength_ = _KeyLength;
        _NumberOfKeysToGenerate_ = _NumberOfKeysToGenerate;
        _FormatJudgment_ = _FormatJudgment;
    }


    /**
     **@第一次判斷所選格式 
     */
    public void generate0(){
        switch(_FormatJudgment_){
            case 0: ASCIIrange = (int)(Math.random()*2)+1;break; //? 都是小寫英文+數字
            case 1: ASCIIrange = (int)(Math.random()*3)+1;break; //? 增加了大寫英文
            case 2: ASCIIrange = (int)(Math.random()*4)+1;break; //? 增加了符號
        }
    }

    /**
     **@帶入格式進行生成 
     */
    public void generate1(){
        
        //! 1.小寫英文 2.數字 3.大寫英文 4.特殊符號
        switch(ASCIIrange){

            case 1: KeyArea.add((char)((Math.random()*26)+97));break;
            case 2: KeyArea.add((char)((Math.random()*10)+48));break;
            case 3: KeyArea.add((char)((Math.random()*26)+65));break;
            case 4: KeyArea.add(_KeyArea[(int)(Math.random()*3)]);break;
        }
    }

    /**
     **執行序啟動方法 
     */
    public void run(){

        //! 第一層迴圈 密鑰所需生成數量
        //? 第二層迴圈 密鑰生成長度 
        for(int i=1;i<=_NumberOfKeysToGenerate_;i++){
            for(int j=0;j<_KeyLength_;j++){
                generate0();
                generate1();
            }

            //! 進行遍歷list 進行密鑰輸出 輸出後重製list 方便之後的密鑰存放
            System.out.print("你的密鑰為 : ");
            for (int k = 0; k < KeyArea.size(); k++) {
                System.out.print(KeyArea.get(k));

                //! 因為不知道如何將List傳到其他方法用了一個很爛的方式寫了密碼強度判斷
                if(KeyArea.size() <= 8){
                    if(PasswordStrengthCheck == 0)PasswordStrengthCheck += 5;
                    if(KeyArea.get(k) >= 'a' & KeyArea.get(k) <= 'z'){CheckWord++; if(CheckWord == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= 'A' & KeyArea.get(k) <= 'Z'){CheckLetters++; if(CheckLetters == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= '0' & KeyArea.get(k) <= '9'){CheckNumbers++; if(CheckNumbers == 1)PasswordStrengthCheck+=10;else if(CheckNumbers == 2)PasswordStrengthCheck+=10;}
                    for(int l=0;l<_KeyArea.length;l++){
                        if(KeyArea.get(k).equals(_KeyArea[l]) == true){CheckSymbol++; if(CheckSymbol == 1)PasswordStrengthCheck+=10;else if(CheckSymbol == 2)PasswordStrengthCheck+=15;}
                    }    
                }
                else if(KeyArea.size()>=9 & KeyArea.size()<=14){
                    if(PasswordStrengthCheck == 0)PasswordStrengthCheck += 10;
                    if(KeyArea.get(k) >= 'a' & KeyArea.get(k) <= 'z'){CheckWord++; if(CheckWord == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= 'A' & KeyArea.get(k) <= 'Z'){CheckLetters++; if(CheckLetters == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= '0' & KeyArea.get(k) <= '9'){CheckNumbers++; if(CheckNumbers == 1)PasswordStrengthCheck+=10;else if(CheckNumbers == 2)PasswordStrengthCheck+=10;}
                    for(int l=0;l<_KeyArea.length;l++){
                        if(KeyArea.get(k).equals(_KeyArea[l]) == true){CheckSymbol++; if(CheckSymbol == 1)PasswordStrengthCheck+=10;else if(CheckSymbol == 2)PasswordStrengthCheck+=15;}
                    }    
                }
                else{
                    if(PasswordStrengthCheck == 0)PasswordStrengthCheck += 25;
                    if(KeyArea.get(k) >= 'a' & KeyArea.get(k) <= 'z'){CheckWord++; if(CheckWord == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= 'A' & KeyArea.get(k) <= 'Z'){CheckLetters++; if(CheckLetters == 1)PasswordStrengthCheck += 10;}
                    if(KeyArea.get(k) >= '0' & KeyArea.get(k) <= '9'){CheckNumbers++; if(CheckNumbers == 1)PasswordStrengthCheck+=10;else if(CheckNumbers == 2)PasswordStrengthCheck+=10;}
                    for(int l=0;l<_KeyArea.length;l++){
                        if(KeyArea.get(k).equals(_KeyArea[l]) == true){CheckSymbol++; if(CheckSymbol == 1)PasswordStrengthCheck+=10;else if(CheckSymbol == 2)PasswordStrengthCheck+=15;}
                    }    
                }
            }
            if(PasswordStrengthCheck >= 90)KeyStrength ="超級強";
            else if(PasswordStrengthCheck >= 80)KeyStrength ="非常強";
            else if(PasswordStrengthCheck >= 70)KeyStrength ="強";
            else if(PasswordStrengthCheck >= 60)KeyStrength ="普通";
            else if(PasswordStrengthCheck >= 50)KeyStrength ="弱";
            else if(PasswordStrengthCheck >= 25)KeyStrength ="非常弱";
            else KeyStrength ="垃圾";
            System.out.print("\n密碼強度為 : "+ KeyStrength);
            
            try{
                sleep(500);
            }catch(Exception a){}

            PasswordStrengthCheck=0;CheckNumbers=0;CheckLetters=0;CheckSymbol=0;CheckWord=0;
            KeyArea.clear();
            System.out.println("\n");
        } 
    }
    
}