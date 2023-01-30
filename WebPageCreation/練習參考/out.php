<?php
$photo = "";

if ( isset( $_FILES['photo']) ) {
    // print_r($_FILES); //印出$_FILES所存陣列；
    /*
     * //檔案的陣列有以下索引值
     * $_FILES['設定的name鍵值']['name'] 原本的檔名
     * $_FILES['設定的name鍵值']['tmp_name'] 暫存在server上面的檔名，會被重新命名過
     * $_FILES['設定的name鍵值']['type'] 檔案型態
     * $_FILES['設定的name鍵值']['size'] 檔案大小
     * $_FILES['設定的name鍵值']['error'] 錯問代碼
     */
    if(file_exists($_FILES['photo']['tmp_name'])){
        $targetfloder="file/";
        move_uploaded_file($_FILES['photo']['tmp_name'],$targetfloder.$_FILES['photo']['name']);
        $photo=$targetfloder.$_FILES['photo']['name'];
    }
}

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>顯示註冊的資訊</title>
</head>

<body>
    <h1>顯示註冊資訊</h1>
    <h3>個人資料</h3>
    <?php
    echo  "姓名：" . $_REQUEST['name'] . "<br>";
    echo  "生日：" . $_REQUEST['birthday'];
    ?>
    <h3>喜歡國家</h3>
    <?php
    echo  "選擇國家：" . $_REQUEST['city'] . "<br>";
    echo  "生日：" . $_REQUEST['birthday'] . "<br>";
    echo  "照片：" . "<img src={$photo}>";
    ?>

</body>

</html>