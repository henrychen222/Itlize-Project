import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerializableExample {

	public static void main(String[] args) throws IOException {

		File file=new File("F:/workspace/filefolder/SerializedData.txt");
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		Employee emp = new Employee(101, "Vicky", "Waqus", new Date(), 1234, 9874, "USA");
		oos.writeObject(emp);
		
		oos.flush();
		oos.close();
		bos.close();
		fos.close();
		System.out.println("File is created successfully.....!!!!");
	}

}
