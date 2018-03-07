package genericSerDeser.util;

import genericSerDeser.util.Second;

public class Second{

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(DoubleValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(DoubleValue2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (LongValue ^ (LongValue >>> 32));
		result = prime * result + (int) (LongValue2 ^ (LongValue2 >>> 32));
		result = prime * result + ShortValue;
		result = prime * result + ShortValue2;
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
		Second other = (Second) obj;
		if (Double.doubleToLongBits(DoubleValue) != Double.doubleToLongBits(other.DoubleValue))
			return false;
		if (Double.doubleToLongBits(DoubleValue2) != Double.doubleToLongBits(other.DoubleValue2))
			return false;
		if (LongValue != other.LongValue)
			return false;
		if (LongValue2 != other.LongValue2)
			return false;
		if (ShortValue != other.ShortValue)
			return false;
		if (ShortValue2 != other.ShortValue2)
			return false;
		if (StringValue == null) {
			if (other.StringValue != null)
				return false;
		} else if (!StringValue.equals(other.StringValue))
			return false;
		return true;
	}
	public Second() {
		super();
	}
	
	private double DoubleValue;
	private double DoubleValue2;
	private long LongValue;
	private long LongValue2;
	private short ShortValue;
	private short ShortValue2;
	private String StringValue;
	
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
	 * @return the doubleValue2
	 */
	public double getDoubleValue2() {
		return DoubleValue2;
	}
	/**
	 * @param doubleValue2 the doubleValue2 to set
	 */
	public void setDoubleValue2(double doubleValue2) {
		DoubleValue2 = doubleValue2;
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
	 * @return the longValue2
	 */
	public long getLongValue2() {
		return LongValue2;
	}
	/**
	 * @param longValue2 the longValue2 to set
	 */
	public void setLongValue2(long longValue2) {
		LongValue2 = longValue2;
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
	 * @return the shortValue2
	 */
	public short getShortValue2() {
		return ShortValue2;
	}
	/**
	 * @param shortValue2 the shortValue2 to set
	 */
	public void setShortValue2(short shortValue2) {
		ShortValue2 = shortValue2;
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