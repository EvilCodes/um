package com.uoumeng.umooc.bean;

import com.uoumeng.umooc.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenjun on 2017/4/25.
 */
public class Token {
    private int id;
    private String mobile;
    private String nick;
    private String role;
    private int err = 0;
    public static final int ExpiredJwtError = 1;
    public static final int SignatureError = 2;

    @Autowired
    private JwtUtil jwtUtil;

    public Token(String token) {
        try {
            Claims claims = jwtUtil.parseJWT(token);
            this.id = Integer.parseInt(claims.get("id").toString());
            this.mobile = claims.get("mobile").toString();
            this.nick = claims.get("nick").toString();
            this.role = claims.get("role").toString();
        } catch (ExpiredJwtException e){
            this.err = ExpiredJwtError;
        } catch (SignatureException e) {
            this.err = SignatureError;
        }
    }

    public int getId() {
        return id;
    }

    public String getMobile() {
        return mobile;
    }

    public String getNick(){
        return nick;
    }

    public String getRole() {
        return role;
    }

    public int getErr() {
        return err;
    }
}
