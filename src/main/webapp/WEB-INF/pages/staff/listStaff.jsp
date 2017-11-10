<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

	<%-- 点击高级查询, 也走查询所有的 action --%>
	<script type="text/javascript">
        function condition(){
            document.getElementById("conditionFormId").submit();
        }
	</script>

	<script type="text/javascript">
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
            var url = "${pageContext.request.contextPath}/postAction_findAllWithDepartment.action?department.depId=" + depId;

//				alert(url);
            xmlHttp.open("GET", url, true);
            xmlHttp.send(null);

            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.status == 200 && xmlHttp.readyState == 4) {
                    // 获取返回的 json 数据
                    var jsonData = eval("(" + xmlHttp.responseText + ")");
                    // 显示到 select 的 option 中
                    var selectE = document.getElementById("postSelect");
                    while (selectE.firstChild) {
                        selectE.removeChild(selectE.firstChild);
                    }
                    selectE.innerHTML = "<option value=''>----请--选--择----</option>";
                    for (var i = 0; i < jsonData.length; i++) {
                        var postObj = jsonData[i];
                        selectE.innerHTML += "<option value='" + postObj.postId + "'>" + postObj.postName + "</option>";

                    }
                }
            }
        }
	</script>
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[员工管理]</td>

    <td width="57%"align="right">

    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="condition()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>

    	<%--添加员工 --%>
			<s:a namespace="/" action="staffAction_addStaffPre">
				<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
			</s:a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：高级查询 -->
 <!-- 查询条件：添加或选择马上查询 -->
 <form id="conditionFormId" action="${pageContext.request.contextPath}/staffAction_findAll" method="post">
	 <table width="88%" border="0" style="margin: 20px;" >
		 <tr>
			 <td width="80px">部门：</td>
			 <td width="200px">
				 <s:select list="%{#departments}"
						   listKey="depId"
						   listValue="depName"
						   headerKey=""
						   headerValue="----请--选--择----"
						   onchange="showPost(this)"
						   name="post.department.depId"/>
			 </td>
			 <td width="80px" >职务：</td>
			 <td width="200px" >
				 <s:select list="allPost"
						   name="post.postId"
						   listKey="postId"
						   listValue="postName"
						   headerValue="----请--选--择----"
						   headerKey=""
						   id="postSelect"
						   requiredLabel="true"/>
			 </td>
			 <td width="80px">姓名：</td>
			 <td width="200px" ><input type="text" name="staffName" size="12" /></td>
			 <td ></td>
		 </tr>
	 </table>
 </form>



<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  
    <s:iterator value="#staffList" status="sl">
	  <tr class="<s:property value="#sl.even ? 'tabtd2':'table1'" />">
	    <td align="center"><s:property value="staffName"/> </td>
	    <td align="center"><s:property value="gender"/></td>
	    <td align="center"><s:property value="onDutyDate"/></td>
	    <td align="center"><s:property value="post.department.depName"/></td>
	    <td align="center"><s:property value="post.postName"/></td>
	  	<td width="7%" align="center">
			<s:a namespace="/" action="staffAction_editStaffPre">
				<s:param name="staffId" value="staffId"/>
				<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
			</s:a>
	  	</td>
		  </s:iterator>
	  	
	  </tr>
    

</table>


<%-- 
<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
--%>
</body>
</html>
