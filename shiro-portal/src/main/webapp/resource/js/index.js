$(function(){
    // 登陆界面
	$('#login').dialog({
		title : '登陆后台',
		width : 300,
		height : 180,
		model : true,
		iconCls : 'icon-login',
		buttons : '#btn'
	});
	
	// 管理员账号验证
	$('#manager').validatebox({
		required : true,
		missingMessage : '请输入管理员账号',
		invalidMessage : '管理员账号不得为空',
	});
	
	// 管理员账号验证
	$('#manager').validatebox({
		required : true,
		missingMessage : '请输入管理员账号',
		invalidMessage : '管理员账号不得为空',
	});
	
	// 管理员密码验证
	$('#password').validatebox({
		required : true,
		validType : 'length[6,30]',
		missingMessage : '请输入管理员密码',
		invalidMessage : '管理员密码不得为空',
	});
	
	// 加载时判断验证
	if(!$('#manager').validatebox('isValid')){
		$('#manager').focus();
	} else if(!$('#password').validatebox('isValid')){
		$('#password').focus();
	}
	
	// 单击登陆
	$('#btn a').click(function(){
		if(!$('#manager').validatebox('isValid')){
			$('#manager').focus();
		} else if(!$('#password').validatebox('isValid')){
			$('#password').focus();
		}else{
			/*alert('提交中......');*/
			$.ajax({
				url : 'http://127.0.0.1:8080/shiro-zp/easyui/easyuser',
				dataType : 'json',
				type : 'post',
				
			    data : {
			    	'name' : $('#manager').val(),
			    	'password' : $('#password').val(),
			    },
			    beforeSend : function(){
			    	$.messager.progress({
			    		text : '正在登陆中......'
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
			    		$("#manager").val('')//赋值
			    		$("#password").val('')//赋值			    		
			    		$('#password').focus();
			    		alert("信息有误");
			    	}
			    }
			});
			
		}
		/*alert($('#manager').validatebox('isValid'));*/
		/*if(!$('#manager').validatebox('isValid')){
			$('#manager').focus();
		} else if(!$('#password').validatebox('isValid')){
			$('#password').focus();
		} else {
			// 服务器提交
		}*/
	});
	
	
});


