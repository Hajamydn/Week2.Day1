package week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
 
	public static void main(String[] args) throws InterruptedException
	{
		//http://leaftaps.com/opentaps/control/login
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
	
		String Pagetitle = driver.getTitle();// Get page title
		
		System.out.println("Home Page : " +Pagetitle);// Print page title
		
		driver.findElement(By.id("username")).sendKeys("democsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Buddies"); //select company
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("hajamydeen"); // enter first name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("sheik"); // enter last name
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("mydeen"); //enter name local
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT Testing"); // enter department
		driver.findElement(By.id("createLeadForm_description")).sendKeys("BSS application");// enter description
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("haja@gmail.com"); // enter email
		
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd=new Select(state);
		dd.selectByVisibleText("New York");
		
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(10000);
		
		Pagetitle = driver.getTitle();// Get page title for the page
		
		System.out.println("Result page : "+Pagetitle);
		
		
		//Duplicate lead
		driver.findElement(By.linkText("Duplicate Lead")).click();// Click duplicate lead button
		System.out.println("Navigate to duplicate lead page");
		driver.findElement(By.id("createLeadForm_companyName")).clear(); //clear existing company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google"); //change company
		driver.findElement(By.id("createLeadForm_firstName")).clear(); // clear existing first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Riyaz"); // Change first name
		driver.findElement(By.className("smallSubmit")).click();

		Pagetitle = driver.getTitle();// Get page title for the page
		
		System.out.println("Resultant page name : "+Pagetitle);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(5000);
		
		Pagetitle = driver.getTitle();// Get page title for the result page
		
		driver.close();		
	}
	
}
