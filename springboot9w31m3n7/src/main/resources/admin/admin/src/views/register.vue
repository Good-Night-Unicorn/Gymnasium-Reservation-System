<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__backInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">体育馆预约系统</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
				<div class="idea-box1">注册</div>
				<div class="idea-box2">输入您的账号和密码以注册帐户</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					lianxifangshi: '',
					touxiang: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240924/8bfa6a6fc9bb456d8c5dd8147864a691.gif);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240924/8bfa6a6fc9bb456d8c5dd8147864a691.gif);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		flex-direction: column;
		background: none;
		display: flex;
		width: 93%;
		}
		padding: 150px 40px 40px 450px;
		margin: auto auto;
		z-index: 1000;
		background-size: 100% 100%;
		display: flex;
		flex-wrap: wrap;
		border-radius: 35px;
		box-shadow: inset 0px 0px 0px 0px #000;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20240924/c1024ec4dcb04283868953c158b36345.png) no-repeat ;
		width: 1043px;
		align-items: flex-start;
		position: relative;
		height:  auto;
		.title {
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
			padding: 0;
			margin: 15px 10px;
			width: 500px;
			position: relative;
			/deep/ .el-form-item__content {
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 20px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 25px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 25px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 100%;
				font-size: 16px;
				height: 60px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #efeff7;
				cursor: pointer;
				border-radius: 0px;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #000;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #999;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 0;
				position: inherit;
				content: "*";
				order: -1;
			}
			.editor {
				border: 1px solid #000;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 25px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 95%;
				font-size: 16px;
				height: 60px;
			}
			input:focus {
				border: 1px solid #333333;
				border-radius: 4px;
				padding: 0 25px;
				box-shadow: 0px 4px 5px 0px rgba(51,51,51,0.3);
				color: #666;
				background: #F5F6F6;
				width: 95%;
				font-size: 16px;
				height: 60px;
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			button {
				border: 1px solid #000;
				cursor: pointer;
				border-radius: 5px;
				padding: 0;
				margin: 1px 0 0;
				color: #333;
				background: #0d6efd20;
				width: 150px;
				font-size: 15px;
				height: 60px;
			}
			button:hover {
				opacity: 0.8;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			display: flex;
			width: 100%;
			justify-content: center;
		}
		.register-btn2 {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 5px;
			background: #FF6A01;
			font-weight: 500;
			min-width: 68px;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 5px;
			padding: 0 10px;
			margin: 30px  auto;
			color: #FFFFFF;
			background: #FF6A01;
			font-weight: 500;
			width: 500px;
			font-size: 28px;
			min-width: 68px;
			height: 60px;
		}
		.r-btn:hover {
			border: 0px solid rgba(0, 0, 0, 1);
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0;
			color: #FFFFFF;
			font-weight: 500;
			display: inline-block;
			font-size: 15px;
			line-height: 60px;
			border-radius: 5px;
			top: 45%;
			left: 4%;
			background: #FF6A01;
			width: 299px;
			position: absolute;
			text-align: center;
			height: 60px;
		}
		.r-login:hover {
			opacity: 1;
		}
	}
	.idea-box1 {
		background: none;
		font-weight: 600;
		display: none;
		width: 560px;
		font-size: 20px;
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
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
