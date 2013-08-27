BDD/BRMS Demo

Links:
	rhcdemo GitHub https://github.com/rhcdemo/bdd-brms
	Jenkins on OpenShift http://bdd-rhcdemo.rhcloud.com/job/demo/
		user//pass : admin//admin

Making Changes:
	In order to make changes, just commit them to GitHub and Jenkins handles the rest for you. If you go to http://jenkins-bmeisele.rhcloud.com/job/cucumberhelloworld-build/, you will see the build status bar under "Build History" on the left. The build usually takes a few minutes, after which you can view console output and Cucumber Reports and other useful features.

Navigating Jenkins/ Cucumber:
	All links on the homepage are relating to the most recent build. There you can view Cucumber Reports, recent changes and many other useful resources. When you click to view the Cucumber Reports, you will be taken to an overview page, which 

Scenarios:
	The scenarios are located at:
bdd-brms/droolsreferenceimplementation/examples/insurance/src/test/resources/features/healthQuadrant.feature
	There are five scenarios in this file: one for each of the four quadrants and a fifth that attempts to place Jill, a quadrant 4 member, into quadrant 1. In order to add a scenario, just append the following template to the healthQuadrant.feature file:

@{ScenarioTag}
Scenario: {Scenario title as it will appear on Cucumber Report}

Given a member "{name}"

And "{name}" has condition "{condition}" of degree "{mild/severe}"

And "{name}" has condition "{condition}" of degree "{mild/severe}"

When determining the health quadrant for "{name}"

Then "{name}" should be placed in Quadrant {number}

And "{name}" {result}

The {condition} must be one of the following: {asthma, diabetes, cardiovascular, depression, anxiety, eatingDisorder}. You can assign more conditions using more And statements. The {number} must be one of {1, 2, 3, 4}, according to what quadrant the member should be assigned to. The {result} must be one of the following: {receives standard care, is assigned a behavioral health case manager, is assigned a specialty disease care manager}. You can also edit the existing scenarios using the same guidelines.
