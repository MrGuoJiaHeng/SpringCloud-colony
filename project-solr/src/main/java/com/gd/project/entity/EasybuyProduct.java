package com.gd.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭家恒
 * @since 2019-03-11
 */
public class EasybuyProduct extends Model<EasybuyProduct> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 价格
     */
    private Float price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 分类1
     */
    @TableField("categoryLevel1Id")
    private Integer categoryLevel1Id;

    /**
     * 分类2
     */
    @TableField("categoryLevel2Id")
    private Integer categoryLevel2Id;

    /**
     * 分类3
     */
    @TableField("categoryLevel3Id")
    private Integer categoryLevel3Id;

    /**
     * 文件名称
     */
    @TableField("fileName")
    private String fileName;

    /**
     * 是否删除(1：删除 0：未删除)
     */
    @TableField("isDelete")
    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCategoryLevel1Id() {
        return categoryLevel1Id;
    }

    public void setCategoryLevel1Id(Integer categoryLevel1Id) {
        this.categoryLevel1Id = categoryLevel1Id;
    }

    public Integer getCategoryLevel2Id() {
        return categoryLevel2Id;
    }

    public void setCategoryLevel2Id(Integer categoryLevel2Id) {
        this.categoryLevel2Id = categoryLevel2Id;
    }

    public Integer getCategoryLevel3Id() {
        return categoryLevel3Id;
    }

    public void setCategoryLevel3Id(Integer categoryLevel3Id) {
        this.categoryLevel3Id = categoryLevel3Id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "EasybuyProduct{" +
        "id=" + id +
        ", name=" + name +
        ", description=" + description +
        ", price=" + price +
        ", stock=" + stock +
        ", categoryLevel1Id=" + categoryLevel1Id +
        ", categoryLevel2Id=" + categoryLevel2Id +
        ", categoryLevel3Id=" + categoryLevel3Id +
        ", fileName=" + fileName +
        ", isDelete=" + isDelete +
        "}";
    }
}
