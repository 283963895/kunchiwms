package com.kunchiwms.wms.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;


    import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kunchiwms.wms.service.MPTInventoryService;
import com.kunchiwms.wms.common.TableJSON;
import com.kunchiwms.wms.common.JSONResult;
import com.kunchiwms.wms.entity.TInventory;
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
 *   @description : TInventory 控制器
 *   ---------------------------------
 * 	 @author Jason
 *   @since 2018-08-09
 */
@Controller
@Api(value="/tInventory", description="TInventory 控制器")
@RequestMapping("/tInventory")
public class TInventoryAction {
private final Logger logger = LoggerFactory.getLogger(TInventoryAction.class);

@Autowired
public MPTInventoryService tInventoryService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTInventoryList")
@ApiOperation(value="/getTInventoryList", notes="获取分页列表")
public TableJSON<TInventory> getTInventoryList(@ApiParam(name="TInventory",value="TInventory 实体类")QueryWrapper<TInventory> param ,
@ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
@ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        TableJSON<TInventory> resJson=new TableJSON<>();
        try {
        Page<TInventory> page=new Page<TInventory>(pageNo,length);
    tInventoryService.page(page, param);
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
 * @description : 通过id获取TInventory
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTInventoryById")
@ApiOperation(value="/getTInventoryById", notes="通过id获取TInventory")
public JSONResult<TInventory> getTInventoryById(@ApiParam(name="id",value="TInventoryID",required=true)Long id) {
        JSONResult<TInventory> resJson = new JSONResult<>();
        try {
    TInventory param= tInventoryService.getById(id);
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
 * @description : 通过id删除TInventory
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@DeleteMapping("/deleteTInventoryById")
@ApiOperation(value="/deleteTInventoryById", notes="通过id删除TInventory")
public JSONResult<TInventory> deleteTInventoryById(@ApiParam(name="id",value="TInventoryID",required=true)Long id) {
        JSONResult<TInventory> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tInventoryService.removeById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新TInventory
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/updateTInventoryById")
@ApiOperation(value="/updateTInventoryById", notes="通过id更新TInventory")
public JSONResult<TInventory> updateTInventoryById(@ApiParam(name="TInventory",value="TInventory 实体类")TInventory param) {
        JSONResult<TInventory> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tInventoryService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加TInventory
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/addTInventory")
@ApiOperation(value="/addTInventory", notes="添加TInventory")
public JSONResult<TInventory> addTInventory(@ApiParam(name="TInventory",value="TInventory 实体类")TInventory param) {
        JSONResult<TInventory> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tInventoryService.save(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }