package pl.coderslab.przyklad1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszTest {




        private WebDriver driver;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            // Uruchom nowy egzemplarz przeglądarki Chrome
            driver = new ChromeDriver();

            // Zmaksymalizuj okno przeglądarki
            driver.manage().window().maximize();
            // Przejdź do Google
            driver.get("http://www.bing.com");
        }
        @Test
        public void testGoogleSearch() {
            // Znajdź element wprowadzania tekstu na podstawie jego nazwy
            WebElement element = driver.findElement(By.name("q"));
            // Wyczyść teskst zapisany w elemencie
            element.clear();

            // Wpisz informacje do wyszukania
            element.sendKeys("Mistrzostwa świata w piłce nożnej 2018");

            // Prześlij formularz
            element.submit();
        }
        @After
        public void tearDown() throws Exception {
            // Zamknij przeglądarkę
            driver.quit();
        }
    }

