//layui.use 当页面渲染成功后，加载配置的模板
layui.use([ 'layer', 'form' ], function() {
	// 通过一个变量将加载的模本取出
	var layer = layui.layer;
	var form = layui.form;
	// layui内置jquery
	var $ = layui.$;

	// 表单的自定义校验
	form.verify({
		checkRoleName : function(value, item) {// value:表单的值;item:表单的DOM的对象
			// console.log(value);
			var msg;
			//判断会否需要进行唯一性的校验
			var oldVal = $(item).data('old');
			//如果原来的值有数据,并且原值和当前的值一样,则不需要进行唯一性校验。
			if(oldVal != null && oldVal == value){
				return msg;
			}else{//否则我们需要进行唯一性的校验
				$.ajax({
					type : 'get',
					async : false,// 为了让layui可以唯一性的校验，需要将ajax的异步提交关闭。
					url : 'role/checkRoleName',
					data : {"roleName" : value},
					success : function(result) {
						// 判断此名称不可以使用，已经有人用了
						if (result == 0) {
							// 不要在ajax的success中return
							// return '此名称已有人使用'
							msg = '此名称已使用,请重新填写';
						}
					}
				});
			}
			// 在ajax的外面return 此检测的结果。
			// 如果return的数据有值的话，则layui就认为是校验不通过。
			// 如果return的结果是个空，则layui认为校验通过。
			return msg;
		}
	});
	// 绑定提交按钮
	form.on('submit(btn_role_submit)', function(data) {
		var rowId = data.field.rowId;
		//默认为新增
		var type='post';
		if(rowId){//如果rowId有值，则执行修改
			type:'put';
		}
		$.ajax({
			type : type,
			url : 'role',
			data : $(data.form).serialize(),
			success : function(result) {
				if (result) {
					//关闭弹出层
					//layer.close(layer.index);
					layui.closeAll();//疯狂模式,关闭所有层
					//重新加载表格数据 #'demo'	<table id="demo">
					table.reload("demo");
					layer.msg("提交成功了！");
				}
			}
		});

		// 将按钮自带的提交动作屏蔽掉
		return false;
	});

});