import os
import cv2 as cv

def face(image):
      
    #因為我使用的是CV2 只能接收BGR 因此要先將圖片轉換為灰階
    gray = cv.cvtColor(image, cv.COLOR_BGR2GRAY)
    
    #取得特徵庫進行比對
    face_detector = cv.CascadeClassifier(os.path.join(cv.data.haarcascades, 'haarcascade_frontalface_default.xml'))
    
    """
      scaleFactor 設置圖像比例縮小
      minNeighbors 指定每個矩形必須的間距(經過測試後 至少要調到 10精度 才能正確顯示)
      
    """
    faces = face_detector.detectMultiScale(gray,scaleFactor=1.1, minNeighbors=10) 
    
    #進行綠色方框繪製
    for x, y, w, h in faces:cv.rectangle(image, (x, y), (x + w, y + h), color=(0, 255, 0), thickness=2)

#讀取圖片
img_ABBA , img_family3 , img_graduation = cv.imread("ABBA.jpg") , cv.imread("family3.jpg") , cv.imread("graduation.jpg")

#傳入方法取得特徵 並繪製方框
face(img_ABBA)
face(img_family3)
face(img_graduation)

#圖片顯示
cv.imshow("img_ABBA", img_ABBA)
cv.imshow("img_family3", img_family3)
cv.imshow("img_graduation", img_graduation)

cv.waitKey(0) 
cv.destroyAllWindows()