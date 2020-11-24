$(function(){
	var id = GetQueryString("id");
	$.ajax({
		url: "/commonQueryCourseInfoToPage",
		type: "POST",
		data: {"id":id},
		async: false,
		success: function(data){
			$("#courseTitle").text(data.courseTitle);
			$("#video").attr('src',data.courseUrl);
			$("#courseIntroduction").text(data.courseIntroduction);
			$("#courseAuthor").text(data.courseAuthor);
		}
	})
	//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
	layui.use('element', function(){
  		var element = layui.element;
	});
	
	//查询是否已经收藏课程
	queryCourseCollectioned();
	
	//点击收藏课程
	$("#courseCollection").click(function(){
		courseCollection();
	})
	
	//点击取消收藏课程
	$("#courseCollectioned").click(function(){
		courseCollectioned();
	})
	
	//前台登录
	$("#login,#carouselLoginButton").click(function(){
		$(location).attr('href', '/toCommonLogin');
	})
	
	//前台注册
	$("#register").click(function(){
		$(location).attr('href', '/toCommonRegister');
	})
	
	//查询所有评论
	showAllComments();
	
	//发布评论
	layui.use(['layer', 'form'], function(){
		var layer = layui.layer
		,form = layui.form;
		$("#releaseComment").click(function(){
			layer.open({
				type: 1,
				skin: 'layui-layer-molv', //加上边框
				title: '发布评论',
				area: ['420px', '220px'], //宽高
				content: '<form class="layui-form" action="">'+
						 	'<div class="layui-form-item layui-form-text">'+
						 		'<div style="margin-top:5px;margin-left:1%;width:98%;" class="layui-input-block">'+
						 			'<textarea id="comment" name="comment" placeholder="请输入内容" class="layui-textarea"></textarea>'+
						 		'</div>'+
						 	'</div>'+
						 	'<div class="layui-form-item">'+
		    					'<div class="layui-input-block">'+
		    						'<button class="layui-btn" lay-submit lay-filter="comment">立即发布</button>'+
		    						'<button type="reset" class="layui-btn layui-btn-primary">重置</button>'+
		    					'</div>'+
		    				'</div>'+
						 '</form>'
			});
		})
		//监听提交评论
		form.on('submit(comment)', function(data){
			$.ajax({
    			url: "/commonUserReleaseComment",
    			type: "POST",
            	async: false,
            	data: {"comment":$("#comment").val(),"id":id},
            	success: function(data) {
            		if(data.code == 0){
            			setTimeout("window.location.reload()", 1000);  
            			layer.msg(data.msg);
            		}else {
            			layer.msg(data.msg);
            		}
    			}
    		})
    		return false;
		});
	});
	
})

function GetQueryString(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
	if(r!=null)return  unescape(r[2]); return null;
}

/**
 * 查询所有评论
 * @returns
 */
function showAllComments(){
	var id = GetQueryString("id");
	$.ajax({
		url: "/commonQueryAllComments",
		type: "POST",
		data: {"id":id},
		async: false,
		success: function(data){
			$.each(data, function(n, value) {
    			var comment = "<div class='wenda-listcon mod-qa-list post-row clearfix'>"+
    							  "<div class='headslider qa-medias l'>"+
    							  	  "<a href='javascript:void(0)' class='media'>"+
    							  	  	  "<img src="+value.headPortrait+" width='40' height='40'>"+
    							  	  "</a>"+
    							  "</div>"+
    							  "<div class='wendaslider qa-content'>"+
    							  	  "<div class='tit'>"+
    							  	  	  "<a href='javascript:void(0)'>"+value.username+"</a>"+
    							  	  "</div>"+
    							  	  "<div class='cnt'>"+value.commentContent+""+
    							  	  "</div>"+
    							  	  "<div class='replymegfooter qa-footer clearfix'>"+
    							  	  	  "<span class='r timeago'>"+value.commentTime+"</span>"+
    							  	  "</div>"+
    							  "</div>"+
    						  "</div>";
    			$("#commentList").append(comment);
    		});
		}
	})
}

/**
 * 查询是否已经收藏课程
 * @returns
 */
function queryCourseCollectioned(){
	var userId = $("#userId").text();
	var courseId = GetQueryString("id");
	$.ajax({
		url: "/queryCourseCollectioned",
		type: "POST",
    	async: false,
    	data: {"userId":userId,"courseId":courseId},
    	success: function(data) {
    		if(data.code == 0){
    			$("#courseCollection").hide();
    			$("#courseCollectioned").show();
    		}else {
    			$("#courseCollection").show();
    			$("#courseCollectioned").hide();
    		}
		}
	})
}

/**
 * 点击课程收藏
 * @returns
 */
function courseCollection(){
	var userId = $("#userId").text();
	var courseId = GetQueryString("id");
	$.ajax({
		url: "/commonCourseCollection",
		type: "POST",
    	async: false,
    	data: {"userId":userId,"courseId":courseId},
    	success: function(data) {
    		if(data.code == 0){ 
    			layer.msg(data.msg);
    			$("#courseCollection").hide();
    			$("#courseCollectioned").show();
    		}else {
    			layer.msg(data.msg);
    		}
		}
	})
}

/**
 * 点击取消课程收藏
 * @returns
 */
function courseCollectioned(){
	var userId = $("#userId").text();
	var courseId = GetQueryString("id");
	$.ajax({
		url: "/commonCourseCollectioned",
		type: "POST",
    	async: false,
    	data: {"userId":userId,"courseId":courseId},
    	success: function(data) {
    		if(data.code == 0){ 
    			layer.msg(data.msg);
    			$("#courseCollectioned").hide();
    			$("#courseCollection").show();
    		}else {
    			layer.msg(data.msg);
    		}
		}
	})
}