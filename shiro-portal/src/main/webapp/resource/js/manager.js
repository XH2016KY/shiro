$(function() {

	$('#manager').datagrid({

		url : 'http://127.0.0.1:8080/shiro-zp/easyui/tree',
		fit : true,
		fitColumns : true,
		striped : true,
		rownumbers : true,
		border : false,
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 30, 40, 50 ],
		pageNumber : 1,
		sortName : 'date',
		sortOrder : 'desc',
		toolbar : '#manage_tool',
		columns : [ [

		{
			field : 'id',
			title : '自动编号',
			width : 100,
			checkbox : true,
		}, {
			field : 'text',
			title : '管理员账号',
			width : 100,

		}, {
			field : 'state',
			title : '创建日期',
			width : 100,

		} ] ],
	});

	$('#manage_add').dialog({
		width : 350,
		title : '新增管理',
		modal : true,
		closed : true,
		buttons : [ {
			text : '提交',
			iconCls : 'icon-add',
			handler : function() {
				if ($('#manage_add').form('validate')) {
					 alert('提交');
					 $.ajax({
							url : 'http://127.0.0.1:8080/shiro-zp/easyui/addeasyuser',
							dataType : 'json',
							type : 'post',
							
						    data : {
						    	'name' : $('input[name="manager"]').val(),
						    	'password' : $('input[name="password"]').val(),
						    	'auth' : $('#auth').combotree('getText'),
						    },
						    beforeSend : function(){
						    	$.messager.progress({
						    		text : '正在新增中......'
						    	});
						    },
						    success : function(data,response,status){
						    	$.messager.progress('close');
						    	if(data.state=="SUCCESS"){
						    		/*alert(data.name);*/
						    		alert(data.id);
						    		$('#login').dialog('close');
						    		window.location.href = 'http://127.0.0.1:8080/shiro-zp/easyui/admin?id='+data.id;
						    		
						    	}else{
						    		$(input[name="manager"]).val('')//赋值
						    		$("#password").val('')//赋值			    		
						    		$('input[name="password"]').focus();
						    		alert("信息有误");
						    	}
						    }
						});
				}
			},
		}, {
			text : '取消',
			iconCls : 'icon-redo',
			handler : function() {
				$('#manage_add').dialog('close').form('reset');
			}
		} ],
	});

	// 管理帐号
	$('input[name="manager"]').validatebox({
		required : true,
		validType : 'length[2,20]',
		missingMessage : '请输入管理名称',
		invalidMessage : '管理名称在 2-20 位',
	});
	// 管理密码
	$('input[name="password"]').validatebox({
		required : true,
		validType : 'length[6,30]',
		missingMessage : '请输入管理密码',
		invalidMessage : '管理密码在 6-30 位',
	});

	// 分配权限
	$('#auth').combotree({
		url : 'http://127.0.0.1:8080/shiro-zp/easyui/tree',
		lines : true,
		required : true,
		lines : true,
		multiple : true,
		checkbox : true,
		onlyLeafCheck : true,
		onLoadSuccess : function(node, data) {
			if (data) {
				$(data).each(function() {
					if (this.state == 'closed') {
						$('#auth').tree('expandAll');
					}
				});
			}
		},
	});

	manager_tool = {
			add : function(){
				$('#manage_add').dialog('open');
				$('input[name = "manager"]').focus();
			},
			edit : function(){
				var rows = $('#manager').datagrid('getSelections');
				if(rows.length > 1){
					$.messager.alert('警告操作','编辑只能锁定一条数据！','Warming');
				}else if(rows.length == 0){
					$.messager.alert('警告操作','编辑至少要锁定一条数据！','Warming');
				}else{
					alert(rows[0].id);
				}
			}
	        
	}
});