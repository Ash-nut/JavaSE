import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Student> clazz = Student.class;
//        System.out.println(clazz);
//        System.out.println(clazz.getSimpleName());
//        Constructor con = clazz.getConstructor(String.class, Integer.class);
//        Student s = (Student) con.newInstance("ce",123);

        Constructor con2= clazz.getDeclaredConstructor();
        con2.setAccessible(true);

        Student s2 = (Student) con2.newInstance();

        System.out.println(s2);

        Constructor con3 = clazz.getConstructor(String.class, Integer.class);
        Student s3 = (Student) con3.newInstance("ce",123);
        System.out.println(s3);
    }
}
