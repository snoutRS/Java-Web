package xyz.snoutr;

import xyz.snoutr.dao.UserDao;
import xyz.snoutr.domain.User;

import java.util.ArrayList;
import java.util.Date;

public class JDBCTEST1 {
    public static void main(String[] args) throws Exception {
        User user = new User();
        UserDao ud =new UserDao();
        user.setId(80);
        user.setUsername("110");
        user.setPassword("阿什顿");
        user.setEmail("123@qq.com");
        user.setBirthday(new Date());
//        boolean b = ud.update (user);
        boolean b = ud.insert (user);
//        boolean b = ud.delete (1);
//        User b = ud.find(110);

//        ArrayList<User> b = ud.findAll();
//        for(int i=0;i<b.size();i++){
//            System.out.println(b.get(i).getUsername());
//        }
        System.out.println(b);
//        System.out.println(b.getUsername());

    }

}
