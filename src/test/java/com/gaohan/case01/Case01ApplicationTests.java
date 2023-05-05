package com.gaohan.case01;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Case01ApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> cliams = new HashMap<>();
        cliams.put("id", 1);
        cliams.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "gaohan") // 设置签名算法
                .setClaims(cliams) // 设置自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置有效期
                .compact();

        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("gaohan")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY4MzIxMDY3N30.ZQxuwZEnRXyTQEYYKEDc4Bl1pk6e_TvVFFtpS02A5GQ")
                .getBody();

        System.out.println(claims);
    }
}
