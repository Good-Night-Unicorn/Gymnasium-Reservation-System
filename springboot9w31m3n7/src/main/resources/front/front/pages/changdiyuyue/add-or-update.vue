<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#F9FAFA","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">预约编号</view>
				<view :style='{"padding":"0px 24rpx","margin":"0px","color":"#000","flex":"1","background":"#FCF3EF","lineHeight":"80rpx","fontSize":"28rpx"}' class="right-input">
					{{ruleForm.yuyuebianhao}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changdimingcheng" v-model="ruleForm.changdimingcheng" placeholder="场地名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地类型</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changdileixing" v-model="ruleForm.changdileixing" placeholder="场地类型"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="" @tap="changditupianTap">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地图片</view>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-if="ruleForm.changditupian" :src="baseUrl+ruleForm.changditupian.split(',')[0]" mode="aspectFill"></image>
				<image :style='{"width":"80rpx","borderRadius":"100%","objectFit":"cover","display":"block","height":"80rpx"}' class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地位置</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changdiweizhi" v-model="ruleForm.changdiweizhi" placeholder="场地位置"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">小时价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xiaoshijiage" v-model.number="ruleForm.xiaoshijiage" placeholder="小时价格" type="digit"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">预约时长</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yuyueshizhang" v-model.number="ruleForm.yuyueshizhang" placeholder="预约时长" type="digit"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">总费用</view>
				<view :style='{"padding":"0px 24rpx","margin":"0px","color":"#000","flex":"1","background":"#FCF3EF","lineHeight":"80rpx","fontSize":"28rpx"}' class="right-input">
					{{zongfeiyong}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">预约时间</view>
				<input :disabled="ro.yuyueshijian" :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' v-model="ruleForm.yuyueshijian" placeholder="预约时间" @tap="toggleTab('yuyueshijian')"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">用户账号</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yonghuzhanghao" v-model="ruleForm.yonghuzhanghao" placeholder="用户账号"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">用户姓名</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.yonghuxingming" v-model="ruleForm.yonghuxingming" placeholder="用户姓名"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">联系方式</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lianxifangshi" v-model="ruleForm.lianxifangshi" placeholder="联系方式"  type="text"></input>
			</view>
              
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">预约内容</view>
				<textarea :style='{"border":"0","padding":"24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.yuyueneirong" placeholder="预约内容" :maxlength="-1"></textarea>
			</view>
			
			<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"#F66725","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker  mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="yuyueshijianConfirm" ref="yuyueshijian" themeColor="#333333"></w-picker>
	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
	import xiaEditor from '@/components/xia-editor/xia-editor';
	import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				yuyuebianhao: this.getUUID(),
				changdimingcheng: '',
				changdileixing: '',
				changditupian: '',
				changdiweizhi: '',
				xiaoshijiage: '',
				yuyueshizhang: '',
				zongfeiyong: '',
				yuyueshijian: '',
				yonghuzhanghao: '',
				yonghuxingming: '',
				lianxifangshi: '',
				yuyueneirong: '',
				ispay: '',
				},
				// 登录用户信息
				user: {},
				ro:{
				   yuyuebianhao : false,
				   changdimingcheng : false,
				   changdileixing : false,
				   changditupian : false,
				   changdiweizhi : false,
				   xiaoshijiage : false,
				   yuyueshizhang : false,
				   zongfeiyong : false,
				   yuyueshijian : false,
				   yonghuzhanghao : false,
				   yonghuxingming : false,
				   lianxifangshi : false,
				   yuyueneirong : false,
				   ispay : false,
				},
				virtualPay: false,
			}
		},
		components: {
			wPicker,
			xiaEditor,
			multipleSelect,
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},


			zongfeiyong:{
			get: function () {
				return 1*this.ruleForm.xiaoshijiage*this.ruleForm.yuyueshizhang
			}
			},

		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			this.ruleForm.yuyueshijian =  this.$utils.getCurDateTime();
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取
			this.ruleForm.yonghuzhanghao = this.user.yonghuzhanghao
			this.ro.yonghuzhanghao = true;
			this.ruleForm.yonghuxingming = this.user.yonghuxingming
			this.ro.yonghuxingming = true;
			this.ruleForm.lianxifangshi = this.user.lianxifangshi
			this.ro.lianxifangshi = true;



			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("appUserid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = Number(options.refid);
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`changdiyuyue`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='yuyuebianhao'){
						this.ruleForm.yuyuebianhao = obj[o];
						this.ro.yuyuebianhao = true;
						continue;
					}
					if(o=='changdimingcheng'){
						this.ruleForm.changdimingcheng = obj[o];
						this.ro.changdimingcheng = true;
						continue;
					}
					if(o=='changdileixing'){
						this.ruleForm.changdileixing = obj[o];
						this.ro.changdileixing = true;
						continue;
					}
					if(o=='changditupian'){
						this.ruleForm.changditupian = obj[o].split(",")[0];
						this.ro.changditupian = true;
						continue;
					}
					if(o=='changdiweizhi'){
						this.ruleForm.changdiweizhi = obj[o];
						this.ro.changdiweizhi = true;
						continue;
					}
					if(o=='xiaoshijiage'){
						this.ruleForm.xiaoshijiage = obj[o];
						this.ro.xiaoshijiage = true;
						continue;
					}
					if(o=='yuyueshizhang'){
						this.ruleForm.yuyueshizhang = obj[o];
						this.ro.yuyueshizhang = true;
						continue;
					}
					if(o=='zongfeiyong'){
						this.ruleForm.zongfeiyong = obj[o];
						this.ro.zongfeiyong = true;
						continue;
					}
					if(o=='yuyueshijian'){
						this.ruleForm.yuyueshijian = obj[o];
						this.ro.yuyueshijian = true;
						continue;
					}
					if(o=='yonghuzhanghao'){
						this.ruleForm.yonghuzhanghao = obj[o];
						this.ro.yonghuzhanghao = true;
						continue;
					}
					if(o=='yonghuxingming'){
						this.ruleForm.yonghuxingming = obj[o];
						this.ro.yonghuxingming = true;
						continue;
					}
					if(o=='lianxifangshi'){
						this.ruleForm.lianxifangshi = obj[o];
						this.ro.lianxifangshi = true;
						continue;
					}
					if(o=='yuyueneirong'){
						this.ruleForm.yuyueneirong = obj[o];
						this.ro.yuyueneirong = true;
						continue;
					}
				}
			}
			this.styleChange()
			this.$forceUpdate()
			if (uni.getStorageSync('raffleType') && uni.getStorageSync('raffleType') != null) {
				uni.removeStorageSync('raffleType')
				setTimeout(() => {
					this.onSubmitTap()
				}, 300)
			}
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数


			// 日长控件选择日期时间
			yuyueshijianConfirm(val) {
				console.log(val)
				this.ruleForm.yuyueshijian = val.result;
				this.$forceUpdate();
			},


			changditupianTap() {
				let _this = this;
				this.$api.upload(function(res) {
					_this.ruleForm.changditupian = 'upload/' + res.file;
					_this.$forceUpdate();
					_this.$nextTick(()=>{
						_this.styleChange()
					})
				});
			},

			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {
				let that = this
				this.ruleForm.ispay = '未支付'
				if(this.ruleForm.yuyuebianhao){
					this.ruleForm.yuyuebianhao = String(this.ruleForm.yuyuebianhao)
				}
				this.ruleForm.zongfeiyong = this.zongfeiyong
				//跨表计算判断
				var obj;
				if(this.ruleForm.xiaoshijiage&&(!this.$validate.isNumber(this.ruleForm.xiaoshijiage))){
					this.$utils.msg(`小时价格应输入数字`);
					return
				}
				if(this.ruleForm.yuyueshizhang&&(!this.$validate.isNumber(this.ruleForm.yuyueshizhang))){
					this.$utils.msg(`预约时长应输入数字`);
					return
				}
				if(this.ruleForm.zongfeiyong&&(!this.$validate.isNumber(this.ruleForm.zongfeiyong))){
					this.$utils.msg(`总费用应输入数字`);
					return
				}
				//更新跨表属性
				var crossuserid;
				var crossrefid;
				var crossoptnum;
				if(this.cross){
					uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
						if(!obj) {
							obj = uni.getStorageSync('crossObj');
						}
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
							   crossuserid=Number(uni.getStorageSync('appUserid'));
							   crossrefid=obj['id'];
							   crossoptnum=uni.getStorageSync('statusColumnName');
							   crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`changdiyuyue`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`changdiyuyue`, this.ruleForm);
						}else{
							oet = await this.$api.add(`changdiyuyue`, this.ruleForm);
						}
						uni.showModal({
							title: '提交成功！',
							content: '是否跳转支付？',
							success: async function(res) {
								if (res.confirm) {
									that.$utils.jump(`./detail?id=${oet.data}&userid=` + uni.getStorageSync("appUserid"))
								}else {
									that.$utils.msgBack('提交成功');
								}
							}
						})
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`changdiyuyue`, this.ruleForm);
					}else{
						oet = await this.$api.add(`changdiyuyue`, this.ruleForm);
					}
					uni.showModal({
						title: '提交成功！',
						content: '是否跳转支付？',
						success: async function(res) {
							if (res.confirm) {
								that.$utils.jump(`./detail?id=${oet.data}&userid=` + uni.getStorageSync("appUserid"))
							}else {
								that.$utils.msgBack('提交成功');
							}
						}
					})
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				if(this.ro[str]){
					return false
				}
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
