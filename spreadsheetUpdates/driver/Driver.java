package spreadsheetUpdates.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spreadsheetUpdates.feature.Cell;
import spreadsheetUpdates.feature.Sheet1;
import spreadsheetUpdates.util.FileReaderInterface;
import spreadsheetUpdates.util.Logger;
import spreadsheetUpdates.util.Logger.DebugLevel;
import spreadsheetUpdates.util.MyFileReader;
import spreadsheetUpdates.util.Results;


/**
 * 
 * @author Bhushan Rathi
 *
 */

public class Driver {
	static boolean isCycle = false;
	public static void main(String[] args) {
		
		//Input validation
		if(args.length <3){
			System.err.println("please provide valid input arguments");
			System.exit(1);
		}

		//initilizing variables
		String input = args[0];
		String output = args[1];
		int DEBUG_VALUE = Integer.parseInt(args[2]);
		Logger.setDebugValue(DEBUG_VALUE);
		
		List<String> inputList = new ArrayList<String>();		
		FileReaderInterface inputReader = new MyFileReader(input);
		Results result = new Results();
		List outputList;

		//reading input file
		inputList = inputReader.read();

		Sheet1 sheet1 = new Sheet1();
		Map<String, Cell> cellPool = sheet1.demo(inputList);
		int totalValue = sheet1.calculateTotal(cellPool);
		

		//working on input andgenerating result
		outputList = sheet1.getOutputForFile();
		
		//printing output to file
		result.writeScheduleToFile(output, outputList, totalValue);
				
	}
		
}
