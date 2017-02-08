//json添加数据
	function addData1(){
		canLoad = false;//开始加载数据是，不让重复加载
		$.getJSON("hot.json",function(data){//用jsonp加载数据
				console.log(data)
		var str = "";
		for(var i =0;i<data.length;i++){ //拿到数值数据，加循环也就是遍历
			var oSrc = data[i].src; //拿到图片的src

			var name = data[i].name;
			var detail = data[i].detail;
			var nowpai = data[i].nowpai;
			var oldpai = data[i].oldpai;
			var href = data[i].href;
			str ='<ul><li><dl><dt><img src="'+'oSrc'+'"/></dt><dd>'
				+name+'</dd></dl></li>';//万恶的字符串 把取到支值放进去

				$(str).appendTo($("#footballnow")); //添加
					}
					//$('body').append(str)t
					canLoad = true;//数据添加完成后，允许再次加载
				})
			}