import com.dubianmayou.dao.mapper.UserMapper;
import com.dubianmayou.dao.slave.mapper.SlaveUserMapper;
import com.dubianmayou.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void testTransactioin(){
        User user = userMapper.loadUser2("bruce.ge","12345");
        printToJson(user);
        System.out.println("nimei");
        user = userMapper.loadUser2("bruce.ge", "12345");
        printToJson(user);
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
