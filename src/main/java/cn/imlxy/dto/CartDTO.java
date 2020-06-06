package cn.imlxy.dto;

import lombok.Data;

/**
 * @ClassName : CartDto
 * @Description : 购物车
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-12 10:09
 */
@Data
public class CartDTO {

    /**商品*/
    private String productId;

    /** 数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
