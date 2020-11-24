$(function(){
	layui.use(['form','upload'], function(){
		var form = layui.form
		,layer = layui.layer
		,upload = layui.upload;
		 
		//自定义验证规则
		form.verify({
			courseTitle: function(value){
		        if(value.length >= 20){
		            return '标题不得超过20个字符！';
		        }
		    }
		    ,courseIntroduction: function(value){
		    	if(value.length >= 100){
		            return '内容不得超过100个字符！';
		        }
		    }
		});
		
		//上传指定文件
		upload.render({
		    elem: $('#courseImg')
		    ,auto: false
		    ,accept: 'file' //普通文件
			,exts: 'jpg|png' //允许上传的文件后缀
		});
		
		upload.render({
		    elem: $('#courseUrl')
		    ,auto: false
		    ,accept: 'file' //普通文件
			,exts: 'avi|mp4' //允许上传的文件后缀
		});
		
		//监听提交
		form.on('submit(upload)', function(data){
			var formData = new FormData($("#courseUpload")[0]);
			$.ajax({
    			url: "/courseUpload",
    			type: "POST",
    			async: false,
                data : formData,
                cache: false,
                contentType: false,  
                processData: false, 
            	success: function(data) {
            		layer.msg(data.msg);
            		setTimeout(function(){
            			window.location.reload();//刷新当前页面.
            		},1000);  
    			}
    		})
    		return false;
		});
		
		form.on('select(quiz1)', function(data){
			$.ajax({
				url: "/commonSelectCourseChildren",
				type: "POST",
				async: false,
				success: function(map) {
					$("#quiz2").empty();
					$("#quiz2").append("<option value=''>请选择二级课程分类</option>");
					$.each(map,function(key,values){
						var num = key + "";
						if(num == data.value){
							$(values).each(function(){   
								var option = "<option value='"+this+"'>"+this+"</option>";
								$("#quiz2").append(option);
						    });
						}
				    });
				}
			})  
			form.render();
		});
	});
	
	//初始化课程类父节点下拉框
	initCourseParentsSelect();
	
})

/**
 * 初始化课程类父节点下拉框
 * @returns
 */
function initCourseParentsSelect() {
	$.ajax({
		url: "/commonSelectCourseParents",
		type: "POST",
		async: false,
		success: function(data) {
			$.each(data,function(index,value){
				var num = index + 1;
				var option = "<option value='"+num+"'>"+value+"</option>";
				$("#quiz1").append(option);
			})
		}
	})
}

/**
 * 初始化课程类子节点下拉框
 * @returns
 */
function initCourseChildrenSelect() {
	$.ajax({
		url: "/commonSelectCourseChildren",
		type: "POST",
		async: false,
		success: function(data) {
			/*$.each(data,function(index,value){
				var option = "<option value='"+value+"'>"+value+"</option>";
				$("#quiz1").append(option);
			})*/
			
		}
	})
}
