// 自定义异常类，继承自 Exception 类
class MyCustomException extends Exception {
    // 默认构造函数，调用父类的默认构造函数
    public MyCustomException() {
        super();
    }

    // 带有错误消息参数的构造函数，调用父类的构造函数设置错误消息
    public MyCustomException(String message) {
        super(message);
    }

    // 带有错误消息和异常原因的构造函数，调用父类的构造函数设置这两个值
    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

// 使用自定义异常的示例类
public class TestCustomException {
    public static void main(String[] args) {
        try {
            // 模拟一个条件检查，例如用户输入验证
            boolean condition = false; // 假设这是要检查的条件
            if (condition) {
                // 如果条件为真，则抛出自定义异常
                throw new MyCustomException("发生了自定义异常");
            }
        } catch (MyCustomException e) {
            // 捕获自定义异常并打印堆栈跟踪
            e.printStackTrace();
        }
    }
}
