package cn.imlxy.service.impl;

import cn.imlxy.dao.SellerInfoDao;
import cn.imlxy.entity.SellerInfo;
import cn.imlxy.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName : SellerServiceImpl
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-20 16:12
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);

    }
}
