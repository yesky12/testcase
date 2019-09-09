package lib.apache_CommonLang3;

import org.apache.commons.lang3.StringUtils;

/**
 * ---------
 * CommonLang3中的StringUtils最全解析 - 架构师之路 - CSDN博客
 * https://blog.csdn.net/xuxiaoxie/article/details/52095930
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        StringUtils.isEmpty(null);  //= true
        StringUtils.isEmpty("");    //= true
        StringUtils.isEmpty(" ");//       = false
        StringUtils.isEmpty("bob");//     = false
        StringUtils.isEmpty("  bob  ");// = false
        StringUtils.isNoneEmpty("");


        StringUtils.isAnyEmpty(null);//             = true
        StringUtils.isAnyEmpty(null, "foo");//      = true
        StringUtils.isAnyEmpty("", "bar");//        = true
        StringUtils.isAnyEmpty("bob", "");//        = true
        StringUtils.isAnyEmpty("  bob  ", null);//  = true
        StringUtils.isAnyEmpty(" ", "bar");//       = false
        StringUtils.isAnyEmpty("foo", "bar");//     = false

        Integer integer = new Integer(1);
//        integer.isAnyEmpty(null);
        /**
         * ---------
         * 【Hutool】Hutool工具类之String工具——StrUtil - ---江北 - 博客园
         * https://www.cnblogs.com/jiangbei/p/7726313.html
         * 指定字符开头或结尾
         *
         * startWith()——是否以指定字符或者指定字符串开头
         *
         * 　　　　　　　相关方法是startWithIgnoreCase()——忽略大小写
         *
         * 　　　　　　　　　　　　　　startWithAny()——以任意字符串开始
         * endWith()——与上述的镜像方法，不再赘述
         *
         * containsIgnoreCase()——忽略大小写的包含
         *
         *  　　去掉指定前后缀
         *
         * removeSuffix()——去除指定后缀
         *
         * 　　　　　　　　　　示例：String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg")
         */
    }
}
