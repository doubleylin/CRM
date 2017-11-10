<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
		<td width="44%" align="left">[正式学员管理]</td>

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

<s:form namespace="/" action="studentAction_addOrEdit">
<s:if test="studentId != null">
	<s:hidden name="studentId" value="%{studentId}"></s:hidden>
</s:if>
<s:if test="status != null">
	<s:hidden name="status" value="%{status}"></s:hidden>
</s:if>
<s:if test="refer != null">
	<s:hidden name="refer.referId" value="%{refer.referId}"></s:hidden>
</s:if>

<table width="88%" class="emp_table">
	<tr>
		<td width="100px" align="left">姓名：</td>
		<td width="200px" align="left"><s:textfield name="name" value="%{name}"/> </td>
		<td width="80px" align="left">性别：</td>
		<td align="left">
			<s:radio list="{'男','女'}" name="gender" value="%{gender}"></s:radio>
		</td>
	</tr>
	<tr>
		<td align="left">应付学费：</td>
		<td align="left"><s:textfield name="mustTuition" value="%{mustTuition}"/></td>
		<td align="left">实付学费：</td>
		<td align="left"><s:textfield name="actualTuition" value="%{actualTuition}"/></td>
	</tr>
	<tr>
		<td align="left">身份证号：</td>
		<td align="left"><s:textfield name="identity" value="%{identity}"/></td>
		<td align="left">手机号：</td>
		<td align="left"><s:textfield name="telephone" value="%{telephone}"/></td>
	</tr>
	<tr>
		<td align="left">QQ号：</td>
		<td align="left"><s:textfield name="qq" value="%{qq}"/></td>
		<td align="left">邮箱：</td>
		<td align="left"><s:textfield name="email" value="%{email}"/></td>
	</tr>
	<tr>
		<td align="left">就读班级：</td>
		<td align="left" colspan="3">
			课程类别：
			<s:if test="studentId != null">
				<s:textfield value="%{clazz.courseType.courseName}" readonly="true"/>
			</s:if>
			<s:else>
			<s:select list="%{#allCourseType}"
					  name="clazz.courseType.courseTypeId"
					  listKey="courseTypeId" listValue="courseName"
					  headerKey="" headerValue="----请--选--择----"
					  onchange="changeClass(this)" value="%{clazz.courseType.courseTypeId}">
			</s:select>
			</s:else>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			班级：
			<s:if test="studentId != null">
				<s:textfield value="%{clazz.name}" readonly="true"/>
			</s:if>
			<s:else>
			<s:select list="%{#allClass}"
					  id="classSelectId"
					  name="clazz.classId"
					  value="%{clazz.classId}"
					  headerKey="" headerValue="----请--选--择----"
					  listKey="classId" listValue="name"
			>
			</s:select>
			</s:else>
		</td>
	</tr>
	<tr>
		<td align="left">毕业学校：</td>
		<td align="left">
			<s:textfield name="school" value="%{school}"/></td>
		<td align="left">学历：</td>
		<td align="left">
			<s:select list="@com.lanou.crm.macro.MacroDefinition@STUDENT_EDUCATION" name="education" headerKey="" headerValue="--选择学历--" value="%{education}">
			</s:select>
			专业
			<s:textfield name="professional" size="17" value="%{professional}"/>
		</td>
	</tr>
	<tr>
		<td align="left">身份证地址：</td>
		<td align="left" colspan="3"><s:textfield name="identityAddress" size="60" value="%{identityAddress}"/></td>
	</tr>
	<tr>
		<td align="left">目前住址：</td>
		<td align="left" colspan="3"><s:textfield name="address" size="60" value="%{address}"/></td>
	</tr>
	<tr>
		<td align="left">学员描述：</td>
		<td align="left" colspan="3"><s:textfield name="remark" size="60" value="%{remark}"/> </td>
	</tr>
	<tr>
		<td colspan="6"><br />出门在外，如果发生意外，我们将通过下面的信息跟学院的家长联系</td>
	</tr>
	<tr>
		<td align="left">家庭联系电话：</td>
		<td align="left"><s:textfield name="homeTelephone" value="%{homeTelephone}"/></td>
		<td align="left">家庭联系人：</td>
		<td align="left"><s:textfield name="homeUser" value="%{homeUser}"/></td>
	</tr>
</table>
</s:form>

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
    function changeClass(courseTypeObj){
        //1 选择的部门id
        var courseTypeId = courseTypeObj.value;
        //2 发送ajax 通过部门id 查询对应职务
        var url = "${pageContext.request.contextPath}/classAction_ajaxGetCLazz?courseType.courseTypeId=" + courseTypeId;

        //2.1 创建核心对象
        var xmlhttp= createXMLHttpRequest();

        // 2.2 设置回调函数，当ajax请求完成之后，进行处理
        xmlhttp.onreadystatechange = function(){
            // * 发送成功， 并发送的正常页面
            if(xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                var classSelectObject = document.getElementById("classSelectId");
                // 必须设置 value='' 否则数据有误
                classSelectObject.innerHTML = "<option value='-1'>----请--选--择----</option>";

                //获得数据 json，并处理
                //@1 获得普通文本数据
                var textData = xmlhttp.responseText;
                //@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
                var jsonData = eval("("+textData+")");
                //@3 遍历数据，将数据添加到“职务”select
                for(var i = 0 ; i < jsonData.length ; i ++){
                    var classObj = jsonData[i];
                    // @3.1 编号
                    var classId = classObj.classId;
                    // @3.2 名称
                    var className = classObj.name;
                    // @3.3 追加
                    classSelectObject.innerHTML = classSelectObject.innerHTML + "<option value='"+classId+"'>"+className+"</option>";
                }
            }
        };

        // 2.3 打开连接 ,以get请求方式发送数据
        xmlhttp.open("get",url);

        // 2.4 发送 , 没有请求体的内容，设置成null
        xmlhttp.send(null);
    }
</script>
</html>