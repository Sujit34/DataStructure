package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadAndMerge {
	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		String inputFileFolderPath = projectPath + "\\src\\File\\InputFile"; 
		String outFileFolderPath = projectPath + "\\src\\File\\OutputFile";
		
		//String mergeFilePath = inputFileFolderPath + "\\" + "mergefile";
		String mergeFilePath = "C:/Data House/PracticeCoding/src/File/InputFile/mergefile"; 
		try(BufferedReader reader = new BufferedReader(new FileReader(mergeFilePath))){
			String line;
			while((line = reader.readLine())!= null) {
				System.out.println(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
