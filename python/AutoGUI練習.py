## 先取得包 ##
import pyautogui
import cv2 as cv
import time
import os

## 獲取螢幕的大小 ##
size_Width, size_Height = pyautogui.size()

## 獲取滑鼠當前位置 ##
#mouse_pos = pyautogui.position()
#mouseX , mouseY = pyautogui.position()


def get_xy(template):

    ## 截圖畫面並保存 ##
    pyautogui.screenshot().save('./AutoResource/screenshot.png')

    ## 載入截圖 ##
    img = cv.imread("./AutoResource/screenshot.png")
    img = cv.cvtColor(img, cv.COLOR_BGR2GRAY)

    ## 圖片模板(要對照的圖片) ##
    img_template = cv.imread(template)
    # 取得模板的圖片大小
    img_templateX, img_templateY , img_templateZ = img_template.shape
    # 模板匹配
    match = cv.matchTemplate(img, img_template, cv.TM_SQDIFF_NORMED)
    # 模板左上坐標
    UPleft = cv.minMaxLoc(match)[2]
    # 計算右下角座標
    lowright = (UPleft[0] + img_templateY, UPleft[1] + img_templateX)
    # 計算中心區域座標
    avg = (int((UPleft[0] + lowright[0])/2), int((UPleft[1] + lowright[1])/2))
    return avg

## 自動點擊 ##
def auto_click(var_avg):
    pyautogui.click(var_avg[0], var_avg[1], button="left")
    time.sleep(1)

def Run(template):
    var_avg = get_xy(template)
    print(var_avg)
    auto_click(var_avg)

"""click 可用參數 (clicks 點擊次數) (interval 點擊間隔時間)"""

## 導入模板運行 ##
Run("./AutoResource/Mould/discord.png")

# 找到圖像中心點
'''Search = pyautogui.center(img)

#移動滑鼠
pyautogui.moveTo(size_Width/2,0,duration=1)

#點擊
pyautogui.click()

#再次移動滑鼠,至螢幕正中間
pyautogui.moveRel(0,size_Height/2,duration=1)'''

## 保留CV顯示畫面 ##
# cv.waitKey(0)
# cv.destroyAllWindows()

## 判斷滑鼠是否在螢幕範圍內 ##
#screen_range = pyautogui.onScreen(100,100)

## 將滑鼠移動到(50,50)的位置,移動週期為1秒 ##
# pyautogui.moveTo(50,50,duration=1)

## 將滑鼠移動到螢幕的正中間,移動週期為0.5秒 ##
# pyautogui.moveTo(size_width/2,size_Height/2,duration=0.5)

## 滑鼠相對移動,以滑鼠當前的位置,向右移動100px ##
# pyautogui.moveRel(100,0,duration=1)

# 上一次的位置
'''last_pos = pyautogui.position()
try:
    while True:
        #新位置
        new_pos = pyautogui.position()
        
        # 判斷如果上次的位置,不等於新的位置了話,延時0.2秒輸出當前位置
        if last_pos != new_pos:
            time.sleep(0.2)
            print(new_pos)
            last_pos = new_pos
except KeyboardInterrupt:
    pass'''
