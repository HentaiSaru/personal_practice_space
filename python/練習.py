import os

print("字串測試輸出")

if 10 > 5:
    print("判斷式輸出要有縮排")
    print("相同程式縮排要相同")
    
x = 10
print(x)
    
# ?這是一個註解

y = 10
y = "可直接轉型別"
print(y)

# !強制指定型別
x = str(5)
x = int(5)
x = float(5)

# !獲取型別
print(type(x))

# !賦予多value
x , y , z = "10" , "20" , "30"
x = y = z = "全變數賦予"

# !創建一個包
fruits = ["30",20,10]
x,y,z=fruits # ?拆包傳值 
print(x)
print(y)
print(z)

# !輸出賦予字串
print("這是一個自串 : "+x) # ?型別要都為字串


# !方法使用
x = "一段文字"

def func():
    print("方法使用 : "+x)
func() # ?呼叫方法

# !方法內與方法外同名變數
x = "方法外"

def func1():
    x = "方法內"
    print(x)
func1()
print(x)

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

# *索引值加上負號 [-5:-2] 會從字串的後面往前輸出

# !字串從後方輸出
n = "轉反串字"
print(n[::-1])

# !反轉字串關鍵字
List = []
List.append("存入list")
List.reverse()

# !迴圈輸出一個一個字輸出
for a in "這是一個長字串":
    print(a,end="") # *設置輸出樣式 往後輸出不換行
print("\n--------我是分隔線---------")


e = "Hello, World!"
print(e.upper()) # ?變成大寫的方法
print(e.lower()) # ?變成小寫的方法
print(e.strip()) # ?從開頭或結尾刪除空格
print(e.replace("H","A")) # ?變換字符

# *字串合併直接 a字串 + b字串

# !使用方法format 把不同型別的變數加在一起
age = 50
txt = "字串合併數字 : {}" # ?這邊要配合大誇號放入
print(txt.format(age))

# *可以宣告好幾個變數 只要加上大誇號 即可插入不同型別變數 {0} 可給索引值確保位置正確

# *在字串輸出時 也可用反斜指令 \" \\ \n \t 等等

# !印出布林值 
print(10 > 9) # ? True | False

# !判斷式
a = 100
b = 200

if a > b:
    print("a > b")
else:
    print("a < b")
    
# !isinstance函式 用於確認對象是否為指定型別 回傳 True | False
x = 200
print(isinstance(x, int))

# !字串陣列插入 insert
list = ["第一串","第二串","第三串"]
list.insert(2,"第二點五串")
print(list)

# !使用 extand 延伸字串陣列
list1 = ["第四串","第五串"]
list.extend(list1)
print(list)

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