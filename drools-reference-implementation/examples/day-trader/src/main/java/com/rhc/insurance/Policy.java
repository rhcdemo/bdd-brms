package com.rhc.insurance;

public class Policy {

	public Member member;
	public int price;
	public int quadrant;

	public Policy() {
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

	public int getQuadrant() {
		return quadrant;
	}

	public void setQuadrant(int quadrant) {
		this.quadrant = quadrant;
	}

}
