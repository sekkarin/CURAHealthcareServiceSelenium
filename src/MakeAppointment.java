import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

class MakeAppointment {

	@Test
	void TC1001MakeAppointment_Success() throws Exception {
		WebDriver driver = null;

		System.setProperty("webdriver.edge.driver", "C:\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		
		//Page1 Make Appointment
		driver.findElement(By.id("btn-make-appointment")).click();
		
		//Page2 Login
		driver.findElement(By.id("txt-username")).sendKeys("John Doe");
		driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
		driver.findElement(By.id("btn-login")).click();
		
		//Page3 Make Appointment Detail
		Select option1 = new Select(driver.findElement(By.id("combo_facility")));
		option1.selectByVisibleText("Hongkong CURA Healthcare Center");
		driver.findElement(By.id("chk_hospotal_readmission")).click();
		WebElement radio1 = driver.findElement(By.id("radio_program_none"));
		radio1.click();
		driver.findElement(By.id("txt_visit_date")).sendKeys("18/01/2023");
		driver.findElement(By.id("txt_comment")).sendKeys("Heart");
		driver.findElement(By.id("btn-book-appointment")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}