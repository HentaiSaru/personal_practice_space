from pynput import mouse
import pyautogui
import time
import os

os.system("color A")
os.system("@echo off")
os.system("cls")
os.system("@ ECHO.")
os.system("@ ECHO.~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 偵測滑鼠座標位置程序 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
os.system("@ ECHO.")
os.system("@ ECHO                                            按下左鍵可記錄下當前位置座標")
os.system("@ ECHO.")
os.system("@ ECHO                                            按下右鍵將會結束程式並且輸出")
os.system("@ ECHO.")
os.system("@ ECHO                                     輸出位置於RecordPoint目錄下的RecordPoint.txt")
os.system("@ ECHO.")
os.system("@ ECHO -----------------------------------------------------------------------------------------------------------------------")
os.system("@ ECHO                                                按任意鍵開始運行程式")
os.system("@ ECHO -----------------------------------------------------------------------------------------------------------------------")
os.system("@ ECHO.")
os.system("pause")
os.system("@ ECHO 程式開始運行~")

"""
創建一個box用於存取每次按下滑鼠左鍵時的座標位置
宣告兩個全域變數 pos_x , pos_y 用於保存new_pos的參數
"""
box = []
global pos_x , pos_y


"""新增一個監聽滑鼠按鍵的方法"""

def on_click(x,y,button,pressed):
    if button == mouse.Button.left and pressed: #偵測到滑鼠左鍵時

        box.append(str(pos_x)+","+str(pos_y))   #將獲得的x,y座標轉型成str放至box中

    elif button == mouse.Button.right and pressed:  #偵測到滑鼠右鍵時

        file= open("./RecordPoint/RecordPoint.txt","w") #在RecordPoint資料夾內創建一個文本

        for i in box:
            file.write("座標點 : "+i+"\n")              #將box內所有內容寫至文本

        file.close()

        os._exit(0)                                 #無拋出例外直接強制終止程式


"""滑鼠當前的舊位置"""
last_pos = pyautogui.position()

"""持續監聽滑鼠點擊事件"""
listener = mouse.Listener(on_click=on_click)
listener.start()

try:

    while True:
        
        """移動後滑鼠的新位置"""
        new_pos = pyautogui.position()

        """判斷如果上次的位置,不等於新的位置了話,延時0.2秒輸出當前位置"""
        time.sleep(0.2)
        if last_pos != new_pos:
            pos_x , pos_y = new_pos
            print(new_pos)

            """並將就位置參數用新位置參數覆蓋掉"""
            last_pos = new_pos

except KeyboardInterrupt:
    listener.stop()
    pass