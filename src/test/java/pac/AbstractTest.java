package pac;

import com.google.gson.Gson;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bruce on 12/3/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration({"/spring/*.xml"})
public abstract class AbstractTest {
    private Gson gson =new Gson();

    public void printToJson(Object o){
        System.out.println(gson.toJson(o));
    }
}
