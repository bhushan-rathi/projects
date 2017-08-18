package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.fileOperations.FileProcessorInterface;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

public class Driver {
	
	/**
	 * return Driver []
	 */
		@Override
		public String toString() {
			return "Driver []";
		}
		
		private String inputFile;
		private int DEBUG_VALUE;
		private int FirstObjectCount;
		private int SecondObjectCount;
		
		
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

		public int getSecondObjectCount() {
			return SecondObjectCount;
		}
		public void setSecondObjectCount(int secondObjectCount) {
			SecondObjectCount = secondObjectCount;
		}
		public int getFirstObjectCount() {
			return FirstObjectCount;
		}
		public void setFirstObjectCount(int firstObjectCount) {
			FirstObjectCount = firstObjectCount;
		}

		/**
		 * returns void
		 * @param args
		 */
		public static void main(String[] args){
			
			/**
			 * to validate number of arguments
			 */
			
			if(2 != args.length) {
				System.err.println("Number of Arguments are wrong, please provide 2 arguments");
				System.exit(1);
			}
			
			/**
			 * to initialize class variable
			 */
			
			Driver d = new Driver();
			d.setInputFile(args[0]);
			//System.out.println("Input file path: " +d.getInputFile());
			FileProcessorInterface fp = new FileProcessor(d.getInputFile());
			FileProcessorInterface fp2 = new FileProcessor(d.getInputFile());
			
			/**
			 * to validate debug value
			 */
			
			try {
					d.setDEBUG_VALUE(Integer.parseInt(args[1]));
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
			FileProcessorInterface fp1 = new FileProcessor(d.getInputFile());
			String temp4 = fp1.readString();
			if(temp4 == null) {
				System.err.println("File is empty");//
				System.exit(1);
			}
			
			/**
			 * reading file and performing req. operation
			 */
			
			while(fp.getLine() != null) {

				String temp6 = fp.readString();
				//System.out.println(temp6);
				if(temp6 == null) 
				{
					break;
				}
				if(temp6.equals("<fqn:genericDeser.util.First>"))
				{	
						d.setFirstObjectCount(d.getFirstObjectCount()+1);
				}
				if(temp6.equals("<fqn:genericDeser.util.Second>"))
				{
					d.setSecondObjectCount(d.getSecondObjectCount()+1);
				}
			}
			
			
			PopulateObjects p = new PopulateObjects(d, fp2);

			//System.out.println(p.getCount1() +"   "+ p.getCount2());
			p.deserObjects();
			
			System.out.println("Number of unique First objects: "+p.getUniqueSet().size());
			//System.out.println(p.getUniquieCount1());
			p.totalFirstObjectFinder();
			System.out.println("Number of unique Second objects: "+p.getUniqueSet2().size());
			p.totalSecondObjectFinder();
			//System.out.println(p.getUniqueSet2().size());
			
			//System.out.println(p.getCount1() +"   "+ p.getCount2());
			
			
		}
		
				
		
}
