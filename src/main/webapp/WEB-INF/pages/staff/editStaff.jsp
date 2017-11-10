<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>

	<script>
        // 创建异步对象
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();//大多数浏览器
            } catch (e) {
                try {
                    return ActvieXObject("Msxml2.XMLHTTP");//IE6.0
                } catch (e) {
                    try {
                        return ActvieXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
                    } catch (e) {
                        alert("哥们儿，您用的是什么浏览器啊？");
                        throw e;
                    }
                }
            }
        }

			function showPost(obj) {
				// 1. 获取选中部门
				var depId = obj.value;

				// 2. ajax
				var xmlHttp = createXMLHttpRequest();
				var url = "<c:url value="/postAction_findAllWithDepartment.action?department.depId="/>" + depId;
//				alert(url);
				xmlHttp.open("GET",url, true);
				xmlHttp.send(null);

				xmlHttp.onreadystatechange = function () {
					if (xmlHttp.status == 200 && xmlHttp.readyState == 4){
					    // 获取返回的 json 数据
						var jsonData = eval("("+xmlHttp.responseText+")");
						// 显示到 select 的 option 中
						var selectE = document.getElementById("postSelect");
						while (selectE.firstChild){
                            selectE.removeChild(selectE.firstChild);
						}
						for (var i=0; i<jsonData.length; i++){
						    var postObj = jsonData[i];
							selectE.innerHTML += "<option value='"+postObj.postId+"'>"+postObj.postName+"</option>";
						}

					}
                }
        }
	</script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="44%" align="left">[员工管理]</td>
   
    <td width="52%"align="right">
    	<!-- 提交表单 -->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()">
       	<img src="${pageContext.request.contextPath}/imag
       	es/button/save.gif" />
       </a>
       <!-- 执行js，进行返回 -->
       <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<s:form action="staffAction_edit" namespace="/">
	<s:hidden name="staffId" value="%{staffId}"/>
	
	<table width="88%" border="0" class="emp_table" style="width:80%;">
	 <tr>
	    <td>登录名：</td>
	    <td><s:textfield name="loginName" value="%{loginName}"/></td>
	    <td>密码：</td>
	    <td><s:password name="loginPwd" value="%{loginPwd}" showPassword="true"/></td>
	  </tr>
	 <tr>
	    <td>姓名：</td>
	    <td><s:textfield name="staffName" value="%{staffName}"/> </td>
	    <td>性别：</td>
	    <td>
	    	<s:radio list="{'男','女'}" name="gender" value="%{gender}"/>
	    </td>
	  </tr>
	 <tr>

	    <td width="10%">所属部门：</td>
	    <td width="20%">
			<s:select
					list="%{#departments}"
					value="post.department.depId"
					listKey="depId"
					listValue="depName"
					headerValue="----请--选--择----"
					onchange="showPost(this)"
					name="post.department.depId"/>
	    </td>
	    <td width="8%">职务：</td>
	    <td width="62%">
			<s:select
					list="post != null ? post.department.posts : {}"
					name="post.postId"
					listKey="postId"
					listValue="postName"
					headerValue="----请--选--择----" id="postSelect"/>
	    </td>
	  </tr>
	  <tr>
	    <td width="10%">入职时间：</td>
	    <td width="20%">
	    	<s:date name="onDutyDate" format="yyyy-MM-dd" var="myDate"/>
			<s:textfield name="onDutyDate" readonly="true" value="%{#myDate}" onfocus="c.showMoreDay=true;c.show(this)"/>
	    </td>
	    <td width="8%"></td>
	    <td width="62%"></td>
	  </tr>
	</table>
</s:form>
<s:debug/>

</body>
</html>
