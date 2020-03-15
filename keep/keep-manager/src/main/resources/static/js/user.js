layui.define(['table','layer'],function(exports){
	var table=layui.table;
	table.render({
		elem : '#user',
		height : 473,
		url : '/user/findUserInfoTable' //数据接口
		,
		page : true //开启分页
		,
		cols : [ [ //表头
		{
			field : 'id',
			title : 'ID',
			width : 80,
			sort : true,
			fixed : 'left'
		}, {
			field : 'name',
			title : '用户名',
			width : 80
		}, {
			field : 'age',
			title : '年龄',
			width : 80,
			sort : true
		}, {
			field : 'tel',
			title : '电话',
			width : 80
		}, {
			field : 'addr',
			title : '住址',
			width : 177
		}, {
			field : 'createdTime',
			title : '创建时间',
			width : 180,
			sort : true
		}, {
			field : 'modifiedTime',
			title : '修改时间',
			width : 180,
			sort : true
		}, {
			field : '',
			title : '操作',
			width : 180,
			toolbar : '#barDemo'
		}

		] ],
		text : {
			none : '加载数据失败'
		}
	});
	table.on('tool(test)', function(res) {
		var user=res.data;
		
		if (res.event === 'edit') {
			$.post('update', {
				id:user.id,
				name:user.name,
				age:user.age,
				tel:user.tel,
				addr:user.addr
			}, function(data){
				  layer.open({
				    type: 1,
				    icon: 5,
				    area: ['700px', '350px'],
				    content: data //注意，如果str是object，那么需要字符拼接。
				  });
				});
		}else if(res.event=='del'){
			var id=user.id;
			layer.confirm('真的删除行么', function(index){
		        console.log(index);
		        layer.close(index);
		        $.get("user/delete",{id:id},function(data){
		        	console.log(data);
		        	if(data.status==200){
		        		res.del();
		        	}else{
		        		layer.msg("删除失败");
		        	}
		        });
		     });
		}

	})
	exports('user');
});



