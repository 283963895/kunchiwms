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
 * @author Yanghu
 * @since 2018-08-08
 */
public class TProduct extends Model<TProduct> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 产品条码
     */
         private String cProductCode;

        /**
     * 产品名称
     */
         private String cProductName;

        /**
     * 创建日期
     */
         private LocalDateTime dtCreateTime;

        /**
     * 更新日期
     */
         private LocalDateTime dtUpdateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcProductCode() {
        return cProductCode;
    }

    public void setcProductCode(String cProductCode) {
        this.cProductCode = cProductCode;
    }

    public String getcProductName() {
        return cProductName;
    }

    public void setcProductName(String cProductName) {
        this.cProductName = cProductName;
    }

    public LocalDateTime getDtCreateTime() {
        return dtCreateTime;
    }

    public void setDtCreateTime(LocalDateTime dtCreateTime) {
        this.dtCreateTime = dtCreateTime;
    }

    public LocalDateTime getDtUpdateTime() {
        return dtUpdateTime;
    }

    public void setDtUpdateTime(LocalDateTime dtUpdateTime) {
        this.dtUpdateTime = dtUpdateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TProduct{" +
        "id=" + id +
        ", cProductCode=" + cProductCode +
        ", cProductName=" + cProductName +
        ", dtCreateTime=" + dtCreateTime +
        ", dtUpdateTime=" + dtUpdateTime +
        "}";
    }
}
