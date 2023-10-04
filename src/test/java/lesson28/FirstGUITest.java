package lesson28;

import org.example.Session;
import org.example.base.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstGUITest {

    @BeforeMethod
    public void before() {
    }
    @Test
    public void testExample1() {
        Session.get().webdriver().get("https://demoqa.com/elements");
        WebElement buttons = Session.get().webdriver().findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']"));
        buttons.click();
        Wait.sleep(1000);
        WebElement clickMe = Session.get().webdriver().findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button"));
        clickMe.click();
        Wait.sleep(1000);
        WebElement message = Session.get().webdriver().findElement(By.xpath("//*[@id=\"dynamicClickMessage\"]"));
        System.out.println("Message: " + message.getText());
    }

    @Test
    public void testExample2() {
        Session.get().webdriver().get("https://demoqa.com/webtables");
        WebElement add = Session.get().webdriver().findElement(By.xpath("//button[@id='addNewRecordButton']"));
        add.click();
        Wait.sleep(3000);
        WebElement firstName = Session.get().webdriver().findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastName = Session.get().webdriver().findElement(By.xpath("//input[@id='lastName']"));
        WebElement email = Session.get().webdriver().findElement(By.xpath("//input[@id='userEmail']"));
        WebElement age = Session.get().webdriver().findElement(By.xpath("//input[@id='age']"));
        WebElement salary = Session.get().webdriver().findElement(By.xpath("//input[@id='salary']"));
        WebElement department = Session.get().webdriver().findElement(By.xpath("//input[@id='department']"));
        WebElement submit = Session.get().webdriver().findElement(By.xpath("//button[@id='submit']"));

        firstName.clear();
        firstName.sendKeys("Brad");
        lastName.clear();
        lastName.sendKeys("Pitt");
        email.sendKeys("bpitt@google.com");
        age.sendKeys("50");
        salary.sendKeys("1000");
        department.sendKeys("Management");
        Wait.sleep(1000);
        submit.click();
        Wait.sleep(1000);
        WebElement editRecord = Session.get().webdriver().findElement(By.xpath("//span[@id='edit-record-4']//*[name()='svg']"));
        editRecord.click();
        Wait.sleep(3000);
        WebElement firstName1 = Session.get().webdriver().findElement(By.xpath("//input[@id='firstName']"));
        firstName1.clear();
        firstName1.sendKeys("Brad1");
        Wait.sleep(1000);
        WebElement submit1 = Session.get().webdriver().findElement(By.xpath("//button[@id='submit']"));
        submit1.click();
        Wait.sleep(2000);
    }

    @AfterMethod
    public void after() {
        Session.get().close();
    }

}
