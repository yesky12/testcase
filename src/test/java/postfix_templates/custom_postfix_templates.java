package postfix_templates;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * ---------
 * cesards / HakunaMatataIntelliJPlugin：IntelliJ的插件，以帮助我们的日常开发，更多完成和liveTemplates，用于IntelliJ和Android Studio
 * https://github.com/cesards/HakunaMatataIntelliJPlugin
 *
 * ---------
 * cesards / HakunaMatataIntelliJPlugin：IntelliJ的插件，以帮助我们的日常开发，更多完成和liveTemplates，用于IntelliJ和Android Studio
 * https://github.com/cesards/HakunaMatataIntelliJPlugin
 */
public class custom_postfix_templates {
    static class SampleClass {
        public SampleClass() {
        }
    }
    public static void main(String[] args) {
        SampleClass sampleClass = new SampleClass();//newInstanceReplacement

        if ("aa" != null) {//ifElse

        } else {

        }

        //maxBy
        String[] strArray = new String[]{"1", "2"};
        Arrays.stream(strArray).max(Comparator.comparing(s -> s.length()));//.stream

        //
        List<String> strings = Arrays.asList(strArray);//.asList
        Optional<String[]> strArray1 = Optional.ofNullable(strArray);//.toOp

        //.new
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.isEmpty();

        //
        String aa = "11";
        Optional<String> aa1 = Optional.ofNullable(aa);
        System.out.println("aa = " + aa);
        String s = Objects.requireNonNull(aa);
        StringUtils.removeEnd(aa, "a");


        //
    }
}
