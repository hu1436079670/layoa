layui.use(['table','form'], function(){
	  var $ = layui.$;
	  //取得layui的table模板
	  var table = layui.table;
	  var form = layui.form;
	  //通过render方法开始渲染table的数据
	  table.render({
	    elem: '#demo'//要绑定的页面元素
	    ,height: 312//设置高度
	    ,url: 'role' //数据接口
	    ,where:$('#form_search').serialize()//模拟额外的参数#目前引入搜索表单的数据
	    ,page: true //开启分页
	    ,limit:5//	每页的数据量	默认：10；自定义：5
	    ,cols: [[ //表头
	      {field: 'rowId', title: 'ID', width:80, sort: true, fixed: 'left'}
	      ,{field: 'roleKind', title: '角色类型', width:180, templet:'#roleKindTpl'} 
	      ,{field: 'roleName', title: '角色名称', width:180}
	      ,{field: 'roleInfo', title: '角色简介'} //此次不设置width 让其自动适应
	      ,{title: '操作', width:140, templet:'#roleBtnTpl'} 	
	    ]]
	  });
	  //监听工具条 
	  //对table里面的按钮进行绑定
	//注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
	  table.on('tool(table_role)', function(obj){ 
	    var data = obj.data; //获得当前行数据
	    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	    //var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
		//通过data将要修改的数据的主键   取出
		var rowId = data.rowId;
	    switch(layEvent){
	    case 'edit':
	    	//打开修改的表单
	    	openLayerAddOrUdateRole(role);
	    	break;
	    case 'delete':
	    	//让用户再确认一次
	    	layer.confirm('你确定要删除吗？',function(){
	    		//点击弹出的确认会触发回调函数
	    		$.ajax({
	    			type:'delete',
	    			url:'role/'+rowId,
	    			success:function(result){
	    				if(result){
	    					//重新加载表格数据 #'demo'	<table id="demo">
	    					table.reload("demo");
	    					//尝试将弹出层关闭一下
	    					layer.closeAll();//疯狂模式，关闭所有层
	    					layer.msg("已删除。");
	    				}
	    			}
	    		});
	    	});
	    	break;	
	    default:
	    	break;
	    }
	  });
	  //绑定新增 按钮
	  $('#btn_add').on('click',function(){
		//打开修改的表单
	    openLayerAddOrUdateRole(role);
	  });
	  //打开新增或者修改表单
	  function openLayerAddOrUdateRole(role){
		  //弹出层的标题
		  var titleVal = rowId==null?'角色新增':'角色修改';
		  $.ajax({
			  url:'role/goadd',
			  success:function(htmlData){
				  layer.open({
					  type:1,//1:页面层
					  title:titleVal,
					  area:'800px',//设置高度，高度自适应
					  content:htmlData,//这里content是一个DOM。注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
					  success:function(){//layer打开成功后的回调
						  //判断需要进行修改动作
						  if(rowId){
							  $.ajax({
								  type:'get',
								  url:'role/'+rowId,
								  success:function(role){
									  //给表单赋值 form_role_add_edit=<form lay-filter="form_role_add_edit">
									  form.val('form_role_add_edit',role);
									  //为了唯一性的校验，修改的时候设置一个原来的数据 
									  //$.data('old') = <input data-old='' />
									  $('#roleName').data('old',role.roleName);
									  //让form表单渲染一下。form_role_add_edit=<form lay-filter="form_role_add_edit">
									  form.render(null,'form_role_add_edit');
								  }
							  });
						  }else{//进入新增动作
							  //让form表单渲染一下。form_role_add_edit=<form lay-filter="form_role_add_edit">
							  form.render(null,'form_role_add_edit');
						  }
					  }
				  });
			  }
		  });
	  }
	  form.on('submit(btn_search)',function(data){
		  //重新渲染table数据
		  table.reload('demo',{
			  page:{
				  curr:1//重新从第1页开始
			  }
		  	  ,where:$('#form_search').serialize()//重新配置查询额外的数据
		  },'data');
		  return false;
	  });
	  
	  
	});