package net.puht.util.httpclient;

/**
 * Created by puht on 2015/3/11.
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

    private CloseableHttpClient client;
    private HttpItems items;
    private HttpResult result;
    private HttpPost post;
    private HttpGet get;

    public HttpClientUtil(HttpItems items) {
        this.items = items;
    }

    private void init() throws UnsupportedEncodingException {
        if (items.url.matches("(^http|^https):\\/\\/.*") == false) {
            System.err.println("网址:" + items.url + "格式不正确");
            return;
        }
        if (client == null) {
            client = HttpClients.createDefault();
        }
        this.post = null;
        this.get = null;
        //初始化请求方式
        if ("post".equals(items.method.toLowerCase())) {
            this.post = new HttpPost(items.url);
        } else if ("get".equals(items.method.toLowerCase())) {
            this.get = new HttpGet(items.url);
        } else {
            System.err.println("请求方式不正确,只能为POST/GET");
            return;
        }
        //初始化参数
        String[] params = items.params.split(",");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (int i = 0; i < params.length; i++) {
            if (params[i].matches("\\w+:\\w+")) {
                String[] temp = params[i].split(":");
                nvps.add(new BasicNameValuePair(temp[0], temp[1]));
            } else {
                System.err.println("参数格式不正确!");
                return;
            }
        }
        if (get == null) {
            post.setEntity(new UrlEncodedFormEntity(nvps, items.encode));
        }
    }

    public HttpResult getEntity() {
        HttpResponse response;
        result = new HttpResult();
        try {
            this.init();
            response = client.execute(get == null ? post : get);
            result.statusCode = String.valueOf(response.getStatusLine().getStatusCode());
            result.content = EntityUtils.toString(response.getEntity());
            if ("302".equals(result.statusCode)) {
                result.location = response.getHeaders("Location")[0].getValue();
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
