package pl.coderslab.przyklad1.funkcje;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementTest {


        private WebDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            // Uruchom nowy egzemplarz przeglądarki Chrome
            driver = new ChromeDriver();
            // Zmaksymalizuj okno przeglądarki
            driver.manage().window().maximize();
            // Przejdź do Google
            driver.get("https://pl.wikipedia.org/");
        }

        @Test
        public void testSearchWikipedia() {
            WebElement search = driver.findElement(By.id("searchInput"));
            if (search.isEnabled()) {
                search.sendKeys("Selenium");
                search.submit();
            } else {
                Assert.fail();
            }
//          inny sposób zapisania:
//        if (!search.isEnabled()) {
//            Assert.fail();
//        } else {
//            search.sendKeys("Selenium");
//            search.submit();
//        }

        }
}
