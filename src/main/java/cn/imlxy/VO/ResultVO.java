package cn.imlxy.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName : ResultVO
 * @Description : http请求返回的最外层对象
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-11 15:09
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 6446653270811670838L;
    /**错误码**/
    private Integer code;

    /**提示信息**/
    private String msg;

    /**具体内容**/
    private T data;
}
