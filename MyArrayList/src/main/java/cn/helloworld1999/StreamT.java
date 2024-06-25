package cn.helloworld1999;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamT {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("32","222","22","123");
        Stream <String> stream = list.stream();
        
        Stream <Integer> stream2 = stream.map(Integer::parseInt);
        stream2.forEach(System.out::println);
    }
}
