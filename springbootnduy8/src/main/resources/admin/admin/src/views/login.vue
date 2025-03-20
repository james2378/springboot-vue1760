<template>
  <div>
    <div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221011/e8a93776b74f4f60816fea7cb08f0eab.jpg)","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>

      <el-form :style='{"padding":"40px 20px 20px","boxShadow":"0 1px 6px rgba(64, 158, 255, .8)","margin":"100px 0px 0px","borderRadius":"20px","background":"#fff","width":"750px","height":"auto"}'>
        <div v-if="true" :style='{"boxShadow":"1px 3px 4px #98c1ef","padding":"10px 0","margin":"-75px 0 10px 70px","borderColor":"#266bb6","color":"#ffffff","textAlign":"center","borderRadius":"6px 30px","background":"-webkit-linear-gradient(top,#2b84e6,#0b417c)","borderWidth":"0px 2px 2px 0px","width":"580px","fontSize":"20px","position":"absolute","borderStyle":"solid","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)","height":"auto"}' class="title-container">基于Hadoop短视频流量数据分析与可视化登录</div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"65%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"rgba(64, 158, 255, 1)","left":"-120px","textAlign":"right","width":"120px","lineHeight":"44px","fontSize":"15px","position":"absolute","fontWeight":"600"}'>用户名：</div>
          <input :style='{"padding":"0 10px","margin":"0px 0px 0px  0px","borderColor":"#419bff","color":"rgba(64, 158, 255, 1)","borderWidth":"0px 0px 2px 0px","width":"100%","fontSize":"14x","borderStyle":"solid","height":"44px"}' placeholder="请输入用户名" name="username" type="text" v-model="rulesForm.username">
        </div>
        <div v-if="loginType==1" class="list-item" :style='{"width":"65%","margin":"0 auto 30px","position":"relative","alignItems":"center","flexWrap":"wrap","display":"flex"}'>
          <div v-if="true" class="lable" :style='{"color":"rgba(64, 158, 255, 1)","left":"-120px","textAlign":"right","width":"120px","lineHeight":"44px","fontSize":"15px","position":"absolute","fontWeight":"600"}'>密码：</div>
          <input :style='{"padding":"0 10px","margin":"0px 0px 0px  0px","borderColor":"#419bff","color":"rgba(64, 158, 255, 1)","borderWidth":"0px 0px 2px 0px","width":"100%","fontSize":"14x","borderStyle":"solid","height":"44px"}' placeholder="请输入密码" name="password" type="password" v-model="rulesForm.password">
        </div>
        <div :style='{"width":"65%","margin":"40px auto"}' v-if="roles.length>1" prop="loginInRole" class="list-type">
          <el-radio v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
        </div>
        <div :style='{"width":"80%","margin":"30px auto","alignItems":"center","justifyContent":"center","display":"flex"}'>
          <el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 40px","margin":"5px 0px 0px 0px","outline":"none","color":"#fff","borderRadius":"4px","background":"-webkit-linear-gradient(top,#96d148,#4a7f06)","width":"auto","fontSize":"18px","height":"44px"}' type="primary" @click="login()" class="loginInBt">登录</el-button>
        </div>
      </el-form>

    </div>
  </div>
</template>
<script>

import menu from "@/utils/menu";
export default {
  data() {
    return {
      baseUrl:this.$base.url,
      loginType: 1,
      rulesForm: {
        username: "",
        password: "",
        role: "",
        code: '',
      },
      menus: [],
      roles: [],
      tableName: "",
      codes: [{
        num: 1,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 2,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 3,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      },{
        num: 4,
        color: '#000',
        rotate: '10deg',
        size: '16px'
      }],
    };
  },
  mounted() {
    let menus = menu.list();
    this.menus = menus;

    for (let i = 0; i < this.menus.length; i++) {
      if (this.menus[i].hasBackLogin=='是') {
        this.roles.push(this.menus[i])
      }
    }

  },
  created() {
    this.getRandCode()
  },
  destroyed() {
	    },
  components: {
  },
  methods: {

    //注册
    register(tableName){
		this.$storage.set("loginTable", tableName);
        this.$storage.set("pageFlag", "register");
		this.$router.push({path:'/register'})
    },
    // 登陆
    login() {

		if (!this.rulesForm.username) {
			this.$message.error("请输入用户名");
			return;
		}
		if (!this.rulesForm.password) {
			this.$message.error("请输入密码");
			return;
		}
		if(this.roles.length>1) {
			if (!this.rulesForm.role) {
				this.$message.error("请选择角色");
				return;
			}

			let menus = this.menus;
			for (let i = 0; i < menus.length; i++) {
				if (menus[i].roleName == this.rulesForm.role) {
					this.tableName = menus[i].tableName;
				}
			}
		} else {
			this.tableName = this.roles[0].tableName;
			this.rulesForm.role = this.roles[0].roleName;
		}

		this.$http({
			url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
			method: "post"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.$storage.set("Token", data.token);
				this.$storage.set("role", this.rulesForm.role);
				this.$storage.set("sessionTable", this.tableName);
				this.$storage.set("adminName", this.rulesForm.username);
				this.$router.replace({ path: "/index/" });
			} else {
				this.$message.error(data.msg);
			}
		});
    },
    getRandCode(len = 4){
		this.randomString(len)
    },
    randomString(len = 4) {
      let chars = [
          "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
          "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
          "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G",
          "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
          "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2",
          "3", "4", "5", "6", "7", "8", "9"
      ]
      let colors = ["0", "1", "2","3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"]
      let sizes = ['14', '15', '16', '17', '18']

      let output = [];
      for (let i = 0; i < len; i++) {
        // 随机验证码
        let key = Math.floor(Math.random()*chars.length)
        this.codes[i].num = chars[key]
        // 随机验证码颜色
        let code = '#'
        for (let j = 0; j < 6; j++) {
          let key = Math.floor(Math.random()*colors.length)
          code += colors[key]
        }
        this.codes[i].color = code
        // 随机验证码方向
        let rotate = Math.floor(Math.random()*60)
        let plus = Math.floor(Math.random()*2)
        if(plus == 1) rotate = '-'+rotate
        this.codes[i].rotate = 'rotate('+rotate+'deg)'
        // 随机验证码字体大小
        let size = Math.floor(Math.random()*sizes.length)
        this.codes[i].size = sizes[size]+'px'
      }
    },
  }
};
</script>

<style lang="scss" scoped>
.container {
  min-height: 100vh;
  position: relative;
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
      background: url(http://codegen.caihongy.cn/20221011/e8a93776b74f4f60816fea7cb08f0eab.jpg);
        
  .list-item /deep/ .el-input .el-input__inner {
		padding: 0 10px;
		margin: 0px 0px 0px  0px;
		color: rgba(64, 158, 255, 1);
		width: 100%;
		font-size: 14x;
		border-color: #419bff;
		border-width: 0px 0px 2px 0px;
		border-style: solid;
		height: 44px;
	  }
  
  .list-code /deep/ .el-input .el-input__inner {
  	  	border: 0px solid rgba(64, 158, 255, 1);
  	  	padding: 0 10px;
  	  	outline: none;
  	  	color: rgba(64, 158, 255, 1);
  	  	width: calc(100% - 95px);
  	  	font-size: 14px;
  	  	border-color: #419bff;
  	  	border-width: 0px 0px 2px 0px;
  	  	border-style: solid;
  	  	height: 44px;
  	  }

  .list-type /deep/ .el-radio__input .el-radio__inner {
		border-radius: 2px;
		background: rgba(53, 53, 53, 0);
		border-color: #666666;
	  }
  .list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
        border-radius: 2px;
        background: rgba(64, 158, 255, 1);
        border-color: rgba(64, 158, 255, 1);
      }
  .list-type /deep/ .el-radio__label {
		color: #666666;
		font-size: 14px;
	  }
  .list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
        color: rgba(64, 158, 255, 1);
        font-size: 14px;
      }
}
</style>
