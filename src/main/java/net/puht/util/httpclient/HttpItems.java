package net.puht.util.httpclient;

/**
 * Created by puht on 2015/3/11.
 */

import java.util.Map;

/**
 * @作者 bobbylee
 * @版本 1.0
 * @说明 Http实体参数类
 */
public class HttpItems {
    /**
     * encode: 编码格式,默认utf-8
     */
    public String encode = "utf-8";
    /**
     * post: 请求参数,中间用逗号隔开,如"user:11,password:123"
     */
    public String params = "";
    /**
     * url 请求地址,格式为http://xxxxx
     */
    public String url = "";
    /**
     * method: 请求方法,get/post,默认get
     */
    public String method = "get";
    /**
     * headers: http头部
     */
    public Map<String, String> headers;
    /**
     * headers: 设置超时时间
     */
    public long timeOut = 30000;
}
