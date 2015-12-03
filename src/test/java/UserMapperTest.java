import com.dubianmayou.dao.mapper.UserMapper;
import com.dubianmayou.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by bruce on 12/3/2015.
 */
public class UserMapperTest extends AbstractTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testMapper(){
        User user = userMapper.loadUser("bruce.ge", "12345");
        printToJson(user);
    }
}
