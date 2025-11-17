<template>
<!-- category 1 -->
	<mescroll-uni @init="mescrollInit" :up="upOption" :down="downOption" @down="downCallback" @up="upCallback">
		<view class="content">
			<view :style='{"minHeight":"100%","width":"100%","padding":"0","position":"relative","background":"#FFF8F5","height":"auto"}'>
				<view class="cu-bar bg-white search" :style='{"padding":"20rpx 24rpx","margin":"0","background":"linear-gradient( 270deg, #F5C18C 0%, #F77E4D 48%, #FFAF4F 100%)","display":"flex","width":"100%","position":"relative","height":"auto"}'>
					<view :style='{"border":"none","margin":"0","borderRadius":"20rpx","flex":"1","background":"none","lineHeight":"80rpx","position":"relative","height":"80rpx"}' class="search-form round">
						<text class="icon iconfont icon-fangdajing07" :style='{"color":"rgb(153, 153, 153)","left":"0px","textAlign":"center","width":"80rpx","fontSize":"40rpx","lineHeight":"80rpx","position":"absolute","right":"0px"}'></text>
						<input placeholder-style="color: #000" :style='{"border":"0","padding":"12rpx 20rpx 12rpx 80rpx","color":"#000","borderRadius":"40rpx","background":"#fff","width":"100%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' v-model="searchForm.name" type="text" placeholder="名称" ></input>
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
					<view class="uni-product-list" :style='{"padding":"0","margin":"0","flexWrap":"wrap","flex":"auto","background":"#fff","display":"flex","width":"0","justifyContent":"space-between","height":"auto"}'>
						<view @tap="onDetailTap(product)" class="uni-product" :style='{"boxShadow":"none","padding":"30rpx","margin":"0 0 20rpx","backgroundColor":"transparent","overflow":"hidden","borderRadius":"180rpx 180rpx 10rpx 10rpx","flexWrap":"wrap","background":"linear-gradient(135.00deg, rgb(58, 44, 88) 0.645%,rgb(65, 46, 96) 52.529%,rgb(58, 44, 88) 100%)","display":"flex","width":"48%","height":"auto"}' v-for="(product,index) in list" :key="index">
							<view class="uni-product-title " :style='{"padding":"4rpx 20rpx","overflow":"hidden","color":"#FFFFFF","maxHeight":"96rpx","width":"100%","lineHeight":"48rpx","fontSize":"32rpx","order":"2"}'>{{product.name}}</view>
							<image :style='{"border":"20rpx solid #4D357B","padding":"0","margin":"0","objectFit":"cover","borderRadius":"50%","display":"block","width":"100%","height":"280rpx","order":"1"}' mode="aspectFill" class="uni-product-image" v-if="product.tablename.substr(0,7)=='chapter'" src="/static/chapter.jpg"></image>
							<image :style='{"border":"20rpx solid #4D357B","padding":"0","margin":"0","objectFit":"cover","borderRadius":"50%","display":"block","width":"100%","height":"280rpx","order":"1"}' mode="aspectFill" class="uni-product-image" v-else-if="preHttp(product.picture)" :src="product.picture"></image>
							<image :style='{"border":"20rpx solid #4D357B","padding":"0","margin":"0","objectFit":"cover","borderRadius":"50%","display":"block","width":"100%","height":"280rpx","order":"1"}' mode="aspectFill" class="uni-product-image" v-else :src="baseUrl+product.picture"></image>
						</view>
					</view>

			
			
			
			
				</view>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"20rpx 20rpx 0 ","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"#F66725","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="userid && isAuth('storeup','新增')" class="add-btn" @click="onAddTap()">新增</button>
				<button :style='{"border":"0","boxShadow":"0 2rpx 12rpx rgba(0,0,0,.3)","margin":"20rpx 20rpx 0 ","color":"rgb(255, 255, 255)","bottom":"0","right":"0","outline":"none","borderRadius":"20rpx","background":"#F66725","width":"120rpx","lineHeight":"70rpx","fontSize":"28rpx","position":"relative","height":"70rpx","zIndex":"1"}' v-if="!userid && isAuthFront('storeup','新增')" class="add-btn" @click="onAddTap()">新增</button>
			</view>
		</view>
	</mescroll-uni>
</template>

<script>
	export default {
		data() {
			return {
				btnColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				clicknumColor: ['#409eff','#67c23a','#909399','#e6a23c','#f56c6c','#356c6c','#351c6c','#f093a9','#a7c23a','#104eff','#10441f','#a21233','#503319'],
				list: [],
				lists: [],
                userid: '',
                type: 1,
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
					name: '',
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
			this.clicknumColor = this.clicknumColor.sort(()=> {
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
            if(options.menuJump) {
                this.type=options.menuJump;
            } else {
                this.type = 1;
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

				if(this.searchForm.name){
					params['name'] = '%' + this.searchForm.name + '%'
				}
				params['type']=this.type;
				let user = uni.getStorageSync("appUserid")?JSON.parse(uni.getStorageSync('userSession')):{}
                let res = {}
                if(this.userid) {
                    res = await this.$api.page(`storeup`, params);
                } else {
                    res = await this.$api.list(`storeup`, params);
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
				if(item.tablename =='news'){
					this.$utils.jump(`../news-detail/news-detail?id=${item.refid}`)
					return false
				}
				if(item.tablename =='forum'){
					this.$utils.jump(`../forum-detail/forum-detail?id=${item.refid}`)
					return false
				}
				if(item.tablename.substr(0,7)=='chapter'){
					let tablename = item.tablename.substr(7,item.tablename.length)
					this.$utils.jump(`../${tablename}/chapter?id=${item.refid}&refid=${item.remark}`)
					return false
				}
				this.$utils.jump(`../${item.tablename}/detail?id=${item.refid}`)
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
							await _this.$api.del('storeup', JSON.stringify([id]));
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

				if(this.searchForm.name){
					searchForm['name'] = '%' + this.searchForm.name + '%'
				}
				searchForm['type']=this.type;
                let res = {};
                if(this.userid) {
                    res = await this.$api.page(`storeup`, searchForm);
                } else {
                    res = await this.$api.list(`storeup`, searchForm);
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
</style>
