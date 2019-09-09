package lib.encode;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

public class UnicodeTest {
    public static void main(String[] args) {
        /**
         * ---------
         * java中字符串 utf8 转为 gbk - java-北京-菜鸟 - ITeye博客
         * https://www.iteye.com/blog/chenyuguxing-2271392
         */

        try {
//            String plain = "你好";
            String plain = "%7B%22name%22%3A%22%E7%8E%8B%E8%BF%8E%E8%BF%8E%22%2C%22mobile%22%3A%2218512113005%22%2C%22ID%22%3A1775%2C%22avatar%22%3A%22%22%2C%22coreId%22%3A%2210000000001130302%22%2C%22depName%22%3A%22%E8%B4%A8%E9%87%8F%E4%BF%9D%E9%9A%9C%E4%B8%89%E7%BB%84%22%2C%22email%22%3A%22wangyingying%40cathay-ins.com.cn%22%2C%22username%22%3A%220100012440%22%7D";
            byte[] bytes = new byte[0];
            bytes = plain.getBytes("utf-8");
            byte[] bytes2 = new String(bytes, "utf-8").getBytes("gbk");

            plain=new String(bytes2, "gbk");
            System.out.println("plain = " + plain);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         * ---------
         * JAVA字符串与Unicode互转 - 强势围观 - CSDN博客
         * https://blog.csdn.net/sinat_25318461/article/details/81227609
         */
        String str = "汉语pinyin";
        String unicode = stringToUnicode(str);
        System.out.println("字符串转unicode结果：" + unicode);
        String s = unicodeToString(unicode);
        System.out.println("unicode转字符串结果：" + s);//汉语pinyin

        String s2 = unicodeToString("%7B%22name%22%3A%22%E7%8E%8B%E8%BF%8E%E8%BF%8E%22%2C%22mobile%22%3A%2218512113005%22%2C%22ID%22%3A1775%2C%22avatar%22%3A%22%22%2C%22coreId%22%3A%2210000000001130302%22%2C%22depName%22%3A%22%E8%B4%A8%E9%87%8F%E4%BF%9D%E9%9A%9C%E4%B8%89%E7%BB%84%22%2C%22email%22%3A%22wangyingying%40cathay-ins.com.cn%22%2C%22username%22%3A%220100012440%22%7D");
        System.out.println("unicode转字符串结果2：" + s2);

        /**
         * ---------
         * java进行url编码和解码 - 宇翊 - 博客园
         * https://www.cnblogs.com/zyf-yxm/p/9014947.html
         */
        String s3 = "%7B%22name%22%3A%22%E7%8E%8B%E8%BF%8E%E8%BF%8E%22%2C%22mobile%22%3A%2218512113005%22%2C%22ID%22%3A1775%2C%22avatar%22%3A%22%22%2C%22coreId%22%3A%2210000000001130302%22%2C%22depName%22%3A%22%E8%B4%A8%E9%87%8F%E4%BF%9D%E9%9A%9C%E4%B8%89%E7%BB%84%22%2C%22email%22%3A%22wangyingying%40cathay-ins.com.cn%22%2C%22username%22%3A%220100012440%22%7D";
        String s4 = URLDecoderString(s3);
        System.out.println("s4 = " + s4);/*{"name":"王迎迎","mobile":"18512113005","ID":1775,"avatar":"","coreId":"10000000001130302","depName":"质量保障三组","email":"wangyingying@cathay-ins.com.cn","username":"0100012440"}*/
        JSONObject jsonObject = JSONObject.parseObject(s4);
        System.out.println("jsonObject = " + jsonObject);
    }

    public static String URLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            sb.append("\\u" + Integer.toHexString(c[i]));
        }
        return sb.toString();
    }

    public static String unicodeToString(String unicode) {
        StringBuffer sb = new StringBuffer();
        String[] hex = unicode.split("\\\\u");
        for (int i = 1; i < hex.length; i++) {
            int index = Integer.parseInt(hex[i], 16);
            sb.append((char) index);
        }
        return sb.toString();
    }
}
