package com.uoumeng.umooc.interceptor;

import com.uoumeng.umooc.bean.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenjun on 2017/4/25.
 * JWT权限认证
 */
public class AccessInterceptor extends CrossDomainInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getContextPath();
        String uri = request.getRequestURI();
        if (!uri.startsWith(path+"/access")) {
            String auth = request.getHeader("Authorization");
            if (auth==null){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Authentication Failed: Require Authorization");
                return false;
            }
            Token token = new Token(auth);
            if (token.getErr()== Token.ExpiredJwtError){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Authentication Failed: 认证过期");
                return false;
            }
            if (token.getErr()==Token.SignatureError){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Authentication Failed: 非法认证");
                return false;
            }
            boolean isStudent = !token.getRole().equals("student")&&uri.startsWith(path+"/Student");
//            boolean isTeacher = !token.getRole().equals("teacher")&&uri.startsWith(path+"/Teacher");
//            boolean isStudent = !token.getRole().equals("student")&&uri.startsWith(path+"/Student");
//            if (isAdmin||isTeacher||isStudent) {
            if (isStudent) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                        "Authentication Failed: 无权访问");
                return false;
            }
        }
        return true;
    }
}
