<template>
<div class="content" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230228/47752d6be3a94e8892a83ec2a70c8443.png) no-repeat center top /100% 100%"}'>
	<div class="text" :style='{"margin":"50px auto","fontSize":"34px","color":"#012c7a","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"0 0 20px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"0px solid #ccc","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"4px","display":"flex"}' v-if="isAuth('panjuxinxi','首页总数')">
				<div :style='{"width":"160px","borderRadius":"5px 0px 0px 5px","background":"#1b5a90","height":"120px"}'></div>
				<div :style='{"alignItems":"center","borderRadius":"0 5px 5px 0","flexDirection":"column","background":"#fff","display":"flex","width":"180px","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#333","fontWeight":"bold","height":"24px"}'>{{panjuxinxiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>番剧信息总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('panjuxinxi','首页统计')">
                <div id="panjuxinxiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('panjuxinxi','首页统计')">
                <div id="panjuxinxiChart2" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('panjuxinxi','首页统计')">
                <div id="panjuxinxiChart3" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('panjuxinxi','首页统计')">
                <div id="panjuxinxiChart4" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 20%;margin: 0 10px;" v-if="isAuth('panjuxinxi','首页统计')">
                <div id="panjuxinxiChart5" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//5
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            panjuxinxiCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getpanjuxinxiCount();
    this.panjuxinxiChat1();
    this.panjuxinxiChat2();
    this.panjuxinxiChat3();
    this.panjuxinxiChat4();
    this.panjuxinxiChat5();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getpanjuxinxiCount() {
        this.$http({
            url: `panjuxinxi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.panjuxinxiCount = data.data
            }
        })
    },

    panjuxinxiChat1() {
      this.$nextTick(()=>{

        var panjuxinxiChart1 = echarts.init(document.getElementById("panjuxinxiChart1"),'macarons');
        this.$http({
            url: "panjuxinxi/group/pingfen",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].pingfen);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].pingfen
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '评分统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                panjuxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    panjuxinxiChart1.resize();
                };
            }
        });
      })
    },

    panjuxinxiChat2() {
      this.$nextTick(()=>{

        var panjuxinxiChart2 = echarts.init(document.getElementById("panjuxinxiChart2"),'macarons');
        this.$http({
            url: "panjuxinxi/group/xuanji",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].xuanji);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xuanji
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '选集统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                panjuxinxiChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    panjuxinxiChart2.resize();
                };
            }
        });
      })
    },

    panjuxinxiChat3() {
      this.$nextTick(()=>{

        var panjuxinxiChart3 = echarts.init(document.getElementById("panjuxinxiChart3"),'macarons');
        this.$http({
            url: "panjuxinxi/group/epid",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].epid);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].epid
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: 'epid统计',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: ['25%', '55%'],
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                panjuxinxiChart3.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    panjuxinxiChart3.resize();
                };
            }
        });
      })
    },


    panjuxinxiChat4() {
      this.$nextTick(()=>{

        var panjuxinxiChart4 = echarts.init(document.getElementById("panjuxinxiChart4"),'macarons');
        this.$http({
            url: `panjuxinxi/value/biaoti/bofangliang`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].biaoti);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].biaoti
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '播放量统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: xAxis
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'line',
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                panjuxinxiChart4.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    panjuxinxiChart4.resize();
                };
            }
        });
      })
    },

    panjuxinxiChat5() {
      this.$nextTick(()=>{

        var panjuxinxiChart5 = echarts.init(document.getElementById("panjuxinxiChart5"),'macarons');
        this.$http({
            url: `panjuxinxi/value/biaoti/danmu`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].biaoti);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].biaoti
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '弹幕量统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                panjuxinxiChart5.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    panjuxinxiChart5.resize();
                };
            }
        });
      })
    },

  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
