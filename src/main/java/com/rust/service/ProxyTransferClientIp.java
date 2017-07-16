package com.rust.service;


import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

public class ProxyTransferClientIp {

	public ProxyTransferClientIp() {
	}

	public static void doTest01() {
		String s1 =
				"U8z2jO+ygzc9h386SwVcSYsyn6+ZKouNs5/Zd1xFpmo=";

		String s2 = "PROXY TCP4 155.155.155.155 255.255.255.255 15535 65535\r\n";

		String s3 = "Ad5BxPonTEY9GuS3I4ZwPK+lpA5fMUrsIeDG73p/qeo=";

		try {
			ByteBuffer buf = ByteBuffer.allocate(1000);
			buf.putInt(s1.length() + 4);
			buf.put(s1.getBytes("UTF-8"));
			buf.put(s2.getBytes("UTF-8"));
			buf.putInt(s3.length() + 4);
			buf.put(s3.getBytes("UTF-8"));

			buf.flip();

			byte[] b = new byte[buf.remaining()];
			buf.get(b, 0, buf.remaining());

			Socket sock = new Socket("192.168.62.30", 8437);
			InputStream in = sock.getInputStream();

			byte[] inByte = new byte[1024];
			int inLen = in.read(inByte);

			System.out.println(new String(inByte, 0, inLen));

			OutputStream out = sock.getOutputStream();
			out.write(b);
			out.flush();

			Thread.sleep(100000);

			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doTest02() {
		String s1 =
				"fYw3gWbPoRkUX6H3Hbz0zTh9VsW97AsFQ8MYzskul+X1g7GBScmhRDUMUFtlqA0Y";

		String s2 = "PRO";

		String s3 = "XY TCP4 155.155.155.155 255.255.255.255 15535 65535\r\n";

		String s4 = "Ad5BxPonTEY9GuS3I4ZwPK+lpA5fMUrsIeDG73p/qeo=";

		try {

			Socket sock = new Socket("192.168.62.26", 8421);
			InputStream in = sock.getInputStream();

			byte[] inByte = new byte[1024];
			int inLen = in.read(inByte);

			System.out.println(new String(inByte, 0, inLen));

			OutputStream out = sock.getOutputStream();

			ByteBuffer buf;
			byte[] b;

			buf = ByteBuffer.allocate(1000);
			buf.putInt(s1.length() + 4);
			buf.put(s1.getBytes("UTF-8"));
			buf.put(s2.getBytes("UTF-8"));

			buf.flip();

			b = new byte[buf.remaining()];
			buf.get(b, 0, buf.remaining());

			out.write(b);
			out.flush();

			Thread.sleep(10000);

			buf = ByteBuffer.allocate(1000);
			buf.put(s3.getBytes("UTF-8"));
			buf.putInt(s4.length() + 4);
			buf.put(s4.getBytes("UTF-8"));

			buf.flip();

			b = new byte[buf.remaining()];
			buf.get(b, 0, buf.remaining());

			out.write(b);
			out.flush();

			Thread.sleep(100000);

			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doTest03() {
		String s1 =
				"9xEWqh5RO/hCwWd5zd1vtydcqaH0qm4yu3Db8GChuhc=";

		String s2 = "\r\n";

		String s3 = "Ad5BxPonTEY9GuS3I4ZwPK+lpA5fMUrsIeDG73p/qeo=";

		try {
			Socket sock = new Socket("localhost", 8437);
			InputStream in = sock.getInputStream();

			byte[] inByte = new byte[1024];
			int inLen = in.read(inByte);

			System.out.println(new String(inByte, 0, inLen));

			OutputStream out = sock.getOutputStream();

			ByteBuffer buf;

			buf = ByteBuffer.allocate(1000);
			buf.putInt(s1.length() + 4);
			buf.put(s1.getBytes());
			buf.putInt(s2.length() + s3.length() + 4);
			buf.put(s2.getBytes());

			buf.flip();

			out.write(buf.array(), 0, buf.remaining());
			out.flush();

			Thread.sleep(3000);

			out.write(s3.getBytes());
			out.flush();

			Thread.sleep(100000);

			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getOnlineAward() {

		String s1 = "U8z2jO+ygzc9h386SwVcSYsyn6+ZKouNs5/Zd1xFpmo=";
		String s2 = "fYw3gWbPoRkUX6H3Hbz0zTh9VsW97AsFQ8MYzskul+X1g7GBScmhRDUMUFtlqA0Y";
		String s3 = "9xEWqh5RO/hCwWd5zd1vtydcqaH0qm4yu3Db8GChuhc=";

	}







	public static void main(String[] args) {
		new Task(1);


	}

}
