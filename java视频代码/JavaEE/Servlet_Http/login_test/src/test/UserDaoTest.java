package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-08-23
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123111");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
