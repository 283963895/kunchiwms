package com.kunchiwms.wms.controller;

import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;


    import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kunchiwms.wms.service.MPTUserService;
import com.kunchiwms.wms.common.TableJSON;
import com.kunchiwms.wms.common.JSONResult;
import com.kunchiwms.wms.entity.TUser;
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
 *   @description : TUser 控制器
 *   ---------------------------------
 * 	 @author Jason
 *   @since 2018-08-09
 */
@Controller
@Api(value="/tUser", description="TUser 控制器")
@RequestMapping("/tUser")
public class TUserAction {
private final Logger logger = LoggerFactory.getLogger(TUserAction.class);

@Autowired
public MPTUserService tUserService;

/**
 * @description : 获取分页列表
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTUserList")
@ApiOperation(value="/getTUserList", notes="获取分页列表")
public TableJSON<TUser> getTUserList(@ApiParam(name="TUser",value="TUser 实体类")QueryWrapper<TUser> param ,
@ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
@ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
        TableJSON<TUser> resJson=new TableJSON<>();
        try {
        Page<TUser> page=new Page<TUser>(pageNo,length);
    tUserService.page(page, param);
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
 * @description : 通过id获取TUser
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@GetMapping("/getTUserById")
@ApiOperation(value="/getTUserById", notes="通过id获取TUser")
public JSONResult<TUser> getTUserById(@ApiParam(name="id",value="TUserID",required=true)Long id) {
        JSONResult<TUser> resJson = new JSONResult<>();
        try {
    TUser param= tUserService.getById(id);
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
 * @description : 通过id删除TUser
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@DeleteMapping("/deleteTUserById")
@ApiOperation(value="/deleteTUserById", notes="通过id删除TUser")
public JSONResult<TUser> deleteTUserById(@ApiParam(name="id",value="TUserID",required=true)Long id) {
        JSONResult<TUser> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tUserService.removeById(id));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 通过id更新TUser
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/updateTUserById")
@ApiOperation(value="/updateTUserById", notes="通过id更新TUser")
public JSONResult<TUser> updateTUserById(@ApiParam(name="TUser",value="TUser 实体类")TUser param) {
        JSONResult<TUser> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tUserService.updateById(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }

/**
 * @description : 添加TUser
 * ---------------------------------
 * @author : Jason
 * @since : Create in 2018-08-09
 */
@PutMapping("/addTUser")
@ApiOperation(value="/addTUser", notes="添加TUser")
public JSONResult<TUser> addTUser(@ApiParam(name="TUser",value="TUser 实体类")TUser param) {
        JSONResult<TUser> resJson = new JSONResult<>();
        try{
        resJson.setSuccess(tUserService.save(param));
        }catch (Exception e) {
        resJson.setSuccess(false);
        resJson.setMessage("异常信息:"+e.getClass().getName());
        logger.info("异常信息:{}",e.getMessage());
        }
        return resJson;
        }
        }