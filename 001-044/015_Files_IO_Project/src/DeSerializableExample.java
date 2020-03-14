import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializableExample {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("F:/workspace/filefolder/SerializedData.txt");
		FileInputStream fos = new FileInputStream(file);
		BufferedInputStream bos = new BufferedInputStream(fos);
		ObjectInputStream oos = new ObjectInputStream(bos);

		Employee emp = (Employee) oos.readObject();
		System.out.println(emp);
		oos.close();
		bos.close();
		fos.close();
		System.out.println("File is read successfully.....!!!!");
	}

}
