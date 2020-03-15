layui.define(['table','layer'],function(exports){
	var table=layui.table;
	table.render({
		elem : '#meterial',
		height : 473,
		url : '/mechine/getMechineTableInfo' //数据接口
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
			field : 'name',
			title : '器械名',
			width : 80
		}, {
			field : 'nums',
			title : '数量',
			width : 80,
			sort : true
		}, {
			field : 'price',
			title : '价格',
			width : 80
		}, {
			field : 'inTime',
			title : '进货时间',
			width : 177
		}, {
			field : 'fixTime',
			title : '维修时间',
			width : 180,
			sort : true
		}, {
			field : '',
			title : '操作',
			width : 180,
			toolbar : '#barDemo'
		}
		] ],
	
	});
	//监听
	table.on('tool(mechine)', function(res) {
		var opt=res.event;
		var mechine=res.data;
		console.log(mechine);
		if (opt === 'edit') {
			$.post('/machine_update',{
				id:mechine.id,
				name:mechine.name,
				nums:mechine.nums,
				price:mechine.price
			},function(data){
				 layer.open({
					    type: 1,
					    icon: 5,
					    area: ['700px', '350px'],
					    content: data //注意，如果str是object，那么需要字符拼接。
					  });
			});
		}else if(opt==='del'){
			/**
			 * 还没有实现批量删除
			 */
			var id=mechine.id;
			layer.confirm('真的删除行么', function(index){
		        layer.close(index);
		        $.get("mechine/delete",{id:id},function(data){
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
	exports('mterial');
});



