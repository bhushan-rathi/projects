package genericSerDeser.fileOperations;

import java.io.BufferedWriter;

public interface FileProcessorInterface {

	public String readString();
	public String getLine();
	
	public void writeString(String s1);
	public BufferedWriter getBr();

}