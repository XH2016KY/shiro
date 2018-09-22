$(function() {

	$('#nav').tree({

		url : 'http://127.0.0.1:8080/shiro-zp/easyui/tree',
		lines : true,
		animate : true,
		/*
		 * checkbox : true, onlyLeafCheck : true, dnd : false,
		 */

		onLoadSuccess : function(node, data) {
			if (data) {
				$(data).each(function(index, value) {
					if (this.state == 'closed') {
						$('#nav').tree('expandAll');
					}
				});
			}
		},

		onClick : function(node) {
			if (node.url) {
				if ($('#tabs').tabs('exists', node.text)) {
					$('#tabs').tabs('select', node.text);
				} else {
					$('#tabs').tabs('add', {
						title : node.text,
						iconCls : node.iconCls,
						closable : true,
						href : node.url,
					});
				}
			}
		}

	/*
	 * data: [{ "id": 1, "text": "系统模块", "state": "open", "iconCls": "", "url":
	 * "", "nid": 0, "children": [{ "id": 3, "text": "会员模块", "state": "open",
	 * "iconCls": "", "url": "", "nid": 1 }] }]
	 */
	/*
	 * data : [ { "id" : 1, "text" : "系统模块", "state" : "open", "iconCls" : "",
	 * "url" : "", "nid" : 0 }, { "id" : 3, "text" : "会员模块", "state" : "open",
	 * "iconCls" : "", "url" : "", "nid" : 0 } ]
	 */
	/*
	 * data : [ { "id" : 1, "text" : "系统模块", "state" : "open", "iconCls" :
	 * "icon-world", "url" : "", "nid" : 0, "children" : [ { "id" : 2, "text" :
	 * "管理员管理", "state" : "", "iconCls" : "icon-house", "url" : "", "nid" : 1,
	 * "children" : null } ] }, { "id" : 3, "text" : "会员模块", "state" : "open",
	 * "iconCls" : "icon-house", "url" : "", "nid" : 0, "children" : [ { "id" :
	 * 4, "text" : "会员管理", "state" : "", "iconCls" : "icon-house", "url" : "",
	 * "nid" : 3, "children" : null } ] } ]
	 */
	});

	$('#tabs').tabs({
		fit : true,
		border : false,
	});

});