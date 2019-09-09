package java8.stream;

/**
 * ---------
 * stream系列——初始stream方法 - 简书
 * https://www.jianshu.com/p/e918e9c07531
 */
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class StreamMethodTest {

    public static void main(String[] args) {
        //初始化list
        List<String> list = asList("one", "two", "three", "four");
        Stream.of("one", "two", "three", "four").collect(toList());

/**map:**/
        /**map功能（将一种类型数据的值转化成另一种类型）
         //比如将小写转成大写
         //注意map的函数接口是Function，一进一出变个身**/
        List<String> mapList = Stream.of("one", "two", "three", "four")
                .map(value->value.toUpperCase())
                .collect(toList());
        //forEach内部函数接口是Consumer，只进不出消化了
        mapList.forEach(x->System.out.println(x));

/**filter:**/
        /**遍历对数据进行检查用filter，一进出来成boolean。其实就是for里面的if语句
         filter内部的函数接口是Predicate**/
        List<String> filterList = Stream.of("one", "two", "three", "four")
                .filter(x->x.equalsIgnoreCase("one"))
                .collect(toList());
        filterList.forEach(x->System.out.println(x));

/**flatMap:**/
        //有时：对map中的值用新的stream来替换他
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(toList());
        together.forEach(x->System.out.print(x));
        System.out.println();

/**reduce:**/
        /** reduce操作可以实现从一组值中生成一个值
         如何通过reduce操作对Stream中的数字求和。以0作起点——一个空流
         Stream的求和结果，每一步都将Stream中的元素累加至accumulator，遍历至Stream中的
         最后一个元素时，accumulator的值就是所有元素的和。**/
        /**BinaryOperator reduce包含初始值和BinaryOperator函数接口**/
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        System.out.println(count);

        /**展开过程**/
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int anotherCount = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0, 1),
                        2),
                3);
        System.out.println(anotherCount);

        /**等同功能**/
        int acc = 0;
        for (Integer element : asList(1, 2, 3)) {
            acc = acc + element;
        }
        System.out.println(acc);

/**max和min: 其实包含了reduce功能：reduce(BinaryOperator.minBy(comparator));**/
        List<Track> tracks = asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451));
        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();
        System.out.println(shortestTrack);
    }

    static class Track {
        String name;
        int length;

        public Track(String name, int length) {
            this.name = name;
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Track [name=").append(name).append(", length=")
                    .append(length).append("]");
            return builder.toString();
        }

    }
}

