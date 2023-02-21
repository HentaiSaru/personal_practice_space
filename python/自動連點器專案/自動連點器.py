from pynput import keyboard
import configparser as config
import pyautogui
import time
import os

"""
Versions 1.0
+ 隨意的簡單練習程式
      
預計增加
+ UI介面
+ 更好的設置
+ 代碼優化
   
"""

############################################################################

try:

    fileName = "./Set.ini"

    infile = config.ConfigParser()
    infile.read(fileName,"UTF-8")

    start = infile.get("set","start")
    m = infile.get("set","minute")
    s = infile.get("set","second")
    button = infile.get("set","button")
    speed = infile.get("set","speed")

    YesorNo = input("已存在上次的設置,是否要重新設置(y/n):")

    if YesorNo == "y" or YesorNo == "Y":
        raise IOError()
    elif YesorNo == "n" or YesorNo == "N":
        pass
    else:
        raise IOError()

############################################################################

except:

    file = open("Set.ini","w")
    file.write("[set]\n")

    while True:

        start = input("請設置開始按鈕:")

        if len(start) == 0:
            print("輸入錯誤,不可為空\n")
        else:
            print("您的開始設定為:"+start+"\n")
            break

    file.write("start="+start+"\n")

############################################################################
    
    while True:

        m = input("請設置執行時間(分)沒有就打0:")
        s = input("請設置執行時間(秒)沒有就打0:")

        if len(m) == 0 or len(s) == 0:
            print("輸入錯誤,不可為空\n")
        else:
            print("執行時間設定為: {}分 {}秒 \n".format(m,s))
            break

    file.write("minute="+m+"\n")
    file.write("second="+s+"\n")
    
############################################################################

    while True:
        button = input("請設置連點的按鈕為(左鍵left)或(右鍵right),請輸入英文:").lower()
        if button in ['right','left'] :
            print("您的按鈕設定為:"+button+"\n")
            break
        else:
            print("請確認是否有輸入錯誤\n")

    file.write("button="+button+"\n")

############################################################################

    while True:
        speed = input("請設置連點的速度(1秒/0.1秒/0.01秒以此類推,輸入數字即可,太快電腦承受不了):")
        if len(speed) > 0 :
            print("您的速度設定為:"+speed+"\n")
            break
        else:
            print("請確認是否有輸入錯誤\n")

    file.write("speed="+speed+"\n")
    file.close()

###########################################################################

def TimeCalculation(m,s,speed):
    
    frequency = (m*60 + s) / speed
    frequency = int(frequency)
    return frequency

###########################################################################

time.sleep(0.5)
os.system("cls")

print("可直接在生成設定檔內更改設定")
print("開始快捷鍵:"+start)
print("執行時間為:{}分{}秒".format(m,s))
print("連點按鍵:"+button)
print("連點速度:"+speed)
print("按下 {} 即可開始運行".format(start))

############################################################################

speed = float(speed)
Time = TimeCalculation(int(m),int(s),speed)

def on_press(key):

    try:

        if key.char == start:
            
            print("開始運行~")
            pyautogui.click(x=None, y=None, interval=speed , clicks=Time  , button=button)
            print("結束運行~")

    except AttributeError:
        pass

def on_release(key):

    if key.char == keyboard.Key.esc:
        print("結束")
        pass

with keyboard.Listener(
       on_press=on_press,
       on_release=on_release) as listener:
   listener.join()
