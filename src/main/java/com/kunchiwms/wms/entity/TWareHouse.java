package com.kunchiwms.wms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jason
 * @since 2018-08-09
 */
public class TWareHouse extends Model<TWareHouse> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库编码
     */
    private String cWareHouseCode;

    /**
     * 仓库名称
     */
    private String cWareHouseName;

    /**
     * 创建日期
     */
    private LocalDateTime dtCreateTime;

    /**
     * 更新日期
     */
    private LocalDateTime upCreateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcWareHouseCode() {
        return cWareHouseCode;
    }

    public void setcWareHouseCode(String cWareHouseCode) {
        this.cWareHouseCode = cWareHouseCode;
    }

    public String getcWareHouseName() {
        return cWareHouseName;
    }

    public void setcWareHouseName(String cWareHouseName) {
        this.cWareHouseName = cWareHouseName;
    }

    public LocalDateTime getDtCreateTime() {
        return dtCreateTime;
    }

    public void setDtCreateTime(LocalDateTime dtCreateTime) {
        this.dtCreateTime = dtCreateTime;
    }

    public LocalDateTime getUpCreateTime() {
        return upCreateTime;
    }

    public void setUpCreateTime(LocalDateTime upCreateTime) {
        this.upCreateTime = upCreateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TWareHouse{" +
        ", id=" + id +
        ", cWareHouseCode=" + cWareHouseCode +
        ", cWareHouseName=" + cWareHouseName +
        ", dtCreateTime=" + dtCreateTime +
        ", upCreateTime=" + upCreateTime +
        "}";
    }
}
