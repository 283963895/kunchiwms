package com.kunchiwms.wms.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;


    import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kunchiwms.wms.service.MPTWareHouseService;
import com.kunchiwms.wms.common.TableJSON;
import com.kunchiwms.wms.common.JSONResult;
import com.kunchiwms.wms.entity.TWareHouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.*;


/**
 *code is far away from bug with the animal protecting
 *  ┏┓　　　┏┓
 *┏┛┻━━━┛┻┓
 *┃　　　　　　　┃ 　
 *┃　　　━　　　┃
 *┃　┳┛　┗┳　┃
 *┃　　　　　　　┃
 *┃　　　┻　　　┃
 *┃　　　　　　　┃
 *┗━┓　　　┏━┛
 *　　┃　　　┃神兽保佑
 *　　┃　　　┃代码无BUG！
 *　　┃　　　┗━━━┓
 *　　┃　　　　　　　┣┓
 *　　┃　　　　　　　┏┛
 *　　┗┓┓┏━┳┓┏┛
 *　　　┃┫┫　┃┫┫
 *　　　┗┻┛　┗┻┛
 *
 *   @description : TWareHouse 控制器
 *   ---------------------------------
 * 	 @author Jason
 *   @since 2018-08-09
 */
@Controller
@Api(value="/tWareHouse", description="TWareHouse 控制器")
@RequestMapping("/tWareHouse")
public class TWareHouseAction {
private final Logger logger = LoggerFactory.getLogger(TWareHouseAction.class);

@Autowired
public MPTWareHouseService tWareHouseService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTWareHouseList")
@ApiOperation(value="/getTWareHouseList", notes="获取分页列表")
public TableJSON<TWareHouse> getTWareHouseList(@ApiParam(name="TWareHouse",value="TWareHouse 实体类")QueryWrapper<TWareHouse> param ,
@ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
@ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        TableJSON<TWareHouse> resJson=new TableJSON<>();
        try {
        Page<TWareHouse> page=new Page<TWareHouse>(pageNo,length);
    tWareHouseService.page(page, param);
        resJson.setRecordsTotal((int)page.getTotal());
        resJson.setData(page.getRecords());
        resJson.setSuccess(true);
        }catch (Exception e){
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id获取TWareHouse
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTWareHouseById")
@ApiOperation(value="/getTWareHouseById", notes="通过id获取TWareHouse")
public JSONResult<TWareHouse> getTWareHouseById(@ApiParam(name="id",value="TWareHouseID",required=true)Long id) {
        JSONResult<TWareHouse> resJson = new JSONResult<>();
        try {
    TWareHouse param= tWareHouseService.getById(id);
        resJson.setData(param);
        resJson.setSuccess(true);
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id删除TWareHouse
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@DeleteMapping("/deleteTWareHouseById")
@ApiOperation(value="/deleteTWareHouseById", notes="通过id删除TWareHouse")
public JSONResult<TWareHouse> deleteTWareHouseById(@ApiParam(name="id",value="TWareHouseID",required=true)Long id) {
        JSONResult<TWareHouse> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tWareHouseService.removeById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新TWareHouse
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/updateTWareHouseById")
@ApiOperation(value="/updateTWareHouseById", notes="通过id更新TWareHouse")
public JSONResult<TWareHouse> updateTWareHouseById(@ApiParam(name="TWareHouse",value="TWareHouse 实体类")TWareHouse param) {
        JSONResult<TWareHouse> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tWareHouseService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加TWareHouse
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/addTWareHouse")
@ApiOperation(value="/addTWareHouse", notes="添加TWareHouse")
public JSONResult<TWareHouse> addTWareHouse(@ApiParam(name="TWareHouse",value="TWareHouse 实体类")TWareHouse param) {
        JSONResult<TWareHouse> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tWareHouseService.save(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }