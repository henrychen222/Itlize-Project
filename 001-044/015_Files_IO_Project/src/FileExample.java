import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) throws IOException {
		int c;

		File fobj = new File("F:/workspace/filefolder/Sample.txt");
		FileInputStream fis = new FileInputStream(fobj);
		BufferedInputStream bis = new BufferedInputStream(fis, 6048);
		DataInputStream dis = new DataInputStream(bis);
		int count = 0;
		while ((c = dis.read()) != -1) {
			count++;
			System.out.print((char) c);
		}
		System.out.println("\n Number of Charecters :- " + count);
		System.out.println("\n File Size :" + fobj.length());
		System.out.println("File size in KB is : " + (float) fobj.length() / 1024);
		System.out.println("File size in MB is :" + (float) ((fobj.length() / (1024)) / 1024));
		
		dis.close();
		bis.close();
		fis.close();
	}

}
