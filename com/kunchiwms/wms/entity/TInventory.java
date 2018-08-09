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
public class TInventory extends Model<TInventory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 商品ID
     */
         private Integer iProductID;

        /**
     * 仓库编码
     */
         private String cWareHouseCode;

        /**
     * 结存
     */
         private Integer iCount;

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

    public Integer getiProductID() {
        return iProductID;
    }

    public void setiProductID(Integer iProductID) {
        this.iProductID = iProductID;
    }

    public String getcWareHouseCode() {
        return cWareHouseCode;
    }

    public void setcWareHouseCode(String cWareHouseCode) {
        this.cWareHouseCode = cWareHouseCode;
    }

    public Integer getiCount() {
        return iCount;
    }

    public void setiCount(Integer iCount) {
        this.iCount = iCount;
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
        return "TInventory{" +
        "id=" + id +
        ", iProductID=" + iProductID +
        ", cWareHouseCode=" + cWareHouseCode +
        ", iCount=" + iCount +
        ", dtCreateTime=" + dtCreateTime +
        ", dtUpdateTime=" + dtUpdateTime +
        "}";
    }
}
