<?php
$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");

@$statue=$_POST["statue"];

$sql="SELECT FanN FROM user where userid=$statue";
$rs=mysql_query($sql,$con);  

while ($row = mysql_fetch_object($rs))
{
	echo $row->FanN;
	
}	
	
	
	@mysql_free_result($rs);  

mysql_close($con);
	
	
?>