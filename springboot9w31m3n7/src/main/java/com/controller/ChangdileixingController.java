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

import com.entity.ChangdileixingEntity;
import com.entity.view.ChangdileixingView;

import com.service.ChangdileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场地类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-27 11:33:35
 */
@RestController
@RequestMapping("/changdileixing")
public class ChangdileixingController {
    @Autowired
    private ChangdileixingService changdileixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdileixingEntity changdileixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();


        //查询结果
		PageUtils page = changdileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdileixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChangdileixingEntity changdileixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();

        //查询结果
		PageUtils page = changdileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdileixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdileixingEntity changdileixing){
       	EntityWrapper<ChangdileixingEntity> ew = new EntityWrapper<ChangdileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdileixing, "changdileixing")); 
        return R.ok().put("data", changdileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdileixingEntity changdileixing){
        EntityWrapper< ChangdileixingEntity> ew = new EntityWrapper< ChangdileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdileixing, "changdileixing")); 
		ChangdileixingView changdileixingView =  changdileixingService.selectView(ew);
		return R.ok("查询场地类型成功").put("data", changdileixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdileixingEntity changdileixing = changdileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdileixing,deSens);
        return R.ok().put("data", changdileixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdileixingEntity changdileixing = changdileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdileixing,deSens);
        return R.ok().put("data", changdileixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdileixing);
        changdileixingService.insert(changdileixing);
        return R.ok().put("data",changdileixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdileixing);
        changdileixingService.insert(changdileixing);
        return R.ok().put("data",changdileixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdileixingEntity changdileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdileixing);
        //全部更新
        changdileixingService.updateById(changdileixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
