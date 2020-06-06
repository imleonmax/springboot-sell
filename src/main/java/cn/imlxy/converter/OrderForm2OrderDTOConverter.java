package cn.imlxy.converter;

import cn.imlxy.dto.OrderDTO;
import cn.imlxy.entity.OrderDetail;
import cn.imlxy.enums.ResultEnum;
import cn.imlxy.exception.SellException;
import cn.imlxy.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : OrderForm2OrderDTOConverter
 * @Description : 转换
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-13 21:24
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        //TODO:修改
//        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerOpenid("oTgZpwaFaMRnRuIEcat2LJJhjlBI");
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (JsonSyntaxException e) {
            log.error("【对象转换】错误,string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
