Feature: Login into app
Scenario: Postive test validating login
Given Initialize the browser with chrome
And navigate to "http://demo.guru99.com/v4/" site
When user enters "mngr26593" and "1!" and log in
Then verified that user has successfully logged in and then log out and close the browser