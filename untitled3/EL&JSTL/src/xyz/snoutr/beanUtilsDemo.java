package xyz.snoutr;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class beanUtilsDemo {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person p = new Person();
        p.setName("aaaa");
        p.setAge(11);
        BeanUtils.setProperty(p,"name","aaa");
        BeanUtils.setProperty(p,"age",111);
        String name = BeanUtils.getProperty(p,"name");
        String age = BeanUtils.getProperty(p,"age");

        System.out.println("name"+name+",age"+age);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name","aaa");
        map.put("age",333);

        BeanUtils.populate(p, map);

        System.out.println(p.getName());
    }
}
