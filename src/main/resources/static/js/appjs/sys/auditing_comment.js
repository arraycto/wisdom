$(function(){
	$('#exampleTable').bootstrapTable({
		method : 'get', // 服务器数据的请求方式 get or post	
		url : "/sysAuditingComment", // 服务器数据的加载地址
		iconSize : 'outline',
		toolbar : '#exampleToolbar',
		striped : true, // 设置为true会有隔行变色效果
		dataType : "json", // 服务器返回的数据类型
		pagination : true, // 设置为true会在底部显示分页条
		singleSelect : false, // 设置为true将禁止多选
		pageSize : 10, // 如果设置了分页，每页数据条数
		pageNumber : 1, // 如果设置了分布，首页页码
		showColumns : false, // 是否显示内容下拉框（选择显示的列）
		sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
		queryParams : function(params) {
			return {
				//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
				limit : params.limit,
				offset : params.offset,
				comment: $('#comment').val()
			};
		},
		columns : [
			{
			    title: '序号',
			    field: '',
			    align: 'center',
			    formatter: function (value, row, index) {
			        var pageSize = $('#exampleTable').bootstrapTable('getOptions').pageSize;     //通过table的#id 得到每页多少条
			        var pageNumber = $('#exampleTable').bootstrapTable('getOptions').pageNumber; //通过table的#id 得到当前第几页
			        return pageSize * (pageNumber - 1) + index + 1;    // 返回每条的序号： 每页条数 *（当前页 - 1 ）+ 序号
			    }
			},
			{
				field : 'commentContent',
				align: 'center',
				title : '评论内容'
			},
			{
				field : 'status',
				align: 'center',
				title : '状态',
				formatter : function(value, row, index) {
					if (value == 0) {
						return '<span class="label label-danger">审核不通过</span>';
					} else if (value == 1) {
						return '<span class="label label-primary">审核通过</span>';
					}
				}
			},
			{
				field : 'username',
				align: 'center',
				title : '评论人'
			},
			{
				field : 'commentTime',
				align: 'center',
				title : '评论时间'
			},
			{
				title : '操作',
				field : 'operation',
				align : 'center',
				formatter : function(value, row, index) {
					var d = '<a class="btn btn-warning btn-sm ' + s_edit_h + '" href="#" title="编辑"  mce_href="#" onclick="edit(\''
						+ row.id
						+ '\')"><i class="layui-icon layui-icon-edit"></i></a> ';
					return  d;
				}
			} 
		]
	});
})

function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}

function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '500px', '250px' ],
		content : '/sysAuditingCommentEdit/' + id, // iframe的url
		end: function () {
			reLoad();
		}
	});
}