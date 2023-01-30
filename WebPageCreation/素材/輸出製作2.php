<?php
$filter = $_GET["品牌"];
$DRAM = $_GET["規格"];
$M = array(
    array(
    0 =>'<a href="https://24h.pchome.com.tw/prod/DRAC00-A900BXHEB?fq=/S/DRAC00" target="_blank" >Micron Crucial 美光 DDR5 4800</a>',
    1 =>'<a href="https://24h.pchome.com.tw/prod/DRAC00-A900ATEGL" target="_blank" >美光 Crucial Ballistix D4 3600</a>',
    2 =>'<a href="https://24h.pchome.com.tw/prod/DRAC00-A900ATEHQ" target="_blank" >美光 Crucial Ballistix 炫光RGB D4 3200</a>',
    3 =>'<a href="https://24h.pchome.com.tw/prod/DRAC8L-A900BL884" target="_blank" >美光 Micron Crucial Ballistix DDR4 2666</a>',
    4 =>'<a href="https://24h.pchome.com.tw/prod/DRAC00-A9007MR6J" target="_blank" >美光Micron Crucial DDR3L 1600</a>'
    ),
    array(
    0 =>'<a href="https://shopee.tw/ADATA%E5%A8%81%E5%89%9B-16GB-DDR5-4800-%E8%A8%98%E6%86%B6%E9%AB%94-%E5%8E%9F%E5%83%B9%E5%B1%8B(AD5U480016G-S)%E3%80%90%E5%8A%A0%E5%83%B9%E8%B3%BC%E5%B0%88%E7%94%A8%E8%B3%A3%E5%A0%B4%E3%80%91-i.54133273.12242890126" target="_blank" >ADATA威剛 16GB DDR5 4800</a>',
    1 =>'<a href="https://24h.pchome.com.tw/prod/DRAC4S-A900C43SM?fq=/S/DRAC4S" target="_blank" >ADATA 威剛 XPG D50 DDR4 3600</a>',
    2 =>'<a href="https://24h.pchome.com.tw/prod/DRAC4S-A900AYU5P?fq=/S/DRAC4S" target="_blank" >威剛 XPG DDR4 3200</a>',
    3 =>'<a href="https://24h.pchome.com.tw/prod/DRAC4S-A900AU85K" >ADATA 威剛 DDR4 2666</a>',
    4 =>'<a href="https://24h.pchome.com.tw/prod/QABB3P-A900A34MX" target="_blank" >ADATA 威剛 DDR3-1600</a>'
    ),
    array(
    0 =>'<a href="NULL" target="_blank" >UMAX查無4800</a>',
    1 =>'<a href="NULL" target="_blank" >UMAX查無3600</a>',
    2 =>'<a href="https://24h.pchome.com.tw/prod/DRAC47-A900AC1IE" target="_blank" >UMAX DDR4 3200</a>',
    3 =>'<a href="https://24h.pchome.com.tw/prod/DRAC47-A9008N2D1" >UMAX DDR4 2666</a>',
    4 =>'<a href="https://24h.pchome.com.tw/prod/DRAC47-A9006DUPD" target="_blank" >UMAX DDR3 1600</a>'
    ),
    array(
    0 =>'<a href="NULL" target="_blank" >金士頓查無4800</a>',
    1 =>'<a href="NULL" target="_blank" >金士頓查無3600</a>',
    2 =>'<a href="https://www.momoshop.com.tw/goods/GoodsDetail.jsp?i_code=8336114&str_category_code=4301900095&ctype=B&Area=DgrpCategory" >【Kingston 金士頓】DDR4 3200</a>',
    3 =>'<a href="https://www.momoshop.com.tw/goods/GoodsDetail.jsp?i_code=7661087&str_category_code=4301900095&ctype=B&Area=DgrpCategory" >【Kingston 金士頓】DDR4-2666</a>',
    4 =>'<a href="https://www.momoshop.com.tw/goods/GoodsDetail.jsp?i_code=6831690&str_category_code=4301900095&ctype=B&Area=DgrpCategory" target="_blank" >【Kingston 金士頓】DDR3-1600</a>'
    )
);
?>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>網址回傳</title>

    <style>
        .RAM回傳樣式{
            text-decoration:none; 
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
    <div class="RAM回傳樣式">
        <?php
            foreach($DRAM as $D){
                if($filter == "美光"){
                    switch ($D) {
                        case "4":
                            echo $M[0][0] . '<br>';
                            break;
                        case "3":
                            echo $M[0][1] . '<br>';
                            break;
                        case "2":
                            echo $M[0][2] . '<br>';
                            break;
                        case "1":
                            echo $M[0][3] . '<br>';
                            break;
                        case "0";
                            echo $M[0][4] . '<br>';
                    };
                }
                else if($filter == "威剛"){
                    switch ($D) {
                        case "4":
                            echo $M[1][0] . '<br>';
                            break;
                        case "3":
                            echo $M[1][1] . '<br>';
                            break;
                        case "2":
                            echo $M[1][2] . '<br>';
                            break;
                        case "1":
                            echo $M[1][3] . '<br>';
                            break;
                        case "0";
                            echo $M[1][4] . '<br>';
                    };
                }
                else if($filter == "UMAX"){
                    switch ($D) {
                        case "4":
                            echo $M[2][0] . '<br>';
                            break;
                        case "3":
                            echo $M[2][1] . '<br>';
                            break;
                        case "2":
                            echo $M[2][2] . '<br>';
                            break;
                        case "1":
                            echo $M[2][3] . '<br>';
                            break;
                        case "0";
                            echo $M[2][4] . '<br>';
                    };
                }
                else if($filter == "金士頓"){
                    switch ($D) {
                        case "4":
                            echo $M[3][0] . '<br>';
                            break;
                        case "3":
                            echo $M[3][1] . '<br>';
                            break;
                        case "2":
                            echo $M[3][2] . '<br>';
                            break;
                        case "1":
                            echo $M[3][3] . '<br>';
                            break;
                        case "0";
                            echo $M[3][4] . '<br>';
                    };
                }
            };
        ?>
    </div>
</body>
</html>