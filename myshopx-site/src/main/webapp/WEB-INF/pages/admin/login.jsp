<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page import="com.gxkj.common.utils.SystemGlobals,java.util.*"%>
 <!DOCTYPE html>
<html lang="en">
<head><%-- 
<jsp:include page="../common/bootstrap.jsp"   >
	<jsp:param name="title" value="登陆页面"/>
</jsp:include>--%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- The styles -->
	<link id="bs-css" href="${pageContext.request.contextPath}/resources/charisma/css/bootstrap-cerulean.css" rel="stylesheet">
	<link id="bs-css" href="${pageContext.request.contextPath}/resources/charisma/css/bootstrap-responsive.css" rel="stylesheet">
	<link id="bs-css" href="${pageContext.request.contextPath}/resources/charisma/css/charisma-app.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-1.11.2.min.js"> </script>
	<script type="text/javascript">if(window.top != window){
			window.top.location = window.location;
		
		}</script>
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  
	  .llwidth{
	  	width:200px;
	  }
	  .yzwidth{
	  	width:110px;
	  }
	</style>
	<script type="text/javascript">
	function refreshYanZhengMa(obj) {  $(obj).attr("src","<%=request.getContextPath()%>/yanzhengma?"+Math.random());  }
  function loginfn(btn){
  
  	var QQ = $("#QQ").val();
  	var url = "<%=request.getContextPath()%>/admin/dologin";
	$.ajax({
			  type:'post',
			  url: url,
			  context: document.body,
			  beforeSend:function(){
			  		 $(btn).attr('disabled',true);
			  		 $(btn).text('正在登陆');
				 },
			  data:{
				  qq: QQ,d:new Date().getTime()
			  },
			  success:function(json){
				 
			  		//json = jQuery.parseJSON(json);
				 	 var result = json["result"];
				 	 if(result){
				 	 	window.location = "${pageContext.request.contextPath}/admin/index";
				 	 }else{
				 	 	 var user = json.entity;
				 	 	 var  msg  = json.msg;

				 	 	 	alert(msg);

				 	 	  $(btn).attr('disabled',false);
						 	 $(btn).text('登陆');
				 	 	 
				 	 }
				 	
				 	  
			  },
		      error:function(xhr,textStatus,errorThrown){
		  		var responseText = xhr.responseText;
		  		$(btn).attr('disabled',false);
			 	 $(btn).text('登陆');
		  		// $(btn)).removeAttr("disabled");
		  } 
  })
 }
  </script>
  </head>

  <body>

     <div class="container-fluid" >
		<div class="row-fluid">
			<div class="row-fluid">
				<div class="span12 center login-header" style="height:100px;">
					<h2>测试系统</h2>
				</div><!--/span-->
			</div><!--/row-->
			<div class="row-fluid">
				<div class="well span5 center login-box"   >

					<form class="form-horizontal" action="" method="post">
						<fieldset>
						
							<div class="clearfix"></div>
							<div class="input-prepend" title="QQ" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large llwidth" name="QQ" id="QQ" type="text" value="" />
							</div>
							<div class="clearfix"></div>
							<p class="center span5">
								<button type="button" class="btn btn-primary"   onclick="loginfn(this);">登陆</button>
							</p>
						</fieldset>
					</form>
				</div><!--/span-->
			</div><!--/row-->
				</div><!--/fluid-row-->
		
	</div><!--/.fluid-container-->
  </body>
</html>
