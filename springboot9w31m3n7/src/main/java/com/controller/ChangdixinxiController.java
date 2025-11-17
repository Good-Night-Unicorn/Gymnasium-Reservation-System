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

import com.entity.ChangdixinxiEntity;
import com.entity.view.ChangdixinxiView;

import com.service.ChangdixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 场地信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-27 11:33:35
 */
@RestController
@RequestMapping("/changdixinxi")
public class ChangdixinxiController {
    @Autowired
    private ChangdixinxiService changdixinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();


        //查询结果
		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChangdixinxiEntity changdixinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();

        //查询结果
		PageUtils page = changdixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdixinxiEntity changdixinxi){
       	EntityWrapper<ChangdixinxiEntity> ew = new EntityWrapper<ChangdixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
        return R.ok().put("data", changdixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdixinxiEntity changdixinxi){
        EntityWrapper< ChangdixinxiEntity> ew = new EntityWrapper< ChangdixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdixinxi, "changdixinxi")); 
		ChangdixinxiView changdixinxiView =  changdixinxiService.selectView(ew);
		return R.ok("查询场地信息成功").put("data", changdixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdixinxiEntity changdixinxi = changdixinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdixinxi,deSens);
        return R.ok().put("data", changdixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok().put("data",changdixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdixinxi);
        changdixinxiService.insert(changdixinxi);
        return R.ok().put("data",changdixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdixinxiEntity changdixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdixinxi);
        //全部更新
        changdixinxiService.updateById(changdixinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
