package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-25
 */
public class BeanUtilsTest {

    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
            String username = BeanUtils.getProperty(user, "username");
            System.out.println(username);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }
}
