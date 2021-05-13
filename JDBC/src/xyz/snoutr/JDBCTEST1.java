package xyz.snoutr;

import xyz.snoutr.dao.UserDao;
import xyz.snoutr.domain.User;

import java.util.Date;

public class JDBCTEST1 {
    public static void main(String[] args) throws Exception {
        User user = new User();
        UserDao ud =new UserDao();
        user.setId(10086);
        user.setUsername("iudshgv");
        user.setPassword("uhfda");
        user.setEmail("123@qq.com");
        user.setBirthday(new Date());
        boolean b = ud.insert (user);
        System.out.println(b);
    }
}
