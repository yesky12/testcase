package java8.jianshu_com;

//import java.util.stream.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ---------
 * Java创建List的4种方法 - 简书
 * https://www.jianshu.com/p/609e853407e8
 */
public class p609e853407e8 {
    public static void main(String[] args) {
        /**
         * 2、通过Arrays.asList("a", "b");
         *
         * 但是这种方法构造出的List是固定长度的，如果调用add方法增加新的元素，会报异常：java.lang.UnsupportedOperationException，其实也可以理解，这个List是由Array转换而来，而Array是不能动态增加长度的，适合于构造静态不变List，
         *
         */
        List<String> strings = Arrays.asList("a", "b");


        /**
         * 3、通过Java8引入的Stream提供的方法：List list = Stream.of("a", "b").collect(Collectors.toList());
         *
         * 这种方式跟第二种类似，但是list可以动态添加元素，比较友好，适合于构造动态List
         */
        List<String> list = Stream.of("a", "b").collect(Collectors.toList());
        System.out.println();

    }
}
