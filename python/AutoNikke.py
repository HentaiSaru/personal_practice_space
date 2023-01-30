import pyautogui as autogui
import cv2 as cv
import time
import os

ScreenSize_X , ScreenSize_Y = autogui.size()

def loading():
    dirPath = r"./AutoResource/NikkeAuto"
    template_loading = os.listdir(dirPath)
    return template_loading

def ScreenCapture():

    """畫面擷取"""
    autogui.screenshot().save('./AutoResource/screenshot.png')

    """畫面讀取"""
    img = cv.imread("./AutoResource/screenshot.png")
    return img


def template_comparison(template):

    """模板對照"""
    img_template = cv.imread(template)

    """取得模板的圖片大小"""
    img_templateX, img_templateY , img_templateZ = img_template.shape

    """模板匹配"""
    match = cv.matchTemplate(ScreenCapture(),img_template , cv.TM_CCOEFF_NORMED)

    """模板左上坐標"""
    UPleft = cv.minMaxLoc(match)[2]

    """計算右下角座標"""
    lowright = (UPleft[0] + img_templateY, UPleft[1] + img_templateX)

    """計算中心區域座標"""
    avg = (int((UPleft[0] + lowright[0])/2), int((UPleft[1] + lowright[1])/2))
    return avg


def auto_click(var_avg,i):

    if i == 0:
        autogui.moveTo(var_avg[0], var_avg[1],duration=0.5)
        autogui.scroll(-500)
    elif i == 1:
        autogui.click(var_avg[0], var_avg[1], button="left")
    elif i == 2:
        autogui.click(var_avg[0], var_avg[1], button="left")
    elif i == 3:
        autogui.click(var_avg[0], var_avg[1], button="left")

def Run(template,i):
    var_avg = template_comparison(template)

    print("延時操做1秒~")
    time.sleep(1)
    auto_click(var_avg,i)

for i in range(len(loading())):
    str = "./AutoResource/NikkeAuto/"+loading()[i]
    Run(str,i)
