import sys
box = []
def change(n,n1,n2):
    global a , b , c
    box.append(eval(n))
    box.append(n1)
    box.append(eval(n2))
    a , b , c = box[0] , box[2] , box[1]
try:
    print("輸入需運算 a值 運算符 b值 (值與值之間請空格)...")
    n,n1,n2 = map(str,input().split())
    change(n,n1,n2)
    
    while len(box) < 4:
        if c == "+":print("%d + %d = %.2f\n"%(a,b,a+b))
        elif c == "-":print("%d - %d = %.2f\n"%(a,b,a-b))
        elif c == "*":print("%d * %d = %.2f\n"%(a,b,a*b))
        elif c == "/":print("%d / %d = %.2f\n"%(a,b,a/b))
        elif c == "%":print("%d / %d 求餘數 = %.2f\n"%(a,b,a%b))
        elif c == "//":print("%d // %d 忽略小數獲得整除數 = %.2f\n"%(a,b,a//b))
        box.clear()
        print("輸入需運算的 a值 運算符 b值 (無輸入值直接Enter結束)...")
        n,n1,n2 = map(str,input().split())
        change(n,n1,n2)
except ValueError as e:sys.exit(0)