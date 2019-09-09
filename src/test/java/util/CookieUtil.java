package util;

/**
 * ---------
 * web-learn-project/CookieUtil.java at 9055fb795fbd3fed3fcb8104742fee5b5b3a14ba · litttlefisher/web-learn-project
 * https://github.com/litttlefisher/web-learn-project/blob/9055fb795fbd3fed3fcb8104742fee5b5b3a14ba/web/src/day06/CookieUtil.java
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private static final int MAX_AGE=365*24*60*60;

    public static void addCookie(String key,String value,HttpServletResponse response){
        try {
            Cookie cookie=new Cookie(key,URLEncoder.encode(value,"utf-8"));

            cookie.setMaxAge(MAX_AGE);

            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static void addCookie(String key,String value,int maxAge,HttpServletResponse response){
        try {
            Cookie cookie=new Cookie(key,URLEncoder.encode(value,"utf-8"));

            cookie.setMaxAge(maxAge);

            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void addCookie(String key,String value,int maxAge,String path,HttpServletResponse response){
        try {
            Cookie cookie=new Cookie(key,URLEncoder.encode(value,"utf-8"));

            cookie.setMaxAge(maxAge);

            cookie.setPath(path);

            response.addCookie(cookie);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void removeCookie(String key,HttpServletResponse response){
//		Cookie cookie=new Cookie(key,"");
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
        addCookie(key, "",0, response);
    }
    public static void modifyCookie(String key,String value,HttpServletResponse response){
        addCookie(key, value, response);
    }
    public static String findCookie(String key,HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals(key)){
                    try {
                        return URLDecoder.decode(cookie.getValue(),"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}