/*
* Package com.rust.service 
* FileName: SocketService
* Author:   Rust
* Date:     2017/7/16 20:22
*/
package com.rust.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import com.rust.component.Response;

/**
 * FileName:    SocketService
 * Author:      Rust
 * Date:        2017/7/16
 * Description:
 */
public class SocketService {


    private static final boolean switchFlg = true;

    private static final String hostName = "10.28.53.197";



    public void startup(int port) {


        InputStream inputStream = null;

        InputStreamReader inputStreamReader = null;

        BufferedInputStream bufferedInputStream = null;

        BufferedReader bufferedReader = null;

        OutputStream outputStream = null;

        PrintWriter printWriter = null;

        Socket socket = null;

        ServerSocket serverSocket = null;

        boolean flg = Boolean.valueOf(switchFlg);

        byte[] addres = null;


        if (!flg) {

            String[] strings = hostName.split(".");

            int[] ints = new int[strings.length];

            addres = new byte[strings.length];

            for (int i = 0; i < strings.length; i++) {

                ints[i] = Integer.valueOf(strings[i]);

                addres[i] = (byte) ints[i];
            }
        }

        try {

            System.out.println("Socket 监听器 start...");

            serverSocket = new ServerSocket(port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {

            System.out.println("等待socket...");

            try {

                socket = serverSocket.accept();

                System.out.println("拦截成功...");

                //获取输出流，响应客户端的请求
                outputStream = socket.getOutputStream();

                inputStream = socket.getInputStream();


                inputStreamReader = new InputStreamReader(inputStream);

                bufferedReader = new BufferedReader(inputStreamReader);

//                String buffer = null;

//                StringBuilder stringBuilder = new StringBuilder(1024);
//
//                while ((buffer = bufferedReader.readLine()) != null) {
//
//                    stringBuilder.append(buffer);
//
//                }
//
//                String data = stringBuilder.toString();
//
//                System.out.println("传输流中客户端请求报文：" + data);

                inputStream = socket.getInputStream();

                //inputStreamReader = new InputStreamReader(inputStream, "GBK");

                //String reqData = stream2ReqData(inputStreamReader);

                bufferedInputStream = new BufferedInputStream(inputStream);
                String reqData = stream2Data2(bufferedInputStream);



                System.out.println("传输流中客户端请求报文：" + reqData);

                socket.shutdownInput();//关闭输入流

                printWriter = new PrintWriter(outputStream);

                Response response = new Response();

                String respData = response.toString();
                System.out.println("返回报文："+respData);
                printWriter.write(respData);
                printWriter.flush();//调用flush()方法将缓冲输出

                System.out.println("处理完毕...");


            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null) {
                        socket.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (outputStream != null) {

                        outputStream.close();
                    }
                    if (printWriter != null) {
                        printWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }

    static String stream2ReqData(InputStreamReader inputStreamReader) throws IOException {
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

    static String stream2Data2(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder sb = new StringBuilder();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            byteBuffer.put(bytes, 0, len);
            sb.append(new String(bytes));
        }
        return sb.toString();
    }
}
