package com.rhc.insurance.repositories;

import java.util.Collection;

import com.rhc.insurance.Claim;

public interface ClaimRepository {

	public Collection<Claim> getClaims();

}
