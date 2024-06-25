package cn.helloworld1999.TeacherManage;
import java.util.stream.*;

public class TestStream {
    public static void main(String[] args) {
        initDate().stream().map(Teacher::getSal).forEach(System.out::println);
    }
}
