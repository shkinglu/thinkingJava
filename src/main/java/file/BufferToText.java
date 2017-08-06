package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	
	private static int BSIZE=1024;
	public static void main(String[] args) throws Exception {
		FileChannel fc=new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some Text".getBytes()));
		fc.close();
		
		fc=new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		buff.rewind();
		String encoding=System.getProperty("file.encoding");
		System.out.println("decode using"+encoding+":"+Charset.forName(encoding).decode(buff));
		
		 fc=new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some Text".getBytes("UTF-16BE")));
		fc.close();
		fc=new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());

	}

}
