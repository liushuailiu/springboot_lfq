<%@page pageEncoding="UTF-8" %>
<div id="sex" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    $(function () {
        //发送ajax异步请求
        $.ajax({
            url: "${pageContext.request.contextPath}/user/selectAllUserBySex",
            type: "get",
            dataType: "JSON",
            success: function (res) {
                console.log(res);
                var myChart = echarts.init(document.getElementById('sex'));
                option = {
                    title: {
                        text: '持明法洲App用户分布图',
                        subtext: "最新数据",
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['男', '女']
                    },
                    visualMap: {
                        min: 0,
                        max: 2500,
                        left: 'left',
                        top: 'bottom',
                        text: ['高', '低'],           // 文本，默认为数值文本
                        calculable: true
                    },
                    toolbox: {
                        show: true,
                        orient: 'vertical',
                        left: 'right',
                        top: 'center',
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    series: [
                        {
                            name: '男',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data: res.man
                        }, {
                            name: '女',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    show: false
                                },
                                emphasis: {
                                    show: true
                                }
                            },
                            data: res.woman
                        }
                    ]
                };
                myChart.setOption(option);
            }

        });
    })
</script>

