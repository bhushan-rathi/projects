package genericDeser.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

import genericDeser.driver.Driver;
import genericDeser.fileOperations.FileProcessorInterface;

public class PopulateObjects {
	
	private Driver d;
	private FileProcessorInterface fp2;
	private String clsName;
	private Class<?> c1;
	private Class<?> c2;
	@SuppressWarnings("rawtypes")
	private Class[] signature1;
	@SuppressWarnings("rawtypes")
	private Class[] signature2;
	private String methdName;
	private Method meth;
	private Object obj;
	private Object[] params;
	private Object result;
	private int count1;
	private int count2;
	private int uniquieCount1;
	private int uniquieCount2;
	private HashSet<Object> uniqueSet1;
	private HashSet<Object> uniqueSet2;
	/**
	 * @return the uniqueSet2
	 */
	public HashSet<Object> getUniqueSet2() {
		return uniqueSet2;
	}

	/**
	 * @param uniqueSet2 the uniqueSet2 to set
	 */
	public void setUniqueSet2(HashSet<Object> uniqueSet2) {
		this.uniqueSet2 = uniqueSet2;
	}

	/**
	 * @return the uniqueSet
	 */
	public HashSet<Object> getUniqueSet() {
		return uniqueSet1;
	}

	/**
	 * @param uniqueSet the uniqueSet to set
	 */
	public void setUniqueSet(HashSet<Object> uniqueSet) {
		this.uniqueSet1 = uniqueSet;
	}

	/**
	 * @return the uniquieCount1
	 */
	public int getUniquieCount1() {
		return uniquieCount1;
	}

	/**
	 * @param uniquieCount1 the uniquieCount1 to set
	 */
	public void setUniquieCount1(int uniquieCount1) {
		this.uniquieCount1 = uniquieCount1;
	}

	/**
	 * @return the uniquieCount2
	 */
	public int getUniquieCount2() {
		return uniquieCount2;
	}

	/**
	 * @param uniquieCount2 the uniquieCount2 to set
	 */
	public void setUniquieCount2(int uniquieCount2) {
		this.uniquieCount2 = uniquieCount2;
	}



	
	/**
	 * @return the count1
	 */
	public int getCount1() {
		return count1;
	}

	/**
	 * @param count1 the count1 to set
	 */
	public void setCount1(int count1) {
		this.count1 = count1;
	}

	/**
	 * @return the count2
	 */
	public int getCount2() {
		return count2;
	}

	/**
	 * @param count2 the count2 to set
	 */
	public void setCount2(int count2) {
		this.count2 = count2;
	}

	
	/**
	 * @return the d
	 */
	public Driver getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(Driver d) {
		this.d = d;
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

	/**
	 * @return the clsName
	 */
	public String getClsName() {
		return clsName;
	}

	/**
	 * @param clsName the clsName to set
	 */
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	/**
	 * @return the c1
	 */
	public Class<?> getC1() {
		return c1;
	}

	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(Class<?> c1) {
		this.c1 = c1;
	}

	/**
	 * @return the c2
	 */
	public Class<?> getC2() {
		return c2;
	}

	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(Class<?> c2) {
		this.c2 = c2;
	}

	/**
	 * @return the signature1
	 */
	@SuppressWarnings("rawtypes")
	public Class[] getSignature1() {
		return signature1;
	}

	/**
	 * @param signature1 the signature1 to set
	 */
	@SuppressWarnings("rawtypes")
	public void setSignature1(Class[] signature1) {
		this.signature1 = signature1;
	}

	/**
	 * @return the signature2
	 */
	@SuppressWarnings("rawtypes")
	public Class[] getSignature2() {
		return signature2;
	}

	/**
	 * @param signature2 the signature2 to set
	 */
	@SuppressWarnings("rawtypes")
	public void setSignature2(Class[] signature2) {
		this.signature2 = signature2;
	}

	/**
	 * @return the methdName
	 */
	public String getMethdName() {
		return methdName;
	}

	/**
	 * @param methdName the methdName to set
	 */
	public void setMethdName(String methdName) {
		this.methdName = methdName;
	}

	/**
	 * @return the meth
	 */
	public Method getMeth() {
		return meth;
	}

	/**
	 * @param meth the meth to set
	 */
	public void setMeth(Method meth) {
		this.meth = meth;
	}

	/**
	 * @return the obj
	 */
	public Object getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the hm
	 */
	@SuppressWarnings("rawtypes")
	public HashMap<String, Class> getHm() {
		return hm;
	}

	/**
	 * @param hm the hm to set
	 */
	public void setHm(@SuppressWarnings("rawtypes") HashMap<String, Class> hm) {
		this.hm = hm;
	}



	@SuppressWarnings("rawtypes")
	HashMap<String, Class> hm;

	@SuppressWarnings("rawtypes")
	public PopulateObjects (Driver d1, FileProcessorInterface fp2) {
		
		Logger.writeMessage("Constructor PopulateObjects", Logger.DebugLevel.IN_RESULTS);
		d = d1;
		this.fp2 = fp2;
		hm = new HashMap<String, Class>();
		uniqueSet1 = new HashSet<Object>();
		uniqueSet2 = new HashSet<Object>();
		hm.put("byte", byte.class);
		hm.put("short", short.class);
		hm.put("int", int.class);
		hm.put("long", long.class);
		hm.put("float", float.class);
		hm.put("double", double.class);
		hm.put("boolean", boolean.class);
		hm.put("char", char.class);
		hm.put("String", String.class);
	}
	
	public void totalFirstObjectFinder() {
		System.out.println("Total Number of First objects:" + d.getFirstObjectCount());
	}
	
	public void totalSecondObjectFinder() {
		System.out.println("Total Number of Second objects:" + d.getSecondObjectCount());	
	}
	
	public void uniqueFirstObjectFinder() {
		System.out.println("Total Number of First objects: ");
	}
	
	public void uniqueSecondObjectFinder() {
		System.out.println("Total Number of Second objects: ");
	}
	

	public Object memberIdentifier(String s0, String s2, String s3) {
		try {
		if(s0.equals("int")) {return new Integer(Integer.parseInt(s3));}
		else if(s0.equals("char")) {return new Character(s3.charAt(0));}
		else if(s0.equals("byte")) {return new Byte(Byte.parseByte(s3));}
		else if(s0.equals("float")) {return new Float(Float.parseFloat(s3));}
		else if(s0.equals("long")) {return new Long(Long.parseLong(s3));}
		else if(s0.equals("double")) {return new Double(Double.parseDouble(s3));}
		else if(s0.equals("short")) {return new Short(Short.parseShort(s3));}
		else if(s0.equals("boolean")) {return new Boolean(Boolean.parseBoolean(s3));}
		else if(s0.equals("String")) {return new String(s3);}
		}catch(NumberFormatException | NullPointerException e )
		{
			System.err.println("Exception in memberIdentifier Method");
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	public void deserObjects() {
		while(fp2.getLine() != null) {
			String temp6 = fp2.readString();
			
			if(temp6 == null) {break;}
			
			//String temp[] = temp6.split("<fqn:");
			//temp = temp[1].split(">");
			
			if(temp6.equals("<fqn:genericDeser.util.First>"))
			{	
				try {
						String clsNm[] = temp6.split("<fqn:");
						clsNm[0] = clsNm[1].replace(">", "");
						clsName = clsNm[0];
						c1 = Class.forName(clsName);
						obj = c1.newInstance();
					}catch (ClassNotFoundException|InstantiationException | IllegalAccessException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
					System.exit(1);
					}finally {}
				
				while(fp2.getLine() != null) {
					String temp7 = fp2.readString();
					if(temp7.equals("</fqn:genericDeser.util.First>"))
					{
						count1++;
						if(uniqueSet1.add(obj)==true) {uniquieCount1++;}
						break;
					}
				
				String[] parts = temp7.split(", ");
				parts[0] = parts[0].replace("<type=", "");
				parts[1] = parts[1].replace("var=", "");
				parts[2] = parts[2].replace("value=", "");
				parts[2] = parts[2].replaceAll(">", "");
				
						try {
							signature1 = new Class[1];
							signature1[0] = hm.get(parts[0]);
							methdName = "set" + parts[1];
							meth = c1.getMethod(methdName, signature1); 
							params = new Object[1];
							params[0] = memberIdentifier(parts[0], parts[1], parts[2]);
							result = meth.invoke(obj, params);
							}
						catch(IllegalAccessException|InvocationTargetException|
								NoSuchMethodException|NullPointerException e) {
							System.err.println("class First object creation failed");
							e.printStackTrace();
							System.exit(1);
						}finally {}
				
				}	
			}
			
			if(temp6.equals("<fqn:genericDeser.util.Second>"))
			{
				
				try {
					String clsNm[] = temp6.split("<fqn:");
					clsNm[0] = clsNm[1].replace(">", "");
					clsName = clsNm[0];
					c2 = Class.forName(clsName);
					obj = c2.newInstance();
					}
				catch(IllegalAccessException|InstantiationException| ClassNotFoundException e) {
					System.err.println("Class not fonud");
					e.printStackTrace();
					System.exit(1);
				}finally {}
				
				while(fp2.getLine() != null) {
					String temp8 = fp2.readString();
					if(temp8.equals("</fqn:genericDeser.util.Second>")){
						count2++;
						if(uniqueSet2.add(obj)==true) {uniquieCount2++;}
					break;}
					
					String[] parts = temp8.split(", ");
					parts[0] = parts[0].replace("<type=", "");
					parts[1] = parts[1].replace("var=", "");
					parts[2] = parts[2].replace("value=", "");
					parts[2] = parts[2].replaceAll(">", "");
					
					
							try {
								signature2 = new Class[1];
								signature2[0] = hm.get(parts[0]);
								methdName = "set" + parts[1];
								meth = c2.getMethod(methdName, signature2);
								params = new Object[1];
								params[0] = memberIdentifier(parts[0], parts[1], parts[2]);
								result = meth.invoke(obj, params);
								}
							catch(IllegalAccessException|IllegalArgumentException|
									InvocationTargetException|NoSuchMethodException|NullPointerException e) {
								System.err.println("class Second object creation failed");
								e.printStackTrace();
								System.exit(1);
							}finally {}
					}
			}
			
			
			
		}
	}
	
}
