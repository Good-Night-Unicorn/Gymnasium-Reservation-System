<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#FFF8F5","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"padding":"20rpx 24rpx","margin":"0","background":"linear-gradient( 270deg, #F5C18C 0%, #F77E4D 48%, #FFAF4F 100%)","display":"flex","width":"100%","position":"relative","height":"auto"}'>
					<view :style='{"border":"none","margin":"0","borderRadius":"20rpx","flex":"1","background":"none","lineHeight":"80rpx","position":"relative","height":"80rpx"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgb(153, 153, 153)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input placeholder-style="color: #000" :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#000","borderRadius":"40rpx","background":"#fff","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.changdimingcheng" type="text" placeholder="场地名称" ></input>
					</view>
					<button :style='{"border":"0","padding":"0px","margin":"0","color":"#fff","right":"20rpx","borderRadius":"40rpx","top":"20rpx","background":"#F66725","width":"136rpx","lineHeight":"80rpx","fontSize":"28rpx","position":"absolute","height":"80rpx","zIndex":"99"}' @tap="search" class="cu-btn shadow-blur round">搜索</button>
				</view>
			

				<view :style='{"padding":"20rpx","margin":"20rpx 0 0","borderRadius":"20rpx 20rpx 0 0","flexWrap":"wrap","background":"#F49971","display":"flex","width":"100%"}'>
					<view @click="sortClick('addtime')" :style='{"border":"2rpx solid rgb(153, 152, 152)","padding":"0 12rpx","margin":"0 20rpx 0 0","outline":"0","borderRadius":"8rpx","display":"flex"}'>
						<text :style='{"color":"#333","lineHeight":"48rpx","fontSize":"24rpx"}'>按日期</text>
						<text v-if="listSort!='addtime'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='asc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
						<text v-else-if="listSort=='addtime'&&listOrder=='desc'" class="icon iconfont icon-shijian18" :style='{"margin":"0 4rpx 0 0","lineHeight":"48rpx","fontSize":"24rpx","color":"#333"}'></text>
					</view>
				</view>
				<view :style='{"padding":"0 20rpx 40rpx 20rpx","borderRadius":"0 0 20rpx 20rpx","flexWrap":"wrap","background":"#F49971","flexDirection":"row","flex":"none","display":"flex","width":"100%","height":"auto"}'>
			
			
					<!-- 样式4 -->
					<view v-if="list.length" class="list-box5" :style='{"padding":"24rpx","margin":"0","borderRadius":"40rpx","background":"#fff","flex":"auto","width":"calc(100% - 200rpx)","height":"auto"}'>
						<block v-for="(product,index) in list" :key="index">
							<view v-if="index%2==0" class="list-item" :style='{"padding":"0 0 20rpx 0","margin":"0 0 20rpx","borderColor":"#9F6045","flexWrap":"wrap","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'>
								<image :style='{"width":"168rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","height":"auto"}' mode="aspectFill" v-if="preHttp(product.changditupian)" :src="product.changditupian"></image>
								<image :style='{"width":"168rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","height":"auto"}' mode="aspectFill" v-else :src="product.changditupian?baseUrl+product.changditupian.split(',')[0]:''"></image>
					
								<view class="list-item-body" :style='{"width":"calc(100% - 168rpx)","padding":"0 0 0 20rpx","margin":"0","height":"auto"}' @tap="onDetailTap(product)">
									<view :style='{"padding":"0","margin":"0","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">{{product.changdimingcheng}}</view>
									<view :style='{"padding":"0"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx 0 0","display":"inline-block"}'>
										<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
									</view>
								</view>
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','修改')) || (!userid && isAuthFront('tixingxinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','删除')) || (!userid && isAuthFront('tixingxinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','修改')) || (!userid && isAuthFront('tixingxinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','删除')) || (!userid && isAuthFront('tixingxinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
							<view v-if="index%2==1" class="list-item" :style='{"padding":"0 0 20rpx 0","margin":"0 0 20rpx","borderColor":"#9F6045","flexWrap":"wrap","borderWidth":"0 0 2rpx 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' @tap="onDetailTap(product)">
								<view class="list-item-body" :style='{"width":"calc(100% - 168rpx)","padding":"0 20rpx 0 0","margin":"0","height":"auto"}'>
									<view :style='{"padding":"0","margin":"0","color":"#333","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600"}' class="title">{{product.changdimingcheng}}</view>
									<view :style='{"padding":"0"}'>
										<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime.split(' ')[0].replace(/\-/g,'-')}}</text>
									</view>
									<view :style='{"padding":"0 20rpx 0 0","display":"inline-block"}'>
										<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#666"}'></text>
										<text :style='{"color":"#666","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
									</view>
								</view>
					
								<image :style='{"width":"168rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","height":"auto"}' mode="aspectFill" v-if="preHttp(product.changditupian)" :src="product.changditupian"></image>
								<image :style='{"width":"168rpx","objectFit":"cover","borderRadius":"8rpx","display":"block","height":"auto"}' mode="aspectFill" v-else :src="product.changditupian?baseUrl+product.changditupian.split(',')[0]:''"></image>
					
								<!-- #ifdef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','修改')) || (!userid && isAuthFront('tixingxinxi','修改'))" @tap.stop.proevent="onUpdate" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','删除')) || (!userid && isAuthFront('tixingxinxi','删除'))" @tap.stop.proevent="onDelete" :data-row="product">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
								<!-- #ifndef MP-WEIXIN -->
								<view :style='{"width":"100%","padding":"8rpx 20rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','修改')) || (!userid && isAuthFront('tixingxinxi','修改'))" @tap.stop.proevent="onUpdateTap(product)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-edit"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>修改</text>
									</view>
									<view :style='{"border":"2rpx solid #F8824E","alignItems":"center","color":"#F8824E","background":"#FEF1EC","display":"flex","width":"160rpx","justifyContent":"center","height":"50rpx"}' v-if="(userid && isAuth('tixingxinxi','删除')) || (!userid && isAuthFront('tixingxinxi','删除'))" @tap.stop.proevent="onDeleteTap(product.id)">
										<text :style='{"margin":"0 8rpx 0 0","fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}' class="cuIcon-delete"></text>
										<text :style='{"fontSize":"28rpx","lineHeight":"1","color":"inherit","display":"inline-block"}'>删除</text>
									</view>
								</view>
								<!-- #endif -->
							</view>
						</block>
					</view>
			


			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx #00000030","margin":"20rpx 0 0","color":"#fff","bottom":"0","outline":"none","borderRadius":"20rpx","left":"0","background":"#F66725","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' class="add-btn" @click="screenBoxShow=true">筛</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"20rpx 20rpx 0 ","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"#F66725","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="userid && isAuth('tixingxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"20rpx 20rpx 0 ","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"#F66725","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="!userid && isAuthFront('tixingxinxi','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<view :style='{"top":"0","left":"0","background":"rgba(0, 0, 0, .3)","width":"100%","position":"absolute","height":"100%","zIndex":"665"}' v-if="screenBoxShow" @click="screenBoxShow=false"></view>
				<view class="screenBox" :class="screenBoxShow?'screenBoxActive':''">
					<view :style='{"width":"100%","padding":"20rpx 0 20rpx 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<view :style='{"width":"18%","padding":"0 0 0 20rpx","fontSize":"24rpx"}'>用户姓名</view>
						<input :style='{"border":"2rpx solid rgb(162, 144, 104)","width":"80%","padding":"0 20rpx 0 20rpx","borderRadius":"40rpx","background":"none","height":"60rpx"}' placeholder="请输入用户姓名" v-model="searchForm.yonghuxingming">
					</view>
					<view :style='{"width":"100%","padding":"40rpx 0 0","alignItems":"center","justifyContent":"space-around","display":"flex"}'>
						<div :style='{"width":"30%","lineHeight":"60rpx","color":"#888","textAlign":"center","background":"#EDEDED","height":"60rpx"}' @click="screenReset">重置</div>
						<div :style='{"width":"30%","lineHeight":"60rpx","color":"#fff","textAlign":"center","background":"#F8824E","height":"60rpx"}' @click="search">搜索</div>
					</view>
				</view>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
				mescroll: null, //mescroll实例对象
				downOption: {
					auto: false //是否在初始化后,自动执行下拉回调callback; 默认true
				},
				upOption: {
					noMoreSize: 5, //如果列表已无数据,可设置列表的总数量要大于半页才显示无更多数据;避免列表数据过少(比如只有一条数据),显示无更多数据会不好看; 默认5
					textNoMore: '~ 没有更多了 ~',
				},
				hasNext: true,
				searchForm:{
					changdimingcheng: '',
					yonghuxingming: '',
				},
				CustomBar: '0',
				listSort: 'id',
				listOrder: 'desc',
				screenBoxShow: false,
			};
		},
		watch: {
		},
		mounted() {
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onShow() {
			this.btnColor = this.btnColor.sort(()=> {
				return (0.5-Math.random());
			});
			this.hasNext = true
			// 重新加载数据
			if (this.mescroll) this.mescroll.resetUpScroll()
		},
		async onLoad(options) {
            if(options.userid) {
                this.userid=options.userid;
            } else {
                this.userid = "";
            }
			this.hasNext = true
			// 重新加载数据
			// if (this.mescroll) this.mescroll.resetUpScroll()
		},
		components: {
		},
		methods: {
			screenReset(){
				this.searchForm = {}
				this.search()
				this.$forceUpdate()
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			sortClick(type){
				if(this.listSort==type){
					if(this.listOrder == 'desc'){
						this.listOrder = 'asc'
					}else{
						this.listOrder = 'desc'
					}
				}else{
					this.listSort = type
					this.listOrder = 'desc'
				}
				this.search()
			},
            priceChange(price) {
                return Number(price).toFixed(2);
            },
            preHttp(str) {
                return str && str.substr(0,4)=='http';
            },
			//类别搜索
			// mescroll组件初始化的回调,可获取到mescroll对象
			mescrollInit(mescroll) {
				this.mescroll = mescroll;
			},
			/*下拉刷新的回调 */
			downCallback(mescroll) {
				this.hasNext = true
				// 重置分页参数页数为1
				mescroll.resetUpScroll()
			},
			/*上拉加载的回调: mescroll携带page的参数, 其中num:当前页 从1开始, size:每页数据条数,默认10 */
			async upCallback(mescroll) {
				let params = {
					page: mescroll.num,
					limit: mescroll.size,
				}
				params['sort'] = this.listSort;
				params['order'] = this.listOrder;

				if(this.searchForm.changdimingcheng){
					params['changdimingcheng'] = '%' + this.searchForm.changdimingcheng + '%'
				}
				if(this.searchForm.yonghuxingming){
					params['yonghuxingming'] = '%' + this.searchForm.yonghuxingming + '%'
				}
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`tixingxinxi`, params);
                } else {
                    res = await this.$api.list(`tixingxinxi`, params);
                }

				// 如果是第一页数据置空
				if (mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				this.$forceUpdate()
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				mescroll.endSuccess(mescroll.size, this.hasNext);
			},
			// 详情
			onDetailTap(item) {
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./detail?id=${item.id}&userid=`+this.userid)
			},
			onUpdate(e){
				this.onUpdateTap(e.currentTarget.dataset.row)
			},
			// 修改
			onUpdateTap(row){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update?id=${row.id}`)
			},
			// 添加
			onAddTap(){
                uni.setStorageSync("useridTag",this.userid);
				this.$utils.jump(`./add-or-update`)
			},
			onDelete(e){
				this.onDeleteTap(e.currentTarget.dataset.row.id)
			},
			onDeleteTap(id){
				var _this = this;
				uni.showModal({
					title: '提示',
					content: '是否确认删除',
					success: async function(res) {
						if (res.confirm) {
							await _this.$api.del('tixingxinxi', JSON.stringify([id]));
							_this.$utils.msg('删除成功');
							_this.hasNext = true
							// 重置分页参数页数为1
							_this.search()
						}
					}
				});
			},
			// 搜索
			async search(){
				this.mescroll.num = 1
				let searchForm = {
					page: this.mescroll.num,
					limit: this.mescroll.size,
				}
				searchForm['sort'] = this.listSort;
				searchForm['order'] = this.listOrder;

				if(this.searchForm.changdimingcheng){
					searchForm['changdimingcheng'] = '%' + this.searchForm.changdimingcheng + '%'
				}
				if(this.searchForm.yonghuxingming){
					searchForm['yonghuxingming'] = '%' + this.searchForm.yonghuxingming + '%'
				}
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`tixingxinxi`, searchForm);
                } else {
                    res = await this.$api.list(`tixingxinxi`, searchForm);
                }
				// 如果是第一页数据置空
				if (this.mescroll.num == 1) this.list = [];
				this.list = this.list.concat(res.data.list);
				
				let length = Math.ceil(this.list.length/6)
				let arr = [];
				for (let i = 0; i<length; i++){
					arr[i] = this.list.slice(i*6, (i+1)*6)
				}
				this.lists = arr
				if (res.data.list.length == 0) this.hasNext = false;
				this.mescroll.endSuccess(this.mescroll.size, this.hasNext);
				this.screenBoxShow = false
			}
		}
	};
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.category-one .tab {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 12rpx 12rpx 0;
		color: #9F6045;
		display: inline-block;
		font-size: 28rpx;
		border-color: #9F6045;
		line-height: 60rpx;
		border-radius: 0;
		background: none;
		width: 100%;
		border-width: 0 0 2rpx 0;
		border-style: solid;
		text-align: center;
		height: 60rpx;
	}
	
	.category-one .tab.active {
		cursor: pointer;
		padding: 0 20rpx;
		margin: 0 12rpx 12rpx 0;
		color: #fff;
		display: inline-block;
		font-size: 28rpx;
		border-color: #9F6045;
		line-height: 60rpx;
		border-radius: 0;
		background: none;
		width: 100%;
		border-width: 0 0 2rpx 0;
		border-style: solid;
		text-align: center;
		height: 60rpx;
	}
	.screenBox {
		padding: 20rpx 0 20rpx 0;
		transform: translate3d(100%, 0, 0);
		z-index: 666;
		top: 88rpx;
		background: #FFFFFF;
		width: 80%;
		position: fixed;
		right: 0;
		transition: transform .3s;
		height: 100%;
		.screenTab {
			border: 2rpx solid rgb(162, 144, 104);
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			background: none;
			width: calc(100% / 3 - 24rpx);
			line-height: 72rpx;
			text-align: center;
		}
		.screenTabActive {
			border-radius: 40rpx;
			margin: 10rpx 0 10rpx 0;
			color: #fff;
			background: #F8824E;
			width: calc(100% / 3 - 20rpx);
			line-height: 72rpx;
			text-align: center;
		}
	}
	.screenBoxActive {
		transform: translate3d(0, 0, 0);
	}
</style>
