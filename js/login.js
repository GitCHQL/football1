
//点击登录按钮，判断用户名和密码
$('#login-btn').on('tap', function() {
    var uname = $('#name').val();
    var upass = $('#pwd').val();
    var data = "name="+uname+"&pass="+upass;
    $.get("php/checknameandpass.php", data, function(msg) {
        console.log(msg)
        var msg = JSON.parse(msg);
        //console.log(msg)
        if(msg.result == 1) {
            if(uname == "11111111111") {
                window.location = "./html/people.html";
            } else {
                window.location = "./html/project.html";
            }
        }else {
            alert("用户名或密码错误");
        }
    });
$('#regist_name').focus(function(){                             //用户名

    $(this).css({"border":"1px solid #ccc"})
    $(this).parent().siblings().html("请输入11位手机号码")

}).blur(function(){   //失去焦点
    var regName = $(this).val();
    $(this).css({"border":"1px solid #666"});
    $(this).parent().siblings().html("");

    if(regName.trim().length == 0) {
        $(this).css({"border": "1px solid #00008b"});
        $(this).parent().siblings().html('手机号码不能为空');
    }else{
        var oNameTestReg = /^[1]\d{10}$/;
        if(!oNameTestReg.test(regName)) {
            $(this).parent().siblings().html("请输入正确的手机号");
        }else {

            var reName = $('#reg-name').val();
            var reData = "name=" + reName;
            $.get("php/checkUser.php",reData, function(msg) {
                // console.log(msg)
                var msg = JSON.parse(msg);
                if(msg.result == 1) {
                    console.log(1)
                    //alert("手机号码已存在")
                    $("#reg-tel").html("手机号码已经存在");
                }
            })
        }
    }
});
//点击注册按钮,注册用户
$("#login_btn").on("tap",function(){

    console.log("aaaaa");

    var regName = $('#regist_name').val();
    var regPass = $('#regist_pwd').val();
    var regnick = $('regist_nicheng').val();
    var regData = "name=" + regName + "&pass=" + regPass + "&nickname=" +regnick;
    $.get("php/addUser.php",regData, function(msg) {
        console.log(msg)
        var msg = JSON.parse(msg);
        if(msg.result == 1) {
            alert("注册成功");
        }

    })
});