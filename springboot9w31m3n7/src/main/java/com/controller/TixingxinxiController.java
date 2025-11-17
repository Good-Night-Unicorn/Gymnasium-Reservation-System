package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TixingxinxiEntity;
import com.entity.view.TixingxinxiView;

import com.service.TixingxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 提醒信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-27 11:33:36
 */
@RestController
@RequestMapping("/tixingxinxi")
public class TixingxinxiController {
    @Autowired
    private TixingxinxiService tixingxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TixingxinxiEntity tixingxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tixingxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<TixingxinxiEntity> ew = new EntityWrapper<TixingxinxiEntity>();


        //查询结果
		PageUtils page = tixingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TixingxinxiEntity tixingxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<TixingxinxiEntity> ew = new EntityWrapper<TixingxinxiEntity>();

        //查询结果
		PageUtils page = tixingxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tixingxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TixingxinxiEntity tixingxinxi){
       	EntityWrapper<TixingxinxiEntity> ew = new EntityWrapper<TixingxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tixingxinxi, "tixingxinxi")); 
        return R.ok().put("data", tixingxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TixingxinxiEntity tixingxinxi){
        EntityWrapper< TixingxinxiEntity> ew = new EntityWrapper< TixingxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tixingxinxi, "tixingxinxi")); 
		TixingxinxiView tixingxinxiView =  tixingxinxiService.selectView(ew);
		return R.ok("查询提醒信息成功").put("data", tixingxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TixingxinxiEntity tixingxinxi = tixingxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixingxinxi,deSens);
        return R.ok().put("data", tixingxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TixingxinxiEntity tixingxinxi = tixingxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(tixingxinxi,deSens);
        return R.ok().put("data", tixingxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TixingxinxiEntity tixingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingxinxi);
        tixingxinxiService.insert(tixingxinxi);
        return R.ok().put("data",tixingxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TixingxinxiEntity tixingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingxinxi);
        tixingxinxiService.insert(tixingxinxi);
        return R.ok().put("data",tixingxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TixingxinxiEntity tixingxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tixingxinxi);
        //全部更新
        tixingxinxiService.updateById(tixingxinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tixingxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
