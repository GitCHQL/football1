<?php  
@$action = $_GET['act'];  
if($action=='delimg'){  
    $filename = $_POST['imagename'];  
    if(!empty($filename)){  
        unlink('./upload/'.$filename);  
        echo '1';  
    }else{  
        echo 'ɾ��ʧ��.';  
    }  
}else{  
    $picname = $_FILES['mypic']['name'];  
    $picsize = $_FILES['mypic']['size'];  
    if ($picname != "") {  
        if ($picsize > 1024000*30) {  
            echo 'ͼƬ��С���ܳ���30M';  
            exit;  
        }  
        $type = strstr($picname, '.');  
        if ($type != ".gif" && $type != ".jpg" && $type != ".png") {  
            echo 'ͼƬ��ʽ���ԣ�';  
            exit;  
        }  
        $rand = rand(100, 999);  
        $pics = date("YmdHis") . $rand . $type;  
        //�ϴ�·��  
        $pic_path = "./upload/". $pics;  
        move_uploaded_file($_FILES['mypic']['tmp_name'], $pic_path);  
    }  
    $size = round($picsize/1024,2);  
    $arr = array(  
        'name'=>$picname,  
        'pic'=>$pics,  
        'size'=>$size  
    );  
    echo json_encode($arr);  
}  
?>