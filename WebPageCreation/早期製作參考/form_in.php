<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>表單補充說明</title>
</head>
<body>
    <div class="main">
        <h3>網站註冊</h3>
        <form action="out.php" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>個人資料</legend>
                姓名：<Input type="text" name="name"></Input><br>
                生日：<Input type="date" name="birthday"></Input>
            </fieldset>
            <fieldset>
                <legend>喜歡的國家</legend>
                選擇國家：<select name="city" >
                   <optgroup label="亞洲">
                       <option value="tokyo">東京</option>
                       <option value="HongKong">香港</option>
                   </optgroup>
                   <optgroup label="台灣地區">
                       <option value="Taipei">台北</option>
                       <option value="Kaohsiung">高雄</option>
                   </optgroup>
                </select><br>
                上傳照片：<Input type="file" name="photo" accept="image/*">
            </fieldset>
            <button type="submit">送出</button>
        </form>
    </div>
</body>
</html>