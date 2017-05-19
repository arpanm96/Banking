package bean;

import java.sql.Date;

public class DataFields {

	String firstNameParam,lastNameParam,description;
	String openingDateParam;
	long mobileNoParam;
	
	String passParam;
	String idParam;

	Long openingBalanceParam;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getMobileNoParam() {
		return mobileNoParam;
	}
	public void setMobileNoParam(long mobileNoParam) {
		this.mobileNoParam = mobileNoParam;
	}

	
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
	public String getOpeningDateParam() {
		return openingDateParam;
	}
	public void setOpeningDateParam(String openingDateParam) {
		this.openingDateParam = openingDateParam;
	}
	public String getPassParam() {
		return passParam;
	}
	public void setPassParam(String passParam) {
		this.passParam = passParam;
	}
	public Long getOpeningBalanceParam() {
		return openingBalanceParam;
	}
	public void setOpeningBalanceParam(Long openingBalanceParam) {
		this.openingBalanceParam = openingBalanceParam;
	}
}
