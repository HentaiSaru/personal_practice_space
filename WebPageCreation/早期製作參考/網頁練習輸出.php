<?php
    //宣告變數 <= (傳值方式["傳入的name"])
    $test1 = $_POST["測試輸入1"];
    $test2 = $_POST["測試輸入2"];
    $test3 = $_POST["單選"];
    $test4 = $_POST["複選"];
    $test5 = $_POST["Member"];
    $test6 = $_POST["content"];

    //接著印出 echo
    echo "測試輸入1 : ".$test1."<br>"; /* 字串連接 . (變數) . 跳行 */
    echo "測試輸入2 : ".$test2."<br>";
    echo "單選 : ".$test3."<br>";
    echo "複選 : ".$test4."<br>";
    echo "Member : ".$test5."<br>";
    echo "content : ".$test6."<br>";
?>