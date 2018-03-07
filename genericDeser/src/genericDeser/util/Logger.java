package genericDeser.util;

public class Logger {
	/*DEBUG_VALUE=4 [Print to stdout every time a file processor constructor is called]
    DEBUG_VALUE=3 [Print to stdout every time a line from file is read]
    DEBUG_VALUE=2 [Print to stdout every time a PopulateObjects constructor is called]
    DEBUG_VALUE=1 [Print to stdout the contents of the data structure in the store]
    DEBUG_VALUE=0 [Only O/P will get print on console]
	 */

  public static enum DebugLevel {RELEASE, FROM_RESULTS, IN_RESULTS, IN_RUN, CONSTRUCTOR
                                 };

  private static DebugLevel debugLevel;


  public static DebugLevel getDebugLevel() {
	return debugLevel;
}


public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  case 3: debugLevel = DebugLevel.IN_RUN; break;
	  case 2: debugLevel = DebugLevel.IN_RESULTS; break;
	  case 1: debugLevel = DebugLevel.FROM_RESULTS; break;
	  case 0: debugLevel = DebugLevel.RELEASE; break;
	}
  }

  public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
  }

  // @return None
  public static void writeMessage (String  message  ,
                                   DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
  }

  /**
	 * @return String
	 */
  public String toString() {
	return "Debug Level is " + debugLevel;
  }

}
