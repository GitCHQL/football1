<?php


$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");



//$result = mysql_query($sql);
@$name=$_POST["name"];
@$pwd=$_POST["pwd"];

$sql="SELECT userid FROM user WHERE phonenumber= '$name' and pwd='$pwd'";

$rs=mysql_query($sql,$con); 

if(mysql_num_rows($rs)!=0)
{
	$row = mysql_fetch_object($rs) ;
    echo $row->userid;
}
else{
	echo 0;
}

//echo $sql; 
//echo $rs;
//释放结果  
@mysql_free_result($rs);  

mysql_close($con);
?>