<?php
    //宣告變數 <= (傳值方式["傳入的name"])
    $test1 = $_POST["技嘉"];
    $test2 = $_POST["微星"];

    $gpu = array('<a href="https://www.gigabyte.com/tw/Graphics-Card/GV-N3090GAMING-OC-24GD#kf" target="_blank" >RTX™ 3090</a>',
    '<a href="https://www.gigabyte.com/tw/Graphics-Card/GV-N308TGAMING-OC-12GD#kf" target="_blank" >RTX™ 3080 Ti</a>',
    '<a href="https://www.gigabyte.com/tw/Graphics-Card/GV-N307TGAMING-OC-8GD#kf" target="_blank" >RTX™ 3070 Ti</a>',
    '<a href="https://tw.msi.com/Graphics-Card/Radeon-RX-6900-XT-GAMING-X-TRIO-16G" target="_blank" >RX 6900</a>',
    '<a href="https://tw.msi.com/Graphics-Card/Radeon-RX-6800-XT-GAMING-X-TRIO-16G" target="_blank" >RX 6800</a>',
    '<a href="https://tw.msi.com/Graphics-Card/Radeon-RX-6700-XT-GAMING-12G" target="_blank" >RX 6700</a>');
?>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>網址回傳</title>

    <style>
        .GPU回傳樣式{
            text-align:auto;
            font-size: 80px;
            line-height: 1.8;
            word-spacing: 3px;
        }
        a:link{
            color: rgba(238,130,238,0.8);
        }
        a:visited{
            color: rgba(255, 0, 0,0.6);
        }
        a:hover{
            color: Magenta;
        }
        a:active{
            color: Cyan;
        }
    </style>

</head>

<body>
    <div class="GPU回傳樣式">
        <?php
            foreach($gpu as $gg){
                if($test1 == NULL & $test2 == NULL) echo $gg .'<br>';
            }
            if($test1 == "GeForce RTX™ 3090")
                echo $gpu[0] . '<br>';
            else if($test1 == "GeForce RTX™ 3080 Ti")
                echo $gpu[1] . '<br>';
            else if($test1 == "GeForce RTX™ 3070 Ti")
                echo $gpu[2] . '<br>';
            if($test2 == "Radeon RX 6900")
                echo $gpu[3] . '<br>';
            else if($test2 == "Radeon RX 6800")
                echo $gpu[4] . '<br>';
            else if($test2 == "Radeon™ RX 6700")
                echo $gpu[5] . '<br>';
        ?>
    </div>
</body>
</html>