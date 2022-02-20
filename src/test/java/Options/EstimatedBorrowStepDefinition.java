package Options;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


@RunWith(Cucumber.class)

public class EstimatedBorrowStepDefinition {

	public WebDriver driver;
	public String browserUrl;
	public String appTypeSingle;
	public String appTypeJoint;
	public String numOfDep;
	public String propToBuyH;
	public String propToBuyR;
	public String annualIncome;
	public String otherAnnualIncome;
	public String livingExp;
	public String homeLoan;
	public String otherLoan;
	public String monthlyCommit;
	public String crCardLimit;
	
	    @Given("^User is on Estimate Borrow Calculator Page$")
	    public void user_is_on_estimate_borrow_calculator_page() throws Throwable {
	    	
	    	browserUrl = "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/";
	    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Keerthy\\Documents\\Eclipse Drivers\\chromedriver.exe");
	    	
	    	driver = new ChromeDriver();
			
			driver.get(browserUrl);
			driver.manage().window().maximize();
	    }
	    
	    @When("^User Enters valid details as Application Type (.+) and Number of dependants (.+) and Property you would like to buy (.+) and Your annual income (.+) and Your annual other income (.+) and Monthly living expenses (.+) and Current home loan monthly repayments (.+) and Other loan monthly repayments (.+) and Other monthly commitments (.+) and Total credit card limits (.+)$")
	    public void user_enters_valid_details_as_application_type_and_number_of_dependants_and_property_you_would_like_to_buy_and_your_annual_income_and_your_annual_other_income_and_monthly_living_expenses_and_current_home_loan_monthly_repayments_and_other_loan_monthly_repayments_and_other_monthly_commitments_and_total_credit_card_limits(String applicationtype, String numberofdependants, String propertyliketobuy, String annualincome, String annualotherincome, String monthlylivingexpenses, String homeloan, String otherloan, String monthlycommitments, String creditcardlimits) throws Throwable {
	    	 
	    	appTypeSingle = ".//input[@id = 'application_type_single']";
	    	appTypeJoint = ".//input[@id = 'application_type_joint']";
	    	numOfDep = ".//select[@title = 'Number of dependants']";
	    	propToBuyH = ".//input[@id = 'borrow_type_home']";
	    	propToBuyR = ".//input[@id = 'borrow_type_investment']";
	    	annualIncome = ".//input[@aria-labelledby = 'q2q1']";
	    	otherAnnualIncome = ".//input[@aria-labelledby = 'q2q2']";
	    	livingExp = ".//input[@id = 'expenses']";
	    	homeLoan = ".//input[@id = 'homeloans']";
	    	otherLoan = ".//input[@id = 'otherloans']";
	    	monthlyCommit = ".//input[@aria-labelledby = 'q3q4']";
	    	crCardLimit = ".//input[@id = 'credit']";
	    	
	    	System.out.println(applicationtype);
	    	if(applicationtype.equalsIgnoreCase("Single"))
	    	{
	    		driver.findElement(By.xpath(appTypeSingle)).click();
	    	}
	    	else
	    	{
	    		driver.findElement(By.xpath(appTypeJoint)).click();
	    	}
	    	
	    	System.out.println(numberofdependants);
	    	int num = Integer.parseInt(numberofdependants);
	    	if(num<0)
	    	{
	    		driver.findElement(By.xpath(numOfDep)).sendKeys("0");
	    	}
	    	if(num>=0 && num <5)
	    	{
	    		driver.findElement(By.xpath(numOfDep)).sendKeys(numberofdependants);
	    	}
	    	else
	    	{
	    		driver.findElement(By.xpath(numOfDep)).sendKeys("5+");
	    	}
	    	
	    	System.out.println(propertyliketobuy);
	    	JavascriptExecutor scroll = (JavascriptExecutor) driver;
	    	scroll.executeScript("window.scrollBy(0, 200)");
	    			
	    	if(propertyliketobuy.equalsIgnoreCase("Home to live in"))
	    	{
	    		driver.findElement(By.xpath(propToBuyH)).click();
	    	}
	    	else
	    	{
	    		driver.findElement(By.xpath(propToBuyR)).click();
	    	}
	    	
	    	System.out.println(annualincome);
	    	driver.findElement(By.xpath(annualIncome)).sendKeys(annualincome);
	    	
	    	System.out.println(annualotherincome);
	    	driver.findElement(By.xpath(otherAnnualIncome)).sendKeys(annualotherincome);
	    	
	    	System.out.println(monthlylivingexpenses);
	    	driver.findElement(By.xpath(livingExp)).sendKeys(monthlylivingexpenses);
	    	
	    	System.out.println(homeloan);
	    	driver.findElement(By.xpath(homeLoan)).sendKeys(homeloan);
	    	
	    	System.out.println(otherloan);
	    	driver.findElement(By.xpath(otherLoan)).sendKeys(otherloan);
	    	
	    	System.out.println(monthlycommitments);
	    	driver.findElement(By.xpath(monthlyCommit)).sendKeys(monthlycommitments);
	    	
	    	System.out.println(creditcardlimits);
	    	driver.findElement(By.xpath(crCardLimit)).sendKeys(creditcardlimits); 
	    }
	    
	  
	    @Then("^Estimate amount that user can borrow should be displayed$")
	    public void estimate_amount_that_user_can_borrow_should_be_displayed() throws Throwable {
	    	
	    	String amtDisplayed = ".//span[@id = 'borrowResultTextAmount']";
	    	
	    	Thread.sleep(5000);
	    	String amount = driver.findElement(By.xpath(amtDisplayed)).getText();
	    	System.out.println(amount);
	    }

	    @And("^User clicks Work out how much I could borrow button$")
	    public void user_clicks_work_out_how_much_i_could_borrow_button() throws Throwable {
	    	
	    	String borrowButton = ".//button[@id = 'btnBorrowCalculater']";
	    	driver.findElement(By.xpath(borrowButton)).click();
	    	
	    }
	    
	    @Then("^User Entered values are removed and default values are displayed$")
	    public void user_entered_values_are_removed_and_default_values_are_displayed() throws Throwable {
	        
	    	System.out.println("CLEARING");
	    	String defAppType = "S";
	    	String defNumOfDep = "0";
	    	String defPropToBuyH = "H";
	    	String defAnnualIncome = "0";
	    	String defOtherAnnualIncome = "0";
	    	String defLivingExp = "0";
	    	String defHomeLoan = "0";
	    	String defOtherLoan = "0";
	    	String defMonthlyCommit = "0";
	    	String defCrCardLimit = "0";
	    	
	    	String actAppType = driver.findElement(By.xpath(appTypeSingle)).getAttribute("value");
	    	String actNumOfDep = driver.findElement(By.xpath(numOfDep)).getAttribute("value");
	    	String actPropToBuyH = driver.findElement(By.xpath(propToBuyH)).getAttribute("value");
	    	String actAnnualIncome = driver.findElement(By.xpath(annualIncome)).getAttribute("value");
	    	String actOtherAnnualIncome = driver.findElement(By.xpath(otherAnnualIncome)).getAttribute("value");
	    	String actLivingExp = driver.findElement(By.xpath(livingExp)).getAttribute("value");
	    	String actHomeLoan = driver.findElement(By.xpath(homeLoan)).getAttribute("value");
	    	String actOtherLoan = driver.findElement(By.xpath(otherLoan)).getAttribute("value");
	    	String actMonthlyCommit = driver.findElement(By.xpath(monthlyCommit)).getAttribute("value");
	    	String actCrCardLimit = driver.findElement(By.xpath(crCardLimit)).getAttribute("value");
	    	
	    	Assert.assertEquals(defAppType,actAppType);
	    	Assert.assertEquals(defNumOfDep,actNumOfDep);
	    	Assert.assertEquals(defPropToBuyH,actPropToBuyH);
	    	Assert.assertEquals(defAnnualIncome,actAnnualIncome);
	    	Assert.assertEquals(defOtherAnnualIncome,actOtherAnnualIncome);
	    	Assert.assertEquals(defLivingExp,actLivingExp);
	    	Assert.assertEquals(defHomeLoan,actHomeLoan);
	    	Assert.assertEquals(defOtherLoan,actOtherLoan);
	    	Assert.assertEquals(defMonthlyCommit,actMonthlyCommit);
	    	Assert.assertEquals(defCrCardLimit,actCrCardLimit);
	    	
	    }

	    @And("^User clicks Start over link$")
	    public void user_clicks_start_over_link() throws Throwable {
	    	
	    	Thread.sleep(5000);
	    	String startOver = ".//button[@class = 'start-over']";
	    	driver.findElement(By.xpath(startOver)).click();
	        
	    }


}
