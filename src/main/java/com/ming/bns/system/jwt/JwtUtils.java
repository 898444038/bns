package com.ming.bns.system.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.ming.bns.admin.entity.sys.User;

public class JwtUtils {

    /**
     * 生成token
     * @param user
     * @return
     */
    public static String getToken(User user) {
        return JWT.create().withAudience(user.getId().toString()).sign(Algorithm.HMAC256(user.getPassword()));
    }


    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("wjm");
        user.setPassword("e10adc3949ba59abbe56e057f20f883e");
        //eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIn0.bFwLcjdORwcB3OhUWK1wjVe7P3gcum1xwFY2USrqo4k
        String token = getToken(user);

        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        jwtVerifier.verify(token);
        jwtVerifier.verify(token+"1");//异常
    }
}
