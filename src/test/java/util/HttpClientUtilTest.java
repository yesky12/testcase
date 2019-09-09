package util;

import junit.framework.TestCase;
import net.puht.util.httpclient.HttpClientUtil;
import net.puht.util.httpclient.HttpItems;
import net.puht.util.httpclient.HttpResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by puht on 2015/3/11.
 */
public class HttpClientUtilTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(HttpClientUtilTest.class);


    @Test
    public void test_HttpClientUtil() throws Exception {
        HttpItems httpItems = new HttpItems();
        httpItems.url = "http://baidu.com?q=123";
        httpItems.method = "post";
        httpItems.params = "a:1,b:2";
        HttpClientUtil httpClientUtil = new HttpClientUtil(httpItems);
        HttpResult entity = httpClientUtil.getEntity();
        logger.info("statusCode=" + entity.statusCode);

    }
}
