<?php
    $title = $_POST["title"];
    $email = $_POST["email"];
    $user = $_POST["user"];
    $Member = $_POST["Member"];
    $question = $_POST["question"];
    $content = $_POST["content"];

    echo "標題主旨：".$title."<br>";
    echo "你的信箱：".$email."<br>";
    echo "你的姓名：".$user."<br>";
    echo "是否為會員：".$Member."<br>";
    echo "問題分類：";
    foreach($question as $value){
		echo $value.".";
	}; echo "<br>" ;
    echo "意見內容：".$content."<br>";
?>