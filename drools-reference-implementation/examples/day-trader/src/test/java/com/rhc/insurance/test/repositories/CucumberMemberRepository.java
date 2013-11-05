package com.rhc.insurance.test.repositories;

import java.util.Collection;
import java.util.HashSet;

import com.rhc.insurance.Member;
import com.rhc.insurance.repositories.MemberRepository;

public class CucumberMemberRepository implements MemberRepository {
	public HashSet<Member> members;

	@Override
	public Collection<Member> getMembers() {
		// return new ArrayList<Member>();
		return members;
	}

	public Member getMemberFromID(int id) {
		for (Member member : members) {
			if (member.getMemberID() == id) {
				return member;
			}
		}

		// we failed
		System.out.println("ERROR: could not find member with id " + id);
		return new Member();

	}

	public void print() {
		for (Member member : members) {
			// System.out.println();
			member.print();
		}
	}

	public void createSingleMember(Member m) {
		members = new HashSet<Member>();
		members.add(m);

	}

}
