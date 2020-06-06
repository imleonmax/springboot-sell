package cn.imlxy.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName : ProductInfoVO
 * @Description : 商品详情
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-11 15:38
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -3450721267209548811L;
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

}
