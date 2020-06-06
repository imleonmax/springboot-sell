package cn.imlxy.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName : SellerInfo
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-20 15:30
 */
@Data
@Entity
public class SellerInfo implements Serializable {

    private static final long serialVersionUID = -2095637530402267420L;
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
