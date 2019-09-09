package java8.me_test;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class t20190624 {

    private static final Logger log = LoggerFactory.getLogger(t20190624.class);

    public static void main(String[] args) {
        /**
         * me
         */
        HashMap<String, String> sHashMap = new HashMap<>();


        /**
         *
         * ---------
         * JAVA构造MAP并初始化MAP - _再见理想 - 博客园
         * https://www.cnblogs.com/exmyth/p/8110942.html
         * HashMap<String, String > h = new HashMap<String, String>(){{  
         *       put("a","b");      
         * }};  
         * ---------
         * java中快速创建带初始值的List和Map实例_java_脚本之家
         * https://www.jb51.net/article/125184.htm
         * List<String> sList = Arrays.asList("str1", "str2");//这种方法生成的list，是不支持添加或删除元素的
         * private Map<Integer, String> newsEventMap = new HashMap<Integer, String>(){{
         * put("k1","v1");
         * put("k2","v2");
         * }};
         */
        Map<String, String> stringStringHashMap1 = new HashMap<String, String>(){{
            put("k1", "v1");
            put("k2", "v2");
        }};
        Map<String, String> stringStringHashMap2 = new HashMap<String, String>(){{
            put("k1", "v11");
            put("k2", "v22");
        }};
        Map<String, String> stringStringHashMap3 = new HashMap<String, String>(){{
            put("k1", "");
            put("k2", "v33");
        }};
        List<Map> list = Arrays.asList(stringStringHashMap1, stringStringHashMap2, stringStringHashMap3);

//        list.stream().

        //
        long count = list.stream().filter(map -> StringUtils.isEmpty((String)map.get("k1"))).count();//1
        long count2 = list.stream().filter(map -> StringUtils.isNotEmpty((String)map.get("k1"))).count();//2
        System.out.println("count = " + count);
        System.out.println("count2 = " + count2);


        System.out.println();

        //
        String s = "";
        {
            s = "1";
        }
        System.out.println("s = " + s);
        log.info("LOG00000:");
        log.info("LOG00020:");
        log.info("LOG00030:s=[{}]");


        //
        {
            String s2 = "";
        }
//        System.out.println("s2 = " + s2); //引用不到s2

        //
        list.stream().filter(map -> map.get("k1")=="v1").map(map -> map.put("k2","v2v2"));//没改变
        list.forEach(x->System.out.println("x="+x));

        System.out.println("map2=====================");
        list.stream().map(map -> {
            System.out.println("map = " + map.get("k1"));
            /*if(((String)map.get("k1")).equals("v1")) {
                System.out.println("map = " + map);
                map.put("k2", "v2-Change");
            }*/
            return null;
        });//没改变
        list.forEach(x->System.out.println("x2="+x));

        System.out.println("map3=====================");
        list.stream().forEach(map -> {
            System.out.println("map3 = " + map.get("k1"));
            if(((String)map.get("k1")).equals("v1")) {
                System.out.println("map = " + map);
                map.put("k2", "v2-Change");
            }
        });
        list.forEach(x->System.out.println("x3="+x));

    }
}
