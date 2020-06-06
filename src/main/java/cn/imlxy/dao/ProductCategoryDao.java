package cn.imlxy.dao;

import cn.imlxy.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName : ProductCategoryDao
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-10 16:05
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
