package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;


/**
 * Created by bruce on 12/4/2015.
 */
public class Log4j2Test {

    private static Logger logger = LogManager.getLogger("devlogger");
    @Test
    public void testLog4j() throws Exception{
        try {
            hello();   //
        }catch (Exception e) {
            logger.error("fail",e);   //get print all message of log
            throw e;
        }
    }

    private void hello() {
        throw new RuntimeException("qunimeide");
    }

    public String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }


    @Test
    public void testPrintln(){
        System.out.println("你妈的");
    }
}
