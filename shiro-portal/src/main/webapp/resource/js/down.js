$(function(){
	
	/** 点击鼠标事件*/
	$("#mybut").on("mouseover",function(){
		$(".dropdown-toggle").dropdown("toggle");
	});
	
	/** 离开鼠标事件*/
	$("#mybut").onclick(function(){
		$(".dropdown-toggle").dropdown("toggle");
	});
	
});