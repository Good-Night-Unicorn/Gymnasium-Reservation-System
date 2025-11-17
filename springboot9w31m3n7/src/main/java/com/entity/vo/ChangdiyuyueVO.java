package com.entity.vo;

import com.entity.ChangdiyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 场地预约
 * @author 
 * @email 
 * @date 2025-02-27 11:33:35
 */
public class ChangdiyuyueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 场地名称
	 */
	
	private String changdimingcheng;
		
	/**
	 * 场地类型
	 */
	
	private String changdileixing;
		
	/**
	 * 场地图片
	 */
	
	private String changditupian;
		
	/**
	 * 场地位置
	 */
	
	private String changdiweizhi;
		
	/**
	 * 小时价格
	 */
	
	private Double xiaoshijiage;
		
	/**
	 * 预约时长
	 */
	
	private Double yuyueshizhang;
		
	/**
	 * 总费用
	 */
	
	private Double zongfeiyong;
		
	/**
	 * 预约时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yuyueshijian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 预约内容
	 */
	
	private String yuyueneirong;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：场地名称
	 */
	 
	public void setChangdimingcheng(String changdimingcheng) {
		this.changdimingcheng = changdimingcheng;
	}
	
	/**
	 * 获取：场地名称
	 */
	public String getChangdimingcheng() {
		return changdimingcheng;
	}
				
	
	/**
	 * 设置：场地类型
	 */
	 
	public void setChangdileixing(String changdileixing) {
		this.changdileixing = changdileixing;
	}
	
	/**
	 * 获取：场地类型
	 */
	public String getChangdileixing() {
		return changdileixing;
	}
				
	
	/**
	 * 设置：场地图片
	 */
	 
	public void setChangditupian(String changditupian) {
		this.changditupian = changditupian;
	}
	
	/**
	 * 获取：场地图片
	 */
	public String getChangditupian() {
		return changditupian;
	}
				
	
	/**
	 * 设置：场地位置
	 */
	 
	public void setChangdiweizhi(String changdiweizhi) {
		this.changdiweizhi = changdiweizhi;
	}
	
	/**
	 * 获取：场地位置
	 */
	public String getChangdiweizhi() {
		return changdiweizhi;
	}
				
	
	/**
	 * 设置：小时价格
	 */
	 
	public void setXiaoshijiage(Double xiaoshijiage) {
		this.xiaoshijiage = xiaoshijiage;
	}
	
	/**
	 * 获取：小时价格
	 */
	public Double getXiaoshijiage() {
		return xiaoshijiage;
	}
				
	
	/**
	 * 设置：预约时长
	 */
	 
	public void setYuyueshizhang(Double yuyueshizhang) {
		this.yuyueshizhang = yuyueshizhang;
	}
	
	/**
	 * 获取：预约时长
	 */
	public Double getYuyueshizhang() {
		return yuyueshizhang;
	}
				
	
	/**
	 * 设置：总费用
	 */
	 
	public void setZongfeiyong(Double zongfeiyong) {
		this.zongfeiyong = zongfeiyong;
	}
	
	/**
	 * 获取：总费用
	 */
	public Double getZongfeiyong() {
		return zongfeiyong;
	}
				
	
	/**
	 * 设置：预约时间
	 */
	 
	public void setYuyueshijian(Date yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	
	/**
	 * 获取：预约时间
	 */
	public Date getYuyueshijian() {
		return yuyueshijian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
				
	
	/**
	 * 设置：预约内容
	 */
	 
	public void setYuyueneirong(String yuyueneirong) {
		this.yuyueneirong = yuyueneirong;
	}
	
	/**
	 * 获取：预约内容
	 */
	public String getYuyueneirong() {
		return yuyueneirong;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
