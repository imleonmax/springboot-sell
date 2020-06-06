package cn.imlxy.service;

import cn.imlxy.entity.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
