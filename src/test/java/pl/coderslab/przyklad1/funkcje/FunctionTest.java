package pl.coderslab.przyklad1.funkcje;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("http://pl.wikipedia.org/");
    }
    @Test
    public void testWikipediaSearch() {
        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
       // WebElement element = driver.findElement(By.id("main-page-column1"));
        //System.out.println(element.getText());
        WebElement el = driver.findElement(By.id("main-page-content"));
//        String elementClass = el.getAttribute("class");
//        System.out.println(elementClass);
        String tagName = el.getTagName();
        System.out.println(tagName); // wyświetli w konsoli rodzeństwo z drzewka od main-page-content
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
       // driver.quit();
    }
}
