package cn.imlxy.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName : ProductForm
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-20 13:52
 */
@Data
public class ProductForm {

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

    /**类目编号**/
    private Integer categoryType;

}
