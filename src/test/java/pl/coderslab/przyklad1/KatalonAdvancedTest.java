package pl.coderslab.przyklad1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonAdvancedTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void testFormularz() {
        inputText(By.id("first-name"), "Marcin");
        inputText(By.id("last-name"), "Chodecki");
        clickElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]"));
        inputText(By.name("dob"), "01/16/1990");
        inputText(By.id("address"), "Wrocław 71");
        inputText(By.id("email"), "marcin@gmail.com");
        inputText(By.id("password"), "Pass123");
        inputText(By.id("company"), "CodersLab");

        // Wybieranie jednej opcji z pola Select nie działa i jeszcze nie wiem dlaczego??
        Select role = new Select(driver.findElement(By.xpath("//*[@id='role']")));
        role.selectByVisibleText("QA");

        inputText(By.id("comment"), "To jest mój pierwszy test automatyczny");
        clickElement(By.id("submit"));
    }

    private void inputText(By by, String text) {
        WebElement element = driver.findElement(by);
        if (element.isEnabled()) {
            element.click();
            element.clear();
            element.sendKeys(text);

            WebElement label = element.findElement(By.xpath("./../../label"));
            System.out.println(label.getText() + ":" + text);
        }
    }

    private void clickElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    @After
    public void tearDown(){
        // driver.quit();
    }
}
