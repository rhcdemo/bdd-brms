Feature: Determine claim price


Scenario: Acme patient visits doctor at doctor's office for wart removal

Given a member "Joe"

And "Joe" is a member of group "Acme"

And "Joe" has visited a "doctor" for "wart removal" at "doctor's office"

When determining the claim price for "Joe"

Then "Joe" should be charged 500