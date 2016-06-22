package com.dubianmayou.utils.jsch;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelShell;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * Created by bruce on 6/22/2016.
 */
public class JschUtils {
    public static boolean connect(String sessionId,String ip){
        try {
            JSch jSch = new JSch();
            Session user4beta = jSch.getSession("betauser", "192.168.225.68", 58422);
//        user4beta.setOutputStream(new FileOutputStream(new File("nimageb.txt")));
            user4beta.setPassword("user4beta");
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            user4beta.setConfig(config);

            user4beta.connect();
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
//
//        String msg = null;
//        while((msg=buffer.readLine())!=null){
//            System.out.println(msg);
//        }\
            final ChannelShell channelExec = (ChannelShell) user4beta.openChannel("shell");
//        channelExec.setInputStream(System.in);
            //制定了outPutStream即可
            //打印出来和inputstream没有关系
            //它是如何检测我的输入的 为何我输入内容他会知晓
            channelExec.setOutputStream(new MyOutPutStream(sessionId));
            ChannelRegister.register(sessionId, channelExec);
            channelExec.connect();
            writeCommd(channelExec, "cd /\nls");
            return true;
//        int count =1;
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(channelExec.getInputStream()));
//        String msg = null;
////        while((msg=buffer.readLine())!=null){
////            System.out.println(msg);
////        }
//        String command="";
//        PrintWriter writer = new PrintWriter(new OutputStreamWriter(channelExec.getOutputStream()));
//        while(count++<10){
//            command="cd /data/applogs\nls";
//            writer.write(command);
//            writer.flush();
//            while((msg=buffer.readLine())!=null){
//                System.out.println(msg);
//            }
//        }
//        user4beta.disconnect();
        }catch (Exception e){
            return false;
        }
    }

    public static void writeCommd(Channel channel, String command) throws InterruptedException, IOException
    {
//        Thread.sleep(3000);
        OutputStreamWriter writer = new OutputStreamWriter(channel.getOutputStream());
        writer.write(command + "\n");
        writer.flush();
    }

}
