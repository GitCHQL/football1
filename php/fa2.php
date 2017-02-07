<?php
$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");

@$statue=$_POST["statue"];

$sql="SELECT userid,nickname,introdution,photosrc FROM user where userid=$statue";
$rs=mysql_query($sql,$con);  

while ($row = mysql_fetch_object($rs))
{
	echo"<dl><dt><img src=";
	echo $row->photosrc;
	echo"/></dt><dd> <h3>";
	echo $row->nickname;
	echo "</h3><p>";
	echo $row->introdution;
	echo"</p></dd></dl>";
	
}	
	
@mysql_free_result($rs);  

mysql_close($con);	
	
	
	
?>