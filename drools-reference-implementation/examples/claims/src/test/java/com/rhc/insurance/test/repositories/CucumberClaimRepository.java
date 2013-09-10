package com.rhc.insurance.test.repositories;

import java.util.Collection;
import java.util.HashSet;

import com.rhc.insurance.Claim;
import com.rhc.insurance.repositories.ClaimRepository;

public class CucumberClaimRepository implements ClaimRepository {
	public HashSet<Claim> claims;

	@Override
	public Collection<Claim> getClaims() {
		// return new ArrayList<Claim>();
		return claims;
	}
/*
	public Claim getClaimFromID(int id) {
		for (Claim claim : claims) {
			if (claim.getClaimID() == id) {
				return claim;
			}
		}

		// we failed
		System.out.println("ERROR: could not find claim with id " + id);
		return new Claim();

	}
*/
	public void print() {
		for (Claim claim : claims) {
			// System.out.println();
			//claim.print();
		}
	}
	
	public void init()
	{
		claims = new HashSet<Claim>();
	}

	public void addSingleClaim(Claim c)
	{	
		claims.add(c);
	}

}
