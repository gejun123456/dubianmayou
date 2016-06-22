package mapper;

import com.dubianmayou.dao.mapper.OpCollectionMapper;
import com.dubianmayou.entity.OpCollection;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

import java.util.List;

/**
 * Created by bruce on 5/29/2016.
 */
public class OpCollectionMapperTest extends AbstractTest {
    @Autowired
    private OpCollectionMapper opCollectionMapper;

    @Test
    public void testMapper(){
        List<OpCollection> opCollections =
                opCollectionMapper.loadByOperatorId(1);
        printToJson(opCollections);
    }
}
