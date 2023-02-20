<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>無標題文件</title>
	</head>

	<body>
	<form action="w7workout.php" method="POST" >
		
				<label for ="title"> 標題主旨 ： </label>
				<input id = "title" name = "title" type = "text"> <br>
			
				<label for ="email"> 你的信箱 ： </label>
				<input name ="email" type = "email"> <br>
				
				<label for = "user"> 你的姓名 ： </label>
				<input name = "user" type = "text"/> <br>
				
				<label for="beMemr"> 是否為會員 ： </label>
				<select name="Member">
				<option value="會員">會員</option>
				<option value="非會員">非會員</option>
				</select><br>

				問題分類 ：
				<?php
					$array = array("相機", "鏡頭", "閃光燈", "腳架", "電池" , "PS5", "電視");
			
					foreach($array as $value){
						echo "<input name='question[]' type='checkbox' value=".$value.">";
						echo "<label for='camera'>".$value."</label>";
					}
				?><br>
				意見內容 ： <br>
					<textarea name = "content" rows="15" cols="55"></textarea><br>
					<button type="submit">送出</button>
    </form>
	</body>
</html>