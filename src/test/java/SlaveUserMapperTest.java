import com.dubianmayou.dao.mapper.UserMapper;
import com.dubianmayou.dao.slave.mapper.SlaveUserMapper;
import com.dubianmayou.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

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
}
