package cn.imlxy.service;

import cn.imlxy.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName : ProductCategoryService
 * @Description : 类目
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-10 20:54
 */
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
