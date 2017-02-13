<?php
class mysql{
	private $con;
	private $dbhost='localhost';
     private $dbuser='root';
     private $dbpwd='root';

	function __construct($databaseName){
		 $this->con=mysql_connect($this->dbhost,$this->dbuser,$this->dbpwd);    
        if(!$this->con){    
            die("连接失败！");    
        }   
        mysql_select_db($databaseName,$this->con);    
        mysql_query("set names utf8;");    
	}
	/**
	 * [报错函数]
	 * @param  [type] $error [description]
	 * @return [type]        [description]
	 */
     
	function err($error){
		die("对不起操作有误：".$error);
	
	}
	/**
	 * [connect description]
	 * @return [type] [description]
	 */
	function connect($dbname){
		if(!($con = mysql_connect($this->dbhost,$this->dbuser,$this->dbpwd))){//连接mysql数据库函数
			$this->err(mysql_error());
		}
		if(!mysql_select_db($dbname,$con)){
			$this->err(mysql_error());
		}
		mysql_query("SET NAMES UTF8");
		
		
	}
	/**
	 * [query description]
	 * @param  [type] $sql [description]
	 * @return [type]      [description]
	 */
	function query($sql){
		if(!($query=mysql_query($sql))){
			$this->err($sql."<br/>".mysql_error());
		}
		else{
			return $query;
		}
	}
	
	/**
	 * [findAll description]
	 * @param  [type] $query [description]
	 * @return [type]        [description]
	 */
	function findAll($query){
		while($rs=mysql_fetch_array($query,MYSQL_ASSOC)){
			$list[]=$rs;
		}
		return isset($list)?$list:"";
	}
	/**
	 * [findOne description]
	 * @param  [type] $query [description]
	 * @return [type]        [description]
	 */
	function findOne($query){
		$rs=mysql_fetch_array($query,MYSQL_ASSOC);
		return $rs;
	}
	function findResult($query,$row=0,$field=0){
		$rs=mysql_result($query, $row, $field);
		return $rs;
	}

    function __destruct(){  
        mysql_close($this->con);    
    }  

}



$mysql1 = new mysql('football');
//echo $mysql1->query('select *from user');
$rss=$mysql1->findOne($mysql1->query('select *from user'),0,0);
$s2=implode(',', $rss);
echo $s2;
