package nothing;


public class Crud implements CrudInterface {

    @Override
    public void create() {
        System.out.println("Crud create");
    }

    @Override
    public void read() {
        System.out.println("Crud read");
    }

    @Override
    public void update() {
        System.out.println("Crud update");
    }

    @Override
    public void delete() {
        System.out.println("Crud delete");
    }
}
