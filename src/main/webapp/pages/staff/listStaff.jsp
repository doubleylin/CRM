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
            <a href="javascript:void(0)" onclick="onStaffsQuery()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
            <%--员工注入 --%>
            <a href="findDepart.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
            </a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<script type="application/javascript">
    function onChange(value) {
        //输出value的值
        console.log(value);
        //根据value的值发送请求,获取二级列表的json数据
        var data = new FormData();
        data.append("depId", value);
        data.append("postId",value);
        data.append("staffName",value);

        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                //获取服务器的标签
                serverSelect = document.getElementById("posts");
                //获取option标签
                optionEle = serverSelect.getElementsByTagName("option");
                //获取option的数量
                length = optionEle.length;
                //使用循环清空所有option标签
                for (var i = 0; i < length - 1; i++) {
                    serverSelect.removeChild(optionEle[1]);
                }
                //将json数据插入到option中
                for (var i = 0; i < json.length; i++) {
                    //创建一个option标签
                    option = document.createElement("option");
                    //设置value属性
                    option.setAttribute("value", json[i].postId);
                    //设置文本信息
                    text = document.createTextNode(json[i].postName)
                    //把文本信息添加到option标签中
                    option.appendChild(text);
                    //把option标签添加到servers标签中
                    serverSelect.appendChild(option);
                }

            }
        });

        xhr.open("POST", "findPostByDepId.action");
        xhr.send(data);
    }
    function createTD(text) {
        var td = document.createElement("td");
        td.setAttribute("align", "center");
        var textNode = document.createTextNode(text);
        td.appendChild(textNode);
        return td;
    }

    function onStaffsQuery() {
        //当点击查询按钮的时候会执行
        //获取两个select选中时的id
        var depId = document.getElementById("department").value;
        var postId = document.getElementById("posts").value;
        var staffName= document.getElementById("staffName").value;

        var data = new FormData();
        data.append("depId",depId);
        data.append("postId",postId);
        data.append("staffName",staffName);
        var xhr = new XMLHttpRequest();
        xhr.withCredentials = true;

        xhr.addEventListener("readystatechange", function () {
            if (this.readyState === 4) {
                console.log(this.responseText);
                //对请求回来的数据进行解析
                json = eval('(' + this.responseText + ')');

                var tableEle = document.getElementById("staff");
                var length = tableEle.rows.length;
                for(var i = 0; i < length - 1; i++){
                    tableEle.deleteRow(1);
                }

                for (var i = 0; i < json.length; i++) {

                    var tr = document.createElement("tr");

                    tr.appendChild(createTD(json[i].staffName));
                    tr.appendChild(createTD(json[i].gender));
                    tr.appendChild(createTD(json[i].onDutyDate));
                    tr.appendChild(createTD(json[i].post.department.depName));
                    tr.appendChild(createTD(json[i].post.postName));

                    function createA() {
                        var get_Id = json[i].staffId;
                        var path = "${pageContext.request.contextPath}/add.action?staffId=";
                        path+=get_Id;
                        var td = document.createElement("td");
                        td.setAttribute("align", "center")
                        var a = document.createElement("a");
                        a.setAttribute("href", "path")
                        var textNode = document.createElement("img");
                        textNode.setAttribute("src", "${pageContext.request.contextPath}/images/button/modify.gif")
                        textNode.setAttribute("class", "img")
                        a.appendChild(textNode);
                        td.appendChild(a);
                        return td;
                    }




                    tr.appendChild(createA());


                    tableEle.appendChild(tr);
                }

            }
        });

        xhr.open("POST", "queryAll.action");
        xhr.send(data);
    }



</script>

<!-- 查询条件：马上查询 -->
<form  action="${pageContext.request.contextPath}ListStaff.action" method="post">
    <table width="88%" border="0" style="margin: 20px;" >
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select id="department"  name="depId" onchange="onChange(this.value)">
                    <option value="-1">--请选择部门--</option>
                    <s:iterator value="#session.departments" var="d">
                        <option value="${d.depId}">${d.depName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="80px" >职务：</td>
            <td width="200px" >

                <select id="posts" name="postId">
                    <option value="-1">--请选择职务--</option>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px" >
                <input type="text" name="staffName" id="staffName"/></td>
            <td ></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="staff">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <s:iterator value="#session.staffs" var="s">
        <tr class="tabtd1">
            <td align="center">${s.staffName}</td>
            <td align="center">${s.gender}</td>
            <td align="center">${s.onDutyDate}</td>
            <td align="center">${s.post.department.depName}</td>
            <td align="center">${s.post.postName}</td>
            <td width="7%" align="center">
                <a href="${pageContext.request.contextPath}/findByStaffId.action?staffId=${s.staffId}
				&post.department.depId=${s.post.department.depId}&post.department.depName=${s.post.department.depName}
				&post.postId=${s.post.postId}&post.postName=${s.post.postName}">
                    <img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>
            </td>
        </tr>
    </s:iterator>
</table>


<%--<table border="0" cellspacing="0" cellpadding="0" align="center">--%>
    <%--<tr>--%>
        <%--<td align="right">--%>
            <%--<span>第<s:property value="#pageBean.pageNum"/>/<s:property value="#pageBean.totalPage"/>页</span>--%>
            <%--<span>--%>
        	<%--<a href="/findAll">[首页]</a>&nbsp;&nbsp;--%>
            <%--<a href="/findAll?pageNum=${pageBean.pageNum-1}">[上一页]</a>&nbsp;&nbsp;--%>
                <%--<s:iterator begin="#pageBean.start" end="#pageBean.end" var="num">--%>
                    <%--<s:if test="#num <= #pageBean.totalPage">--%>
                            <%--<a href="/findAll?pageNum=${num}">--%>
                            <%--<s:property value="#num"/> </a>&nbsp;&nbsp;--%>
                    <%--</s:if>--%>
                <%--</s:iterator>--%>
            <%--<a--%>
                    <%--<c:choose>--%>

                        <%--<c:when test="${pageBean.pageNum >= pageBean.totalPage}">href="#"</c:when>--%>

                        <%--<c:otherwise>href="/findAll?pageNum=${pageBean.pageNum + 1}"</c:otherwise>--%>

                    <%--</c:choose>--%>
            <%-->[下一页]</a>&nbsp;&nbsp;--%>
            <%--<a href="/findAll?pageNum=${pageBean.totalPage}">[尾页]</a>--%>
        <%--</span>--%>
        <%--</td>--%>
    <%--</tr>--%>
<%--</table>--%>
</body>
</html>
