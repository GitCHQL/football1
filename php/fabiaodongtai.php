<?php
$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");

$filename = $_POST['imagename'];  

$content = $_POST['content']; 

$userid = $_POST['userid']; 



$sql="INSERT INTO news (Picsrc,cont,likeN,userid) VALUES('$filename','$content','0','$userid')";
$rs = mysql_query($sql, $con);
echo mysql_insert_id();
@mysql_free_result($rs);

mysql_close($con);
	
	
?>