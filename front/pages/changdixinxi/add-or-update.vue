<template>
<view class="content">
	<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#F9FAFA","height":"auto"}'>
		<form :style='{"width":"100%","padding":"24rpx","background":"none","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地编号</view>
				<view :style='{"padding":"0px 24rpx","margin":"0px","color":"#000","flex":"1","background":"#FCF3EF","lineHeight":"80rpx","fontSize":"28rpx"}' class="right-input">
					{{ruleForm.changdibianhao}}
				</view>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地名称</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changdimingcheng" v-model="ruleForm.changdimingcheng" placeholder="场地名称"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地类型</view>
				<picker :disabled="ro.changdileixing" :style='{"width":"100%","flex":"1","height":"auto"}' @change="changdileixingChange" :value="changdileixingIndex" :range="changdileixingOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#F66725"}' class="uni-input">{{ruleForm.changdileixing?ruleForm.changdileixing:"请选择场地类型"}}</view>
				</picker>
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
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地状态</view>
				<picker :disabled="ro.changdizhuangtai" :style='{"width":"100%","flex":"1","height":"auto"}' @change="changdizhuangtaiChange" :value="changdizhuangtaiIndex" :range="changdizhuangtaiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#F66725"}' class="uni-input">{{ruleForm.changdizhuangtai?ruleForm.changdizhuangtai:"请选择场地状态"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地面积</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.changdimianji" v-model="ruleForm.changdimianji" placeholder="场地面积"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">场地分类</view>
				<picker :disabled="ro.changdifenlei" :style='{"width":"100%","flex":"1","height":"auto"}' @change="changdifenleiChange" :value="changdifenleiIndex" :range="changdifenleiOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#F66725"}' class="uni-input">{{ruleForm.changdifenlei?ruleForm.changdifenlei:"请选择场地分类"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">联系人</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lianxiren" v-model="ruleForm.lianxiren" placeholder="联系人"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">联系电话</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.lianxidianhua" v-model="ruleForm.lianxidianhua" placeholder="联系电话"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">小时价格</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.xiaoshijiage" v-model.number="ruleForm.xiaoshijiage" placeholder="小时价格" type="digit"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">开放时间</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.kaifangshijian" v-model="ruleForm.kaifangshijian" placeholder="开放时间"  type="text"></input>
			</view>
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ECE0FF","alignItems":"center","borderWidth":"0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#727272","textAlign":"right"}' class="title">容纳人数</view>
				<input :style='{"border":"0","padding":"0px 24rpx","margin":"0px","color":"#000","borderRadius":"8rpx","flex":"1","background":"#FCF3EF","fontSize":"28rpx","height":"80rpx"}' :disabled="ro.rongnarenshu" v-model.number="ruleForm.rongnarenshu" placeholder="容纳人数" type="number"></input>
			</view>
               
			<view :style='{"padding":"12rpx 0","margin":"0 0 24rpx 0","borderColor":"#ccc","borderWidth":"0","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#fff","fontWeight":"500"}' class="title">场地详情</view>
				<xia-editor ref="changdixiangqing" :style='{"minHeight":"300rpx","width":"100%","padding":"20rpx","color":"#333","background":"#FCF3EF","height":"auto"}' v-model="ruleForm.changdixiangqing" placeholder="场地详情" @editorChange="changdixiangqingChange"></xia-editor>
			</view>
			
			<view :style='{"width":"100%","flexWrap":"wrap","justifyContent":"space-between","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0","padding":"0px","margin":"0 0 24rpx 0","color":"#fff","borderRadius":"40rpx","background":"#F66725","width":"100%","lineHeight":"80rpx","fontSize":"32rpx","fontWeight":"600","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

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
				changdibianhao: this.getUUID(),
				changdimingcheng: '',
				changdileixing: '',
				changditupian: '',
				changdiweizhi: '',
					changdizhuangtai: '空闲中' ,
				changdimianji: '',
				changdifenlei: '',
				lianxiren: '',
				lianxidianhua: '',
				xiaoshijiage: '',
				kaifangshijian: '',
				rongnarenshu: '',
				changdixiangqing: '',
				storeupnum: '',
				},
				changdileixingOptions: [],
				changdileixingIndex: 0,
				changdizhuangtaiOptions: [],
				changdizhuangtaiIndex: 0,
				changdifenleiOptions: [],
				changdifenleiIndex: 0,
				// 登录用户信息
				user: {},
				ro:{
				   changdibianhao : false,
				   changdimingcheng : false,
				   changdileixing : false,
				   changditupian : false,
				   changdiweizhi : false,
				   changdizhuangtai : false,
				   changdimianji : false,
				   changdifenlei : false,
				   lianxiren : false,
				   lianxidianhua : false,
				   xiaoshijiage : false,
				   kaifangshijian : false,
				   rongnarenshu : false,
				   changdixiangqing : false,
				   storeupnum : false,
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



		},
		async onLoad(options) {
			if(options.virtualPay){
				this.virtualPay = true
			}
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下拉框
			res = await this.$api.option(`changdileixing`,`changdileixing`,{});
			this.changdileixingOptions = res.data;
			this.changdileixingOptions.unshift("请选择场地类型");
			// 自定义下拉框值
			this.changdizhuangtaiOptions = "已预约,空闲中".split(',')
			// 自定义下拉框值
			this.changdifenleiOptions = "室内,室外".split(',')

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
				res = await this.$api.info(`changdixinxi`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='changdibianhao'){
						this.ruleForm.changdibianhao = obj[o];
						this.ro.changdibianhao = true;
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
					if(o=='changdizhuangtai'){
						this.ruleForm.changdizhuangtai = obj[o];
						this.ro.changdizhuangtai = true;
						continue;
					}
					if(o=='changdimianji'){
						this.ruleForm.changdimianji = obj[o];
						this.ro.changdimianji = true;
						continue;
					}
					if(o=='changdifenlei'){
						this.ruleForm.changdifenlei = obj[o];
						this.ro.changdifenlei = true;
						continue;
					}
					if(o=='lianxiren'){
						this.ruleForm.lianxiren = obj[o];
						this.ro.lianxiren = true;
						continue;
					}
					if(o=='lianxidianhua'){
						this.ruleForm.lianxidianhua = obj[o];
						this.ro.lianxidianhua = true;
						continue;
					}
					if(o=='xiaoshijiage'){
						this.ruleForm.xiaoshijiage = obj[o];
						this.ro.xiaoshijiage = true;
						continue;
					}
					if(o=='kaifangshijian'){
						this.ruleForm.kaifangshijian = obj[o];
						this.ro.kaifangshijian = true;
						continue;
					}
					if(o=='rongnarenshu'){
						this.ruleForm.rongnarenshu = obj[o];
						this.ro.rongnarenshu = true;
						continue;
					}
					if(o=='changdixiangqing'){
						this.ruleForm.changdixiangqing = obj[o];
						this.ro.changdixiangqing = true;
						continue;
					}
					if(o=='storeupnum'){
						this.ruleForm.storeupnum = obj[o];
						this.ro.storeupnum = true;
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
			changdixiangqingChange(e) {
				this.ruleForm.changdixiangqing = e
			},
			styleChange() {
				this.$nextTick(()=>{
					// document.querySelectorAll('.app-update-pv . .uni-input-input').forEach(el=>{
					//   el.style.backgroundColor = this.addUpdateForm.input.content.backgroundColor
					// })
				})
			},

			// 多级联动参数



			// 下拉变化
			changdileixingChange(e) {
				this.changdileixingIndex = e.target.value
				this.ruleForm.changdileixing = this.changdileixingOptions[this.changdileixingIndex]
			},
			// 下拉变化
			changdizhuangtaiChange(e) {
				this.changdizhuangtaiIndex = e.target.value
				this.ruleForm.changdizhuangtai = this.changdizhuangtaiOptions[this.changdizhuangtaiIndex]
			},
			// 下拉变化
			changdifenleiChange(e) {
				this.changdifenleiIndex = e.target.value
				this.ruleForm.changdifenlei = this.changdifenleiOptions[this.changdifenleiIndex]
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
				if(this.ruleForm.changdibianhao){
					this.ruleForm.changdibianhao = String(this.ruleForm.changdibianhao)
				}
				//跨表计算判断
				var obj;
				if(this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
					this.$utils.msg(`联系电话应输入手机格式`);
					return
				}
				if(this.ruleForm.xiaoshijiage&&(!this.$validate.isNumber(this.ruleForm.xiaoshijiage))){
					this.$utils.msg(`小时价格应输入数字`);
					return
				}
				if(this.ruleForm.rongnarenshu&&(!this.$validate.isIntNumer(this.ruleForm.rongnarenshu))){
					this.$utils.msg(`容纳人数应输入整数`);
					return
				}
				if(this.ruleForm.storeupnum&&(!this.$validate.isIntNumer(this.ruleForm.storeupnum))){
					this.$utils.msg(`收藏数应输入整数`);
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
					let res = await this.$api.list(`changdixinxi`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
						uni.removeStorageSync('crossCleanType');
						return false;
					} else {
				//跨表计算
						let oet = {}
						if(this.ruleForm.id){
							await this.$api.update(`changdixinxi`, this.ruleForm);
						}else{
							oet = await this.$api.add(`changdixinxi`, this.ruleForm);
						}

						this.$utils.msgBack('提交成功');
					}
				} else {
				//跨表计算
					let oet = {}
					if(this.ruleForm.id){
						await this.$api.update(`changdixinxi`, this.ruleForm);
					}else{
						oet = await this.$api.add(`changdixinxi`, this.ruleForm);
					}

					this.$utils.msgBack('提交成功');
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
