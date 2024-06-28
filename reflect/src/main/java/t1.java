import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class t1 {
    static public <T>T mapToOp(Map<String, Object> map, Class class1) throws Exception {

        Constructor con = class1.getDeclaredConstructor();  //拿到类型的构造器
        con.setAccessible(true);
        T newObj = (T) con.newInstance(); //创建实例
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            // 尝试拿到这个Map存在的属性
            try {
                Field field = class1.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(newObj, entry.getValue()); //拿到了，赋值
            } catch (Exception e) {      //没拿到
                throw new Exception(entry.getKey());
            }
        }
        return newObj;
    }
}
