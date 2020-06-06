package cn.imlxy.aspect;

import cn.imlxy.constant.CookieConstant;
import cn.imlxy.constant.RedisConstant;
import cn.imlxy.exception.SellerAuthorizeException;
import cn.imlxy.utils.serializer.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : SellerAuthorize
 * @Description :
 * @Author : LiuXinyu
 * @Site : www.imlxy.cn
 * @Date: 2020-05-21 10:14
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorize {
    @Autowired
    private StringRedisTemplate redisTemplate;
//
//    @Pointcut("execution(public * cn.imlxy.controller.Seller*.*(..))" +
//            "&& !execution(public * cn.imlxy.controller.SellerUserController.*(..))")
//    public void verify() {
//    }
//
//    @Before("verify()")
//    public void doVerify() {
//        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登录校验】Cookie中找不到token");
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis里查
//        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }

}
