package genericSerDeser.fileOperations;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import genericSerDeser.util.Logger;

public class FileProcessor implements FileProcessorInterface {
	/**
	 * return FileProcessor []
	 */
		@Override
		public String toString() {
			return "FileProcessor []";
		}
		private String filepath1;
		private String filepath2;
		
		private BufferedReader bufferedReader;
		private String line = "NotNull";
		
		private File f ;
		private FileOutputStream fos;
		private BufferedWriter br;
		
		

			public FileProcessor(String filepath1In, String filepath2In) {
				this.filepath1 = filepath1In;
				this.filepath2 = filepath2In;
		
					try {
						FileReader fileReader = new FileReader(filepath1);
							bufferedReader = new BufferedReader(fileReader);
							
							f = new File(filepath2);
							fos =  new FileOutputStream(f);
							 br = new BufferedWriter(new OutputStreamWriter(fos));
							
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
			 * returns void
			 * used to write in the file
			 */
					public void writeString(String outputFileIn){
						
						try{
							br.write(outputFileIn);
							
							br.write("\n");
							
						}catch(IOException e) {
							System.err.println("Error while writing in the file");
							System.exit(1);
						}catch(NullPointerException e) {
							try{
								br.close();
							}catch(IOException e1) {
								System.err.println("try in catch block");
								System.exit(1);
							}finally{}
						}
						finally {}
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
	
	/**
	 * 
	 * @return filepath2
	 */
	public String getFilepath2() {
		return filepath2;
	}
	/**
	 * returns void
	 * @param filepath2
	 */
	public void setFilepath2(String filepath2) {
		this.filepath2 = filepath2;
	}

	@Override
	public BufferedWriter getBr() {
		// TODO Auto-generated method stub
		return null;
	}
}