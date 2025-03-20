const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootnduy8/",
            name: "springbootnduy8",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootnduy8/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Hadoop短视频流量数据分析与可视化"
        } 
    }
}
export default base
