package genericSerDeser.driver;

import java.io.IOException;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.fileOperations.FileProcessorInterface;
import genericSerDeser.strategy.SerStrategy;
import genericSerDeser.util.DPML;
import genericSerDeser.util.Logger;
import genericSerDeser.util.PopulateObjects;

public class Driver {
	
	/**
	 * return Driver []
	 */
		@Override
		public String toString() {
			return "Driver []";
		}
		
		private String inputFile;
		private String outputFile;
		private int DEBUG_VALUE;
		
		
		public static void main(String[] args){
			/**
			 * to validate number of arguments
			 */
			
			if(3 != args.length) {
				System.err.println("Number of Arguments are wrong, please provide 3 arguments");
				System.exit(1);
			}
			
			/**
			 * to initialize class variable
			 */
			
			Driver d = new Driver();
			d.setInputFile(args[0]);
			d.setOutputFile(args[1]);
			FileProcessorInterface fp2 = new FileProcessor(d.getInputFile(), d.getOutputFile());
			
			/**
			 * to validate debug value
			 */
			
			try {
					d.setDEBUG_VALUE(Integer.parseInt(args[2]));
					//System.out.println("Debug value is: "+d.getDEBUG_VALUE());
					if(!((0==d.getDEBUG_VALUE()) | (1==d.DEBUG_VALUE) | (2==d.DEBUG_VALUE) | (3==d.DEBUG_VALUE)
						| (4==d.DEBUG_VALUE))){
						System.err.println("Number of Debug Value should be an interger "
										+ "| from 0 to 4 ");
						System.exit(1);
					}
					Logger.setDebugValue(d.getDEBUG_VALUE());////
			}catch(NumberFormatException e) {
					System.err.println("Please provide integer value for Debug code");
					System.exit(1);
			}finally {}
			
			
			/**
			 * To check the file is empty or not
			 */
			FileProcessorInterface fp1 = new FileProcessor(d.getInputFile(), d.getOutputFile());
			String temp4 = fp1.readString();
			if(temp4 == null) {
				System.err.println("File is empty");//
				System.exit(1);
			}
			
			SerStrategy sr = new DPML(fp2);		
			PopulateObjects p = new PopulateObjects(d, fp2, sr);
			p.deserObjects();
			int a = p.getArrayList().size();
			for(int i =0; i<=a;i++)
			{
				
				if(i==a) {fp2.writeString(null);}
				else{
				try {
					Object obj = p.getArrayList().get(i);
					p.processObjects(obj, sr);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {}
				}
			}
			

		}
		
		/**
		 * @return the outputFile
		 */
		public String getOutputFile() {
			return outputFile;
		}
		/**
		 * @param outputFile the outputFile to set
		 */
		public void setOutputFile(String outputFile) {
			this.outputFile = outputFile;
		}
		/**
		 *
		 * @return inputFile
		 */
		public String getInputFile() {
			return inputFile;
		}
		
	/**
	 * returns void
	 * @param inputFileIn
	 */
		public void setInputFile(String inputFileIn) {
			this.inputFile = inputFileIn;
		}
	
	/**
	 * returns DEBUG_VALUE
	 * @return
	 */
		public int getDEBUG_VALUE() {
			return DEBUG_VALUE;
		}
	/**
	 * returns void
	 * @param dEBUG_VALUEIn
	 */
		public void setDEBUG_VALUE(int dEBUG_VALUEIn) {
			DEBUG_VALUE = dEBUG_VALUEIn;
		}
		/**
		 * returns void
		 * @param args
		 */		
		
}