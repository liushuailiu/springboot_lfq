<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {
        $("#btn").linkbutton({
            onClick:function () {
                var texts= $("#cc").combotree("getText");
                var fileds= $("#cc").combotree("getValues");
                var a="";
                $.each(fileds,function (index,filed) {
                    if (index==fileds.length-1){
                        a+=filed
                    }else {
                        a+=filed+",";
                    }
                })
                $("#ff").form("submit",{
                    url:"${pageContext.request.contextPath}/user/customer",
                    queryParams:{
                        "title":texts,
                        "fileds":a
                    },
                    success:function () {
                        $('#dd').dialog('close')
                    }

                })
            },
            method: "post",
            text:'保存',
        });
        var toolbar = [{
            text: "自定义导出",
            iconCls: 'icon-add',
            handler: function () {
                $("#dd").dialog("open")
            }
        }]
        $('#queryAllUser').datagrid({
            url: '${pageContext.request.contextPath}/user/queryAllUser',
            columns: [[
                {field: 'name', title: '名字', width: 100},
                {field: 'dharmName', title: '法名', width: 100},
                {field: 'sex', title: '性别·', width: 100},
                {field: 'city', title: '城市', width: 100},
                {field: 'phoneNum', title: '电话', width: 100}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar
        });
    });

</script>

<table id="queryAllUser"></table>

<div id="dd" class="easyui-dialog" title="自定义导出" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <select id="cc" class="easyui-combotree" style="width:200px;"
            data-options="checkbox:true,onlyLeafCheck:true,multiple:true,required:true,data:
            [{
            'id':'custom',
            'text':'自定义导出',
            'state':'closed',
            'children':[{
                'id':'name',
                'text':'名字'
            },{
               'id':'dharmName',
                'text':'法名'
            },{
                'id':'sex',
                'text':'性别'
            },{
                'id':'city',
                'text':'城市'
            },{
                'id':'phoneNum',
                'text':'电话'
            }]
            }]"></select><br/>

    <form id="ff" method="post">
        <a id="btn"></a>
    </form>
</div>

<%--
,buttons:[{
text:'提交',
handler:function(){
$('#dd').dialog('close')
}
},{
text:'关闭',
handler:function(){
$('#dd').dialog('close')
}
}]--%>
