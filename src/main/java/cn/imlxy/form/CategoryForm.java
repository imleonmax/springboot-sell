package cn.imlxy.form;

import lombok.Data;

/**
 * @ClassName : CategoryForm
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-20 14:48
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
