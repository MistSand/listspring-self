package org.litespring.beans;


public class PropertyValue {
	
	private String name;
	
	private Object value;
	
	private boolean converted = false;
	
	private Object convertedValue;

	public PropertyValue() {
		super();
	}

	public PropertyValue(String name, Object value, boolean converted, Object convertedValue) {
		super();
		this.name = name;
		this.value = value;
		this.converted = converted;
		this.convertedValue = convertedValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isConverted() {
		return converted;
	}

	public void setConverted(boolean converted) {
		this.converted = converted;
	}

	public Object getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(Object convertedValue) {
		this.convertedValue = convertedValue;
	}

	@Override
	public String toString() {
		return "PropertyValue [name=" + name + ", value=" + value + ", converted=" + converted + ", convertedValue="
				+ convertedValue + "]";
	}
	
	
	

	

}
