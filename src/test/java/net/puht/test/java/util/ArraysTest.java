package net.puht.test.java.util;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by puht on 2015/3/11.
 */
public class ArraysTest extends TestCase {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ArraysTest.class);

    /**
     * 排序，对所有参数按照字段名的 ASCII码从小到大排序(字典序)...
     * @throws Exception
     */
    @Test
    public void test_sort() throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("city", "3");
        map.put("time", "2015-3-13 19:00:00");
        map.put("pay_type", "2");
        map.put("package", "1");
        map.put("area", "xx区");
        map.put("community", "xx小区");
        map.put("door_number", "xx路101号1号楼1层01室");
        map.put("name", "张先生");
        map.put("phone", "13912341234");
        map.put("memo", "做一桌川菜");

        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        logger.info("end");
    }

    @Test
    public void test_asList() throws Exception {


    }
}
