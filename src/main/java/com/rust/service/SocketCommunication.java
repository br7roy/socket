package com.rust.service;

import com.rust.component.RequestBean;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * FileName: SocketCommunication
 * Author:   Rust
 * DATE:     2017/8/10
 */
public class SocketCommunication {
    public static void main(String[] args) {
        String code = "c32";
        String action = "GET_ONLINE_AWARD";
        Object[] data = new Object[] {};
        String status = "END";
        new SocketCommunication(code, action, data, status,8437);
    }

    private static String reqMsg;

    private static Socket socket;

    private static Integer port;

    public SocketCommunication(Object... reqMsg) {
        this(new RequestBean(), reqMsg);

    }

    private SocketCommunication(RequestBean bean, Object... objects) {

        bean.setCode((String) objects[0]);
        bean.setAction((String) objects[1]);
        bean.setData(objects[2]);
        bean.setStatus((String) objects[3]);
        SocketCommunication.port = (Integer) objects[4];

        try {
//            SocketCommunication.reqMsg = JacksonJsonTools.toJson(bean);
//            System.out.println("请求报文："+reqMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startUp();

    }

    private static void startUp() {

        BufferedWriter bufferedWriter;
        OutputStream outputStream =null;
        try {
            String host = "localhost";
            socket = new Socket(host, port);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        try {
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            outputStream = socket.getOutputStream();
            //登录
//        	String s1 = "U8z2jO+ygzc9h386SwVcSYsyn6+ZKouNs5/Zd1xFpmo=";
            //进桌
//        	String s1 = "fYw3gWbPoRkUX6H3Hbz0zTh9VsW97AsFQ8MYzskul+X1g7GBScmhRDUMUFtlqA0Y";
            //进桌Ok
//        	String s1 = "F4jdxfQGHxWf1NtcG1k7xidcqaH0qm4yu3Db8GChuhc=";
            //领奖
            String s1 = "9xEWqh5RO/hCwWd5zd1vtydcqaH0qm4yu3Db8GChuhc=";
            //hb
//        	String s1 = "Ad5BxPonTEY9GuS3I4ZwPK+lpA5fMUrsIeDG73p/qeo=";
            ByteBuffer buf;
            byte[] b;

            buf = ByteBuffer.allocate(1000);
            buf.putInt(s1.length() + 4);
            buf.put(s1.getBytes("UTF-8"));

            buf.flip();

            b = new byte[buf.remaining()];
            buf.get(b, 0, buf.remaining());

            outputStream.write(b);






//            socket.shutdownOutput();

            StringBuilder respData = new StringBuilder();

            respData = new StringBuilder(stream2ReqData(new InputStreamReader(socket.getInputStream(), "UTF-8")));

            System.out.println("服务器响应数据:" + respData);
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String stream2ReqData(InputStreamReader inputStreamReader) throws IOException {
        char[] buffer = new char[1024];
        StringBuilder bf = new StringBuilder();
        int n = 0;
        while ((n = inputStreamReader.read(buffer)) != -1) {
            bf.append(new String(buffer, 0, n));
            if (n != 1024) {
                break;
            }
        }

        return bf.toString();
    }

}