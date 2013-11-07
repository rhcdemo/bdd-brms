package com.rhc.trade;


import java.util.Collection;

import com.rhc.drools.reference.DroolsQueryInfo;

public class TradeResponse {
	@DroolsQueryInfo(binding = "$action", queryName = "Get actions")
	private Collection<String> actions;

	public Collection<String> getActions() {
		return actions;
	}

	public void setActions(Collection<String> actions) {
		this.actions = actions;
	}
	
	/**
	 * Returns the first value in actions
	 * 
	 * @return first String in actions
	 */
	public String getAction() {
		return (actions.iterator().hasNext() ? actions.iterator().next() : null);
	}

}
