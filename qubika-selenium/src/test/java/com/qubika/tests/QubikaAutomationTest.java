package com.qubika.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QubikaAutomationTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qubika.com");
    }

    @Test(priority = 1)
    public void validateHomePage() {
        // Validate URL
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.qubika.com");

        // Validate Qubika logo
        WebElement logo = driver.findElement(By.cssSelector(".logo-selector")); // Replace with actual selector
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed.");
    }

    @Test(priority = 2)
    public void validateContactForm() {
        // Click 'Contact us' button
        WebElement contactUsButton = driver.findElement(By.id("contact-us-button")); // Replace with actual selector
        contactUsButton.click();

        // Validate contact form fields
        Assert.assertTrue(driver.findElement(By.id("name-field")).isDisplayed(), "Name field not displayed.");
        Assert.assertTrue(driver.findElement(By.id("email-field")).isDisplayed(), "Email field not displayed.");
        Assert.assertTrue(driver.findElement(By.id("get-in-touch-button")).isDisplayed(), "Get in touch button not displayed.");
    }

    @Test(priority = 3)
    public void validateMandatoryFields() {
        // Click 'Get in touch' without filling any field
        WebElement getInTouchButton = driver.findElement(By.id("get-in-touch-button"));
        getInTouchButton.click();

        // Validate error messages
        Assert.assertTrue(driver.findElement(By.id("name-error")).isDisplayed(), "Name field error not displayed.");
        Assert.assertTrue(driver.findElement(By.id("email-error")).isDisplayed(), "Email field error not displayed.");

        // Validate 'Name' field is red
        WebElement nameField = driver.findElement(By.id("name-field"));
        String borderColor = nameField.getCssValue("border-color");
        Assert.assertEquals(borderColor, "rgba(255, 0, 0, 1)", "Name field is not marked red.");
    }

    @Test(priority = 4)
    public void validateErrorAfterInput() {
        // Input 'Test name' in the Name field
        WebElement nameField = driver.findElement(By.id("name-field"));
        nameField.sendKeys("Test name");

        // Click 'Get in touch' button
        WebElement getInTouchButton = driver.findElement(By.id("get-in-touch-button"));
        getInTouchButton.click();

        // Validate Name field no longer has an error
        Assert.assertFalse(driver.findElement(By.id("name-error")).isDisplayed(), "Name field still shows error.");

        // Validate Email field error remains
        WebElement emailField = driver.findElement(By.id("email-field"));
        String borderColor = emailField.getCssValue("border-color");
        Assert.assertEquals(borderColor, "rgba(255, 0, 0, 1)", "Email field is not marked red.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
