Feature: Estimate Borrow Calculator

Scenario Outline: Calculate Borrow Estimate
Given User is on Estimate Borrow Calculator Page
When User Enters valid details as Application Type <ApplicationType> and Number of dependants <Numberofdependants> and Property you would like to buy <Propertyliketobuy> and Your annual income <annualincome> and Your annual other income <annualotherincome> and Monthly living expenses <Monthlylivingexpenses> and Current home loan monthly repayments <homeloan> and Other loan monthly repayments <Otherloan> and Other monthly commitments <monthlycommitments> and Total credit card limits <creditcardlimits>
And User clicks Work out how much I could borrow button
Then Estimate amount that user can borrow should be displayed

Examples:
|ApplicationType	|Numberofdependants	|Propertyliketobuy	|annualincome	|annualotherincome	|Monthlylivingexpenses	|homeloan	|Otherloan	|monthlycommitments	|creditcardlimits	|
|Single	|0	|Home to live in	|80000	|10000	|100	|10	|20	|50	|50000	|

Scenario Outline: Click Start over to start fresh
Given User is on Estimate Borrow Calculator Page
When User Enters valid details as Application Type <ApplicationType> and Number of dependants <Numberofdependants> and Property you would like to buy <Propertyliketobuy> and Your annual income <annualincome> and Your annual other income <annualotherincome> and Monthly living expenses <Monthlylivingexpenses> and Current home loan monthly repayments <homeloan> and Other loan monthly repayments <Otherloan> and Other monthly commitments <monthlycommitments> and Total credit card limits <creditcardlimits>
And User clicks Start over link
Then User Entered values are removed and default values are displayed

Examples:
|ApplicationType	|Numberofdependants	|Propertyliketobuy	|annualincome	|annualotherincome	|Monthlylivingexpenses	|homeloan	|Otherloan	|monthlycommitments	|creditcardlimits	|
|Single	|6	|Home to live in	|80000	|10000	|100	|10	|20	|50	|50000	|
