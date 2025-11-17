package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 提醒信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-02-27 11:33:36
 */
@TableName("tixingxinxi")
public class TixingxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TixingxinxiEntity() {
		
	}
	
	public TixingxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
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
	 * 提醒时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tixingshijian;
	
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
	 * 提醒内容
	 */
					
	private String tixingneirong;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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
	 * 设置：提醒时间
	 */
	public void setTixingshijian(Date tixingshijian) {
		this.tixingshijian = tixingshijian;
	}
	/**
	 * 获取：提醒时间
	 */
	public Date getTixingshijian() {
		return tixingshijian;
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
	 * 设置：提醒内容
	 */
	public void setTixingneirong(String tixingneirong) {
		this.tixingneirong = tixingneirong;
	}
	/**
	 * 获取：提醒内容
	 */
	public String getTixingneirong() {
		return tixingneirong;
	}

}
