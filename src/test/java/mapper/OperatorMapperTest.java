package mapper;

import com.dubianmayou.dao.mapper.OperatorMapper;
import com.dubianmayou.entity.Operator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

/**
 * Created by bruce on 5/29/2016.
 */
public class OperatorMapperTest extends AbstractTest {
    @Autowired
    private OperatorMapper operatorMapper;

    @Test
    public void testMapper(){
        Operator operator = operatorMapper.loadByIp("192.168.8.101");
        printToJson(operator);
    }
}
