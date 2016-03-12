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
</body>
<script type="text/javascript">
    var addUserBtn = true; //"#_adminUser_.btnMap.userdoadd}"== "true"?true:false;
    var updateUserBtn = true; //"#_adminUser_.btnMap.userdoupdate}"== "true"?true:false;
    var userdodel =  true;// "#_adminUser_.btnMap.userdodel}"== "true"?true:false;
    var userdopage =  true;//"#_adminUser_.btnMap.userdopage}"== "true"?true:false;
    var usersetpassword =  true;//"#_adminUser_.btnMap.usersetpassword}"== "true"?true:false;


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
                {field:'uname',title:'真实姓名',width:200},
                {field:'role',title:'角色',width:200,formatter:roleFormat},
                {field:'status',title:'状态' ,width:50,formatter:statusFormat},
                {field:'opt',title:'操作' ,width:200,formatter:optFormat}
            ]],
            toolbar: '#tb',
            loadFilter:function(data){
                var statusCode = data.statusCode;
                if(data.statusCode == normalStatusCode){
                    var obj = {};
                    obj.total = data.entity.totalPage;
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
        if(value == 1) {
            return "启用";
        }else if(value == 2) {
            return "锁定";
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
        $('#w').window('close');
    }
    function addFn(){
        saveType = "add";
        $("#ff").form("reset");
        $('#adminuser_w').window('open').panel('setTitle',"增加管理员");
    }
    function optFormat(v,row,index){
        var btns = [];
        if(updateUserBtn){
            //btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="updateFn(\''+row['id']+'\')" href="#" plain="true" iconCls="update_btn"><span class="l-btn-left"><span class="l-btn-text update_btn l-btn-icon-left">修改</span></span></a>');
        }
        if(userdodel){
            btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="cancleManagerFn(\''+row['id']+'\')" href="#" plain="true" iconCls="del_btn"><span class="l-btn-left"><span class="l-btn-text del_btn l-btn-icon-left">取消管理员</span></span></a>');
        }
        if(usersetpassword){
          //  btns.push('<a class="easyui-linkbutton l-btn l-btn-plain" onclick="passwordRest(\''+row['id']+'\')" href="#" plain="true" iconCls="lock"><span class="l-btn-left"><span class="l-btn-text lock l-btn-icon-left">密码初始化</span></span></a>');
        }
        return btns.join("&nbsp;");
    }
    function roleFormat(v,row,index){
        if(!v)return "";
        return v.name;
    }
    function updateFn(id){
        $("#ff").form("reset");
        updateRowIndex = -1;
        saveType = "update";
        var rows = $("#dg").datagrid("getRows");
        var row = null;
        for(var i=0;i<rows.length;i++){
            if(rows[i]['id'] == id){
                row = rows[i];
                break;
            }
        }
        var rowIndex = 	$('#dg').datagrid("getRowIndex",row);
        updateRowIndex = rowIndex;



        $("#id").val(row['id']);
        $("#name").val(row['name']);
        $("#realName").val(row['realName']);


        $('#name').validatebox("validate");
        $('#realName').validatebox("validate");

        $('#status').combobox('setValue', row['status']);
        if(row['role']){
            var role = row['role'];
            var roleID =role.id;
            var roleName = role.name;
            $('#roleid').combogrid('setValue', roleID);
            $('#roleid').combogrid('setText', roleName);
        }

        $('#adminuser_w').window('open').panel('setTitle',"修改管理员") ;
        $('#adminuser_w').window('center');



    }
    function closeWinFn(){
        $('#adminuser_w').window('close');
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
    function insertIntoDb(saveObj){
        var url =  "${rc.contextPath}/admin/user/doadd";
        $.ajax({
            type:'post',
            url: url,
            context: document.body,
            data:saveObj,
            success:function(json){
                //json = $.parseJSON(json);
                json = json.entity;
                $('#dg').datagrid('appendRow',json);
                $.messager.alert('系统提示','保存成功!','info',closeWinFn);
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
    function updateIntoDb(saveObj){
        var url =  "${rc.contextPath}/admin/user/doupdate";
        $.ajax({
            type:'post',
            url: url,
            context: document.body,
            data:saveObj,
            success:function(json){
                //json = $.parseJSON(json);
                json = json.entity;
                $('#dg').datagrid('updateRow',{
                    index:updateRowIndex,
                    row:json
                });
                $('#dg').datagrid('selectRow',updateRowIndex);
                $.messager.alert('系统提示','保存成功!','info',closeWinFn);

            },
            error:function(xhr,textStatus,errorThrown){

                var responseText = xhr.responseText;
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
    var initPassword = "111111";
    function passwordRest(id){
        var url = "${rc.contextPath}/admin/user/setpassword";
        $.ajax({
            type:'get',
            url: url,
            context: document.body,
            data:{
                d:new Date().getTime(),
                id:id  ,
                password:initPassword
            },
            success:function(json){
                // json = eval("("+json+")");

                var success = json['result'];
                if(success){
                    $.messager.alert('系统提示','密码重置成功!新密码为'+initPassword,'info',function(){ });
                }else{
                    $.messager.alert('系统提示','密码重置失败，请刷新后重试!','error');
                }


            },
            error:function(xhr,textStatus,errorThrown){
                var responseText = xhr.responseText;
                $.messager.alert('系统提示','密码重置失败，请刷新后重试!','error');

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
                $.messager.alert('系统提示','密码重置失败，请刷新后重试!','error');

            }
        });

    }

</script>
</html>