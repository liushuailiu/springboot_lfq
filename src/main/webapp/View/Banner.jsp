<%@page pageEncoding="utf-8" %>
<script>
    $(function () {
        var toolbar = [{
            text: "添加",
            iconCls: 'icon-add',
            handler: function () {
                $("#dd").dialog("open")
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                var t = $("#dg").edatagrid("getSelected");
                if (t == null) {
                    $.messager.alert('警告', '请选中修改行');
                } else {
                    var index=$("#dg").edatagrid("getRowIndex",t);
                    $("#dg").edatagrid("editRow",index);
                }
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-help',
            handler: function () {
                var t = $("#dg").datagrid("getSelected");
                if (t == null) {
                    $.messager.alert('警告', '请选中删除行');
                } else {
                    $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                        if (r) {
                            $.get("${pageContext.request.contextPath}/banner/deleteOneBanner",
                                "id=" + t.id,
                                function () {
                                    $("#dg").datagrid("load");
                                });
                        }
                    });
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-edit',
            handler: function () {
               $("#dg").edatagrid("saveRow");
            }
        }]

        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/queryAllBanner',
            method: "get",
            columns: [[
                {field: 'picName', title: '名字', width: 100,editor:{
                    type:'text',
                    options:{
                        required:true
                    }
                }},
                {field: 'status', title: '状态', width: 100,editor:{
                    type:'text',
                    options:{
                        required:true
                    }
                }},
                {field: 'picPath', title: '路径', width: 100, align: 'right',editor:{
                    type:'text',
                    options:{
                        required:true
                    }
                }},
                {field: 'createTime', title: '时间', width: 100, align: 'right',editor:{
                    type:'text',
                    options:{
                        required:true
                    }
                }}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 3,
            pageList: [3, 5, 7, 9],
            toolbar: toolbar,
            updateUrl:"${pageContext.request.contextPath}/banner/updateOneBanner",
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/myimage' + rowData.picPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>date: ' + rowData.createTime + '</p>' +
                    '<p>picName: ' + rowData.picName + '</p>' +
                    '<p>path: ' + rowData.picPath + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }


        });

    });
    function submit() {
        $('#ff').form({
            url: "${pageContext.request.contextPath}/banner/insertOneBanner"
        });
        $('#ff').submit();
    }

</script>

<table id="dg"></table>

<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submit();
                   $('#dd').dialog('close')
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#dd').dialog('close')
				}
			}]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="id">id:</label>
            <input id="id" class="easyui-validatebox" type="text" name="id" data-options="required:true"/>
        </div>
        <div>
            <label for="picName">名字:</label>
            <input id="picName" class="easyui-validatebox" type="text" name="picName" data-options="required:true"/>
        </div>
        <div>
            <label for="picPath">上传:</label>
            <input id="picPath" type="text" class="easyui-filebox" style="width:300px" name="img">
        </div>
        <div>
            <label for="description">描述:</label>
            <input id="description" class="easyui-validatebox" type="text" name="description"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="0">不展示</option>
                <option value="1">展示</option>
            </select>
        </div>
        <div>
            <label for="createTime">时间:</label>
            <input id="createTime" class="easyui-datebox" type="text" name="createTime"
                   data-options="required:true,editable:false,"/>
        </div>
        <div>
            <label for="url">跳转路径:</label>
            <input id="url" class="easyui-validatebox" type="text" name="url" data-options="required:true"/>
        </div>
    </form>
</div>

