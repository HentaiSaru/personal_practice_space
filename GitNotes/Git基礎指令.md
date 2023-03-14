<div align=center>

# Git指令筆記 #

</div>

***
> Git是什麼?

<pre>
Git是一個版本控製系統,幫助您跟蹤代碼更改,可用於協作或編寫代碼
</pre>

> Git的下載點

```
https://www.git-scm.com/
```

> Git的基本指令

`查詢Git版本:`
```CMD
git --version
```

`查詢基礎用選項:`
```
git -help
```

`查詢所有可用選項:`
```
git help --all
```

`配置設定 (GitHub ID & Mail):`
```
git config --global user.name "YourName"
git config --global user.email "Your@Mail"
```

`Git初始化 (在要連結的資料夾內,使用CMD輸入):`
```
git init
```

`狀態添加 (擇一使用):`
```
git add 任意檔案

git add --all

git add -A

git add .
```

`查看修改狀態:`
```
git status --short
```
<pre>
？？ - 未跟蹤的文件
A - 添加的文件
M - 修改文件
D - 刪除的文件
</pre>

`直接提交:`
```
git commit -a -m "註解"
```

`提交日誌:`
```
git log
```

`查看分支狀態:`
```
git status
```
`創建分支:`
```
git branch "分支名"
```
`查詢分支:`
```
git branch -a
```
`切換分支:`
```
git checkout "分支名"
```
`刪除分支:`
```
git branch -d "要刪除的分支"
```
`合併分支(在主分支下輸入,要合併的分支):`
```
git merge "要合併的分支"
```
<hr>