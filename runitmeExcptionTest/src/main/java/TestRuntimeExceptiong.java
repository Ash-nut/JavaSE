import java.util.Scanner;

public class TestRuntimeExceptiong {
    public static void main(String[] args) {
        System.out.println("---------");
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while (flag) {
            try {
                System.out.println(10 / sc.nextInt());
                flag = false;
                System.out.println("正常结束");
            } catch (Exception e) {
                System.out.println("或许有问题");
                flag = true;
            } finally {
                System.out.println("跑完了");
            }
        }
    }
}
