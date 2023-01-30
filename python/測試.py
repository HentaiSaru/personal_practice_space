import pyautogui
import time
from pynput import mouse

def on_click(x, y, button, pressed):
    if button == mouse.Button.left and pressed:
        print("你在當前x,y座標按下了:",x,y)

# 舊位置
last_pos = pyautogui.position()
listener = mouse.Listener(on_click=on_click)
listener.start()

try:
    while True:
        
        # 新位置
        new_pos = pyautogui.position()

        # 判斷如果上次的位置,不等於新的位置了話,延時0.2秒輸出當前位置
        time.sleep(0.2)
        if last_pos != new_pos:
            print(new_pos)
            last_pos = new_pos

except KeyboardInterrupt:
    listener.stop()
