package cn.imlxy.service.impl;

import cn.imlxy.entity.ProductCategory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest extends TestCase {

    @Autowired
    private ProductCategoryServiceImpl categoryService;

    @Test
    public void testFindOne() {
        ProductCategory productCategory = categoryService.findOne(9);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void testFindAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void testFindByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0,productCategoryList.size());

    }

    @Test
    public void testSave() {
        ProductCategory productCategory = new ProductCategory("男生专享", 7);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);

    }
}