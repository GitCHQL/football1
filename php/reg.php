<?php

$con = mysql_connect('localhost', 'root', 'root');
if (!$con) {
	die('Could not connect: ' . mysql_error());
}

$db_select = mysql_select_db("football", $con);

mysql_query("SET NAMES UTF8");

//$result = mysql_query($sql);
@$nickname = $_POST["nickname"];
@$name = $_POST["name"];
@$pwd = $_POST["pwd"];
$sql = "SELECT * FROM user WHERE phonenumber= '$name'";

$rs = mysql_query($sql, $con);
if (!mysql_num_rows($rs)) {//查重
	$sql = "INSERT into user (nickname,pwd,phonenumber) VALUES('$nickname','$pwd','$name')";
	$rs = mysql_query($sql, $con);
	echo mysql_insert_id();
} else {
	echo 0;
}
//echo $sql;
//echo $rs;
//释放结果
@mysql_free_result($rs);

mysql_close($con);
?>