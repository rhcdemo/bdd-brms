Feature: Determine health quadrant

@Quadrant1
Scenario: Quadrant 1 - Low Physical Health Risk, Low Behavioral Health Risk

Given a member "Joe"

And "Joe" has condition "asthma" of degree "mild"

And "Joe" has condition "depression" of degree "mild"

When determining the health quadrant for "Joe"

Then "Joe" should be placed in Quadrant 1

And "Joe" receives standard care


@Quadrant2
Scenario: Quadrant 2 - Low Physical Health Risk, High Behavioral Health Risk

Given a member "Jane"

And "Jane" has condition "depression" of degree "severe"

And "Jane" has condition "eatingDisorder" of degree "severe"

When determining the health quadrant for "Jane"

Then "Jane" should be placed in Quadrant 2

And "Jane" is assigned a behavioral health case manager


@Quadrant3
Scenario: Quadrant 3 - High Physical Health Risk, Low Behavioral Health Risk

Given a member "Jess"

And "Jess" has condition "asthma" of degree "severe"

And "Jess" has condition "diabetes" of degree "mild"

And "Jess" has condition "cardiovascular" of degree "mild"

And "Jess" has condition "depression" of degree "mild"

When determining the health quadrant for "Jess"

Then "Jess" should be placed in Quadrant 3

And "Jess" is assigned a specialty disease care manager


@Quadrant4
Scenario: Quadrant 4 - High Physical Health Risk, High Behavioral Health Risk

Given a member "Jack"

And "Jack" has condition "asthma" of degree "severe"

And "Jack" has condition "diabetes" of degree "mild"

And "Jack" has condition "cardiovascular" of degree "mild"

And "Jack" has condition "depression" of degree "mild"

And "Jack" has condition "anxiety" of degree "severe"

When determining the health quadrant for "Jack"

Then "Jack" should be placed in Quadrant 4

And "Jack" is assigned a specialty disease care manager

And "Jack" is assigned a behavioral health case manager


@QuadrantX
Scenario: Member Placed in Wrong Quadrant

Given a member "Jill"

And "Jill" has condition "asthma" of degree "severe"

And "Jill" has condition "diabetes" of degree "severe"

And "Jill" has condition "cardiovascular" of degree "severe"

And "Jill" has condition "depression" of degree "severe"

And "Jill" has condition "anxiety" of degree "severe"

And "Jill" has condition "eatingDisorder" of degree "severe"

When determining the health quadrant for "Jill"

Then "Jill" should be placed in Quadrant 1

And "Jill" receives standard care