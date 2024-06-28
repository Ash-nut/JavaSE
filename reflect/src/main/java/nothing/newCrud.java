package nothing;

import java.util.Date;

public class newCrud extends Crud{
    @Override
    public void create() {
        System.out.println("Crud create "+new Date());
    }

    @Override
    public void read() {
        System.out.println("Crud read "+new Date());
    }

    @Override
    public void update() {
        System.out.println("Crud update "+new Date());
    }

    @Override
    public void delete() {
        System.out.println("Crud delete "+new Date());
    }
}
