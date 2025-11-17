<template>
<view class="content">
	<view class="box" :style='{"width":"100%","padding":"60rpx","alignItems":"flex-start","background":"url(http://codegen.caihongy.cn/20250205/91190d6e1f0248648045de493c3d9a59.png) no-repeat center top","display":"flex","height":"auto"}'>
		<view :style='{"width":"100%","padding":"60rpx 42rpx 0 42rpx","position":"relative","borderRadius":"30rpx","background":"#fff","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0 auto 24rpx auto","borderRadius":"8rpx","display":"block","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">用户账号：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yonghuzhanghao"  type="text"  class="uni-input" name="" placeholder="用户账号" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.mima" type="password"  class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">确认密码：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">用户姓名：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.yonghuxingming"  type="text"  class="uni-input" name="" placeholder="用户姓名" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">性别：</view>
				<picker :style='{"width":"100%","margin":"0","display":"flex","height":"auto"}' v-if="tableName=='yonghu'"  @change="yonghuxingbieChange" :value="yonghuxingbieIndex" :range="yonghuxingbieOptions">
					<view>
						<view :style='{"padding":"0 20rpx","lineHeight":"80rpx","fontSize":"28rpx","color":"#6B6153","flex":"1","background":"#FCF3EF"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
					</view>
				</picker>
			</view>
			<view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" class="uni-form-item uni-column">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">联系方式：</view>
				<input :style='{"border":"none","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}'  v-model="ruleForm.lianxifangshi"  type="text"  class="uni-input" name="" placeholder="联系方式" />
			</view>
            <view :style='{"margin":"0 0 40rpx 0","borderColor":"#ECE0FF","alignItems":"center","flexWrap":"wrap","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' v-if="tableName=='yonghu'" @tap="yonghutouxiangTap" class="">
				<view :style='{"padding":"0 0 0 20rpx","color":"#707070","borderRadius":"0","textAlign":"left","background":"none","flex":"none","width":"100%","lineHeight":"50rpx","fontSize":"28rpx","height":"50rpx"}' class="label">头像：</view>
				<image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"120rpx","borderRadius":"16rpx","display":"block","height":"120rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"#F66725","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
			
			<view class="idea1" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea1</view>
			<view class="idea2" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea2</view>
			<view class="idea3" :style='{"width":"100%","background":"red","display":"none","height":"80rpx"}'>idea3</view>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                yonghuxingbieOptions: [],
                yonghuxingbieIndex: 0,
				ruleForm: {
                yonghuzhanghao: '',
                mima: '',
                yonghuxingming: '',
                xingbie: '',
                lianxifangshi: '',
                touxiang: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

                        // 自定义下拉框值
			if(this.tableName=='yonghu'){
                this.yonghuxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.yonghuxingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            // 下拉变化
            yonghuxingbieChange(e) {
                    this.yonghuxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.yonghuxingbieOptions[this.yonghuxingbieIndex]
            },
            yonghutouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'upload/' + res.file;
					_this.$forceUpdate();
                });
            },

            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.uni-input .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.registerFrom.content.input.backgroundColor
					// })
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
				
				if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
					this.$utils.msg(`用户账号不能为空`);
					return
				}
				if((!this.ruleForm.mima) && `yonghu` == this.tableName){
					this.$utils.msg(`密码不能为空`);
					return
				}
                if(`yonghu` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
					this.$utils.msg(`用户姓名不能为空`);
					return
				}
				if(`yonghu` == this.tableName && this.ruleForm.lianxifangshi&&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
					this.$utils.msg(`联系方式应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
