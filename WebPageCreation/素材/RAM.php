<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="keywords" content="作業">
    <meta name="author" content="危昌鴻">
    <meta name="description" content="期末作業">

    <title>RAM</title>
    <link rel="stylesheet" type="text/css" href="./樣式.css">
</head>

<body>
    <div class="商品頁面div框架">
        <div style="padding: 5px;width:1370px;height:40px;margin:0 auto;">
            <form action="輸出製作2.php" method="GET">
                <table class="ram表格樣式">
                    <tr style="word-spacing: 1px;">
                        <td>美光<input type="radio" name="品牌" value="美光"><br>
                            威剛<input type="radio" name="品牌" value="威剛"><br>
                            UMAX<input type="radio" name="品牌" value="UMAX"><br>
                            金士頓<input type="radio" name="品牌" value="金士頓"><br>
                        </td>
                        <td>
                            <?php
                                $i = 4;
					            $DRAM = array(
                                "DDR5 4800",
                                "DDR4 3600",
                                "DDR4 3200",
                                "DDR4 2666",
                                "DDR3 1600");
					            foreach($DRAM as $DDR){
						            echo "<input name='規格[]' type='checkbox' value=". $i-- .">" . $DDR ;
					            };
				            ?>
                            <button type="submit" class="按鈕">送出</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div style="padding: 110px ; vertical-align:auto ; margin:auto;">
            <embed width="100%" height="700px" title="HTML5 的語法"
                src="https://pic.pimg.tw/ofeyhong/1635900109-1070327555-g.jpg">
        </div>
    </div>
</body>

<style>
    body {
        background-image: url("./bg.gif");
        background-position: center;
    }
</style>

</html>