package genericSerDeser.util;

import genericSerDeser.util.First;

public class First{

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "First [BooleanValue=" + BooleanValue + ", ByteValue=" + ByteValue + ", CharValue=" + CharValue
				+ ", DoubleValue=" + DoubleValue + ", FloatValue=" + FloatValue + ", IntValue=" + IntValue
				+ ", LongValue=" + LongValue + ", ShortValue=" + ShortValue + ", StringValue=" + StringValue + "]";
	}
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
	
	private boolean BooleanValue;
	private byte ByteValue;
	private char CharValue;
	private double DoubleValue;
	private float FloatValue;
	private int IntValue;
	private long LongValue;
	private short ShortValue;
	private String StringValue;
	
	/**
	 * @return the booleanValue
	 */
	public boolean isBooleanValue() {
		return BooleanValue;
	}
	/**
	 * @param booleanValue the booleanValue to set
	 */
	public void setBooleanValue(boolean booleanValue) {
		BooleanValue = booleanValue;
	}
	/**
	 * @return the byteValue
	 */
	public byte getByteValue() {
		return ByteValue;
	}
	/**
	 * @param byteValue the byteValue to set
	 */
	public void setByteValue(byte byteValue) {
		ByteValue = byteValue;
	}
	/**
	 * @return the charValue
	 */
	public char getCharValue() {
		return CharValue;
	}
	/**
	 * @param charValue the charValue to set
	 */
	public void setCharValue(char charValue) {
		CharValue = charValue;
	}
	/**
	 * @return the doubleValue
	 */
	public double getDoubleValue() {
		return DoubleValue;
	}
	/**
	 * @param doubleValue the doubleValue to set
	 */
	public void setDoubleValue(double doubleValue) {
		DoubleValue = doubleValue;
	}
	/**
	 * @return the floatValue
	 */
	public float getFloatValue() {
		return FloatValue;
	}
	/**
	 * @param floatValue the floatValue to set
	 */
	public void setFloatValue(float floatValue) {
		FloatValue = floatValue;
	}
	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return IntValue;
	}
	/**
	 * @param intValue the intValue to set
	 */
	public void setIntValue(int intValue) {
		IntValue = intValue;
	}
	/**
	 * @return the longValue
	 */
	public long getLongValue() {
		return LongValue;
	}
	/**
	 * @param longValue the longValue to set
	 */
	public void setLongValue(long longValue) {
		LongValue = longValue;
	}
	/**
	 * @return the shortValue
	 */
	public short getShortValue() {
		return ShortValue;
	}
	/**
	 * @param shortValue the shortValue to set
	 */
	public void setShortValue(short shortValue) {
		ShortValue = shortValue;
	}
	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return StringValue;
	}
	/**
	 * @param stringValue the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		StringValue = stringValue;
	}
	
	
	

}