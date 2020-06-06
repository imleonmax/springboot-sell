package cn.imlxy.utils;

/**
 * @ClassName : MathUtil
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-18 12:44
 */
public class MathUtil {
    public static final Double MONEY_RANGE = 0.01;
    /**
     * @Description 比较两个金额是否相等
     * @Date 2020/5/18 12:45
     * @Param [d1, d2]
     * @return java.lang.Boolean
     * @throws
     **/
    public static Boolean equals(Double d1, Double d2) {
        double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        } else {
            return false;
        }
    }
}
