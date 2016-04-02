import com.dubianmayou.dao.mapper.UserMapper;
import com.dubianmayou.dao.slave.mapper.SlaveUserMapper;
import com.dubianmayou.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 12/3/2015.
 */
public class SlaveUserMapperTest extends AbstractTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SlaveUserMapper slaveUserMapper;
    @Test
    public void testMapper(){
        User user = userMapper.loadUser("bruce.ge", "12345");
        printToJson(user);
    }


    @Test
    public void testTransactioin(){
        User user = userMapper.loadUser("bruce.ge", "12345");
        printToJson(user);
        System.out.println("nimei");
        user = userMapper.loadUser("bruce.ge", "12345");
        printToJson(user);
        System.out.println("start with slave");

        User slaveuser = slaveUserMapper.loadUser("bruce.ge","12345");
        printToJson(slaveuser);
        System.out.println("nimei");
        slaveuser = slaveUserMapper.loadUser("bruce.ge", "12345");
        printToJson(slaveuser);
        System.out.println("hehe");
    }

    @Test
    public void testSlave(){
        User user = slaveUserMapper.loadUser("bruce.ge","12345");
        printToJson(user);
        System.out.println("nimei");
        user = slaveUserMapper.loadUser("bruce.ge", "12345");
        printToJson(user);
        System.out.println("hehe");
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("hehe");
        user.setPassword("nimei");
        int a = userMapper.insert(user);
        System.out.println(user.getId());
        System.out.println(a);
    }

    @Test
    public void mutipleInsert(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User a = new User();
            a.setUserName("lala"+i);
            a.setPassword("lala"+i);
            userList.add(a);
        }
        int a = userMapper.insertList(userList);
        printToJson(a);
        for (int i = 0; i < 10; i++) {
            printToJson(userList.get(i));
        }

    }
}
