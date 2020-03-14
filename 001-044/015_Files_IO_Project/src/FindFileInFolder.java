import java.io.File;

public class FindFileInFolder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFileInFolder fout = new FindFileInFolder();
		fout.findFile("F:/SESSION NOTES/JAVA SESSIONS/JAVA_POOJA&SPOORTHY&ALIAS&VERGHESEE", "Spring");

	}

	public void findFile(String fileDesPath, String matchedFileName) {

		File folder = new File(fileDesPath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile() && file.getName().startsWith(matchedFileName)) {
				System.out.println(file.getAbsolutePath());
			}else if(file.isDirectory()){
				findFile(file.getAbsolutePath(), matchedFileName); //recursive
			}
		}
	}

}
