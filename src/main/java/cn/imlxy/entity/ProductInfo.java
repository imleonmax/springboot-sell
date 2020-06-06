package cn.imlxy.entity;

import cn.imlxy.enums.ProductStatusEnum;
import cn.imlxy.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName : ProductInfo
 * @Description : 商品
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-10 21:17
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo implements Serializable{
    private static final long serialVersionUID = 8209277437135944434L;
    @Id
    private  String productId;

    /**名字**/
    private String productName;

    /**单价**/
    private BigDecimal productPrice;

    /**库存**/
    private Integer productStock;

    /**描述**/
    private String productDescription;

    /**小图**/
    private String productIcon;

    /**状态，0正常，1下架**/
    private Integer productStatus=ProductStatusEnum.UP.getCode();

    /**类目编号**/
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
    }

}