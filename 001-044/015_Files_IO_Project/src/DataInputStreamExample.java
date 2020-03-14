import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamExample {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos= new FileOutputStream("F:\\workspace\\filefolder\\test.txt");
			
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeInt(123456);
			dos.writeFloat(18000.95f);
			dos.writeLong(987654);
			
			dos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream("F:\\workspace\\filefolder\\test.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readLong());
			
			dis.close();
			fis.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
