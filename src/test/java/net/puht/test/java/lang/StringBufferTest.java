package net.puht.test.java.lang;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by puht on 2015/3/11.
 */
public class StringBufferTest extends TestCase{
    private Logger logger = LoggerFactory.getLogger(StringBufferTest.class);

    @Test
    public void test_deleteCharAt() throws Exception {
        StringBuffer stringBuffer = new StringBuffer("abcde");
        System.out.println("before:"+stringBuffer);

        //删除倒数第1个字符
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
        System.out.println("after:" + stringBuffer);

        //删除倒数第2个字符
        stringBuffer.deleteCharAt(stringBuffer.length() - 2);
        System.out.println("after:" + stringBuffer);

    }

    @Test
    public void test_toUpperCase() throws Exception {
        String str = "123";
        String s = str.toUpperCase();
        String s1 = str.toLowerCase();

    }
}
