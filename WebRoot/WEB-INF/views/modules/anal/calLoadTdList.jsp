<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>负荷管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/anal/calLoadTd/">负荷列表</a></li>
		<shiro:hasPermission name="anal:calLoadTd:edit"><li><a href="${ctx}/anal/calLoadTd/form">负荷添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="calLoadTd" action="${ctx}/anal/calLoadTd/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>最大负荷值</th>
				<th>最小负荷值</th>
				<th>平均荷值</th>
				<th>创建者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="anal:calLoadTd:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="calLoadTd">
			<tr>
				<td><a href="${ctx}/anal/calLoadTd/form?id=${calLoadTd.id}">
					${calLoadTd.name}
				</a></td>
				<td>
					${calLoadTd.max}
				</td>
				<td>
					${calLoadTd.min}
				</td>
				<td>
					${calLoadTd.avg}
				</td>
				<td>
					${calLoadTd.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${calLoadTd.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${calLoadTd.remarks}
				</td>
				<shiro:hasPermission name="anal:calLoadTd:edit"><td>
    				<a href="${ctx}/anal/calLoadTd/form?id=${calLoadTd.id}">修改</a>
					<a href="${ctx}/anal/calLoadTd/delete?id=${calLoadTd.id}" onclick="return confirmx('确认要删除该负荷吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>