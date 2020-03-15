layui.define(['table','layer'],function(exports){
	var table=layui.table;
	table.render({
		elem : '#classes',
		height : 530,
		url : '/classes/getClassesTableInfo' //数据接口
		,
		toolbar: '#toolbarDemo',
		page : true //开启分页
		,
		cols : [ [ //表头
			{type: 'checkbox'},	
		{
			field : 'id',
			title : 'ID',
			width : 80,
			sort : true
		}, {
			field : 'className',
			title : '课程名',
			width : 80
		}, {
			field : 'teacher',
			title : '教练',
			width : 80,
			sort : true
		}, {
			field : 'classTime',
			title : '课时',
			width : 80
		}, {
			field : 'nums',
			title : '课程数',
			width : 177
		}, {
			field : 'price',
			title : '课程价格',
			width : 180,
			sort : true
		}, {
			field : '',
			title : '操作',
			width : 312,
			toolbar : '#barDemo'
		}
		] ],
	
	});
	//监听
	table.on('tool(classes)', function(res) {
		var opt=res.event;
		var classes=res.data;
		console.log(classes);
		
		if (opt === 'edit') {
			$.post('/classes_update',{
				id:classes.id,
				className:classes.className,
				teacher:classes.teacher,
				classTime:classes.classTime,
				nums:classes.nums,
				price:classes.price
			},function(data){
				 layer.open({
					    type: 1,
					    icon: 5,
					    area: ['700px', '350px'],
					    content: data //注意，如果str是object，那么需要字符拼接。
					  });
			});

		}else if(opt === 'del'){
			var id=classes.id;
			layer.confirm('真的删除行么', function(index){
		        layer.close(index);
		        $.get("classes/delete",{id:id},function(data){
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
	exports('classes');
});



