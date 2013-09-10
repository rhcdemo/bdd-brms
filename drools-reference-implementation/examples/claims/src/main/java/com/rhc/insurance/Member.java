package com.rhc.insurance;

import java.util.HashMap;

public class Member {

	// all *Rating variables measured on 0.0-10.0 scale
	// in all cases, 0.0 is most healthy, 10.0 is least healthy
	// physical health factors
	//public Group group;
	
	public String group;

	//HashMap<String, String> conditions;

	public Member()
	{
	/*	conditions = new HashMap<String, String>();
*/
	}

	public void print() {
		System.out.println("member, with group="+group);
	}

}
