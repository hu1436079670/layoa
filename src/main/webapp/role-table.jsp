<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layui-table</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- 引用layui的样式表 -->
<link rel="stylesheet" href="assert/layui/css/layui.css">
</head>
<body>
	<button type="button" class="layui-btn" id="btn_add" >新增</button>
	<table id="demo" lay-filter="table_role"></table>
	<script type="text/html" id="roleKindTpl">
  		{{#  if(d.roleKind == 1){ }}
				<span class="layui-badge layui-bg-orange">超级用户</span>
  			{{#  } else { }}
			 	<span class="layui-badge layui-bg-black">普通用户</span>
  		{{#  } }}
	</script>
	<!-- 修改 删除按钮 -->
	<!-- 此处注意，必须有lay-event	才能通过table.on完成事件的绑定 -->
	<script type="text/html" id="roleBtnTpl">
		<a lay-event="edit" class="layui-btn layui-btn-normal layui-btn-xs">修改</a>
  		{{#  if(d.roleKind == 1){ }}
				<button type="button" class="layui-btn layui-btn-xs layui-btn-disabled">删除</button>				
  			{{#  } else { }}
			 	<button lay-event="delete" type="button" class="layui-btn layui-btn-xs">删除</button>
  		{{#  } }}
	</script>
</body>
<script type="text/javascript" src="assert/layui/layui.js"></script>
<script type="text/javascript">
layui.use(['table','form'], function(){
	  var $ = layui.$;
	  //取得layui的table模板
	  var table = layui.table;
	  var form = layui.form;
	  //通过render方法开始渲染table的数据
	  table.render({
	    elem: '#demo'//要绑定的页面元素
	    ,height: 312//设置高度
	    ,url: 'role/find' //数据接口
	    ,page: true //开启分页
	    ,limit:2//	每页的数据量	默认：10；自定义：2
	    ,cols: [[ //表头
	      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'roleCode', title: '角色编号', width:120}
	      ,{field: 'roleName', title: '角色名称', width:120}
	      ,{field: 'roleKind', title: '角色类型', width:120, templet:'#roleKindTpl'} 
	      ,{field: 'roleInfo', title: '角色简介', width:120} 
	      ,{field: '', title: '操作', width:140, templet:'#roleBtnTpl'} 	
	      /*  ,{field: 'experience', title: '积分', width: 80, sort: true}
	      ,{field: 'score', title: '评分', width: 80, sort: true}
	      ,{field: 'classify', title: '职业', width: 80}
	      ,{field: 'wealth', title: '财富', width: 135, sort: true} */
	    ]]
	  });
	//监听工具条 
	  table.on('tool(table_role)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
	    var data = obj.data; //获得当前行数据
	    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	    //var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
		//通过data将要修改的数据的主键   取出
		var rowId = data.rowId;
	    switch(layEvent){
	    case 'edit':
	    	//console.log("准备执行 修改");
	    	$.ajax({
	    		type:'put',
	    		url:'role/'+rowId,
	    		success:function(role){
	    			 if(role){
	    				$('#roleCode').val(role.roleCode);
	    				$('#userName').val(role.roleName);
	    				$('#roleKind').val(role.roleKind);
	    				$('#roleInfo').val(role.roleInfo);
	    				$('#rowId').val(role.rowId);
	    				layer.open({
	  					  type:1,//1:页面层
	  					  title:'修改角色',
	  					  area:'800px',//设置高度，高度自适应
	  					 content:htmlData,//这里content是一个DOM。注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
	  					  success:function(){//layer打开成功后的回调
	  						  //让form表单渲染一下。form_role_add_edit=<form lay-filter="form_role_add_edit">
	  						  form.render(null,'form_role_add_edit');
	  					  }
	  				  });
	    			} 
	    		}
	    	});
	    	break;
	    case 'delete':
	    	//让用户再确认一次
	    	if(layer.confirm('你确定要删除吗？')){
	    		$.ajax({
	    			type:'delete',
	    			url:'role/'+rowId,
	    			success:function(result){
	    				if(result){
	    					layer.msg("已删除。");
	    				}
	    			}
	    		});
	    	}
	    	break;	
	    default:
	    	break;
	    }
	  });
	  //绑定新增 按钮
	  $('#btn_add').on('click',function(){
		  //alert('ttt');
		  $.ajax({
			  type:'post',
			  url:'role/goadd',
			  success:function(htmlData){
				  //console.log(htmlData);
				  layer.open({
					  type:1,//1:页面层
					  title:'新增角色',
					  area:'800px',//设置高度，高度自适应
					  content:htmlData,//这里content是一个DOM。注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					  success:function(){//layer打开成功后的回调
						  //让form表单渲染一下。form_role_add_edit=<form lay-filter="form_role_add_edit">
						  form.render(null,'form_role_add_edit');
					  }
				  });
			  }
		  });
	  });
	
	});
</script>
</html>