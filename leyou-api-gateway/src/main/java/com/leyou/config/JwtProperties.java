package com.leyou.config;


import com.leyou.auth.utils.RsaUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @Author: 98050
 * @Time: 2018-10-24 16:12
 * @Feature: jwt属性
 */
@ConfigurationProperties(prefix = "ly.jwt")
public class JwtProperties {

    private PublicKey publicKey;

//    @Value("${leyou.jwt.pub-key-path}")
    private String pubKeyPath;
//    @Value("${leyou.jwt.cookie-name}")
    private String cookieName;

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public String getPubKeyPath() {
        return pubKeyPath;
    }

    public void setPubKeyPath(String pubKeyPath) {
        this.pubKeyPath = pubKeyPath;
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    /**
     * @PostConstruct :在构造方法执行之后执行该方法
     */
    @PostConstruct
    public void init(){
        try {
            // 获取公钥
            this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
