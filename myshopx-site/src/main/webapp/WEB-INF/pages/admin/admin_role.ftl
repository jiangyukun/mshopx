
 <!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理信息</title>
<#include "../common/easyui-html5.ftl"/>
</head>
<body class="easyui-layout">
	 <div data-options="region:'center'">
		<table id="dg"></table>
	</div>
	<!-- 工具条  -->
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<table width="100%">
			<tr width="100%">
				<td width="50%">
					角色名称: <input class="easyui-textbox" style="line-height:12px; width:200px" id="role_Name"/>
					<!--
					状态:<select class="easyui-combobox" data-options="editable:false,panelHeight:'auto'" style="width:100px" id="role_status">
						<option value="0">不限</option>
						<option value="1">有效</option>
						<option value="2">待审核</option>
						<option value="3">锁定</option>
					</select> -->
					<a href="#"  class="easyui-linkbutton" iconCls="icon-search" onclick="searchFn()">查询</a>
				</td>
				<td align="right" width="50%">
					<a id="addBtn" href="#" class="easyui-linkbutton" iconCls="add_btn" plain="true" onclick="addFn()">增加</a>
				</td>
			</tr>
		</table>
		</div>
	</div>
	<!-- 弹出窗口  -->
	<div id="w" class="easyui-window"
		data-options="modal:true,closed:true,iconCls:'icon-save',
		collapsible:false,minimizable:false,maximizable:false,resizable:false"
			style="width:500px;height:420px;padding:10px;">
			<div class="easyui-layout" data-options="fit:true">
				<form id="role_form">
					<div data-options="region:'center',border:false" style="padding:10px;">
						<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
							<div title="基本信息" style="padding:10px">
								<table>
									<tr style="display: none;">
						    			<td>角色id:</td>
						    			<td><input  type="text" id="form_role_id" ></input></td>
						    		</tr>
						    		<tr style="display: none;">
						    			<td>角色状态:</td>
						    			<td><input  type="text" id="form_role_status" name="status"></input></td>
						    		</tr>
						    		<tr>
						    			<td>角色名称:</td>
						    			<td><input class="easyui-validatebox" type="text" id="form_role_name" data-options="prompt:'请输入角色名称.',required:true,validType:'length[2,10]'"></input></td>
						    		</tr>
						    	</table>
							</div>
							<div title="资源授权" style="padding:10px">
								 <ul id='tt' class="easyui-tree" data-options="url:  '${rc.contextPath}/admin/menu/list?d='+new Date().getTime(),loadFilter:function (data){
                                                              if(data.statusCode == normalStatusCode){
            								                     return makeTreeData( data.entity,true);
            								                 } else {
                                              				          return makeTreeData( [],true);
                                              				 }

								 },method:'get',animate:true,checkbox:true,cascadeCheck:true"></ul>
							</div>
						</div>
					</div>

					<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
						<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:submitForm()">保存</a>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:closeWinFn()">取消</a>
					</div>
				</form>
			</div>
	</div>
<script type="text/javascript">
var roledoadd =   authIds.indexOf(",admin_role_doadd,")>=0?true:false;
var roledoupdate =  authIds.indexOf(",admin_role_doupdate,")>=0?true:false;
var roledodel =  authIds.indexOf(",admin_role_dodel,")>=0?true:false;
var roledopage =  authIds.indexOf(",admin_role_dopager,")>=0?true:false;
var rolesetstatus =   authIds.indexOf(",admin_role_dodel,")>=0?true:false;

var saveType="add";
		$(function(){
			if(!roledoadd){
				$("#addBtn").hide();
			}
			$('#dg').datagrid({
			 	border:false,
				rownumbers:true,
				checkOnSelect:true,
				fitColumns:true,
				pagination:true,
				singleSelect:true,
				fit:true,
				pageSize:20,
				method:'get',
			  	url:'${rc.contextPath}/admin/role/dopage?d='+new Date().getTime(),
			  	queryParams:{ },
			  	onBeforeLoad:function(param){
                    if(!roledopage){
                        $.messager.alert('系统提示','您没有权限访问!','info');
                        return;
                    }
					param['pageno'] =  param['page']-1;
					param['pagesize']  = param['rows'];
			  		return true ;
			  	},
			  	onDblClickRow:function(rowIndex, rowData){
			  			//updateRowIndex = rowIndex;
						//getRoleInfoById(rowData['roleId']);
			  	},
			  	onLoadError:function(){
			  	},

				columns:[[
					{field:'id',title:'id'},
					{field:'name',title:'角色名' ,width:100},

					{field:'status',title:'状态',width:100,formatter:function(value,row,index){
						if(value == 'NORMAL'){
							return "有效";
						}else  if(value == 'DEL'){
							return "删除";
						}
					}},
					{field:'opt',title:'操作' ,width:100,formatter:optFormat}
				]],
				toolbar: '#tb',
				loadFilter:function(data){
				   if(data.statusCode == normalStatusCode){
                        	var obj = {};
                            obj.total =  data.entity.totalRows;
                            obj.rows = $.isArray(data.entity.pageData)?data.entity.pageData:[];
                            return obj;
				   }else {
				            var obj = {};
                           obj.total = 0;
                            obj.rows = [];
                            return obj;
				   }

				}
			});

			var pager = $('#dg').datagrid("getPager");
			pager.pagination({
				'onBeforeRefresh':function(){
					searchFn();
					return false;
				}
			});
		});

		function searchFn(){
			if(!roledopage){
				 $.messager.alert('系统提示','您没有权限访问!','info');
				return;
			}
			var role_Name = $("#role_Name").val();
			//var role_status = $('#role_status').combobox('getValue');
			$('#dg').datagrid('load',{
					//status:role_status,
					name:role_Name,
					d:new Date().getTime()
			});

		}
		var resource_dg_loadSuccess = false;
		var updateRowIndex = -1;
		function addFn(){
			  saveType = "add";
			  $("#form_role_name").val("");
			  $('#tt').tree("reload");
			  $('#w').window('open').panel('setTitle',"增加角色");
			  var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);
		   		for(var i=0;i<nodes.length;i++){
		   			var node = nodes[i];
		   			if(node  && $('#tt').tree("isLeaf",node.target)){
		   				$('#tt').tree('uncheck',node.target);
		   			}
		   		}
		}
		function delFn(id){
			$.messager.confirm('系统提示', '您确定要删除该条记录吗?', function(r){
			if (r){
					var url = "${rc.contextPath}/admin/role/setstatus";
		  	 		$.ajax({
			  	  	  type:'post',
					  url: url,
					  context: document.body,
					  data:{
					  	ids: id,
					  	state:"DEL"
					  },
					  success:function(data){

					  	if(data.statusCode == normalStatusCode){
							var row = null;
							var rows = $("#dg").datagrid("getRows");
							for(var i=0;i<rows.length;i++){
								if(rows[i]['id'] == id){
									row = rows[i];
									var rowIndex = 	$('#dg').datagrid("getRowIndex",row);
									$('#dg').datagrid("deleteRow",rowIndex);
									break;
								}
							}
					  		$.messager.alert('系统提示','删除成功!','info');

					  	}else{
					  		$.messager.alert('系统提示','删除失败，请刷新后重试!','error');
					  	}
					  },
					  error:function(xhr,textStatus,errorThrown){
					  	var responseText = xhr.responseText;
					  	$.messager.alert('系统提示','删除失败，请刷新后重试!','error');

					  }
				});

				}
			});
		}
		function optFormat (value,row,index){
			var btns = [];
			if(roledoupdate){
				btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="updateFn(\''+row['id']+'\')" href="#" plain="true" iconCls="update_btn"><span class="l-btn-left"><span class="l-btn-text update_btn l-btn-icon-left">修改</span></span></a>');
			}
			if(rolesetstatus){
				btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="delFn(\''+row['id']+'\')" href="#" plain="true" iconCls="del_btn"><span class="l-btn-left"><span class="l-btn-text del_btn l-btn-icon-left">删除</span></span></a>');
			}
			return btns.join("&nbsp;");
		}
		function updateFn(id){
			updateRowIndex = -1;
			var rows = $("#dg").datagrid("getRows");
			var row = null;
			for(var i=0;i<rows.length;i++){
				if(rows[i]['id'] == id){
					row = rows[i];
					break;
				}
			}

			var rowIndex =  $('#dg').datagrid("getRowIndex",row);
			 updateRowIndex = rowIndex;
//			 getRoleInfoById(row['id']);
            showUpdateWin(row);
		}

		function submitForm(){
			 var isValidate = $('#role_form').form('validate');
			 if(!isValidate){
			 	$.messager.alert('系统提示','请确保填写正确!','warning');
			 	return;
			 }

			var form_role_name = $.trim($("#form_role_name").val());
			var selections = $('#tt').tree('getChecked',['checked','indeterminate']);

			if(form_role_name.length ==0 ){
				$.messager.alert('系统提示','角色名称不能为空!','warning');
				return;
			}

			var ids = [];
			for(var i=0;i<selections.length;i++){
				ids.push(selections[i]["id"]);
			}

			if(saveType == 'add'){
				addRoleInDB(form_role_name,ids.join(","));
			}else if(saveType == 'update'){
			 	var roleId = $("#form_role_id").val();
			 	var rolestatus = $("#form_role_status").val();
			 	updateRoleInDB(roleId,form_role_name,ids.join(","),rolestatus);
			}
		}

		function closeWinFn(){
			$('#w').window('close');
		}

		function addRoleInDB(roleName,authoritiesIds){
			var url =  "${rc.contextPath}/admin/role/doadd";
		  	 $.ajax({
		  	  	  type:'post',
				  url: url,
				  context: document.body,
				  beforeSend:function(){
					  	jQuery.showMask($("#w")[0],"正在保存中 ....");
				},
				  data:{
				  	name:roleName,
				  	state:'NORMAL',
				  	menuIds: authoritiesIds
				  },
				  success:function(data){
					  jQuery.hideMask($("#w")[0]);
				   	//	json = $.parseJSON(json);
				   	if(data.statusCode == normalStatusCode){
				   	                     //$('#dg').datagrid('appendRow',data.entity);
										 $('#dg').datagrid('reload');
                    				 	 $.messager.alert('系统提示','保存成功!','info',closeWinFn);
				   	}else{
                        $.messager.alert('系统提示','保存失败!','info');
				   	}


				  },
				  error:function(xhr,textStatus,errorThrown){
					  jQuery.hideMask($("#w")[0]);
				  		var responseText = xhr.responseText;
				    	$.messager.alert('系统提示','保存失败，请刷新后重试!','error');

				  }
			});
		}
		function updateRoleInDB(roleId,roleName,authoritiesIds,rolestatus){
			var url = "${rc.contextPath}/admin/role/doupdate";
		  	 $.ajax({
		  	  	  type:'post',
				  url: url,
				  context: document.body,
				  beforeSend:function(){
					  	jQuery.showMask($("#w")[0],"正在保存中 ....");
				},
				  data:{
				  	id:roleId,
				  	name:roleName,
				  	state:rolestatus,
				  	menuIds: authoritiesIds
				  },
				  success:function(data){
					  jQuery.hideMask($("#w")[0]);
				  	 	if(data.statusCode == normalStatusCode){
//                                         $('#dg').datagrid('updateRow',{
//                                        				  	 	index:updateRowIndex,
//                                        				  	 	row:data.entity
//                                         });
//                                          $('#dg').datagrid('selectRow',updateRowIndex);
                            			$('#dg').datagrid('reload');
                                        closeWinFn();

                                         $.messager.alert('系统提示','保存成功!','info');
                    }else{
                         $.messager.alert('系统提示','保存失败!','info');
                    }


				  },
				  error:function(xhr,textStatus,errorThrown){
					  jQuery.hideMask($("#w")[0]);
				  	var responseText = xhr.responseText;
				  	$.messager.alert('系统提示','保存失败，请刷新后重试!','error');

				  }
				});

		}

		function getRoleInfoById(roldId){
			var url =  "${rc.contextPath}/admin/role/get?d="+new Date().getTime();
		  	 $.ajax({
			  url: url,
			  context: document.body,
			  data:{
			  	 id:roldId
			  },
			  success:function(data){
			 	// var json_str = JSON2.stringify(data);
			 	if(!data){
			 		$.messager.alert('系统提示','获取数据失败，请刷新后重试!','error');
			 		return;
			 	}else {
			 	    if(data.statusCode != normalStatusCode){
                            $.messager.alert('系统提示','获取数据失败，请刷新后重试!','error');
			 		    return;
			 	    }
			 	}
			 	//json = jQuery.parseJSON(json)
			  	 showUpdateWin(data.entity);

			  },
			  error:function(xhr,textStatus,errorThrown){
			  	var responseText = xhr.responseText;
			  	$.messager.alert('系统提示','获取数据失败，请刷新后重试!','error');

			  }
			});
		}
		function showUpdateWin(role){
			saveType = "update";
			//$('#tt').tree("reload");
			$('#w').window('open').panel('setTitle',"修改角色");
			$("#form_role_name").val(role["name"]);
            $("#form_role_name").validatebox("validate");
			$("#form_role_id").val(role["id"]);
			$("#form_role_status").val(role["state"]);

		   	var nodes = $('#tt').tree('getChecked', ['checked','indeterminate']);

		   		for(var i=0;i<nodes.length;i++){
		   			var node = nodes[i];
		   			if(node  && $('#tt').tree("isLeaf",node.target)){
		   				$('#tt').tree('uncheck',node.target);
		   			}
		   		}

		   		var menus = role["menus"];

		   		for(var i=0,l=menus.length;i<l;i++){
		   			var treeId = menus[i]['id'];
		   			var treeNode =  $('#tt').tree('find', treeId);

		   			if(treeNode  && $('#tt').tree("isLeaf",treeNode.target)){
		   				$('#tt').tree('check', treeNode.target);
		   			}
		   		}
		}
function makeTreeData(menus,usecheck){

	if(menus.length==0)return menus;
 	 var mapdata = {};
	  //第一次组织树节点内容
	  for(var i=0;i<menus.length;i++)
	  {
	      var node = menus[i];
	      var menuname = node['name'];
	      var pid = node['parentId'];
	      var aid = node['id'] ;
	      var path = node['url'];
	      var isbutton = node['button'];
	      var authorityId = node["authorityId"];
			var obj = {
	    		  id:aid,
	    		  text:menuname,
	    		 // "iconCls":isbutton!=1?"tree-file":"icon-add",
	    		  attributes:{
	    		  	path:path,
	    		  	isbutton:isbutton,
	    		  	authorityId:authorityId,
	    		  	pid:pid
	    		  }

	    		};
	    		if(isbutton==1){
	    			obj['iconCls'] = 'icon-add';
	    		}
	      mapdata["id_"+aid]= obj;
	     if(usecheck)
		 {
		 	mapdata["id_"+aid]['checked']=false;
		 }

	  }
  var ret = [];
  for(var key in mapdata)
  {
      var node = mapdata[key];
      var pid = mapdata[key]['attributes']['pid'];
      if(mapdata["id_"+pid])
      {
          if(typeof mapdata["id_"+pid]['children'] == 'undefined')
          {
              mapdata["id_"+pid]['children'] = [];
          }
          mapdata["id_"+pid]['children'].push(mapdata[key]);
      }else
      {
          ret.push(mapdata[key]);
      }
  }
  return ret;
}

	</script>
</body>
</html>