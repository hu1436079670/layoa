<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="layui-form" lay-filter="form_role_add_edit">
	<div class="layui-form-item">
		<label class="layui-form-label">角色编号</label>
		<div class="layui-input-block">
			<!-- lay-verify="required" 是校检 -->
			<input name="roleCode" required lay-verify="required" placeholder="请输入角色编号" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色名称</label>
		<div class="layui-input-block">
			<!-- lay-verify="required" 是校检 -->
			<input name="roleName" required lay-verify="required|checkRoleName" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色类型</label>
		<div class="layui-input-block">
			<select name="roleKind" lay-verify="required">
				<option value=""></option>
				<option value="0">普通角色</option>
				<option value="1">超级角色</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">角色简介</label>
		<div class="layui-input-block">
			<!-- lay-verify="required" 是校检 -->
			<input name="roleInfo" required lay-verify="required" placeholder="请输入角色简介" autocomplete="off" class="layui-input">
		</div>
	</div>
	
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="btn_role_submit">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<script type="text/javascript">
	//layui.use 当页面渲染成功后，加载配置的模板
	layui.use([ 'layer', 'form' ], function() {
		//通过一个变量将加载的模本取出
		var layer = layui.layer;
		var form = layui.form;
		//layui内置jquery
		var $ = layui.$;

		//表单的自定义校验
 		form.verify({
			checkRoleName : function(value, item) {//value:表单的值;item:表单的DOM的对象
				//console.log(value);
				var msg;
				$.ajax({
					type : 'get',
					async : false,//为了让layui可以唯一性的校验，需要将ajax的异步提交关闭。
					url : 'role/checkRoleName',
					data : {
						"roleName" : value
					},
					success : function(result) {
						//判断此名称不可以使用，已经有人用了
						if (result == 0) {
							//不要在ajax的success中return 
							//return '此名称已有人使用' 
							msg = '此名称已有人使用';
						}
					}
				});
				//在ajax的外面return 此检测的结果。
				//如果return的数据有值的话，则layui就认为是校验不通过。
				//如果return的结果是个空，则layui认为校验通过。
				return msg;
			}
		}); 
		//绑定提交按钮
		form.on('submit(btn_role_submit)', function() {
			//console.log(data.elem);//被执行时间的元素DOM对象，一般为button对象
			//console.log(data.form);//被执行提交的form对象，一般在存在form标签是才会返回
			//console.log(data.field);//当前容器的全部表单字，名值对形式；{name:value}
			//form.val('filter',object);表单赋值，取值
			//var data = form.val('form_role');
			
			//通过 使用jQuery的表单序列化
			var formData = $(data.form).serialize();
			//console.log(formData);
			$.ajax({
				type : 'post',
				url : 'role',
				data : formData,
				success : function(result) {
					if (result) {
						layer.msg("提交成功了！");
					}
				}
			}); 
			//如果你想关闭最新弹出的层，直接获取layer.index即可
			layer.close(layer.index);
			
			//尝试使用ajax的方式提交到后台
			//$.ajax();
			//将按钮自带的提交动作屏蔽掉
			return false;
		});

	});
</script>
