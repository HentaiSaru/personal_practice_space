import requests
from bs4 import BeautifulSoup
import os

url = "http://www.jkforum.net/forum.php"
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0;Win64) AppleWebkit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36'
}
response = requests.get(url, headers=headers)
soup = BeautifulSoup(response.text, "html.parser")

# 找到所有圖片標籤
images = soup.find_all("img")

# 建立一個資料夾來儲存圖片
if not os.path.exists("images"):
    os.makedirs("images")

# 遍歷所有圖片標籤
for image in images:
    # 獲取圖片的URL
    img_url = image["src"]
    if not (img_url.startswith("http:") or img_url.startswith("https:")):
        img_url = "http:" + img_url
    # 下載圖片
    response = requests.get(img_url, headers=headers)
    # 獲取圖片檔名
    filename = os.path.join("images", img_url.split("/")[-1])
    open(filename, "wb").write(response.content)
    print("Image downloaded:", filename)