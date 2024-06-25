package cn.helloworld1999;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1123);
        set.add(152);
        set.add(111);
        set.add(12);
        System.out.println(set.toString());
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer initer = it.next();
            System.out.println(initer.toString());
        }
    }
    
}
