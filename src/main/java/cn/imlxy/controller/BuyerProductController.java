package cn.imlxy.controller;

import cn.imlxy.VO.ProductInfoVO;
import cn.imlxy.VO.ProductVO;
import cn.imlxy.VO.ResultVO;
import cn.imlxy.entity.ProductCategory;
import cn.imlxy.entity.ProductInfo;
import cn.imlxy.service.ProductCategoryService;
import cn.imlxy.service.ProductService;
import cn.imlxy.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.idn.Punycode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : BuyerProductController
 * @Description : 买家商品
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-11 15:00
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product",key = "123",unless = "#result.getCode()!=0")
    public ResultVO list() {
        //1.查询所有的上架的商品
        List<ProductInfo> productInfoList=productService.findUpAll();

        //2.查询在架商品所属类目（一次性查询）
//        List<Integer> categoryTypeList=new ArrayList<>();
//        //传统方法
//        for(ProductInfo productInfo: productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法lamba表达式
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e->e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList=productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3. 数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory: productCategoryList){
            ProductVO productVO=new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for(ProductInfo productInfo: productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO=new ResultVO();
//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
        ResultVO resultVO= ResultVOUtil.success(productVOList);
        return resultVO;
    }
}
