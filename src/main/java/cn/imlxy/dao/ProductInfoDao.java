package cn.imlxy.dao;

import cn.imlxy.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName : ProductInfoDao
 * @Description : 商品
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-10 21:20
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
