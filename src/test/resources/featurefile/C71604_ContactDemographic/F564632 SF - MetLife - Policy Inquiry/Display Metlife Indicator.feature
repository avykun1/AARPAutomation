# new feature
# Tags: optional

Feature: US3234341 SF - Display MetLife Policy indicator in SF

    @US3234341 @Core @UHC
    Scenario: Display MetLife Policy indicator in SF

        Given there is an Customer have "Metlife" Policy Coverage
        When navigates to the Customer Page
        Then able to see the "Metlife" Policy Indicator as Checked
        When the customer not have "Metlife" Policy Coverage
        Then able to see the "Metlife" Policy Indicator as Unchecked