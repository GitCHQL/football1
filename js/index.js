var statue=0;
var webstatue=0;
var guanzhustatue=0;
var img;
//横向滑动
var mySwiper = new Swiper('.home .swiper-container',{
	onSlideChangeEnd: function(swiper){
	    $(".sec_mean p").eq(swiper.activeIndex).addClass("active1").siblings().removeClass("active1");
    }
})

$('.sec_mean p').on('tap',function () {
	$(this).addClass("active1").siblings().removeClass("active1");
	//$(this>"ul").scrollTop(0);
	mySwiper.slideTo($(this).index(), 500, false);//切换到第一个slide，速度为1秒
});

// 底部标题切换
var home = $(".home");
var discover = $(".discover");
var mine = $(".mine");
var fabiao=$(".fabiao");
$('.footer div').tap(function(){
	$(this).addClass("active").siblings().removeClass("active");
	var i = $(this).index();
	if(i==0){
		home.show();
		discover.hide();
		mine.hide();
		fabiao.hide();
	}else if(i==1){
		home.hide();
		discover.show();
		mine.hide();
		fabiao.hide();
	}else if(i == 4){
		home.hide();
		discover.hide();
		mine.show();
		fabiao.hide();
	}else if(i==3){
		if(statue==0)
		{
			alert("请先登录或注册再来发表动态哦！");
		}
		else{
			home.hide();
		    discover.hide();
		    mine.hide();
		    fabiao.show();
	    	}
		
	}else if(i==2){
		alert("2");
	}
})

// 向下滑动
var myScroll1;
var myScroll2;
var myScroll3;
var myScroll4;
var myScroll5;
var myScroll6;
var myScroll7;
var myScroll8;
//初始化iscroll

$(document).ready(function()
{
    addData();
    setTimeout(function()
        {
    myScroll1 = new IScroll('#wrapper1',{});
    myScroll2 = new IScroll('#wrapper2',{});
    myScroll3 = new IScroll('#wrapper3',{});
    //myScroll4 = new IScroll('#wrapper4',{});
    myScroll5 = new IScroll('#wrapper5',{});
    myScroll6 = new IScroll('#wrapper6',{});
    myScroll7 = new IScroll('#wrapper7',{});
    myScroll8 = new IScroll('#wrapper8',{});


        }


        ,1000);
    
}
    );

// vScrollbar:false;
//document.addEventListener('DOMContentLoaded',loaded,false)

// var mySwiper = new Swiper('.swiper-container',{
// 	direction:'horizontal',
// 	loop:false,
// })

//热点关注切换
$(".hot").tap(function(){
	$(this).addClass("focus");
	$(".btn").removeClass("focus");
	$(".hot_con,.sec_mean").show();
	$(".follow_con").hide();
})
$(".btn").tap(function(){
	$(this).addClass("focus");
	$(".hot").removeClass("focus");
	$(".hot_con,.sec_mean").hide();
	$(".follow_con").show();
})


// $("#login").tap(function(){
// 	var name = $("#name").val();
// 	var pwd = $("#pwd").val();

// 	localStorage.username =name;
// 	localStorage.userpwd = pwd;
// })

// $.ajax({
// 	type:"get",
// 	url:"http://100.164.17/index.php",
// 	success:function(msg){
// 		console.log(msg);
// 	}
// })

// 登录注册
$("#registSwitch").on("tap",function(){
	$(".login_con").hide();
	$(".regist_con").show();
	$("#mine_title").html("足球圈 - 注册");
})
//我的页面横向滑动
var mySwiper2 = new Swiper('.mine .swiper-container',{
	onSlideChangeEnd: function(swiper){
	    $(".mine_mean p").eq(swiper.activeIndex).addClass("active1").siblings().removeClass("active1");
    }
})

$('.mine_mean p').on('tap',function () {
	$(this).addClass("active1").siblings().removeClass("active1");
	mySwiper2.slideTo($(this).index(), 500, false);
});

function callbacks(arr){
    console.log(arr);
}
//正则验证
var aucc1;
var aucc2;

$("#name").focusout(
	function(){
		var uname = $('#name').val();
		var nameReg =/^1[3|4|5|8][0-9]\d{4,8}$/;
		if($.trim(uname)==""){
			$(".notice").html("您输入的手机号为空");
		}else 
		if(nameReg.test(uname)){
			aucc1 = true;
		}else{
			$(".notice").html("您输入的手机号错误");
		}
		}
)

//json添加数据
//json添加数据
//$(function(){
//	
//	addData();//页面加载调用
//})
	function addData(){
		canLoad = false;//开始加载数据是，不让重复加载
		
		$.getJSON("homenews.json",function(data){//用jsonp加载数据
				console.log(data)
		var str = "";
		
	
		for(var i =0;i<data.length;i++){ 
			//拿到数值数据，加循环也就是遍历
			var oSrc = data[i].src; //拿到图片的src
			var nTitle = data[i].nTitle;
			str ='<li><dl><dt><img src="'+oSrc+'"/></dt><dd>'
					+nTitle+'</dd></dl></li>';//万恶的字符串 把取到支值放进去
					

				$('#ftn').append(str) ;//添加
					}
					//$('body').append(str)t
					canLoad = true;//数据添加完成后，允许再次加载
				})
			}

$("#pwd").focusout(
	function(){
		var upass = $('#pwd').val();
		var passReg = /^.{6,12}$/;
		if($.trim(upass)==""){
			$(".notice").html("密码不能为空");
		}else 
		if(passReg.test(upass)){
			aucc2 = true;
		}else{
			$(".notice").html("密码长度只能是6-16位字母/数字/符号");
		}
	}
)

//登录
$('#login_btn').on('click', function() {
	
    var uname = $('#name').val();
    var upass = $('#pwd').val();
    var data = "name="+uname+"&pwd="+upass;
    if(aucc1==1 || aucc2==2){
    	$.post('php/Login.php',
	        data,
	        function(response){
	        // process response
	        
	        if(response != 0) {
	        $(".regist_con").hide();
         $(".mine_con").show();
         statue=response;
         webstatue=0;

    $.post('php/fa2.php',
        {statue:statue},
        function(response){
        // process response
        $('#sc2').append(response)

        })
     $.post('php/FanN.php',
        {statue:statue},
        function(response){
        // process response
        $('#fans_num').append(response)

        })
         $.post('php/AtN.php',
        {statue:statue},
        function(response){
        // process response
        $('#follow_num').append(response)

        })
	    }//登录失败
	        else {
	         $(".notice").html("账号或密码错误");
         $('#regist_name').val("");
         $('#regist_pwd').val("");
	     }
	        })
    }
   
 });
 //regist注册
 $('#regist_btn').on('click', function() {
	
    var uname = $('#regist_name').val();
    var upass = $('#regist_pwd').val();
    var unick = $('#regist_nicheng').val();
    var data = "name="+uname+"&pwd="+upass+"&nickname="+unick;

   $.post('php/reg.php',
        data,
        function(response){
        // process response
        
        if(response != 0) {
         $(".regist_con").hide();
         $(".mine_con").show();
         statue=response;
         webstatue=0;
         $.post('php/fa2.php',
        {statue:statue},
        function(response){
        // process response
        $('#sc2').append(response)

        })
         $.post('php/FanN.php',
        {statue:statue},
        function(response){
        // process response
        $('#fans_num').append(response)

        })
         $.post('php/AtN.php',
        {statue:statue},
        function(response){
        // process response
        $('#follow_num').append(response)

        })
    }else {
         $(".notice").html("改手机号已被注册");
         $('#regist_name').val("");
         $('#regist_pwd').val("");
     }
        })
 });

//发现
$('#fa1').on('click', function() {
	if(webstatue==0){
		webstatue=1;
		document.getElementById("sc1").innerHTML="";
	$.post('php/fa.php', {id:statue},function(response){
  $('#sc1').append(response)
  
})}
});
//搜索
$('#search').on('click', function() {
	document.getElementById("sc1").innerHTML="";
	var uname = $('#search_val').val();
	webstatue=0;
	$.post('php/search.php',
        {nick:uname,id:statue},
        function(response){
        	$('#sc1').append(response)
        	
        })
});
//关注按钮

$('.dis_fol').live('click', function() {
	$ids=$(this).attr('id');
	if(statue==0)
	{
		alert("请先登录或注册再来添加关注哦！")
	}
	else if($(this).hasClass("dis_fol on_fol"))
	{
		$.post('php/QUguan.php',
        {IDA:statue,IDB:$ids},
        function(response){
        })
		$(this).attr("class","dis_fol");
		
	}
	else{
		$.post('php/GUAN.php',
        {IDA:statue,IDB:$ids},
        function(response){
        })
		$(this).addClass("on_fol");
	}
	
});
//关注页面
$('#btn_focus').on('tap',function () {
	if(guanzhustatue==0)
	$.post('php/guanzhuyemian.php',
        
        function(response){
        	$('#guanzhu').append(response)
        })
	guanzhustatue=1;
})
//我的页面
$('#mine').on('click',function () {
	document.getElementById("follow_num").innerHTML="";
	document.getElementById("fans_num").innerHTML="";
	document.getElementById("sc3").innerHTML="";
	document.getElementById("sc4").innerHTML="";
	 $.post('php/FanN.php',
        {statue:statue},
        function(response){
        // process response
        $('#fans_num').append(response)

        })
         $.post('php/AtN.php',
        {statue:statue},
        function(response){
        // process response
        $('#follow_num').append(response)

        })
         $.post('php/Zguan.php',
        {id:statue},
        function(response){
        // process response
        $('#sc3').append(response)

        })
         $.post('php/Jguan.php',
        {id:statue},
        function(response){
        // process response
        $('#sc4').append(response)

        })
})
//赞的数目
$('#zanN').live('click',function()
      {
      	$(this).css('color','red');
      }

);
//发布动态
$('#fabiao').on('click',function()
    {
    	
    }
);

//上传图片
$(function () {  
	
    var bar = $('.bar');  
    var percent = $('.percent');  
    var showimg = $('#showimg');  
    var progress = $(".progress");  
    var files = $(".files");  
    var btn = $(".btn span");  
    $(".demo").wrap("<form id='myupload' action='action.php' method='post' enctype='multipart/form-data'></form>");  
    $("#fileupload").change(function(){  
        $("#myupload").ajaxSubmit({  
            dataType:  'json',  
            beforeSend: function() {  
                showimg.empty();  
                progress.show();  
                var percentVal = '0%';  
                bar.width(percentVal);  
                percent.html(percentVal);  
                btn.html("上传中...");  
            },  
            uploadProgress: function(event, position, total, percentComplete) {  
                var percentVal = percentComplete + '%';  
                bar.width(percentVal)  
                percent.html(percentVal);  
            },  /*
            complete: function(xhr) { 
                $(".files").html(xhr.responseText); 
            },*/
            success: function(data) {  
                files.html("<b>"+data.name+"("+data.size+"k)</b> <span class='delimg' rel='"+data.pic+"'>删除</span>");  
                img = "./upload/"+data.pic;  
                showimg.html("<img src='"+img+"'>");  
                btn.html("添加附件");  
            },  
            error:function(xhr){  
                btn.html("上传失败");  
                bar.width('0')  
                files.html(xhr.responseText);  
            }  
        });  
    });  
      
    $(".delimg").live('click',function(){  
        var pic = $(this).attr("rel");  
        $.post("action.php?act=delimg",{imagename:pic},function(msg){  
            if(msg==1){  
                files.html("删除成功.");  
                showimg.empty();  
                progress.hide();  
            }else{  
                alert(msg);  
            }  
        });  
    });  
});  

//发表动态
$("#fabiaodongtai").on('click',function()
	{
		
		var cont=$("#cont").val();

		if (cont=="")
			{alert("说点什么吧...");}
		else{
			$.post("php/fabiaodongtai.php",{imagename:img,content:cont,userid:statue},function(msg){  
            	if(msg!=0){  
                	alert("发表成功.");  
                
            	}else{  
                	alert(msg);  
            	}  
        		});  
			}
	}


)