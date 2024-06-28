import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


public class t2 {
    public static Map<String,Object> map;
    public static void main(String[] args) throws Exception {

        map=new HashMap<String,Object>();
        map.put("name","反射");
        map.put("age",15);

        Class class1 = Student.class;
        System.out.println(t1.mapToOp(map,class1).toString());
    }
}
