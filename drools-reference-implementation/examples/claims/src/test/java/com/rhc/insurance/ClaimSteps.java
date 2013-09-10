package com.rhc.insurance;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.drools.logger.KnowledgeRuntimeLogger;

import com.rhc.drools.reference.CommandListBuilder;
import com.rhc.drools.reference.KnowledgeBaseBuilder;
import com.rhc.drools.reference.ReaderKnowledgeBaseBuilder;
import com.rhc.drools.reference.RuleFlowCommandListBuilder;
import com.rhc.drools.reference.StatelessDroolsComponent;
import com.rhc.insurance.test.repositories.CucumberClaimRepository;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ClaimSteps {

	private CucumberClaimRepository claimRepository;
	// private CucumberMemberRepository memberRepositoryResults;

	private Member member;
	// private Member memberResult;

	// private List<Map<String, String>> memberRepository;

	private StatelessDroolsComponent component;

	static KnowledgeRuntimeLogger logger;

	@Before
	public void setupComponent() {

		Set<BufferedReader> resources = new HashSet<BufferedReader>();

		DroolsExcelConverter dec = new DroolsExcelConverter();

		resources.add(dec.buildReader("rules/SetPrice.xls"));

		// buildKnowledgeBaseFromBufferedReader(dec.run());

		// placeholder rules to be replaced by real rules soon
		// resources.add("rules/HealthQuadrantRules.xls");
		// resources.add("rules/HealthQuadrantRules.drl");
		// resources.add("rules/setBH.drl");

		KnowledgeBaseBuilder kBuilder = new ReaderKnowledgeBaseBuilder(
				resources);
		CommandListBuilder commandListBuilder = new RuleFlowCommandListBuilder();

		component = new StatelessDroolsComponent();
		component.setKnowledgeBaseBuilder(kBuilder);
		component.setCommandListBuilder(commandListBuilder);

	}

	@Before
	public void init() {
		claimRepository = new CucumberClaimRepository();
		claimRepository.init();
		// memberRepositoryResults = new CucumberMemberRepository();

		// calculate mapping between

		// member = new Member();
		// memberRepository.createSingleMember(m)

	}

	@Given("^a member \"([^\"]*)\"$")
	public void a_member(String arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		member = new Member();
		// claimRepository.createSingleMember(member);
		// throw new PendingException();
	}

	@Given("^\"([^\"]*)\" is a member of group \"([^\"]*)\"$")
	public void is_a_member_of_group(String arg1, String groupName)
			throws Throwable {
		// Express the Regexp above with the code you wish you had

		member.setGroup(groupName);

		// throw new PendingException();
	}

	@Given("^\"([^\"]*)\" has visited a \"([^\"]*)\" for \"([^\"]*)\" at \"([^\"]*)\"$")
	public void has_visited_a_for_at(String arg1, String caregiverString,
			String procedureString, String locationString) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// throw new PendingException();

		Claim c = new Claim();
		c.setMember(member);
		c.setCaregiverString(caregiverString);
		c.setProcedureString(procedureString);
		c.setLocationString(locationString);
		c.setGroup(member.getGroup());

		claimRepository.addSingleClaim(c);

		member.setClaim(c);
	}

	@When("^determining the claim price for \"([^\"]*)\"$")
	public void determining_the_claim_price_for(String arg1) throws Throwable {
		System.out.println("pre");
		claimRepository.print();

		Collection<Claim> claims = claimRepository.getClaims();
		// System.out.println("MEMBERS: "+members);
		// members.print();
		ClaimRequest request = new ClaimRequest();
		request.addFacts(claims);
		System.out.println(component);
		component.execute(request, null);

		System.out.println("post");
		claimRepository.print();

		//component.execute(request, null);
	}

	@Then("^\"([^\"]*)\" should be reimbursed (\\d+) dollars$")
	public void should_be_reimbursed_dollars(String arg1,
			int priceShouldBeCharged) throws Throwable {
		// Express the Regexp above with the code you wish you had
		// throw new PendingException();

		System.out.println("About to assert that " + priceShouldBeCharged
				+ " equals " + member.getClaim().getPrice());

		assertEquals(priceShouldBeCharged, member.getClaim().getPrice(), 0.001);
	}

	/*
	 * @Given("^a member \"([^\"]*)\"$") public void a_member(String arg1)
	 * throws Throwable { // Express the Regexp above with the code you wish you
	 * had member = new Member(); memberRepository.createSingleMember(member);
	 * // throw new PendingException(); }
	 * 
	 * @Given("^\"([^\"]*)\" has condition \"([^\"]*)\" of degree \"([^\"]*)\"$")
	 * public void has_condition_of_degree(String arg1, String conditionArg,
	 * String degreeArg) throws Throwable { // ValueEnum conditionEnumVal =
	 * ValueEnum.fromString(myString); CONDITIONS condition =
	 * CONDITIONS.valueOf(conditionArg); switch (condition) { case depression:
	 * 
	 * member.setDepressionDegree(degreeArg); break;
	 * 
	 * case anxiety:
	 * 
	 * member.setAnxietyDegree(degreeArg); break;
	 * 
	 * case asthma:
	 * 
	 * member.setAsthmaDegree(degreeArg); break;
	 * 
	 * case diabetes:
	 * 
	 * member.setDiabetesDegree(degreeArg); break;
	 * 
	 * case eatingDisorder:
	 * 
	 * member.setEatingDisorderDegree(degreeArg); break;
	 * 
	 * case cardiovascular:
	 * 
	 * member.setCardiovascularDegree(degreeArg); break; }
	 * 
	 * // Express the Regexp above with the code you wish you had // throw new
	 * PendingException(); }
	 * 
	 * public enum CONDITIONS { asthma, depression, anxiety, diabetes,
	 * eatingDisorder, cardiovascular }
	 * 
	 * @When("^determining the health quadrant for \"([^\"]*)\"$") public void
	 * determining_the_health_quadrant_for(String arg1) throws Throwable { //
	 * Express the Regexp above with the code you wish you had // throw new
	 * PendingException(); System.out.println("pre"); memberRepository.print();
	 * 
	 * Collection<Member> members = memberRepository.getMembers(); //
	 * System.out.println("MEMBERS: "+members); // members.print();
	 * MemberRequest request = new MemberRequest(); request.addFacts(members);
	 * System.out.println(component); component.execute(request, null);
	 * 
	 * System.out.println("post"); memberRepository.print();
	 * 
	 * component.execute(request, null); }
	 * 
	 * @Then("^\"([^\"]*)\" should be placed in Quadrant (\\d+)$") public void
	 * should_be_placed_in_Quadrant(String arg1, int quadrantArg) throws
	 * Throwable { // Express the Regexp above with the code you wish you had //
	 * throw new PendingException(); System.out.println("OUTPUT TEST XLS");
	 * memberRepository.print();
	 * 
	 * System.out.println("About to assert that " + quadrantArg + " equals " +
	 * member.getQuadrant());
	 * 
	 * assertEquals(quadrantArg, member.getQuadrant()); }
	 * 
	 * @Then("^\"([^\"]*)\" receives standard care$") public void
	 * receives_standard_care(String arg1) throws Throwable { assertEquals(1,
	 * 1); }
	 * 
	 * @Then("^\"([^\"]*)\" is assigned a behavioral health case manager$")
	 * public void is_assigned_a_behavioral_health_case_manager(String arg1)
	 * throws Throwable { assertEquals(1, 1); }
	 * 
	 * @Then("^\"([^\"]*)\" is assigned a specialty disease care manager$")
	 * public void is_assigned_a_specialty_disease_care_manager(String arg1)
	 * throws Throwable { assertEquals(1, 1); }
	 */

}
