package cn.helloworld1999.TwoWeekFriday;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class TestArrayList {
    public static List<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        list.add("null");
        list.add("null");
        list.add("All");
        list.add("null");
        list.add("2");
        list.add("null");
        list.add("2");
        list.add("null");

        // for(int i=0;i<list.size();i++){
        //     for(int j=0;j<list.size();j++)
        //     {
        //         if(list.get(i).equals(list.get(j))&&i!=j){
        //             list.remove(j);
        //             j--;
        //         }
        //     }
        // }
        // System.out.println(list.toString()); 
    }
}