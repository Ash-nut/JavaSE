

import java.util.Date;
import java.util.UUID;

/**
 * IDUtil
 */
public class IDUtil {

    public void getUUID(){
        String id = new UUID(0, 0).toString();
    }

    static public long getLongId(){
        long id = new Date().getTime();
        return id;
    }
}