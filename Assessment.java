import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assessment {

	public static void main(String[] args) throws Exception {
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().fullscreen();
		WebElement revenueOption = driver.findElement(By.xpath("//div[contains(text(),'Revenue Calculator')]"));
		revenueOption.click();
		Thread.sleep(3000);
		WebElement slider =driver.findElement(By.cssSelector(".MuiSlider-root.MuiSlider-colorPrimary.MuiSlider-sizeMedium.css-16i48op"));
		Actions actions = new Actions(driver);
		actions.moveToElement(slider).clickAndHold().moveByOffset(-107, -107).release().perform(); 
		Thread.sleep(3000);
		WebElement textBox = driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-129j43u']"));
        Thread.sleep(3000);
        WebElement inputText = driver.findElement(By.xpath("//input[contains(@class, 'MuiInputBase-input')]"));
        Thread.sleep(3000);
        String actualValueString= inputText.getAttribute("value");
        int actualValue = Integer.parseInt(actualValueString);
        System.out.println(actualValue);
        int expectedValue = 283;
        if (actualValue==expectedValue) {
        	System.out.println("Test Passed:The slider value is same as text box value.");
        } else {
        	System.out.println("Test Failed:The slider value is not same as text value.");
        }
        Thread.sleep(3000);
        WebElement textValue = driver.findElement(By.xpath("//input[@type='number']"));
        textValue.clear();
        Actions actions1 = new Actions(driver);
        Thread.sleep(2000);

        actions1.moveToElement(textValue).click().sendKeys(Keys.BACK_SPACE).sendKeys("560").perform();
        Actions scrollDown = new Actions(driver);
        // Scroll down by moving the mouse wheel
        scrollDown.scrollByAmount(0, 500).perform(); 
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[contains(@class, 'PrivateSwitchBase-input')]"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        checkboxes.get(2).click();
        scrollDown.scrollByAmount(0, 500).perform(); 
        checkboxes.get(7).click();
        Thread.sleep(2000);
        WebElement totalRecurring = driver.findElement(By.xpath("//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-1lnu3ao']/*[4]"));
        String actualText= totalRecurring.getText();
        String displayedText= "Total Recurring Reimbursement for all Patients Per Month:\n$37935";
        if (actualText.equals(displayedText)) {
            System.out.println("Text matches!");
        } else {
            System.out.println("Text does not match. Found: " + actualText);
        }
        driver.quit();
	}
	
}
		