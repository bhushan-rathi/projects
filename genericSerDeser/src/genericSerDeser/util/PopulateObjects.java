package genericSerDeser.util;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import genericSerDeser.driver.Driver;
import genericSerDeser.fileOperations.FileProcessorInterface;
import genericSerDeser.strategy.SerStrategy;

public class PopulateObjects {
	
	private Driver d;
	private FileProcessorInterface fp2;
	private SerStrategy sr;
	//private SerStrategy;
	private Class<?> c1;
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
	private int uniquieCount1;
	private int uniquieCount2;
	private HashSet<Object> uniqueSet1;
	private HashSet<Object> uniqueSet2;
	private int simpleCount1;
	private int simpleCount2;
	private String firstClass;
	private String secondClass;
	private String firstClassEnd;
	private String secondClassEnd;
	private String classStart;
	private String classEnd;
	private int lineNumber;
	private ArrayList<Object> arrayList;
	
	public PopulateObjects (Driver d1, FileProcessorInterface fp2, SerStrategy srIn) {
		
		Logger.writeMessage("Constructor PopulateObjects", Logger.DebugLevel.IN_RESULTS);
		d = d1;
		this.fp2 = fp2;
		this.sr = srIn;
		hm = new HashMap<String, Class>();
		uniqueSet1 = new HashSet<Object>();
		uniqueSet2 = new HashSet<Object>();
		arrayList = new ArrayList<Object>();
		hm.put("byte", byte.class);
		hm.put("short", short.class);
		hm.put("int", int.class);
		hm.put("long", long.class);
		hm.put("float", float.class);
		hm.put("double", double.class);
		hm.put("boolean", boolean.class);
		hm.put("char", char.class);
		hm.put("String", String.class);
		firstClass = "fqn:genericSerDeser.util.First";
		secondClass = "fqn:genericSerDeser.util.Second";
		firstClassEnd = "/fqn:genericSerDeser.util.First";
		secondClassEnd = "/fqn:genericSerDeser.util.Second";
		classStart = "<fqn:";
		classEnd = "</fqn:";
		
	}

	public Object memberIdentifier(String s0, String s2, String s3, String s4) {
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
			System.out.println(s4);
			System.out.println(lineNumber);
			System.err.println("Exception in memberIdentifier Method");
			e.printStackTrace();
			System.exit(1);
		}finally {}
		return null;
	}
	
	public void processObjects(Object obj, SerStrategy sr) throws Exception {
		sr.createDPMLFormat(obj);
	}
	
	public void deserObjects() {
		while(fp2.getLine() != null) {
			String temp6 = fp2.readString();
			if(temp6 == null) {break;}
			if(temp6.contains(classStart))
			{	
				if(temp6.contains(firstClass))
				{	
					try {		
						String s1 = temp6.substring(5);
						s1 = new StringBuffer(s1).reverse().toString();
						s1 = s1.substring(1);
						s1 = new StringBuffer(s1).reverse().toString();
						c1 = Class.forName(s1);
						obj = c1.newInstance();
					}catch (ClassNotFoundException|InstantiationException | IllegalAccessException e1) {
					//TODO Auto-generated catch block
					e1.printStackTrace();
					System.exit(1);
					}finally {}
				
					while(fp2.getLine() != null) 
					{
						String temp7 = fp2.readString();
						if(temp7.contains(firstClassEnd))
						{
							count1++;
							if(uniqueSet1.add(obj)==true) {simpleCount1++;uniquieCount1++;}
							else {simpleCount1++;}
							arrayList.add(obj);
							try {
								//processObjects(obj, sr);
								//fp2.writeString("</fqn:"+firstClassEnd+">");
							}catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						}
				
				
						try {
							String[] parts1 = temp7.split(",", 3);
							parts1[0] = parts1[0].substring(6);
							parts1[1] = parts1[1].substring(5);
							parts1[2] = parts1[2].substring(7);
							parts1[2] = new StringBuffer(parts1[2]).reverse().toString();
							parts1[2] = parts1[2].substring(1);
							parts1[2] = new StringBuffer(parts1[2]).reverse().toString();
							signature1 = new Class[1];
							signature1[0] = hm.get(parts1[0]);
							methdName = "set" + parts1[1];
							meth = c1.getMethod(methdName, signature1); 
							params = new Object[1];
							params[0] = memberIdentifier(parts1[0], parts1[1], parts1[2], temp7);
							result = meth.invoke(obj, params);
							}
						catch(ArrayIndexOutOfBoundsException|IllegalAccessException|InvocationTargetException|
								NoSuchMethodException|NullPointerException e)
						{
							System.err.println("class First object creation failed");
							e.printStackTrace();
							System.exit(1);
						}finally {}
					}	
				}
			
				if(temp6.contains(secondClass))
				{
					try {
						String s1 = temp6.substring(5);
						s1 = new StringBuffer(s1).reverse().toString();
						s1 = s1.substring(1);
						s1 = new StringBuffer(s1).reverse().toString();
						c1 = Class.forName(s1);
						obj = c1.newInstance();
						}
					catch(IllegalAccessException|InstantiationException| ClassNotFoundException e)
					{
						System.err.println("Class not fonud");
						e.printStackTrace();
						System.exit(1);
					}finally {}
				
						while(fp2.getLine() != null)
						{
							String temp8 = fp2.readString();
							if(temp8.contains(secondClassEnd))
							{
								count1++;
								if(uniqueSet2.add(obj)==true) {simpleCount2++;uniquieCount2++;}
								else {simpleCount2++;}
								arrayList.add(obj);
								try {
									//processObjects(obj,sr);
									//fp2.writeString("</fqn:"+secondClassEnd+">");
								}catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
							try {	
								String[] parts1 = temp8.split(",", 3);
								parts1[0] = parts1[0].substring(6);
								parts1[1] = parts1[1].substring(5);
								parts1[2] = parts1[2].substring(7);
								parts1[2] = new StringBuffer(parts1[2]).reverse().toString();
								parts1[2] = parts1[2].substring(1);
								parts1[2] = new StringBuffer(parts1[2]).reverse().toString();
							
								signature2 = new Class[1];
								signature2[0] = hm.get(parts1[0]);
								methdName = "set" + parts1[1];
								meth = c1.getMethod(methdName, signature2);
								params = new Object[1];
								params[0] = memberIdentifier(parts1[0], parts1[1], parts1[2], temp8);
								result = meth.invoke(obj, params);
								}
							catch(ArrayIndexOutOfBoundsException |IllegalAccessException|IllegalArgumentException|
									InvocationTargetException|NoSuchMethodException|NullPointerException e)
							{
								System.err.println("class Second object creation failed");
								e.printStackTrace();
								System.exit(1);
							}finally {}
					}
				}
			
			
			}	
		}
		
		//printOutput();
	}

	
	public void printOutput() {
		System.out.println("Number of unique First objects: "+getUniqueSet().size());
		System.out.println("Total Number of Second objects:" + getSimpleCount1());
		System.out.println("Number of unique Second objects: "+getUniqueSet2().size());
		System.out.println("Total Number of Second objects:" +getSimpleCount2());
		System.out.println("Total Number of objects: " +arrayList.size());
		
	}
	
	/**
	 * @return the arrayList
	 */
	public ArrayList<Object> getArrayList() {
		return arrayList;
	}

	/**
	 * @param arrayList the arrayList to set
	 */
	public void setArrayList(ArrayList<Object> arrayList) {
		this.arrayList = arrayList;
	}

	@SuppressWarnings("rawtypes")
	HashMap<String, Class> hm;

	@SuppressWarnings("rawtypes")

	/**
	 * @return the sr
	 */
	public SerStrategy getSr() {
		return sr;
	}

	/**
	 * @param sr the sr to set
	 */
	public void setSr(SerStrategy sr) {
		this.sr = sr;
	}
	/**
	 * @return the classStart
	 */
	public String getClassStart() {
		return classStart;
	}

	/**
	 * @param classStart the classStart to set
	 */
	public void setClassStart(String classStart) {
		this.classStart = classStart;
	}

	/**
	 * @return the classEnd
	 */
	public String getClassEnd() {
		return classEnd;
	}

	/**
	 * @param classEnd the classEnd to set
	 */
	public void setClassEnd(String classEnd) {
		this.classEnd = classEnd;
	}

	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the uniqueSet1
	 */
	public HashSet<Object> getUniqueSet1() {
		return uniqueSet1;
	}

	/**
	 * @param uniqueSet1 the uniqueSet1 to set
	 */
	public void setUniqueSet1(HashSet<Object> uniqueSet1) {
		this.uniqueSet1 = uniqueSet1;
	}

	/**
	 * @return the simpleCount1
	 */
	public int getSimpleCount1() {
		return simpleCount1;
	}

	/**
	 * @param simpleCount1 the simpleCount1 to set
	 */
	public void setSimpleCount1(int simpleCount1) {
		this.simpleCount1 = simpleCount1;
	}

	/**
	 * @return the simpleCount2
	 */
	public int getSimpleCount2() {
		return simpleCount2;
	}

	/**
	 * @param simpleCount2 the simpleCount2 to set
	 */
	public void setSimpleCount2(int simpleCount2) {
		this.simpleCount2 = simpleCount2;
	}

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

	/**
	 * @return the firstClass
	 */
	public String getFirstClass() {
		return firstClass;
	}

	/**
	 * @param firstClass the firstClass to set
	 */
	public void setFirstClass(String firstClass) {
		this.firstClass = firstClass;
	}

	/**
	 * @return the secondClass
	 */
	public String getSecondClass() {
		return secondClass;
	}

	/**
	 * @param secondClass the secondClass to set
	 */
	public void setSecondClass(String secondClass) {
		this.secondClass = secondClass;
	}

	/**
	 * @return the firstClassEnd
	 */
	public String getFirstClassEnd() {
		return firstClassEnd;
	}

	/**
	 * @param firstClassEnd the firstClassEnd to set
	 */
	public void setFirstClassEnd(String firstClassEnd) {
		this.firstClassEnd = firstClassEnd;
	}

	/**
	 * @return the secondClassEnd
	 */
	public String getSecondClassEnd() {
		return secondClassEnd;
	}

	/**
	 * @param secondClassEnd the secondClassEnd to set
	 */
	public void setSecondClassEnd(String secondClassEnd) {
		this.secondClassEnd = secondClassEnd;
	}
	
}