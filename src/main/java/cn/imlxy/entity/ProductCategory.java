package cn.imlxy.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName : ProductCategory
 * @Description : 类目
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-10 20:19
 */
@Data
@DynamicUpdate
@Entity
public class ProductCategory {
    /**类目id.**/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**类目名字**/
    private String categoryName;
    /** 类目编号**/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}