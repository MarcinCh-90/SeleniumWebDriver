package pl.coderslab.przyklad1.funkcje;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadanie3Test {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do strony z formularzem
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
    }
    @Test
    public void testFormularz() {

        WebElement searchFirstname = driver.findElement(By.id("first-name"));
            if (searchFirstname.isEnabled()) {
                searchFirstname.sendKeys("");
                searchFirstname.submit();
            } else {
                Assert.fail();
            }

        // Znajdź element wprowadzania tekstu na podstawie jego nazwy
        WebElement username = driver.findElement(By.id("first-name"));
        // Wyczyść teskst zapisany w elemencie- przy tym zadaniu trzeba too wyłączyć bo wyczyszcza tekst "nazwa pola"
       // username.clear();
        username.sendKeys("Marcin");
        username.submit();

        WebElement elementName = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[1]/label"));
        System.out.println("Nazwa pola :");
        System.out.println(elementName.getText());

        WebElement searchLastname = driver.findElement(By.id("last-name"));
        if (searchLastname.isEnabled()) {
            searchLastname.sendKeys("");
            searchLastname.submit();
        } else {
            Assert.fail();
        }

        WebElement lastname = driver.findElement(By.id("last-name"));
        //lastname.clear();
        lastname.sendKeys("Chodecki");
        lastname.submit();

        WebElement elementLast = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[2]/label"));
        System.out.println("Nazwa pola :" + elementLast.getText());
        //System.out.println(elementLast.getText());

        // Znajdź przycisk/koło wyboru płeć męska
        // tutaj jakiś błąd= WebElement buttonGender = driver.findElement(By.xpath("//[@id=''infoForm']/div[3]/div/div/label[1]/input"));
        WebElement buttonGender = driver.findElement(By.cssSelector("#infoForm > div:nth-child(3) > div > div > label:nth-child(1) > input[type=radio]"));
        buttonGender.click(); //zamiast submit, wybieramy drugi sposób


        // Znajdź pole data urodzin, tutaj łatwy sposób - nie powinno sie tak pisać, można bardziej rozwinąć
        WebElement dateofbirth = driver.findElement(By.id("dob"));
        dateofbirth.clear();
        dateofbirth.sendKeys("05/18/21");

        WebElement searchAddres = driver.findElement(By.id("address"));
        if (searchAddres.isEnabled()) {
            searchAddres.sendKeys("");
            searchAddres.submit();
        } else {
            Assert.fail();
        }
        // Znajdź element wprowadzania tekstu Adresu
        WebElement ulica = driver.findElement(By.id("address"));
        //ulica.clear();
        ulica.sendKeys("Krucza 55");
        ulica.submit();

        WebElement elementAdress = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[5]/label"));
        System.out.println("Nazwa pola :");
        System.out.println(elementAdress.getText());

        WebElement searchEmail = driver.findElement(By.id("email"));
        if (searchEmail.isEnabled()) {
            searchEmail.sendKeys("");
            searchEmail.submit();
        } else {
            Assert.fail();
        }

        // Znajdź element wprowadzenia tekstu w pole Email
        WebElement poleemail = driver.findElement(By.id("email"));
        //poleemail.clear();
        // Za pomocą xpath
        // za pomocą css selector
        poleemail.sendKeys("marcin@gmail.com");
        poleemail.submit();

        // Znajdź element hasła
        WebElement haslo = driver.findElement(By.id("password"));
        haslo.clear();
        haslo.sendKeys("Pass123");
        haslo.submit();

        WebElement searchCompany = driver.findElement(By.id("company"));
        if (searchCompany.isEnabled()) {
            searchCompany.sendKeys("");
            searchCompany.submit();
        } else {
            Assert.fail();
        }

        // Znajdź element pola Firmy
        WebElement company = driver.findElement(By.id("company"));
        //company.clear();
        company.sendKeys("Coders Lab");
        company.submit();

        //dodatkowo - Znajdź i wybierz role
        // WebElement role = driver.findElement(By.xpath ("//*[@id='role']/option[2]"));
        //WebElement role = driver.findElement(By.cssSelector("#role > option:nth-child(2)"));
        // role.click();

        // Prawidłowy wybór wyszukania gdy pole na kilka opcji z otwartą listą !! importujemy select
        WebElement roleSelectElement = driver.findElement(By.id("role"));
        Select role = new Select(roleSelectElement);
        role.selectByVisibleText("Manager");


        // dodatkowo - znajdz pole w wyborze opcji w oczekiwaniu w pracy - praca w zespole
        WebElement jobExpectation = driver.findElement(By.xpath("//*[@id='expectation']/option[4]"));
        jobExpectation.click();

        // dodatkowo zaznacz 2 sposoby na rozwój (czytanie ksiązek i zajęcia online)
        WebElement development = driver.findElement(By.cssSelector("#infoForm > div:nth-child(11) > div > div:nth-child(1) > label > input[type=checkbox]"));
        development.click();
        WebElement development2= driver.findElement(By.cssSelector("#infoForm > div:nth-child(11) > div > div:nth-child(2) > label > input[type=checkbox]"));
        development2.click();

        WebElement searchComment = driver.findElement(By.id("comment"));
        if (searchComment.isEnabled()) {
            searchComment.sendKeys("");
            searchComment.submit();
        } else {
            Assert.fail();
        }

        // Znajdź element pola komentarz
        WebElement comment = driver.findElement(By.id("comment"));
        //comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy");
        comment.submit();
    }
    @After
    public void tearDown() throws Exception {
        // Zamknij przeglądarkę
        //driver.quit();
    }
}

