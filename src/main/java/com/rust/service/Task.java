package com.rust.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;

/**
 * FileName: Task
 * Author:   Rust
 * DATE:     2017/8/11
 */
public class Task {
    public static void main(String[] args) {
        new Task(1);
    }

    private Timer timer;

    public Task(int second) {
        timer = new Timer();
        timer.schedule(new BeatTask(), 0, second * 1000);
    }

    class BeatTask extends TimerTask {

        @Override
        public void run() {
            try {

                boolean flg = true;


                System.out.println("心跳");

                Socket socket = new Socket("192.168.62.30", 8437);
//                Socket socket = new Socket("122.226.186.185", 8431);
                OutputStream outputStream = socket.getOutputStream();
                ByteBuffer buf = null;
                byte[] b;


                String s0 = "0+9ow8YnSch5I35ztSqchxFb9tE2wosMDFLqKYZ38EZQVQdTknZ9ibkO95DonJKN4YX3ep/n4KJ7fVFTMxng0jxkRPQn9VVYgXfLJDxwjHSLMp+vmSqLjbOf2XdcRaZq";
                String hb = "Ad5BxPonTEY9GuS3I4ZwPK+lpA5fMUrsIeDG73p/qeo=";//心跳
                String s1 = "U8z2jO+ygzc9h386SwVcSYsyn6+ZKouNs5/Zd1xFpmo=";//登录
                //心跳
                String c42 = "ipC5SMmXQa+RhN+gDA91rk0kdeqrq+nePuYpaC/l6Xw=";
                String c44 = "/PRtnQruWCY0yEtwsP0TxydcqaH0qm4yu3Db8GChuhc=";
                //心跳
                String s3 = "fYw3gWbPoRkUX6H3Hbz0zTh9VsW97AsFQ8MYzskul+X1g7GBScmhRDUMUFtlqA0Y";//进桌
                String s4 = "F4jdxfQGHxWf1NtcG1k7xidcqaH0qm4yu3Db8GChuhc=";//进桌Ok
                //心跳
                String s5 = "9xEWqh5RO/hCwWd5zd1vtydcqaH0qm4yu3Db8GChuhc=";//领奖

                if (flg) {
                    System.out.println("connect");
                    buf = ByteBuffer.allocate(10000);
                    buf.putInt(s0.length() + 4);
                    buf.put(s0.getBytes("UTF-8"));
                    buf.flip();
                    b = new byte[buf.remaining()];
                    buf.get(b, 0, buf.remaining());
                    outputStream.write(b);
                    outputStream.flush();

                    Thread.sleep(500);
                }


                System.out.println("心跳");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(hb.length() + 4);
                buf.put(hb.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(500);


                System.out.println("登录");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(s1.length() + 4);
                buf.put(s1.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(500);

                System.out.println("心跳");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(hb.length() + 4);
                buf.put(hb.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(1000);


//                System.out.println("客户拥有物品查询");
//                buf.clear();
//                buf = ByteBuffer.allocate(10000);
//                buf.putInt(c42.length() + 4);
//                buf.put(c42.getBytes("UTF-8"));
//                buf.flip();
//                b = new byte[buf.remaining()];
//                buf.get(b, 0, buf.remaining());
//                outputStream.write(b);
//                outputStream.flush();
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//
//                System.out.println("邮件列表");
//                buf.clear();
//                buf = ByteBuffer.allocate(10000);
//                buf.putInt(c44.length() + 4);
//                buf.put(c44.getBytes("UTF-8"));
//                buf.flip();
//                b = new byte[buf.remaining()];
//                buf.get(b, 0, buf.remaining());
//                outputStream.write(b);
//                outputStream.flush();
//
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }


                System.out.println("心跳");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(hb.length() + 4);
                buf.put(hb.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(500);

                System.out.println("进桌");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(s3.length() + 4);
                buf.put(s3.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(1000);


                System.out.println("进桌ok");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(s4.length() + 4);
                buf.put(s4.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                System.out.println("进桌，等待0.5秒发领奖请求");
                Thread.sleep(500);

                /////////////////////////////

                System.out.println("心跳");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(hb.length() + 4);
                buf.put(hb.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                Thread.sleep(500);


                System.out.println("领奖");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(s5.length() + 4);
                buf.put(s5.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();

                System.out.println("领奖");
                buf.clear();
                buf = ByteBuffer.allocate(10000);
                buf.putInt(s5.length() + 4);
                buf.put(s5.getBytes("UTF-8"));
                buf.flip();
                b = new byte[buf.remaining()];
                buf.get(b, 0, buf.remaining());
                outputStream.write(b);
                outputStream.flush();
//
//                System.out.println("心跳");
//                buf.clear();
//                buf = ByteBuffer.allocate(10000);
//                buf.putInt(hb.length() + 4);
//                buf.put(hb.getBytes("UTF-8"));
//                buf.flip();
//                b = new byte[buf.remaining()];
//                buf.get(b, 0, buf.remaining());
//                outputStream.write(b);
//                outputStream.flush();
//
//                    Thread.sleep(500);
//
//
//                System.out.println("领奖2");
//                buf.clear();
//                buf = ByteBuffer.allocate(10000);
//                buf.putInt(s5.length() + 4);
//                buf.put(s5.getBytes("UTF-8"));
//                buf.flip();
//                b = new byte[buf.remaining()];
//                buf.get(b, 0, buf.remaining());
//                outputStream.write(b);
//                outputStream.flush();
//
//                Thread.sleep(10000);
//
//                System.out.println("领奖3");
//                buf.clear();
//                buf = ByteBuffer.allocate(10000);
//                buf.putInt(s5.length() + 4);
//                buf.put(s5.getBytes("UTF-8"));
//                buf.flip();
//                b = new byte[buf.remaining()];
//                buf.get(b, 0, buf.remaining());
//                outputStream.write(b);
//                outputStream.flush();

                Thread.sleep(20000);
                System.out.println("任务结束，等待20秒");

                flg = false;


                socket.shutdownOutput();


            } catch (IOException | InterruptedException e) {
                e.printStackTrace();

            }


        }
    }
}
