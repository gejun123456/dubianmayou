package service;

import com.dubianmayou.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pac.AbstractTest;

/**
 * Created by bruce on 3/26/2016.
 */
public class AccountServiceTest extends AbstractTest{
    @Autowired
    private AccountService accountService;


    @Test
    public void testSerice(){
        accountService.sayHi();
    }
}
