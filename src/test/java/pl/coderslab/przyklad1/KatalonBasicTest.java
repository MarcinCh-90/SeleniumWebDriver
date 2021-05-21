package pl.coderslab.przyklad1;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class KatalonBasicTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }

    @Test
    public void testFormularz(){
        // test z powtórzeniami
        inputTextById("first-name", "Marcin");
        inputTextById("last-name", "Chodecki");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]"));
        gender.click();

        inputTextById("dob", "01/16/1990");

        WebElement address = driver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("Wrocław 71");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("marcin@gmail.pl");

        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("Pass123");

        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys("Coderslab");

        Select role = new Select(driver.findElement(By.xpath("//*[@id='role']")));
        role.selectByVisibleText("QA");

        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy test automatyczny");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
    }

    private void inputTextById(String id, String text) {
        WebElement element = driver.findElement(By.id(id));

        if (element.isEnabled()) {
            element.click();
            element.clear();
            element.sendKeys(text);

            // to mi znajdzie labelkę
            WebElement label = driver.findElement(By.xpath("//label[@for='"+ id +"']"));
            System.out.println(label.getText() + ":" + text);
        }

    }

    @After
    public void tearDown(){
        // driver.quit();
    }

}
