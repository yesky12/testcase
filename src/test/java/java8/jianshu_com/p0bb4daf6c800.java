package java8.jianshu_com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ---------
 * 简洁又快速地处理集合——Java8 Stream（上） - 简书
 * https://www.jianshu.com/p/0bb4daf6c800?from=groupmessage
 */


class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class p0bb4daf6c800 {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("jack", 20));
        list.add(new Person("mike", 25));
        list.add(new Person("tom", 30));

        //map
        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("collect = " + collect);//collect = [jack, mike, tom]

        //
        list.stream().forEach(person -> person.setAge(1));
        System.out.println("list = " + list.toString());//list = [java8.jianshu_com.Person@312b1dae, java8.jianshu_com.Person@7530d0a, java8.jianshu_com.Person@27bc2616]
//        System.out.println("list = " + list.stream().forEach(System.out::println););
        list.stream().forEach(System.out::println);//java8.jianshu_com.Person@312b1dae java8.jianshu_com.Person@7530d0a java8.jianshu_com.Person@27bc2616
        System.out.println("person.getAge()");
        list.stream().forEach(person -> System.out.println("person = " + person.getAge())); //person = 1    person = 1  person = 1

    }


}
