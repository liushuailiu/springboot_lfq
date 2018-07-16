<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $('#queryAllLogging').datagrid({
        url:'${pageContext.request.contextPath}/logging/queryAllLogging',
        columns:[[
            {field:'id',title:'id',width:100},
            {field:'name',title:'名字',width:100},
            {field:'date',title:'日期',width:100},
            {field:'main',title:'操作方法',width:100},
            {field:'method',title:'注解方法',width:100}
        ]],
        fit: true,
        fitColumns: true
    });

</script>

<table id="queryAllLogging"></table>