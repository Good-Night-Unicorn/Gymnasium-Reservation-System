<template>
	<view :style='{"minHeight":"100%","padding":"20rpx","color":"#000","background":"#FFF8F5","width":"100%","position":"relative","height":"auto"}'>
		<view class="title" :style='{"lineHeight":"1.5","fontSize":"32rpx","color":"inherit","textAlign":"center","background":"none","fontWeight":"600"}'>{{detail.title}}</view>
		
		<view :style='{"padding":"0 0 12rpx 0","borderColor":"#C4C4C4","alignItems":"center","color":"#8D8D8D","borderWidth":"0 0 2rpx 0","background":"none","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"center"}'>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
		    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>发布时间：{{detail.addtime}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
		    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.name}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
		    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.thumbsupnum}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
		    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.storeupnum}}</text>
		  </view>
		  <view :style='{"padding":"0"}'>
		    <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
		    <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{detail.clicknum}}</text>
		  </view>
		</view>
		
		<view :style='{"margin":"20rpx 0 0","background":"none","justifyContent":"flex-end","display":"flex"}'>
		  <view :style='{"width":"120rpx","background":"#F66725","justifyContent":"center","display":"flex"}' @click="likeClick">
		    <text class="icon iconfont" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' :class="likeType?'icon-zan10':'icon-zan10'"></text>
		    <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"28rpx"}'>{{likeType?'已':''}}赞</text>
		  </view>
		  <view :style='{"width":"160rpx","background":"#797979","justifyContent":"center","display":"flex"}' @click="collectClick">
		    <text class="icon iconfont" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"28rpx","color":"#fff"}' :class="collectType?'icon-shoucang10':'icon-shoucang10'"></text>
		    <text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"28rpx"}'>{{collectType?'已':''}}收藏</text>
		  </view>
		</view>
		
		<view class="content" :style='{"width":"100%","color":"inherit","background":"none","height":"auto"}'>
			<rich-text :nodes="detail.content"></rich-text>
		</view>
		
		<div :style='{"width":"100%","padding":"0 40rpx","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
		  <div @click="prepDetailClick" :style='{"padding":"0 20rpx","color":"#fff","background":"#F66725","flex":"auto","width":"0","lineHeight":"80rpx","fontSize":"28rpx"}'>上一篇：prev</div>
		  <div @click="nextDetailClick" :style='{"padding":"0 20rpx","color":"#fff","background":"#797979","flex":"auto","width":"0","lineHeight":"80rpx","fontSize":"28rpx"}'>下一篇：next</div>
		</div>
		

		<!-- 热门 -->
		<view class="hot" :style='{"width":"100%","padding":"0 0 40rpx 0","margin":"40rpx 0 0","background":"none","height":"auto"}'>
		  <view :style='{"padding":"0 0 0 60rpx","margin":"0","color":"#fff","alignItems":"center","background":"#F8824E","display":"flex","width":"100%","fontSize":"32rpx","position":"relative","justifyContent":"left","height":"58rpx"}'>热门信息</view>
		  <view :style='{"padding":"0","margin":"20rpx 0 0","background":"none","flexDirection":"column","display":"flex","width":"100%","height":"auto"}'>
		    <view v-for="(item,index) in hotList" :key="index" :style='{"border":"none","padding":"30rpx","margin":"20rpx auto 0","alignItems":"center","borderRadius":"20rpx","background":"#FFFFFF","flexDirection":"column","display":"flex","width":"calc(100% - 40rpx)","position":"relative","justifyContent":"center","height":"auto"}' @click="toDetail(item.id)">
			  <image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"160rpx"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
		      <view :style='{"padding":"0","overflow":"hidden","color":"#000000","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600","height":"48rpx"}'>{{ item.title }}</view>
		      <view :style='{"padding":"8rpx","color":"#959595","textAlign":"right","background":"none","width":"100%","lineHeight":"24rpx","fontSize":"24rpx"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>
		<!-- 推荐 -->
		<view class="recommend" :style='{"width":"100%","padding":"0 0 40rpx 0","margin":"40rpx 0 0","background":"none","height":"auto"}'>
		  <view :style='{"padding":"0 0 0 60rpx","margin":"0","color":"#fff","alignItems":"center","background":"#F8824E","display":"flex","width":"100%","fontSize":"32rpx","position":"relative","justifyContent":"left","height":"58rpx"}'>推荐信息</view>
		  <view :style='{"padding":"0","margin":"20rpx 0 0","background":"none","flexDirection":"column","display":"flex","width":"100%","height":"auto"}'>
		    <view v-for="(item,index) in recommendList" :key="index" :style='{"border":"none","padding":"30rpx","margin":"20rpx auto 0","alignItems":"center","borderRadius":"20rpx","background":"#FFFFFF","flexDirection":"column","display":"flex","width":"calc(100% - 40rpx)","position":"relative","justifyContent":"center","height":"auto"}' @click="toDetail(item.id)">
		      <image :style='{"width":"100%","objectFit":"cover","borderRadius":"10rpx","display":"block","height":"160rpx"}' mode="aspectFill" :src="baseUrl + item.picture"></image>
			  <view :style='{"padding":"0","overflow":"hidden","color":"#000000","textAlign":"left","width":"100%","lineHeight":"48rpx","fontSize":"28rpx","fontWeight":"600","height":"48rpx"}'>{{ item.title }}</view>
		      <view :style='{"padding":"8rpx","color":"#959595","textAlign":"right","background":"none","width":"100%","lineHeight":"24rpx","fontSize":"24rpx"}'>{{ item.addtime }}</view>
		    </view>
		  </view>
		</view>

	</view>
</template>
<script>
	export default {
		data() {
			return {
				detail: {},
				id: '',
				likeType: false,
				likeForm: {},
				collectType: false,
				collectForm: {},
				allList: [],
				currentIndex: 0,
				hotList: [],
				recommendList: [],
			}
		},
		async onLoad(options) {
			this.id = options.id;
			this.getInfo()
			
			this.getHotList()
			this.getRecommendList()
		},
		computed:{
			baseUrl() {
				return this.$base.url;
			},
			userid(){
				return uni.getStorageSync('appUserid')
			}
		},
		methods: {
			async getInfo(){
				let res = await this.$api.info('news', this.id)
				res.data.content = res.data.content.replace(/<img/g,'<img style="width: 100%;"');
				this.detail = res.data;
				uni.pageScrollTo({
					scrollTop: 0,
					duration: 100,
				})
				this.getLike()
				this.getCollect()
				res = await this.$api.list('news',{page:1,limit:100,sort:'addtime',order:'desc'})
				for(let x in res.data.list){
					if(res.data.list[x].id == this.id){
						this.currentIndex = Number(x)
						break
					}
				}
				this.allList = res.data.list
				
			},
			// 获取点赞状态
			async getLike() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: 21,
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.likeType = true
					this.likeForm = res.data.list[0]
				} else {
					this.likeType = false
					this.likeForm = {}
				}
			},
			// 获取热门列表
			async getHotList(){
				let res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				this.hotList = res.data.list;
			},
			// 获取推荐列表	
			async getRecommendList(){
				let res;
				if(uni.getStorageSync("appUserid")){
					res = await this.$api.recommend2('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}else{
					res = await this.$api.recommend('news',{page:1, limit: 4,sort:'addtime',order:'desc'})
				}
				
				this.recommendList = res.data.list;
			},
			// 上一篇
			prepDetailClick(){
				if(this.currentIndex == 0){
					this.$message.error('已经是第一篇了')
					return false
				}
				this.currentIndex--
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			// 下一篇
			nextDetailClick(){
				if(this.currentIndex == this.allList.length - 1){
					this.$message.error('已经是最后一篇了')
					return false
				}
				this.currentIndex++
				this.id = this.allList[this.currentIndex].id
				this.getInfo()
			},
			toDetail(id){
				this.id = id
				this.getInfo()
			},
			// 获取收藏状态
			async getCollect() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: 1,
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'news'
				})
				if (res.data.list.length) {
					this.collectType = true
					this.collectForm = res.data.list[0]
				} else {
					this.collectType = false
					this.collectForm = {}
				}
			},
			// 点赞按钮
			async likeClick() {
				let that = this
				if (this.likeType) {
					uni.showModal({
						title: '提示',
						content: '是否取消点赞？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.likeForm.id]))
								that.$utils.msg('取消成功')
								that.detail.thumbsupnum--
								await that.$api.update('news', that.detail)
								that.getLike()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: 21,
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('点赞成功')
					that.detail.thumbsupnum++
					await that.$api.update('news', that.detail)
					this.getLike()
				}
			},
			// 收藏按钮
			async collectClick() {
				let that = this
				if (this.collectType) {
					uni.showModal({
						title: '提示',
						content: '是否取消收藏？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.collectForm.id]))
								that.$utils.msg('取消成功')
								that.detail.storeupnum--
								await that.$api.update('news', that.detail)
								that.getCollect()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: 1,
						name: this.detail.title,
						picture: this.detail.picture,
						tablename: 'news',
					})
					this.$utils.msg('收藏成功')
					that.detail.storeupnum++
					await that.$api.update('news', that.detail)
					this.getCollect()
				}
			},
		}
	}
</script>

<style scoped lang="scss">
	page {
		background: #FFFFFF;
	}
</style>
