package springjdbc;

import com.dubianmayou.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import pac.AbstractTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 12/21/2015.
 */
public class JdbcTemplateTest extends AbstractTest{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testFind(){
        List<User> query = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User use = new User();
                use.setUserName(resultSet.getString("userName"));
                use.setPassword(resultSet.getString("password"));
                return use;
            }
        });
        System.out.println(query.size());
    }

    @Test
    public void testUpdate(){
        List<Integer> mm = new ArrayList<Integer>();
        mm.add(1);
        mm.add(2);
        String ss = "";
        for (int i = 0; i < mm.size()-1; i++) {
            ss+="?,";
        }
        if(mm.size()>0) {
            ss += "?";
        }
        System.out.println(ss);

        Object[] uu = new Object[mm.size()+1];
        int[] types = new int[mm.size()+1];
        uu[0] = "userName";
        types[0] = Types.VARCHAR;

        for (int i = 0; i < mm.size(); i++) {
            uu[i+1] = mm.get(i);
            types[i+1] = Types.INTEGER;
        }
        jdbcTemplate.update("update user set userName = ? where id in("+ss+")",uu,types);
        System.out.println("yes");
    }
}
