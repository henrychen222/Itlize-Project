import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileWriterExample {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		File file=new File("F:/workspace/filefolder/output/");
		file.mkdirs();
		FileWriter writer = new FileWriter(file.getAbsolutePath()+"/SampleOutput.pdf");
		BufferedWriter bwriter = new BufferedWriter(writer);

		String str;
		
		FileReader freader=new FileReader("F:/workspace/filefolder/Sample.txt");
		BufferedReader breader=new BufferedReader(freader);
		while ((str = breader.readLine()) != null) {
			bwriter.write(str);
			bwriter.newLine();
		}
		
		bwriter.flush();
		bwriter.close();
		writer.close();
		breader.close();
		freader.close();
		System.out.println("File written is completed!!!!!!!!!!!!!!!!!!!!!!");

	}

}
