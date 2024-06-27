import java.io.*;


public class IoStreamOp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student stu = new Student(111,"NickFenn",40);
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new FileOutputStream("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\students.txt"));
        oos.writeObject(stu);
        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\DevelopData\\JavaSE\\JavaSE\\ioStream2\\src\\main\\java\\students.txt"));
        Student s = (Student)  ois.readObject();
        System.out.println(s);
    }
}
