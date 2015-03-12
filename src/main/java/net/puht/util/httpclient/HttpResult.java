package net.puht.util.httpclient;

/**
 * Created by puht on 2015/3/11.
 */
/**
 *
 * @作者 bobbylee
 * @版本 1.0
 * @说明 请求结果类实体
 */
public class HttpResult {
    /**
     * statusCode: 状态码
     */
    public String statusCode;
    /**
     * content: 返回网页实体
     */
    public String content;
    /**
     * cookie: cookie
     */
    public String cookie;
    /**
     * location: 是否重定向
     */
    public String location;
}
