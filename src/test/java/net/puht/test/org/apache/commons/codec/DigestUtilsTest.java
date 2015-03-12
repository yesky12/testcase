package net.puht.test.org.apache.commons.codec;

import junit.framework.TestCase;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by puht on 2015/3/11.
 * D:\Download_Doc\Code\Jar\1.apache-common\commons-codec-1.10-src\src\test\java\org\apache\commons\codec\digest\DigestUtilsTest.java
 */
public class DigestUtilsTest extends TestCase{

    @Test
    public void test_md5Hex() throws Exception {
        String s = DigestUtils.md5Hex("123");

    }
}
