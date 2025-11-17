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

import com.entity.ChangdiyuyueEntity;
import com.entity.view.ChangdiyuyueView;

import com.service.ChangdiyuyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 场地预约
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-27 11:33:35
 */
@RestController
@RequestMapping("/changdiyuyue")
public class ChangdiyuyueController {
    @Autowired
    private ChangdiyuyueService changdiyuyueService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChangdiyuyueEntity changdiyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			changdiyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();


        //查询结果
		PageUtils page = changdiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuyue), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChangdiyuyueEntity changdiyuyue, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();

        //查询结果
		PageUtils page = changdiyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiyuyue), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChangdiyuyueEntity changdiyuyue){
       	EntityWrapper<ChangdiyuyueEntity> ew = new EntityWrapper<ChangdiyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( changdiyuyue, "changdiyuyue")); 
        return R.ok().put("data", changdiyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdiyuyueEntity changdiyuyue){
        EntityWrapper< ChangdiyuyueEntity> ew = new EntityWrapper< ChangdiyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( changdiyuyue, "changdiyuyue")); 
		ChangdiyuyueView changdiyuyueView =  changdiyuyueService.selectView(ew);
		return R.ok("查询场地预约成功").put("data", changdiyuyueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChangdiyuyueEntity changdiyuyue = changdiyuyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdiyuyue,deSens);
        return R.ok().put("data", changdiyuyue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChangdiyuyueEntity changdiyuyue = changdiyuyueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(changdiyuyue,deSens);
        return R.ok().put("data", changdiyuyue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdiyuyue);
        changdiyuyueService.insert(changdiyuyue);
        return R.ok().put("data",changdiyuyue.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdiyuyue);
        changdiyuyueService.insert(changdiyuyue);
        return R.ok().put("data",changdiyuyue.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdiyuyueEntity changdiyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(changdiyuyue);
        //全部更新
        changdiyuyueService.updateById(changdiyuyue);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        changdiyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
