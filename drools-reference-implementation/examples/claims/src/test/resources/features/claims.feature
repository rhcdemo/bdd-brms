Feature: Determine claim price


Scenario: Acme patient is seen by doctor at doctor's office for wart removal

Given a member "Joe"

And "Joe" is a member of group "Acme"

And "Joe" has visited a "doctor" for "wart removal" at "doctor's office"

When determining the claim price for "Joe"

Then "Joe" should be reimbursed 40 dollars



Scenario: Non-Acme patient is seen by doctor at doctor's office for wart removal

Given a member "Joe"

And "Joe" has visited a "doctor" for "wart removal" at "doctor's office"

When determining the claim price for "Joe"

Then "Joe" should be reimbursed 80 dollars



Scenario: Acme patient is seen by NP at doctor's office for wart removal

Given a member "Joe"

And "Joe" is a member of group "Acme"

And "Joe" has visited a "nurse practitioner" for "wart removal" at "doctor's office"

When determining the claim price for "Joe"

Then "Joe" should be reimbursed 26 dollars



Scenario: Acme patient is seen by NP at inpatient for wart removal

Given a member "Joe"

And "Joe" is a member of group "Acme"

And "Joe" has visited a "doctor" for "wart removal" at "inpatient"

When determining the claim price for "Joe"

Then "Joe" should be reimbursed 50 dollars