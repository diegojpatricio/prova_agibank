package Desafios;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AgibanktesteTest {
    private static final String URL =  "https://blogdoagi.com.br";
    private WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        browser.navigate().to(URL);
    }
    @AfterEach
    public void tearDown() {
        browser.quit();
    }
    @Test
    public void realizandoBuscaFaziaDeveAparecerNoticiasRecentes() {
        browser.get(URL);
        browser.manage().window().maximize();
        browser.findElement(By.id("search-open")).click();
        browser.findElement(By.cssSelector(".desktop-search .search-submit")).click();
        browser.manage().window().maximize();
        browser.findElement(By.id("search-open")).click();
    }
    @Test
    public void realizandoBuscaNominalDeveAparecerNoticiasNominais() {
        browser.get(URL);
        browser.manage().window().maximize();
        browser.findElement(By.id("search-open")).click();
        browser.findElement(By.name("s")).click();
        browser.findElement(By.name("s")).sendKeys("renda");
        browser.findElement(By.cssSelector(".desktop-search .search-submit")).click();
    }

}
