package genericDeser.util;

public class First{

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (BooleanValue ? 1231 : 1237);
		result = prime * result + ByteValue;
		result = prime * result + CharValue;
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(FloatValue);
		result = prime * result + IntValue;
		result = prime * result + (int) (LongValue ^ (LongValue >>> 32));
		result = prime * result + ShortValue;
		result = prime * result + ((StringValue == null) ? 0 : StringValue.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		First other = (First) obj;
		if (BooleanValue != other.BooleanValue)
			return false;
		if (ByteValue != other.ByteValue)
			return false;
		if (CharValue != other.CharValue)
			return false;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (Float.floatToIntBits(FloatValue) != Float.floatToIntBits(other.FloatValue))
			return false;
		if (IntValue != other.IntValue)
			return false;
		if (LongValue != other.LongValue)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
	
	public First() {
		super();
	}
	
	private byte ByteValue;
	private char CharValue;
	private int IntValue;
	private float FloatValue;
	private boolean BooleanValue;
	private short ShortValue;
	private long LongValue;
	private double DoubleValue;
	private String StringValue;
	
	/**
	 * @param byteValue the byteValue to set
	 */
	public void setByteValue(byte byteValue) {
		ByteValue = byteValue;
	}
	/**
	 * @param charValue the charValue to set
	 */
	public void setCharValue(char charValue) {
		CharValue = charValue;
	}
	/**
	 * @param intValue the intValue to set
	 */
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}
	/**
	 * @param floatValue the floatValue to set
	 */
	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}
	/**
	 * @param b the boolean to set
	 */
	public void setBooleanValue(boolean b) {
		BooleanValue = b;
	}
	/**
	 * @param shortValue the shortValue to set
	 */
	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}
	/**
	 * @param longValue the longValue to set
	 */
	public void setLongValue(long longValue) {
		LongValue = longValue;
	}
	/**
	 * @param doubleValue the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}
	/**
	 * @param stringValue the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}
	
	

}
