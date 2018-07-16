<%@page pageEncoding="UTF-8" %>

<script type="text/javascript">
    $(function () {
        var toolbar = [{
            text: "添加专辑",
            iconCls: 'icon-add',
            handler: function () {
                $("#insertOneAlbum").dialog("open")
            }
        }, '-', {
            text: "删除专辑",
            iconCls: 'icon-help',
            handler: function () {
                var t = $("#queryAllAlbum").datagrid("getSelected");
                if (t == null) {
                    $.messager.alert('警告', '请选中删除行');
                } else {
                    $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                        if (r) {
                            $.get("${pageContext.request.contextPath}/album/deleteOneAlbum",
                                "id=" + t.id,
                                function () {
                                    $("#queryAllAlbum").treegrid("load");
                                });
                        }
                    });
                }
            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-edit',
            handler: function () {

                $("#insertOneChapter").dialog("open")
            }
        }]

        $('#queryAllAlbum').treegrid({
            url: '${pageContext.request.contextPath}/album/queryAllAlbum',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 100},
                {field: 'url', title: '下载路径', width: 100},
                {field: 'size', title: '章节大小', width: 100},
                {field: 'times', title: '章节时长', width: 100}
            ]],
            fit: true,
            fitColumns: true,
            toolbar: toolbar
        });
        $('#albumId').combobox({
            url:'${pageContext.request.contextPath }/album/queryAllAlbum',
            valueField:'id',
            textField:'title'
        });

    });
    function submitAlbum() {
        $('#insertAlbum').form({
            url: "${pageContext.request.contextPath}/album/insertOneAlbum"
        });
        $('#insertAlbum').submit();


    }
    function submitChapter() {
        $('#insertChapter').form({
            url: "${pageContext.request.contextPath}/album/insertOneChapter"
        });
        $('#insertChapter').submit();

    }
</script>

<table id="queryAllAlbum" style="width:600px;height:400px"></table>

<div id="insertOneAlbum" class="easyui-dialog" title="添加专辑" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submitAlbum();
                   $('#insertOneAlbum').dialog('close');
                   $('#queryAllAlbum').treegrid('load');

				}
			},{
				text:'关闭',
				handler:function(){
                    $('#insertOneAlbum').dialog('close')
				}
			}]">
    <form id="insertAlbum" method="post" enctype="multipart/form-data">
        <div>
            <label for="id">id:</label>
            <input id="id" class="easyui-validatebox" type="text" name="id" data-options="required:true"/>
        </div>
        <div>
            <label for="title">名称:</label>
            <input id="title" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="score">分数:</label>
            <input id="score" class="easyui-validatebox" type="text" name="score"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="brodecast">播音:</label>
            <input id="brodecast" class="easyui-validatebox" type="text" name="brodecast"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="author">作者:</label>
            <input id="author" class="easyui-validatebox" type="text" name="author"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="description">简介:</label>
            <input id="description" class="easyui-validatebox" type="text" name="description"
                   data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="0">上传</option>
                <option value="1">未上传</option>
            </select>
        </div>
    </form>
</div>

<div id="insertOneChapter" class="easyui-dialog" title="添加音乐" style="width:400px;height:300px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                   submitChapter();
                   $('#insertOneChapter').dialog('close');

				}
			},{
				text:'关闭',
				handler:function(){
                    $('#insertOneChapter').dialog('close')
				}
			}]">
    <form id="insertChapter" method="post" enctype="multipart/form-data">
        <div>
            <label for="idChapter">id:</label>
            <input id="idChapter" class="easyui-validatebox" type="text" name="id" data-options="required:true"/>
        </div>
        <div>
            <label for="titleChapter">音乐名:</label>
            <input id="titleChapter" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="music">上传:</label>
            <input id="music" type="text" class="easyui-filebox" style="width:300px" name="music">
        </div>
        <div>
            <label for="albumId">专辑类别:</label>
                <input id="albumId" name="albumId">
        </div>
        <EMBED title="播放" src="" autostart="true" loop="2" width=300 height='100'>上千万群无·</EMBED>
    </form>
</div>


