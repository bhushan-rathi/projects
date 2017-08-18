package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import genericDeser.util.Logger;

public class FileProcessor implements FileProcessorInterface {
	/**
	 * return FileProcessor []
	 */
		@Override
		public String toString() {
			return "FileProcessor []";
		}
		private String filepath1;
		private BufferedReader bufferedReader;
		private String line = "NotNull";
		
		
		

			public FileProcessor(String filepath1In) {
				this.filepath1 = filepath1In;
		
					try {
						FileReader fileReader = new FileReader(filepath1);
							bufferedReader = new BufferedReader(fileReader);
						 //Logger.writeMessage("Constructor FileProcessor", Logger.DebugLevel.CONSTRUCTOR);
							Logger.writeMessage("Constructor FileProcessor", Logger.DebugLevel.CONSTRUCTOR);
					}catch(IOException e){
						System.err.println("IO Exception | File not found");
						System.exit(1);
					}finally {}
				
			}
			
			/**
			 * returns String
			 * used to read from the file
			 */
			public String readString(){
				try {
					Logger.writeMessage("Reading line from file", Logger.DebugLevel.IN_RUN);
						if(null != line) {
							line = 	bufferedReader.readLine();
						}
						if(line == null)
							bufferedReader.close();
							
							//return line;
					}catch(IOException e) {
						System.err.println("File not found");
						System.exit(1);		
					}finally {}
				
				return line;
			}
				
	/**
	 * 
	 * @return bufferedReader
	 */
	public BufferedReader getBufferedReader() {
		return bufferedReader;
	}
	/**
	 * returns void
	 * @param bufferedReader
	 */
	public void setBufferedReader(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	/**
	 * returns line
	 */
	public String getLine() {
		return line;
	}
	/**
	 * returns void
	 * @param line
	 */
	public void setLine(String line) {
		this.line = line;
	}
	/**
	 * 
	 * @return filepath1
	 */
	public String getFilepath1() {
		return filepath1;
	}
	/**
	 * returns void
	 * @param filepath1
	 */
	public void setFilepath1(String filepath1) {
		this.filepath1 = filepath1;
	}
		
}
