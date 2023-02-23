<!DOCTYPE html><html><head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head></html>

<div align=center>

# <div style="color: Green; font-size:80px">個人練習筆記資料</div> #

## <div class="變色文字">並不是專案項目只是個筆記!!</div> ##

***

> <div class="Title">目前練習的語言</div> 

<br>
<img src="https://yen0304.github.io/p/java%E7%AD%86%E8%A8%981%E6%B3%9B%E5%9E%8B%E9%9B%86%E5%90%88%E8%88%87%E6%AA%94%E6%A1%88%E6%93%8D%E4%BD%9C/logo.jpeg" width="500"/>

</div>

***
## <div style="color: Green; font-size:65px ; text-align:center;">Markdown的使用筆記</div>

<div align=left>
<div class="container p-3 my-5 mt-3 border">

說明 : `Markdown 是一種輕量級標記語言，它允許人們使用易讀易寫的純文本格式編寫文檔。`

應用 : `許多網站都廣泛使用 Markdown 來撰寫幫助文檔或是用於論壇上發表消息。`

</div>
</div><hr>

## <div style="color: Green; font-size:65px ; text-align:center;">使用教學</div> ##

> <div class="Title">標題</div>

一級標題
(在文字下方輸入=====)
====== 

二級標題
(在文字下方輸入-----)
-------

# 一級標題
(前方輸入 #)
## 二級標題
(前方輸入 ##)
### 三級標題
(前方輸入 ###)
#### 四級標題
(前方輸入 ####)
##### 五級標題
(前方輸入 #####)
###### 六級標題
(前方輸入 ######)

<hr>

> <div class="Title">文本效果</div>

*斜體文本* (在* *內輸入文字)
_斜體文本_ (在_ _內輸入文字)

**粗體文本** (在** **內輸入文字)
__粗體文本__ (在__ __內輸入文字)

***粗斜體文本*** (在*** ***內輸入文字)
___粗斜體文本___ (在___ ___內輸入文字)

~~刪除線~~
<u>下劃線文本</u>
`[^RUNOOB]: 文本註解`

<hr>

> <div class="Title">文本換行</div>

<p>可以直接使用</p>
HTML 中的 p 標籤進行換行<br>或是br

<hr>

> <div class="Title">分隔線</div>

`***`

`* * *`

`*****`

`- - -`

`----------`

<hr>

> <div class="Title">無序與有序列表</div>

* 使用一個*
+ 使用一個+
- 使用一個-

1. 第一項 (有序使用數字 + . )
    * 第一項嵌套的第一個元素(*)
    * 第一項嵌套的第二個元素(*)
2. 第二項
    + 第一項嵌套的第一個元素(+)
    + 第一項嵌套的第二個元素(+)
3. 第三項
    - 第一項嵌套的第一個元素(-)
    - 第一項嵌套的第二個元素(-)

<hr>

> <div class="Title">引用區塊</div>

> 第一層引用 (在最前面打>)
>> 第二層引用 (在最前面打>>)
>>> 第三層引用 (在最前面打>>>)

<hr>

> <div class="Title">代碼的標記</div>

(在最上方與最下方打上 ```)
```javascript
$(document).ready(function () {
    alert('test');
});
```

<hr>

> <div class="Title">URL連結</div>

文字連結 : `[連結文字] (連結)`
[我的GitHub](https://github.com/HentaiSaru)

直接連結 : `<連結>`
<https://github.com/HentaiSaru>

<hr>

> <div class="Title">放入圖片</div>

圖標 : `![說明文字,可以不打](連結)`
![](https://allvectorlogo.com/img/2021/12/github-logo-vector.png)

如果要設置大小就要使用 : `<img src="">`
<img src="https://allvectorlogo.com/img/2021/12/github-logo-vector.png" width="50%">

<hr>

> <div class="Title">表格使用</div>

|  表頭   | 表頭  |
|  ----  | ----  |
| 單元格  | 單元格 |
| 單元格  | 單元格 |

-: 設置內容和標題欄居右對齊。
:- 設置內容和標題欄居左對齊。
:-: 設置內容和標題欄居中對齊。

| 左對齊 | 右對齊 | 居中對齊 |
| :-----| ----: | :----: |
| 單元格 | 單元格 | 單元格 |
| 單元格 | 單元格 | 單元格 |

<hr>

> <div class="Title">特別技巧</div>

使用 <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+<kbd>Del</kbd> 用kbd標籤將要轉換的包起來

使用反斜線將特殊字元顯示

\\   反斜線
\`   反引號
\*   星號
\_   下劃線
\{}  花括號
\[]  方括號
\()  小括號
\#   井字號
\+   加號
\-   減號
\.   英文句點
\!   感嘆號

<style>

    .Title{

        text-align:center;
        font-size: 35px; 
        color: red;
        padding: 20px;

    }

    .變色文字 {
        animation: change 5s linear 0s infinite;
        text-align: center;
        font-size: 60px;
        text-shadow: 3px 5px 4px rgba(228, 5, 143, 0.3);
    }
    @keyframes change {
        0% {
            color: rgba(255, 0, 0, 0.7);
        }
        25% {
            color: rgba(255, 72, 0, 0.7);
        }
        50% {
            color: rgba(253, 217, 9, 0.7);
        }
        75% {
            color: rgba(0, 25, 253, 0.7);
        }
        100% {
            color: rgba(17, 255, 0, 0.7);
        }
    }

</style>