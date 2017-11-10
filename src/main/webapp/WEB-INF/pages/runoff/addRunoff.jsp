<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
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
    <td width="44%" align="left">[添加流失学员]</td>
   
    <td width="52%"align="right">
    	<!--<a href="listLog.html"><img src="${pageContext.request.contextPath}/images/button/find.gif" class="img"/></a>
        <a href="addLog.html"><img src="${pageContext.request.contextPath}/images/button/add.gif" class="img"/></a>~-->
        
       <!-- <a href="#"><img src="${pageContext.request.contextPath}/images/button/close.gif" class="img"/></a>-->
       <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/save.gif" /></a>
		<!-- 执行js，进行返回 -->
		<a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

 <s:form action="runOffAction_addRunoff">
 	<s:hidden name="studentId" value="%{student.studentId}"/>

	<table width="88%" class="emp_table">
	  <tr>
	    <td width="120px" align="left">学生姓名：</td>
	    <td width="200px" align="left"><s:property value="%{name}"/> </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="120px" align="left">是否退款：</td>
	    <td width="200px" align="left">

			<s:select list="@com.lanou.crm.macro.MacroDefinition@RUNOFF_REFUND" name="isRefund"/>

	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="120px" align="left">退款金额：</td>
	    <td width="200px" align="left">
			<s:textfield name="refundAmount" value=""/>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="120px" align="left">描述：</td>
	    <td width="200px" align="left">
			<s:textarea name="remark" value=""/>
	    </td>
	    <td>&nbsp;</td>
	  </tr>
	</table>

 </s:form>

</html>