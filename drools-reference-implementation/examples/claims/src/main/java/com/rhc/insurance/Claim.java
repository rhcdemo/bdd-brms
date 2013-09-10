package com.rhc.insurance;

public class Claim {

	public Member member;
	public int price;
	
	public String procedureString;
	public int procedureCode;
	
	public String caregiverString;
	public String locationString;
	
	public String groupString;

	public String getGroupString() {
		return groupString;
	}

	public void setGroupString(String groupString) {
		this.groupString = groupString;
	}

	public String getProcedureString() {
		return procedureString;
	}

	public void setProcedureString(String procedureString) {
		this.procedureString = procedureString;
	}

	public String getCaregiverString() {
		return caregiverString;
	}

	public void setCaregiverString(String caregiverString) {
		this.caregiverString = caregiverString;
	}

	public String getLocationString() {
		return locationString;
	}

	public void setLocationString(String locationString) {
		this.locationString = locationString;
	}

	public Claim() {
		price = 0;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
