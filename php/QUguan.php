<?php


$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");



//$result = mysql_query($sql);
@$IDA=$_POST["IDA"];
@$IDB=$_POST["IDB"];

$sql="DELETE from realation WHERE userAid=$IDA and userbid=$IDB";
$sql2="UPDATE user SET AtN=Atn-1 WHERE userid =$IDA";
$sql3="UPDATE user SET FanN=FanN-1 WHERE userid =$IDB";
$rs=mysql_query($sql,$con); 
$rs=mysql_query($sql2,$con); 
$rs=mysql_query($sql3,$con); 

//echo $sql; 
//echo $rs;
//释放结果  
@mysql_free_result($rs);  

mysql_close($con);
?>