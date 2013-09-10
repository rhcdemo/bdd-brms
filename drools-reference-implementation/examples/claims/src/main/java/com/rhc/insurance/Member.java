package com.rhc.insurance;

import java.util.HashMap;

public class Member {

	// all *Rating variables measured on 0.0-10.0 scale
	// in all cases, 0.0 is most healthy, 10.0 is least healthy
	// physical health factors
	//public Group group;
	
	public String group;
	
	public Claim claim;

	//HashMap<String, String> conditions;

	public Member()
	{
		group = "default";
	/*	conditions = new HashMap<String, String>();
*/
	}

	public String getGroup() {
		return group;
	}
	

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void print() {
		System.out.println("member, with group="+group);
	}

}
