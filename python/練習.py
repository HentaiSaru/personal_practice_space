import os

""" Python的變數Type

Numeric:
int = 1,2,-3
float = 3.14,-1.5
complex = 2+3j,-1-4j
hex = 0x1F,0xFF
bin = 0b101,0b111

Text:
str = 任意文本內容

Binary:
bytes(二進制內容) = 圖片、聲音、影片
memoryview = 內存視圖類型，可以對二進製數據進行切片操作，而不需要進行複製或者轉換。

Sequence:
list = 是一種可變序列，可以包含任意類型的數據，並支持增加、刪除、修改等操作。
tuple = 是一種不可變序列，可以包含任意類型的數據，一旦創建就無法修改。
range = 是一種用於表示一個連續的數字序列的類型，通常用於循環迭代。

Mapping:
dict(字典)是一種可變的映射類型，可以用於存儲任意類型的鍵值對。字典中的鍵必須是不可變的（如字符串、元組等），而值可以是任意類型的數據。
defaultdict(默認字典)是一種特殊的字典類型，可以在查找不存在的鍵時返回一個默認值，而不是引發KeyError異常。
OrderedDict(有序字典)是一種有序的字典類型，可以記錄鍵值對的添加順序。
Counter(計數器)是一種字典的子類，可以用於對序列中的元素進行計數。
ChainMap(鏈式映射)是一種將多個字典串聯在一起的映射類型，可以用於快速查找多個字典中的

set:
set(集合)是一種可變的集合類型，可以用於存儲任意類型的元素。集合中的元素必須是不可變的（如數字、字符串、元組等），而且不能重複。
frozenset(凍結集合)是一種不可變的集合類型，可以用於作為字典的鍵或其他集合的元素。凍結集合的元素也必須是不可變的，而且不能重複。

bool:
bool = True or False

NoneType
"""

"""常用方法

.capitalize()               首字母大寫
.title()                    每個單字首字母轉大寫
.istitle()                  每個單字首字母是否為大寫
.isupper()                  是否均為大寫
.casefold()                 首字母小寫
.upper()                    全轉大寫
.lower()                    全轉小寫
.swapcase()                 小寫變大寫,大寫變小寫
.center(50)                 使輸出置中(輸入的值為,空格的數量)
.count(value, start, end)   value為參考值,例如"Test" / start 和 end 為查找範圍,例如10,20 = 查找該字串內10~20中 為Test字串的數量
.endswith(value, start, end) 查找字串是否以value字串結尾,可設置範圍,輸出True和False
.expandtabs(2)              設置使用\隔開文字時,表示空格為2 , 例如 我\要\將\這\串\字\隔\開 這樣就會將每個字中間空2格
.find(value, start, end)    查找文本中第一次出現value值的位置,沒有就輸出-1 , 可設置範圍
.rfind(value, start, end)   查找文本中最後一次出現value值的位置,沒有就輸出-1 , 可設置範圍
.index()                    和find基本相同,差別在找不到value值時,輸出例外
.rindex()                   和rfind基本相同,找不到輸出例外
.isalnum()                  是否是數字或字母
.isalpha()                  是否是字母

* 以下兩種不包含負數和小數 *
.isdigit()                  是否是阿拉伯數字
.isnumeric()                是否都是數字(包含羅馬數字符號)

.startswith("開始")         開頭字串=開始=True
.isdecimal()                是否是小數點
.isidentifier()             是否為有效變數
.islower()                  是否均為小寫
.isprintable()              是否是可輸出的字串
.isspace()                  是否是空格
"#".join(list)              將序列內多個元素以#連接
.ljust(長度, 字符)           左對齊右填充字符,無設置為空格
.rjust()                    右對齊左填充
.strip()                    刪除開頭結尾空格
.lstrip(value)              刪除左側字符
.rstrip(value)              刪除右側字符
.maketrans(x, y, z)        輸入x,y,z字串,從選定的字串中刪除與xyz相同的字串
.replace(原值,新值,替換數量) 變更字串
.split(拆分符)              可用 . / 空白等 作為拆分依據

isinstance(value,Type)     檢測變數是否為指定類型
"""

print("字串測試輸出")

if 10 > 5:
    print("判斷式輸出要有縮排")
    print("相同程式縮排要相同")
    
x = 10
print(x)
print("\n")
    
# ?這是一個註解

# !附值時給予Type
y = 10
y = "可直接轉型別"
print(y)
print("\n")

# !強制指定型別
x = str(5)
x = int(5)
x = float(5)
print("\n")

# !獲取型別
print(type(x))
print("\n")

# !賦予多value
x , y , z = "10" , "20" , "30"
x = y = z = "全變數賦予"

# !創建一個集合
txt = ["30",20,10]
x,y,z=txt # ?拆包傳值 
print(x)
print(y)
print(z)
print("\n")

# !輸出賦予字串
print("這是一個自串 : "+x) # ?型別要都為字串
print("\n")


# !多變量輸出
x="abc"
y="def"
z="ghi"
print(x,y,z)
print(x+"+"+y+"+"+z)
print("\n")

# !不同Type
x=123
y="abc"
print(type(x),type(y))
print("\n")

# !方法使用
x = "一段文字"

def func():
    print("方法使用 : "+x)
func() # ?呼叫方法
print("\n")

# !方法內與方法外同名變數
x = "方法外"

def func1():
    x = "方法內"
    print(x)
func1()
print(x)
print("\n")

# !方法全域變數宣告

def func2():    # ?關鍵字 : global
    global x
    x = "全域變數"
func2()
print(x)

import random # ?取用外部API
print(random.randrange(1, 10)) # ?印出1~9隨機數

# !字串是以 字元陣列方式存在
a = "這是一個長字串"
print(len(a)) # ?回傳字串的長度

if "長字串" in a:
    print("如果有該字串 就印出這行")
 
if "沒有該字串" not in a:
    print("如果沒有該字串 就印出這行")
    
print(a[4]+"-----") # ?回傳字串指定的索引值
print(a[1:6]) # ?給予範圍輸出 也可[:5]輸出0~5 反之[2:]輸出2~最後
print("\n")

# *索引值加上負號 [-5:-2] 會從字串的後面往前輸出

# !字串從後方輸出
n = "轉反串字"
print(n[::-1])
print("\n")

# !反轉字串關鍵字
List = []
List.append("存入list")
List.reverse()

# !迴圈輸出一個一個字輸出
for a in "這是一個長字串":
    print(a,end="") # *設置輸出樣式 往後輸出不換行
print("\n--------我是分隔線---------")

e = " Hello, World!"
print(e.upper()) #? 變成大寫的方法
print(e.lower()) #? 變成小寫的方法
print(e.strip()) #? 從開頭或結尾刪除空格
print(e.replace("H","A")) #? 變換字符
print(e.split(",")) #? 拆分字串(以,為切片點)
print("\n")

# *字串合併直接 a字串 + b字串

# !使用方法format 把不同型別的變數加在一起
age = 50
txt = "字串合併數字 : {}" # ?這邊要配合大誇號放入
print(txt.format(age))
print("\n")

# !format的各類用法
txt = "將我{}合併{}字串使{}format合併"
print(txt.format("要","的","用"))
txt = "另一{1}format{2}併{0}方式"
print(txt.format("的","種","合"))
print("\n")

# *可以宣告好幾個變數 只要加上大誇號 即可插入不同型別變數 {0} 可給索引值確保位置正確

# *在字串輸出時 也可用反斜指令 \" \\ \n \t 等等

# !印出布林值 
print(10 > 9) # ? True | False
print("\n")

# !判斷式
a = 100
b = 200

if a > b:
    print("a > b")
else:
    print("a < b")
print("\n")
    
# !isinstance函式 用於確認對象是否為指定型別 回傳 True | False
x = 200
print(isinstance(x, int))
print("\n")

# !字串陣列插入 insert
list = ["第一串","第二串","第三串"]
list.insert(2,"第二點五串")
print(list)
print("\n")

# !使用 extand 延伸字串陣列
list1 = ["第四串","第五串"]
list.extend(list1)
print(list)
print("\n")

# *上面也可以直接用第三個陣列 3陣列 = 1陣列 + 2陣列

"""
python 的 remove 要使用 pop(索引值) 刪除 無指定就刪最後1個
clear() 清空陣列
陣列.index(判斷值) 取得該判斷值 在陣列內的索引值

"""
# !遍利
for i in list:
    print("%s,"%i,end="")
    
NewList = []
for i in list:
    if "三" in i:
        NewList.append(i)
print("\n%s\n"%NewList,end="")
print("\n")

"""
soft() 方法進行排序 反轉排序 reverse()
copy() 複製陣列 用法: MyList = list.copy()

"""
# !建立數組 set
a_set = set()   #? 空數組
b = {1,2,3,4,5}
c = set((1,2,3,4,5))
a_set.add(1)
 
print(a_set)
print(b)
print(c)
print(type(a))
print(type(b))
print(type(c))
print("\n")

# * eval 這個含式 會自動判斷
# * eval(10) 他就會變 int
# * eval(10.0) 他就會變 float

#*---------------------------------

# ! for 的特別用法
test = [1,2,3,4,5]
n = 0

for i in range(len(test)): # ? 直接做 0 ~ 陣列長度
    n += test[i]
print(n)
n = 0

for i in test: # ? 直接將陣列值 每次丟入 i 直接讀取 i 就是值
    n += i
print(n)
print("\n")

text = """多行文字賦予
第二行內容
第三行內容
"""
print(text)
print(text[5])  #? 輸出指定位置的字串
print("free" in text) #? 輸出是否存在該字串
print("free" not in text) #? 輸出是否不存在該字串

