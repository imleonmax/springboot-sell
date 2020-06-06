package cn.imlxy.dao;

import cn.imlxy.entity.OrderDetail;
import cn.imlxy.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("11111112");
        orderDetail.setProductIcon("http://xxx.jpc");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("小饼干");
        orderDetail.setProductPrice(new BigDecimal(2.7));
        orderDetail.setProductQuantity(2);
        OrderDetail result = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrOrderId() {
        List<OrderDetail> orderDetailList = orderDetailDao.findByOrOrderId("11111111");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}