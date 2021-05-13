package xyz.snoutr;

public class useStudent {
    public static void main(String[] args) {
        Student a =new Student();
        a.setAge(10);
        System.out.println(a.getAge());
        a.setName("张三");
        System.out.println(a.getName());
    }
}
