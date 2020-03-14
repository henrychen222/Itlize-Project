import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


@SuppressWarnings("unused")
public class FileReaderExample {

	public static void main(String[] args) throws IOException {
		String str;
		
		FileReader fobj=new FileReader("F:\\workspace\\filefolder\\Sample.txt");
		BufferedReader bis=new BufferedReader(fobj, 6096);
		int count=0;
		while((str=bis.readLine()) != null){
			count++;
				System.out.println(str);
		}
		System.out.println("\n Number for Lines count :- "+count); 
		bis.close();
		fobj.close();
	}

}
