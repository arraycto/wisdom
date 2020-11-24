$(function(){
	//展示菜单
	menuShow();
	
	//前台登录
	$("#login,#carouselLoginButton").click(function(){
		$(location).attr('href', '/toCommonLogin');
	})
	
	//前台注册
	$("#register").click(function(){
		$(location).attr('href', '/toCommonRegister');
	})
	
	//个人信息
	$("#personalInformation").click(function(){
		showPersonalInformation();
	})
	
	//申请讲师
	$("#applyLecturer").click(function(){
		applyLecturer();
	})
	
	//退出系统
	$("#commonLogout").click(function(){
		layer.confirm('确认退出吗？', {
			btn: ['确认','取消'] //按钮
		}, function(){
		    $.ajax({
		    	url: "/commonToLogout",
    			type: "GET",
            	async: false,
            	success: function(data) {
        			layer.msg(data.msg);
        			setTimeout("location.href='/commonLogout';", 1000);  
    			}
		    });
		}, function(){
			layer.close(layer.index);
	    });
	})
	
	//查询课程分类父节点
	selectCourseParents();
	
	//查询课程分类子节点
	selectCourseChildren();
	
	//layui表单验证及提交
	layui.use('form', function(){
	    var form = layui.form; 
	    form.render();
	    //搜索课程
		form.on('submit(courseSearch)', function(data){
			$.ajax({
				url: "/commonCourseSearch",
				type: "GET",
	        	async: false,
	        	data: {"keywords":$("#keywords").val()},
	        	success: function(data) {
	        		$(location).attr('href', '/toCourseSearch?keywords='+data+'');
				}
			})
			return false;
		});
	});	
	
	layui.use('carousel', function(){
	  	var carousel = layui.carousel;
	  	//建造实例
	  	carousel.render({
	    	elem: '#carousel'
	    	,width: '100%' //设置容器宽度
	    	,height: '100%' //设置容器宽度
	    	,arrow: 'hover' //始终显示箭头
	    	,anim: 'fade' //切换动画方式
	  	});
	  	document.getElementById('layui-cld').style.background = getCarouselColor(document.getElementById('carouselImg1'));
	  	document.getElementById('carouselLogin').style.background = getCarouselColor(document.getElementById('carouselImg1'));
	  	//监听轮播切换事件
	  	carousel.on('change(carousel)', function(obj){
	  	 	var img = obj.item[0].getElementsByTagName("img")[0];
	  	  	document.getElementById('layui-cld').style.background = getCarouselColor(img);
	  	  	document.getElementById('carouselLogin').style.background = getCarouselColor(img);
	  	  	
	  	}); 
	});
	
	//查询最新课程
	queryLatestCourse();
	
	//查询最热门课程
	queryHottestCourse();
	
	//查询站长推荐课程
	queryRecommendCourse();
})

//获取轮播图图片颜色
function getCarouselColor(img){
	var canvas = document.getElementById('carouselCanvas');
	var ctx = canvas.getContext("2d");
	ctx.drawImage(img, 0, 0);
	var colorData = document.getElementById("carouselCanvas").getPixelColor(1, 1);
	var hexColor = colorData.hex;//获得十六进制颜色
	return hexColor;
}

//展示菜单
function menuShow() {
	$("#courseParentsListUl").on("mouseover","li",function(){
		var index = $(this).index();
		var num = index + 1;
		$(".menu_show").eq(index).siblings().hide();
		$(".menu_show").eq(index).show();
		$("#menu_show"+num).mouseover(function(){
			$(this).css("display","block");
		});
		$("#menu_show"+num).mouseout(function(){
			$(this).css("display","none");
		});
	})
	$("#courseParentsListUl").on("mouseout","li",function(){
		var index = $(this).index();
		$(".menu_show").eq(index).hide();
	})
}

//查询课程父节点
function selectCourseParents() {
	$.ajax({
		url: "/commonSelectCourseParents",
		type: "POST",
		async: false,
    	success: function(data) {
    		$.each(data, function(n, value) {
    			var courseParentsListLi = "<li class='mod-nav__li menu_line'>"+
										      "<div>"+
												  "<i class='layui-icon i-v-right'>&#xe602;</i>"+   
													  "<h3 class='mod-nav__link-nav-first'>"+
														  "<a href='javascript:void(0);' class='mod-nav__link-nav-first-link'>"+value+"</a>"+
													  "</h3>"+
											  "</div>"+
										  "</li>";
    			$("#courseParentsListUl").append(courseParentsListLi);
    		});
		}
	});
} 

//查询课程分类字子节点
function selectCourseChildren() {
	$.ajax({
		url: "/commonSelectCourseChildren",
		type: "POST",
		async: false,
		success: function(data){
			//解析map
			$.each(data,function(key,values){
				var courseChildMap = "";
				var courseChildList = "";
				var courseChildMapStart= "<div id='menu_show"+key+"' class='menu_show'>"+
											  "<div class='innerBox'>"+
											      "<div class='subinnerBox'>"+
											          "<div class='banner-line'>"+
											              "<span class='bold mr10 l'>课程分类</span>"+
											          "</div>"+
												  "<div class='tag-box l'>";
				$.each(values,function(n, value){
					courseChildList += "<a target='_blank' href='/toCourseSearch?keywords="+value+"'>"+value+"</a>";
				});
				var courseChildMapEnd = 			"</div>"+
												"</div>"+
											"</div>"+
										"</div>";
				courseChildMap = courseChildMapStart + courseChildList + courseChildMapEnd;	
				$("#courseChildrenMapShow").append(courseChildMap);
			});
		}
	});
}

//首页查询最新课程
function queryLatestCourse() {
	$.ajax({
		url: "/commonQueryLatestCourse",
		type: "POST",
		async: false,
		success: function(data){
			$.each(data,function(key,values){
				var recommendations = "";
				for (var i = 0; i < values.recommendationIndex; i++) {
					var recommendation = "<i class='layui-icon' style='font-size: 12px; color: #ff9900;'>&#xe67a;</i>";
					recommendations = recommendations + recommendation;
				}
				var content = "<div class='index-card-container course-card-container'>"+
							  	  "<a href='javascript:void(0)' onclick='toCourseVideoPage("+values.id+")' target='_blank'>"+
							  	  	  "<div class='course-card-top'>"+
							  	  	  	  "<img class='course-banner' src="+values.courseImg+">"+
							  	  	  "</div>"+
							  	  	  "<div class='course-card-content'>"+
							  	  	  	  "<h3 class='course-card-name'>"+values.courseTitle+"</h3>"+
							  	  	  	  "<div class='course-card-info'>"+
							  	  	  	  	  "<span>实战</span>"+
							  	  	  	  	  "<span>初级</span>"+
							  	  	  	  	  "<span>"+
							  	  	  	  	  	  "<i class='icon-set_sns layui-icon'>&#xe770;</i>"+values.clickRate+""+
							  	  	  	  	  "</span>"+
							  	  	  	  	  "<span id='courseStarBox' class='course-star-box'>";
							  	  	  	  	  
				var content3 =			  	  "</span>"+
							  	  	  	  "</div>"+
							  	  	  "</div>"+
							  	  "</a>"+
							  "</div>";
				$("#latestCourses").append(content+recommendations+content3);
			});
		}
	})
}

//首页查询最热门课程
function queryHottestCourse() {
	$.ajax({
		url: "/commonQueryHottestCourse",
		type: "POST",
		async: false,
		success: function(data){
			$.each(data,function(key,values){
				var recommendations = "";
				for (var i = 0; i < values.recommendationIndex; i++) {
					var recommendation = "<i class='layui-icon' style='font-size: 12px; color: #ff9900;'>&#xe67a;</i>";
					recommendations = recommendations + recommendation;
				}
				var content = "<div class='index-card-container course-card-container'>"+
							  	  "<a href='javascript:void(0)' onclick='toCourseVideoPage("+values.id+")' target='_blank'>"+
							  	  	  "<div class='course-card-top'>"+
							  	  	  	  "<img class='course-banner' src="+values.courseImg+">"+
							  	  	  "</div>"+
							  	  	  "<div class='course-card-content'>"+
							  	  	  	  "<h3 class='course-card-name'>"+values.courseTitle+"</h3>"+
							  	  	  	  "<div class='course-card-info'>"+
							  	  	  	  	  "<span>实战</span>"+
							  	  	  	  	  "<span>初级</span>"+
							  	  	  	  	  "<span>"+
							  	  	  	  	  	  "<i class='icon-set_sns layui-icon'>&#xe770;</i>"+values.clickRate+""+
							  	  	  	  	  "</span>"+
							  	  	  	  	  "<span id='courseStarBox' class='course-star-box'>";
							  	  	  	  	  
				var content3 =			  	  "</span>"+
							  	  	  	  "</div>"+
							  	  	  "</div>"+
							  	  "</a>"+
							  "</div>";
				$("#hottestCourses").append(content+recommendations+content3);
			});
		}
	})
}

//首页查询站长推荐课程
function queryRecommendCourse() {
	$.ajax({
		url: "/commonQueryRecommendCourse",
		type: "POST",
		async: false,
		success: function(data){
			$.each(data,function(key,values){
				var recommendations = "";
				for (var i = 0; i < values.recommendationIndex; i++) {
					var recommendation = "<i class='layui-icon' style='font-size: 12px; color: #ff9900;'>&#xe67a;</i>";
					recommendations = recommendations + recommendation;
				}
				var content = "<div class='index-card-container course-card-container'>"+
							  	  "<a href='javascript:void(0)' onclick='toCourseVideoPage("+values.id+")' target='_blank'>"+
							  	  	  "<div class='course-card-top'>"+
							  	  	  	  "<img class='course-banner' src="+values.courseImg+">"+
							  	  	  "</div>"+
							  	  	  "<div class='course-card-content'>"+
							  	  	  	  "<h3 class='course-card-name'>"+values.courseTitle+"</h3>"+
							  	  	  	  "<div class='course-card-info'>"+
							  	  	  	  	  "<span>实战</span>"+
							  	  	  	  	  "<span>初级</span>"+
							  	  	  	  	  "<span>"+
							  	  	  	  	  	  "<i class='icon-set_sns layui-icon'>&#xe770;</i>"+values.clickRate+""+
							  	  	  	  	  "</span>"+
							  	  	  	  	  "<span id='courseStarBox' class='course-star-box'>";
							  	  	  	  	  
				var content3 =			  	  "</span>"+
							  	  	  	  "</div>"+
							  	  	  "</div>"+
							  	  "</a>"+
							  "</div>";
				$("#recommendCourses").append(content+recommendations+content3);
			});
		}
	})
}

function toCourseVideoPage(id){
	window.open('/toCourseVideo?id='+id);
}

function showPersonalInformation(){
	layer.open({
        type: 2,
        title: '个人设置',
        maxmin: true,
        shadeClose: false,
        area: ['500px', '400px'],
        content: '/showPersonalInformation'
    });
}

function applyLecturer(){
	layer.open({
        type: 2,
        title: '讲师申请',
        maxmin: true,
        shadeClose: false,
        area: ['500px', '400px'],
        content: '/applyLecturer'
    });
}






