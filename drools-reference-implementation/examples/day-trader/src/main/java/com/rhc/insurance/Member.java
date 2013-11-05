package com.rhc.insurance;

import java.util.HashMap;

public class Member {

	// all *Rating variables measured on 0.0-10.0 scale
	// in all cases, 0.0 is most healthy, 10.0 is least healthy
	// physical health factors
	public float asthmaRating;
	public float diabetesRating;
	public float cardiovascularRating;
	// behavioral health factors
	public float depressionRating;
	public float anxietyRating;
	public float eatingDisorderRating;

	public String asthmaDegree;
	public String diabetesDegree;
	public String cardiovascularDegree;
	// behavioral health factors
	public String depressionDegree;
	public String anxietyDegree;
	public String eatingDisorderDegree;

	HashMap<String, String> conditions;

	// PH and BH values
	public float physicalHealth;
	public float behavioralHealth;

	public Policy policy;
	public int quadrant;

	public int memberID;

	public Member() {
		conditions = new HashMap<String, String>();

		asthmaDegree = "";
		diabetesDegree = "";
		cardiovascularDegree = "";

		depressionDegree = "";
		anxietyDegree = "";
		eatingDisorderDegree = "";

		quadrant = 15;

		physicalHealth = 0;
		behavioralHealth = 0;
	}

	public float getAsthmaRating() {
		return asthmaRating;
	}

	public void setAsthmaRating(float asthmaRating) {
		this.asthmaRating = asthmaRating;
	}

	public float getDiabetesRating() {
		return diabetesRating;
	}

	public void setDiabetesRating(float diabetesRating) {
		this.diabetesRating = diabetesRating;
	}

	public float getCardiovascularRating() {
		return cardiovascularRating;
	}

	public void setCardiovascularRating(float cardiovascularRating) {
		this.cardiovascularRating = cardiovascularRating;
	}

	public float getDepressionRating() {
		return depressionRating;
	}

	public void setDepressionRating(float depressionRating) {
		this.depressionRating = depressionRating;
	}

	public float getAnxietyRating() {
		return anxietyRating;
	}

	public void setAnxietyRating(float anxietyRating) {
		this.anxietyRating = anxietyRating;
	}

	public float getEatingDisorderRating() {
		return eatingDisorderRating;
	}

	public void setEatingDisorderRating(float eatingDisorderRating) {
		this.eatingDisorderRating = eatingDisorderRating;
	}

	public String getAsthmaDegree() {
		return asthmaDegree;
	}

	public void setAsthmaDegree(String asthmaDegree) {
		this.asthmaDegree = asthmaDegree;
	}

	public String getDiabetesDegree() {
		return diabetesDegree;
	}

	public void setDiabetesDegree(String diabetesDegree) {
		this.diabetesDegree = diabetesDegree;
	}

	public String getCardiovascularDegree() {
		return cardiovascularDegree;
	}

	public void setCardiovascularDegree(String cardiovascularDegree) {
		this.cardiovascularDegree = cardiovascularDegree;
	}

	public String getDepressionDegree() {
		return depressionDegree;
	}

	public void setDepressionDegree(String depressionDegree) {
		this.depressionDegree = depressionDegree;
	}

	public String getAnxietyDegree() {
		return anxietyDegree;
	}

	public void setAnxietyDegree(String anxietyDegree) {
		this.anxietyDegree = anxietyDegree;
	}

	public String getEatingDisorderDegree() {
		return eatingDisorderDegree;
	}

	public void setEatingDisorderDegree(String eatingDisorderDegree) {
		this.eatingDisorderDegree = eatingDisorderDegree;
	}

	public HashMap<String, String> getConditions() {
		return conditions;
	}

	public void setConditions(HashMap<String, String> conditions) {
		this.conditions = conditions;
	}

	public float getPhysicalHealth() {
		return physicalHealth;
	}

	public void setPhysicalHealth(float physicalHealth) {
		this.physicalHealth = physicalHealth;
	}

	public float getBehavioralHealth() {
		return behavioralHealth;
	}

	public void setBehavioralHealth(float behavioralHealth) {
		this.behavioralHealth = behavioralHealth;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public int getQuadrant() {
		return quadrant;
	}

	public void setQuadrant(int quadrant) {
		this.quadrant = quadrant;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public void print() {
		System.out.println("member, with id=" + memberID + " quadrant: "
				+ quadrant + " getquadrant " + getQuadrant()
				+ " physicalHealth:" + physicalHealth + "  behavioralHealth:"
				+ behavioralHealth);
	}

}
