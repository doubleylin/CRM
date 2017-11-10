<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>

    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>

    <script>

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

            function changeStudent(obj) {
                var classId = obj.value;

                var xmlhttp = createXMLHttpRequest();

                var url = "${pageContext.request.contextPath}/studentAction_ajaxGetNotGraduateStudent?clazz.classId=" + classId;
                xmlhttp.open("get", url);

                xmlhttp.send(null);

                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

                        var studentSelectObj = document.getElementById("studentSelectId");
                        // 必须设置 value='' 否则数据有误
                        studentSelectObj.innerHTML = "<option value=''>-- 请选择学生 --</option>";

                        //获得数据 json，并处理
                        //@1 获得普通文本数据
                        var textData = xmlhttp.responseText;
                        //@2 将文本转换成json数据  eval()  ,但兼容  eval("("+...+")")
                        var jsonData = eval("(" + textData + ")");
                        //@3 遍历数据，将数据添加到“学生”select
                        for (var i = 0; i < jsonData.length; i++) {
                            var studentObj = jsonData[i];
                            // @3.1 编号
                            var studentId = studentObj.studentId;
                            // @3.2 名称
                            var studentName = studentObj.name;
                            // @3.3 追加
                            studentSelectObj.innerHTML = studentSelectObj.innerHTML + "<option value='" + studentId + "'>" + studentName + "</option>";
                        }
                    }
                };


            }



    </script>

</head>
<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[添加学员就业信息]</td>

        <td width="52%" align="right">
            <!-- 添加 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img src="${pageContext.request.contextPath}/images/button/tuihui.gif" /></a>
        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<s:form namespace="/" action="graduateAction_addOrEdit">

<s:if test="%{student.clazz.classId != null}">
<s:hidden name="student.clazz.classId" value="%{student.clazz.classId}"/>
</s:if>
<table width="88%" border="0" class="emp_table" style="width:80%;">
    <tr>
        <td width="9%">班级：</td>
        <td width="19%">
            <s:select id="selectClazz"
                    list="%{#allClass}"
                      name="student.clazz.classId"
                      value="%{student.clazz.classId}"
                      headerKey="" headerValue="---- 请选择班级 ----"
                      listKey="classId" listValue="name"
                      onchange="changeStudent(this)">
            </s:select>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td width="9%">学生：</td>
        <td width="19%">

            <s:if test="%{student.clazz != null}">
            <s:select id="studentSelectId"
                      list="%{student.clazz.students}"
                      listKey="studentId"
                      listValue="name"
                      name="student.studentId"
                      value="%{student.studentId}"
                      headerKey=""
                      headrValue="--- 请选择学生 ---">
            </s:select>
            </s:if>
            <s:else>
                <s:select list="{}"
                          id="studentSelectId"
                          headerKey="" headerValue="----请--选--择----"
                          name="student.studentId"
                ></s:select>
            </s:else>
        </td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>就业公司：</td>
        <td><s:textfield name="companyName" value="%{companyName}"/></td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>薪资：</td>
        <td><s:textfield name="salary" value="%{salary}"/></td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>岗位：</td>
        <td><s:textfield name="post" value="%{post}"/></td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>入职时间：</td>
        <td><s:textfield name="entryTime" value="%{entryTime}" readonly="true"
                         onfocus="c.showMoreDay=true; c.show(this);"/></td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td>备注：</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
    </tr>
    <tr>
        <td colspan="3">
            <s:textarea name="remark" value="%{remark}" cols="60" rows="10"></s:textarea>
        </td>
    </tr>
</table>
</s:form>




</html>