package com.kunchiwms.wms.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;


    import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kunchiwms.wms.service.MPTProductService;
import com.kunchiwms.wms.common.TableJSON;
import com.kunchiwms.wms.common.JSONResult;
import com.kunchiwms.wms.entity.TProduct;
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
 *   @description : TProduct 控制器
 *   ---------------------------------
 * 	 @author Jason
 *   @since 2018-08-09
 */
@Controller
@Api(value="/tProduct", description="TProduct 控制器")
@RequestMapping("/tProduct")
public class TProductAction {
private final Logger logger = LoggerFactory.getLogger(TProductAction.class);

@Autowired
public MPTProductService tProductService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTProductList")
@ApiOperation(value="/getTProductList", notes="获取分页列表")
public TableJSON<TProduct> getTProductList(@ApiParam(name="TProduct",value="TProduct 实体类")QueryWrapper<TProduct> param ,
@ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
@ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        TableJSON<TProduct> resJson=new TableJSON<>();
        try {
        Page<TProduct> page=new Page<TProduct>(pageNo,length);
    tProductService.page(page, param);
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
 * @description : 通过id获取TProduct
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTProductById")
@ApiOperation(value="/getTProductById", notes="通过id获取TProduct")
public JSONResult<TProduct> getTProductById(@ApiParam(name="id",value="TProductID",required=true)Long id) {
        JSONResult<TProduct> resJson = new JSONResult<>();
        try {
    TProduct param= tProductService.getById(id);
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
 * @description : 通过id删除TProduct
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@DeleteMapping("/deleteTProductById")
@ApiOperation(value="/deleteTProductById", notes="通过id删除TProduct")
public JSONResult<TProduct> deleteTProductById(@ApiParam(name="id",value="TProductID",required=true)Long id) {
        JSONResult<TProduct> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tProductService.removeById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新TProduct
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/updateTProductById")
@ApiOperation(value="/updateTProductById", notes="通过id更新TProduct")
public JSONResult<TProduct> updateTProductById(@ApiParam(name="TProduct",value="TProduct 实体类")TProduct param) {
        JSONResult<TProduct> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tProductService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加TProduct
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/addTProduct")
@ApiOperation(value="/addTProduct", notes="添加TProduct")
public JSONResult<TProduct> addTProduct(@ApiParam(name="TProduct",value="TProduct 实体类")TProduct param) {
        JSONResult<TProduct> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tProductService.save(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }