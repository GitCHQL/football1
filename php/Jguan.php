<?php
$con = mysql_connect('localhost', 'root', 'root');
if (!$con)
 {
 die('Could not connect: ' . mysql_error());
 }

$db_select = mysql_select_db("football",$con);

mysql_query("SET NAMES UTF8");


@$id=$_POST["id"];
$sql="SELECT userid,nickname,introdution,photosrc,realation.realID FROM user  JOIN realation ON realation.userAID=user.userID AND realation.userBID=$id ";
$rs=mysql_query($sql,$con);  
//echo $sql;
while ($row = mysql_fetch_object($rs))
{
	echo"<div class=\"myMessage\"><dl><dt><img src=";
	echo $row->photosrc;
	echo"/></dt><dd> <h3>";
	echo $row->nickname;
	echo "</h3><p>";
	echo $row->introdution;
	if($row->realID)
	{
			echo"</p></dd></dl>";
			
	        echo"</div>";
			
	}
	else
	{
	echo"</p></dd></dl>";

	echo"</div>";
    }
}
	
	
	
	@mysql_free_result($rs);  

mysql_close($con);
	
	
	
?>