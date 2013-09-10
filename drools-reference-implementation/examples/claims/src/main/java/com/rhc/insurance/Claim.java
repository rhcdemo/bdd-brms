package com.rhc.insurance;

public class Claim {

	public Member member;
	public float price;
	
	public String procedureString;
	public int procedureCode;
	
	public String caregiverString;
	public String locationString;
	
	public String group;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getProcedureString() {
		return procedureString;
	}

	public void setProcedureString(String procedureString) {
		this.procedureString = procedureString;
		
		if (procedureString.equals("well visit"))
		{
			procedureCode = 1000;
		}
		if (procedureString.equals("sick visit"))
		{
			procedureCode = 2000;
		}
		if (procedureString.equals("wart removal"))
		{
			procedureCode = 3000;
		}
		if (procedureString.equals("EKG"))
		{
			procedureCode = 4000;
		}
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
