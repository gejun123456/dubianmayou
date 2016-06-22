package com.dubianmayou.utils.jsch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by bruce on 6/22/2016.
 */
public class MyOutPutStream extends ByteArrayOutputStream {
    private String sessionId;
    @Override
    public void flush() throws IOException {
        SessionUtils.addData(sessionId,toString());
        reset();
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public MyOutPutStream(String sessionId) {
        super();
        this.sessionId = sessionId;
    }
}
