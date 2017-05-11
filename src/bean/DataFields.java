package bean;

import java.sql.Date;

public class DataFields {

	String firstNameParam,lastNameParam,description;
	String opDateParam;
	long mobileNoParam;

	String opBalParam;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOpDateParam() {
		return opDateParam;
	}
	public void setOpDateParam(String opDateParam) {
		this.opDateParam = opDateParam;
	}
	public long getMobileNoParam() {
		return mobileNoParam;
	}
	public void setMobileNoParam(long mobileNoParam) {
		this.mobileNoParam = mobileNoParam;
	}
	public String getOpBalParam() {
		return opBalParam;
	}
	public void setOpBalParam(String opBalParam) {
		this.opBalParam = opBalParam;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String password;
	String idParam;
	
	public String getFirstNameParam() {
		return firstNameParam;
	}
	public void setFirstNameParam(String firstNameParam) {
		this.firstNameParam = firstNameParam;
	}
	public String getLastNameParam() {
		return lastNameParam;
	}
	public void setLastNameParam(String lastNameParam) {
		this.lastNameParam = lastNameParam;
	}

	public String getIdParam() {
		return idParam;
	}
	public void setIdParam(String idParam) {
		this.idParam = idParam;
	}
}
