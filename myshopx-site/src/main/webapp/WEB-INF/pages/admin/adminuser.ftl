<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员管理 </title>
<#include "../common/easyui-html5.ftl"/>
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
    <table id="dg"></table>
</div>
<div id="tb" style="padding:5px;height:auto">
    <table width="100%">
        <tr width="100%">
            <td width="50%">
                QQ: <input class="easyui-textbox" style="width:160px" id="s_qq"/>
                姓名: <input class="easyui-textbox" style="width:160px" id="s_name"/>
                <a href="#"  class="easyui-linkbutton" iconCls="icon-search" onclick="searchFn()">查看</a>
            </td>
            <td align="right" width="50%">
                <a href="#"  class="easyui-linkbutton" id="addBtn"  data-options="iconCls:'add_btn',plain:true" onclick="addFn()">增加</a>
            </td>
        </tr>
    </table>
</div>
<div id="adminuser_w" class="easyui-window" title="系统管理员" data-options="modal:true,closed:true,iconCls:'icon-save',
		collapsible:false,minimizable:false,maximizable:false,resizable:false"
           style="width:600px;height:420px;padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" id="content_layout" >
            <form id="ff" method="post">
                <table>

                    <tr>
                        <td>qq:</td>
                        <td>
                            <input style="width:300px;height: 22px;" class="easyui-validatebox" type="text" id="qq" name="qq" data-options="required:true"></input>
                            <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchUser()">查询</a>
                        </td>
                    </tr>
                    <tr>
                        <td>查询结果:</td>
                        <td>
                            <input style="width:300px;height: 22px;" id="userInfo" name="userInfo" class="easyui-textbox" data-options="editable:false"  ></input>
                        </td>
                    </tr>
                    <tr>
                        <td>ID:</td>
                        <td>
                            <input style="width:300px;height: 22px;" id="userId" name="userId" class="easyui-textbox" data-options="editable:false"  ></input>
                        </td>
                    </tr>

                </table>
            </form>
        </div>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:submitFormFn()">保存</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:closeWinFn()">取消</a>
        </div>
    </div>
</div>

<div id="setrole_w" class="easyui-window" title="设置用户角色" data-options="modal:true,closed:true,iconCls:'icon-save',
		collapsible:false,minimizable:false,maximizable:false,resizable:false"
     style="width:600px;height:420px;padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'center',border:false" id="content_layout" >
            <div  class="easyui-layout" data-options="fit:true">
                <div data-options="region:'center',title:'可选角色'" style="background:#eee;">
                    <table id="role_dg"></table>
                    <input type="hidden" id="user_id"/>
                </div>
                <div id="have_sel_div" data-options="region:'south',title:'已选角色'" style="height:100px;"></div>
            </div>
        </div>
        <div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)" onclick="javascript:saveFormFn()">保存</a>
            <a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="javascript:cancleRole()">取消</a>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    var addUserBtn =   authIds.indexOf(",admin_adminuser_doadd,")>=0?true:false;
    var userdodel =   authIds.indexOf(",admin_adminuser_dodel,")>=0?true:false;
    var userdopage =  authIds.indexOf(",admin_adminuser_dopager,")>=0?true:false;
    var setUserRoleBtn =  authIds.indexOf(",admin_adminuser_setroles,")>=0?true:false;


    $(function(){
        if(!addUserBtn){
            $("#addBtn").hide();
        }
        $('#dg').datagrid({
            border:false,
            rownumbers:true,
            checkOnSelect:true,
            fitColumns:true,
            pagination:true,
            fit:true,
            pageSize:20,
            singleSelect:true,
            method:'get',
            url:'${rc.contextPath}/admin/adminuser/dopager?d='+new Date().getTime(),
            queryParams:{ },
            onBeforeLoad:function(param){
                if(!userdopage){
                    return false;
                }
                param['pageno'] =  param['page']-1;
                param['pagesize']  = param['rows'];

                return true ;
            },
            onDblClickRow:function(rowIndex, rowData){
                //updateRowIndex = rowIndex;
                //getRoleInfoById(rowData['roleId']);
            },
            columns:[[
                {field:'id',title:'id'},
                {field:'qq',title:'qq' ,width:100},
                {field:'uname',title:'姓名',width:200},
                {field:'roleList',title:'角色',width:200,formatter:roleFormat},
                {field:'status',title:'状态' ,width:50,formatter:statusFormat},
                {field:'opt',title:'操作' ,width:200,formatter:optFormat}
            ]],
            toolbar: '#tb',
            loadFilter:function(data){
                var statusCode = data.statusCode;
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
                return true;
            }
        });
    });
    function statusFormat(value,row,index){
        if(value == 'NORMAL') {
            return "启用";
        }
        return "";
    }
    function searchFn(){
        if(!userdopage){
            $.messager.alert('系统提示','您没有权限访问!','info');
            return;
        }
        var s_qq = $("#s_qq").val();
        var s_name = $("#s_name").val();
        $('#dg').datagrid('load',{
            uname:s_name,
            qq:s_qq,
            d:new Date().getTime()
        });
    }
    var saveType = "add";
    function closeWinFn(){
        $('#adminuser_w').window('close');
    }
    function addFn(){
        saveType = "add";
        $("#ff").form("reset");
        $('#adminuser_w').window('open').panel('setTitle',"增加管理员");
    }
    function optFormat(v,row,index){
        var btns = [];

        if(userdodel){
            btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="cancleManagerFn(\''+row['id']+'\')" href="#" plain="true" iconCls="del_btn"><span class="l-btn-left"><span class="l-btn-text del_btn l-btn-icon-left">取消管理员</span></span></a>');
        }
        if(setUserRoleBtn){
            btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="setUserRole(\''+row['id']+'\')" href="#" plain="true" iconCls="set_btn"><span class="l-btn-left"><span class="l-btn-text set_btn l-btn-icon-left">设置用户角色</span></span></a>');
        }
        return btns.join("&nbsp;");
    }
    function roleFormat(v,row,index){

        if(!v || v.length == 0)return "";
        var roleNames = [];
        for(var i=0;i< v.length;i++){
            roleNames.push(v[i]['name']);
        }
        return roleNames.join(",");
    }
    function cancleManagerFn(id){
        var rows = $("#dg").datagrid("getRows");
        var row = null;
        for(var i=0;i<rows.length;i++){
            if(rows[i]['id'] == id){
                row = rows[i];
                break;
            }
        }
        var delRowIndex = 	$('#dg').datagrid("getRowIndex",row);
        $.messager.confirm('系统提示', '您确定要删除该管理员吗?', function(r){
            if (r){
                var url = "${rc.contextPath}/admin/adminuser/cancleadmin";
                $.ajax({
                    type:'post',
                    url: url,
                    data:{
                        id:id,
                        d:new Date().getTime()
                    },
                    context: document.body,
                    success:function(json){
                        $('#dg').datagrid("deleteRow",delRowIndex);
                        $('#dg').datagrid('acceptChanges');
                        $.messager.alert('系统提示','操作成功!','info',closeWinFn);

                    },
                    error:function(xhr,textStatus,errorThrown){
                        var responseText = xhr.responseText;
                        $.messager.alert('系统提示','操作失败，请刷新后重试!','error');

                    }
                });
            }}
        );
    }
    function submitFormFn(){
       var userId = $("#userId").textbox('getValue');
        var url =  "${rc.contextPath}/admin/adminuser/setadmin";
        $.ajax({
            type:'post',
            url: url,
            context: document.body,
            data:{id:userId},
            success:function(data){
                //json = $.parseJSON(json);
                var statusCode = data.statusCode;
                if(normalStatusCode == statusCode){
                    $('#dg').datagrid('reload');
                    $.messager.alert('系统提示','保存成功!','info',closeWinFn);
                }else {
                    $.messager.alert('系统提示','保存失败，请刷新后重试!','error');
                }
            },
            error:function(xhr,textStatus,errorThrown){
                var responseText = xhr.responseText;

                var obj = jQuery.parseJSON(responseText);

                json = $.parseJSON(responseText);
                var  errortype = json.errortype;
                if(errortype){
                    $.messager.alert('系统提示','保存失败,'+json.msg,'error');
                }else{
                    $.messager.alert('系统提示','保存失败，请刷新后重试!','error');
                }
            }
        });
    }

    /***/
    function searchUser(){
        var qq = $("#qq").val();
        if(qq.length == 0){
            $('#userInfo').textbox('setText',"请输入QQ号");
            $("#userId").textbox('setText',"");
            return;
        }
        var url = "${rc.contextPath}/admin/adminuser/getbyqq";
        $.ajax({
            type:'get',
            url: url,
            context: document.body,
            data:{
                d:new Date().getTime(),
                qq:qq
            },
            beforeSend:function(){
                $('#userInfo').textbox('setText',"查询中。。。");
                $("#userId").textbox('setText',"");
            },
            success:function(data){
                // json = eval("("+json+")");
                var statusCode = data.statusCode;
                if(normalStatusCode == statusCode   ){
                    var user = data.entity;
                    if(user){
                        $('#userInfo').textbox('setValue',"查询到用户");
                        $("#userId").textbox('setValue',user.id);
                    }else{
                        $('#userInfo').textbox('setValue',"未查询到用户");
                        $("#userId").textbox('setValue',"");
                    }
                }else {
                    $('#userInfo').textbox('setValue',"没有查到用户");
                    $("#userId").textbox('setValue',"");
                }
            },
            error:function(xhr,textStatus,errorThrown){
                var responseText = xhr.responseText;
                $.messager.alert('系统提示','查到失败，请刷新后重试!','error');

            }
        });
    }
    function setUserRole(id){
        var rows = $("#dg").datagrid("getRows");
        var row = null;
        for(var i=0;i<rows.length;i++){
            if(rows[i]['id'] == id){
                row = rows[i];
                break;
            }
        }
        $('#setrole_w').window('open').panel('setTitle',"设置用户角色") ;
        $('#setrole_w').window('center');
        $("#user_id").val(row["id"]);
        initRoleGrid();
        initHaveSelectedUserRoles(row);
    }
    function initRoleGrid(){
        $('#role_dg').datagrid({
            border:false,
            rownumbers:true,
            checkOnSelect:true,
            fitColumns:true,
            pagination:true,
            singleSelect:true,
            fit:true,
            pageSize:20,
            method:'get',
            url:'${rc.contextPath}/admin/adminuser/canselroles?d='+new Date().getTime(),
            queryParams:{ },
            onBeforeLoad:function(param){
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
                {field:'opt',title:'操作' ,width:200,formatter:function optFormat(v,row,index){
                    var btns = [];
                      btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="addUserRole(\''+row['id']+'\')" href="#" plain="true" iconCls="add_btn"><span class="l-btn-left"><span class="l-btn-text add_btn l-btn-icon-left">增加</span></span></a>');
                      btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="delUserRole(\''+row['id']+'\')" href="#" plain="true" iconCls="del_btn"><span class="l-btn-left"><span class="l-btn-text del_btn l-btn-icon-left">删除</span></span></a>');

                    return btns.join("&nbsp;");
                }}
            ]],
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
    }
    var haveSelRoles = [];
    function addUserRole(id){
        var rows = $("#role_dg").datagrid("getRows");
        var row = null;
        for(var i=0;i<rows.length;i++){
            if(rows[i]['id'] == id){
                row = rows[i];
                break;
            }
        }
        var roleId = row['id'];
        var roleName = row['name'];
        haveSelRoles.push({id:roleId,name:roleName});
        showRoleButns(haveSelRoles);
    }
    function delUserRole(id){
        var newhaveSelRoles = [];
        for(var i=haveSelRoles.length-1;i>=0;i--){
            if(haveSelRoles[i]['id'] != id){
                newhaveSelRoles.push(haveSelRoles[i]);
            }
        }
        haveSelRoles = newhaveSelRoles;
        newhaveSelRoles = null;
        showRoleButns(haveSelRoles);
    }
    function showRoleButns(roles){

        $("#have_sel_div").empty();
        if(!roles || roles.length == 0){
            return;
        }
        var ids = [];
        for(var i=0;i<roles.length;i++ ){
            if((";"+ids.join(";")+";").indexOf(";"+roles[i]['id']+";")>=0){
                continue;
            }
            if(i>0){
                $("#have_sel_div").append(';');
            }
            $("#have_sel_div").append('<a   href="#" class="easyui-linkbutton"  >'+roles[i].name+'</a>');
            ids.push(roles[i]['id']);
        }
    }
    function cancleRole(){
        $('#setrole_w').window('close');
    }
    function saveFormFn(){

        var userId = $("#user_id").val();
        var roles = [];
        for(var i=0;i<haveSelRoles.length;i++ ){
            roles.push(haveSelRoles[i]['id']);
        }
        roles = roles.join(",");
        var url = "${rc.contextPath}/admin/adminuser/setroles";
        $.ajax({
            type:'post',
            url: url,
            context: document.body,
            data:{
                d:new Date().getTime(),
                userId:userId,
                roles:roles
            },
            beforeSend:function(){
                jQuery.showMask($("#setrole_w")[0],"正在保存中 ....");
            },
            success:function(data){
                jQuery.hideMask($("#setrole_w")[0]);
                var statusCode = data.statusCode;
                if(normalStatusCode == statusCode   ){
                    $('#dg').datagrid('reload');
                    $.messager.alert('系统提示','保存成功!','info',cancleRole);
                }else {
                    $.messager.alert('系统提示','保存失败!','warning');
                }
            },
            error:function(xhr,textStatus,errorThrown){
                var responseText = xhr.responseText;
                jQuery.hideMask($("#setrole_w")[0]);
                $.messager.alert('系统提示','设置失败，请刷新后重试!','error');

            }
        });
    }
    function initHaveSelectedUserRoles(row){
        var roleList = row['roleList'];
        if(!roleList || roleList.length == 0){
            haveSelRoles = [];
        }else{
            for(var i=0;i<roleList.length;i++){
                haveSelRoles.push({id:roleList[i]['id'],name:roleList[i]['name']})
            }

        }
        showRoleButns(haveSelRoles);
    }

</script>
</html>