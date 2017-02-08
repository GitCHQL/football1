<?php
$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");

$sql="SELECT news.NewID,user.nickname,user.introdution,user.photosrc,news.Picsrc,news.likeN,news.cont from user right JOIN news ON user.userID=news.UserID";
$rs=mysql_query($sql,$con);  



while ($row = mysql_fetch_object($rs))
{
	echo"<div class=\"fol_con\"><div class=\"myMessage\"><dl><dt><img src=";
	echo $row->photosrc;
	echo"/></dt><dd> <h3>";
	echo $row->nickname;
	echo "</h3><p>";	
	echo $row->introdution;
	echo "</p></dd></dl><div class=\"zan\"><span>";
	echo $row->likeN;
	echo "</span><i class=\"fa thumbs-up\"></i></div></div><img src=";
	echo $row->Picsrc;
	echo"><p>"; 
	echo $row->cont;
	echo"</p></div>";

}
	
	
	
	
	
	
	
?>