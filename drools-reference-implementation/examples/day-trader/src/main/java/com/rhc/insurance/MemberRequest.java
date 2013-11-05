package com.rhc.insurance;

import java.util.ArrayList;
import java.util.Collection;

import com.rhc.drools.reference.DroolsRequest;

public class MemberRequest implements DroolsRequest
{
	private Collection<Object> facts = new ArrayList<Object>();

	public void addFacts(Collection<?> objs) {
		facts.addAll(objs);
	}

	@Override
	public Collection<Object> getAllFacts() {
		return facts;
	}

	@Override
	public String getProcessId() {
		// TODO Auto-generated method stub
		return null;
	}
}