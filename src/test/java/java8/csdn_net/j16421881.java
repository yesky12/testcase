package java8.csdn_net;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------
 * Guava用法总结 - 家山的专栏 - CSDN博客
 * https://blog.csdn.net/j16421881/article/details/79874819
 */
public class j16421881 {
    public static void main(String[] args) {
        //1
//Error:        List<String> listStr = new ArrayList<String>("1", "2", "3");
        List<String> listStr = Arrays.asList("1", "2", "3");
        List<Integer> listInteger2 = listStr.stream().map(Integer::valueOf).collect(Collectors.toList());

        System.out.println();
    }
}
