package crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import pac.SimpleTest;

import java.io.IOException;

/**
 * Created by bruce on 5/29/2016.
 */
public class DouyuTest extends SimpleTest{
    @Test
    public void testDouyu() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://www.douyu.com/wt55kai");
        CloseableHttpResponse execute = client.execute(get);
        System.out.println(EntityUtils.toString(execute.getEntity()));
    }
}
