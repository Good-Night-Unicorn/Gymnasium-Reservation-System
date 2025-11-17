<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">体育馆预约系统</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号
						</div>
						<input placeholder="请输入账号" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码
						</div>
						<div class="password-box">
							<input placeholder="请输入密码" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item " v-if="roles.length>1">
						<div class="lable">
							角色
						</div>
						<div prop="loginInRole" class="list-type">
							<el-radio v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" v-bind:key="item.roleName" v-model="rulesForm.role" :label="item.roleName">{{item.roleName}}</el-radio>
						</div>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
				<div class="idea-box1">还没有账号？</div>
				<div class="idea-box2">输入您的账号和密码以访问帐户</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
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

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
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
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240924/8bfa6a6fc9bb456d8c5dd8147864a691.gif);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240924/8bfa6a6fc9bb456d8c5dd8147864a691.gif);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	background-position: center center;

	.login_form {
		padding: 150px 40px 40px 450px;
		margin: auto auto;
		z-index: 1000;
		background-size: cover;
		display: flex;
		flex-wrap: wrap;
		border-radius: 35px;
		box-shadow: inset 0px 0px 0px 0px #000;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20240924/c1024ec4dcb04283868953c158b36345.png) no-repeat;
		width: 1043px;
		align-items: flex-start;
		position: relative;
		height:  auto;
		.login_form2 {
			flex-direction: column;
			background: none;
			display: flex;
			width: 93%;
		}
		.title-container {
			padding: 0 40px;
			margin: 0 0 20px 448px;
			color: #333333;
			top: 60px;
			left: 0;
			background: none;
			font-weight: 500;
			width: 50%;
			font-size: 28px;
			line-height: 40px;
			position: absolute;
			text-align: center;
		}
		.list-item {
			border: 1px solid #333333;
			border-radius: 4px;
			padding: 0;
			box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
			margin: 15px 10px;
			display: flex;
			width: 500px;
			align-items: center;
			position: relative;
			.lable {
				margin: 0 10px 0 0;
				color: #000;
				white-space: nowrap;
				width: auto;
				font-size: 16px;
				line-height: 40px;
				text-align: right;
				min-width: 90px;
				height: 40px;
			}
			input {
				border: 0px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				color: #666;
				background: #F5F6F6;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			input:focus {
				border: 0px solid #efeff7;
				border-radius: 4px;
				padding: 0 20px;
				color: #666;
				background: #F5F6F6;
				flex: 1;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 0px solid #333333;
					border-radius: 4px;
					padding: 0 20px;
					color: #666;
					background: #F5F6F6;
					width: 100%;
					font-size: 16px;
					height: 60px;
				}
				input:focus {
					border: 0px solid #333333;
					border-radius: 4px;
					padding: 0 20px;
					color: #666;
					background: #F5F6F6;
					width: 100%;
					font-size: 16px;
					height: 60px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 15%;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 20px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
		}
		.list-type {
			padding: 0;
			margin: 15px 10px;
			background: #f5f6f6;
			display: flex;
			width: 500px;
			align-items: center;
			position: relative;
			height: 40px;
			/deep/ .el-radio__input .el-radio__inner {
				background: #333333;
				border-color: #333333;
			}
			/deep/ .el-radio__input.is-checked .el-radio__inner {
				background: #FF6A01;
				border-color: #FF6A01;
			}
			/deep/ .el-radio__label {
				color: #333333;
				font-size: 16px;
			}
			/deep/ .el-radio__input.is-checked+.el-radio__label {
				color: #FF6A01;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px auto;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
				order: 2;
			}
			.login-btn2 {
				top: 58%;
				left: 0;
				display: flex;
				width: 35%;
				justify-content: space-around;
				align-items: center;
				position: absolute;
				flex-wrap: wrap;
			}
			.login-btn3 {
				width: 100%;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 5px;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #FFFFFF;
				background: #FF6A01;
				font-weight: 500;
				width: 100%;
				font-size: 28px;
				min-width: 68px;
				height: 60px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: 2px solid  #FFFFFF;
				cursor: pointer;
				border-radius: 4px;
				padding: 0 10px;
				margin: 0 0 10px;
				color:  #FFFFFF;
				background: none;
				width: auto;
				font-size: 16px;
				height: 34px;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #000000;
				background: none;
				width: 100%;
				font-size: 16px;
				text-align: center;
				height: 34px;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
	.idea-box1 {
		color: #fff;
		top: 50%;
		left: 13%;
		background: none;
		font-weight: 400;
		width: 560px;
		font-size: 16px;
		position: absolute;
		height: 30px;
		order: -2;
	}
	.idea-box2 {
		margin: 5px 0 40px;
		background: #fff;
		display: none;
		width: 100%;
		font-size: 16px;
		height: 30px;
		order: -1;
	}
}

</style>
