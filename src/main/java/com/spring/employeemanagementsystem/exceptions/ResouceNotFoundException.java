package com.spring.employeemanagementsystem.exceptions;

public class ResouceNotFoundException extends RuntimeException{

	String resouceName;
	String fieldName;
	long fieldValue;
	public String getResouceName() {
		return resouceName;
	}
	public void setResouceName(String resouceName) {
		this.resouceName = resouceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public long getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(long fieldValue) {
		this.fieldValue = fieldValue;
	}
	public ResouceNotFoundException(String resouceName, String fieldName, long fieldValue) {
		
		super(String.format("%s not found with %s : %s", resouceName, fieldName, fieldValue));
		this.resouceName = resouceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
}
