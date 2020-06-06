package cn.imlxy.converter;

import cn.imlxy.dto.OrderDTO;
import cn.imlxy.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName : OrderMaster2OrderDTOConverter
 * @Description : 转换器
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-12 13:25
 */
public class OrderMaster2OrderDTOConverter {
    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }
}
