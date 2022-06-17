# qa-tasks
This repo contains the answers of the challenges set up by the examiner

## I - Test Plan
* **ID:**  SA_LOGIN_TP01
+ **Objective:** 
  *  Highlight feature to be tested
  *  Describe required test deliverables for the project
  *  Describe test strategy to be used
+ **Test items:** 
  + Features to be tested:
    * User login
  + Features not to be tested:
    * User registration
    * User buying items
    * Search items
    * etc (will be reduces for shortening this exercise)
+ **Test Methodology:**
  *  Smoke testing
  *  Functional testing
  *  Usability testing
+ **Testing Approach:**
  + Approach QA team will be using for this test plan is proactive which means all tests should be design, written and automated from the beginning development process. Main goal of this strategy is to cover as much as possible the impacted areas in software (for this case Log in page).
+ **Test Deliverables:** Example
  * Test Plan: This document
  + Test Cases:
    - TC01- Verify user is able to log in with valid credentials
    - TC02- Verify user is not able to log in with invalid credentials
    - TC03- Verify toggle password button is displaying password when clicked
    - TC04- Verify toggle password button is hiding password when clicked 
    - TC05- Verify user is not able to log in with empty credentials
    - TC06- Verify user is not able to log in with malformed email
    - TC07- Verify user is able to log in after performing log out action
    - TC08- Verify email input field contains a limit amount of characters
    - TC09- Verify color palette for login button is according apotheke standards and desig
    - TC010- Verify warning/error banners when error is trigger
  * Test Scripts (automation): 
Below is the list of automated tests
    * TC01
    * TC02
    * TC05
    * TC06
  * Defects report: Please refer to _**Findings**_ section for an example of defect reporting
 - **Test Environment:**  Production
 + **Entry and Exit criteria:**
    + Entry criteria:
      * All test deliveries should be ready
      * Business Requirements are understood and analyzed by the team
    + Exit criteria:
      * 70% of top priority tests cases should pass
      * Not major (showstopper) bugs has been found
 + **Test Automation:** 
    + Features to be tested:
      * User login
    + Tools to use for automation:
      * Java
      * Selenium
 

## II - Detailed test case
* TestID: TC01
* Feature: Log in action
* Description: Check user log in with valid credentials
* Test Data:
  * user = alpm9615+testapotheke@gmail.com 
  * password = Test123@

 Test Step  | Expected Result
------------- | -------------
1. Navigate to https://www.shop-apotheke.com/nl/login.htm   | **Anmelden** button should be shown
2. Click on **Anmelden** button | User should be taken to the actual login page
3. Type valid user email  | Email text should be displayed on screen
4. Type valid user password | Password should be masked and displayed on screen
5. Wait for human verification to be done | Log in button should get enabled
6. Click on **Anmelden** button | User data should shown. User was able to login to apotheke web


Note: others tests cases are highlighted on test plan section
## III - Code challenge 
- **Requirements**
    - Have installed java 1.8+ version
    - Have installed maven 3.8.5+ version
- **How to use the framework**
  - Open the terminal in project folder and run: `$ mvn test`
- **Report's Locations**:
  - Testng: ${user.dir}/test-output
  - Surfire: ${user.dir}/target/surefire-reports

## IV - Findings 
Note: Just first item found will be written as if it was part of a bug report
- _Bug01_:
  - **Description**: There is no limit in the amount of characters that can be added to each input box (just for email field)
  - **Environment**: production - Chrome browser
  - **Priority**: medium
  - **Steps to reproduce:**
  
Test Step  | Expected Result
------------- | -------------
1. Navigate to https://www.shop-apotheke.com/nl/login.htm   | **Anmelden** button should be shown
2. Click on **Anmelden** button | User should be taken to the actual login page
3. Type 10000 characters on email input  | Email input should not allow user to type what amount of characters
- UX perspective: When trying to log in it takes to a new screen where I can either log in or create a new account this is ok for new users but for existing users might being tedious following flow since prob they just have one mistake in their password and would like to know that asap
- User data is not being passed from login form to the other
