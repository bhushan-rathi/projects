package genericSerDeser.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.fileOperations.FileProcessorInterface;
import genericSerDeser.strategy.SerStrategy;

public class DPML implements SerStrategy{

	private FileProcessorInterface fp2;
	
	public String   createDPMLFormat(Object obj) throws Exception
	{
		String s1 = obj.getClass().getName();
	    fp2.writeString("<fqn:"+s1+">");
	    //System.out.println("<fqn:"+s1+">");
		for (Field field : obj.getClass().getDeclaredFields()) {
			
		    Type s2 = field.getType();
		  // String s3 = s2.toString();
		    @SuppressWarnings("unchecked")
			String memberType = ((Class<? extends Object>) s2).getSimpleName().toString();
		    String name = field.getName().toString();
		    PropertyDescriptor objP = new PropertyDescriptor(name, obj.getClass());
		    Object value = objP.getReadMethod().invoke(obj).toString();
		  /* 
		    if(s3.equals("class java.lang.String")) 
		   {
			   fp2.writeString("<type="+"String"+", var="+name+", value="+value+">");
			  System.out.println("<type="+"String"+", var="+name+", value="+value+">");
		   }
		   else
		   {
			*/   fp2.writeString("<type="+memberType+", var="+name+", value="+value+">");
			   //System.out.println("<type="+memberType+", var="+name+", value="+value+">");
		   //}
		}
		fp2.writeString("</fqn:"+s1+">");
	    //System.out.println("</fqn:"+s1+">");
		return null;
	}
	
	public DPML(FileProcessorInterface fp2) {
		super();
		this.fp2 = fp2;
		Logger.writeMessage("Constructor DPML", Logger.DebugLevel.IN_RUN);
	}
	/**
	 * @return the fp2
	 */
	public FileProcessorInterface getFp2() {
		return fp2;
	}

	/**
	 * @param fp2 the fp2 to set
	 */
	public void setFp2(FileProcessorInterface fp2) {
		this.fp2 = fp2;
	}	
}
