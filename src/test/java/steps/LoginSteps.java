package steps;

import io.cucumber.java.pt.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SlowMotion;

import static org.junit.Assert.*;

public class LoginSteps {

    WebDriver driver;

    @Dado("que o usuário acessa a página de login")
    public void acessarPaginaLogin() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Quando("ele informa usuário {string} e senha {string}")
    public void preencherCredenciais(String usuario, String senha) {
        driver.findElement(By.cssSelector("[data-test='username']")).sendKeys(usuario);
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys(senha);
    }

    @E("clica no botão de login")
    public void clicarLogin() {
        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
    }

    @Então("ele deve ser redirecionado para a página de produtos")
    public void validarLoginSucesso() {
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        driver.quit();
    }

    @Então("deve ver uma mensagem de erro")
    public void validarErro() {
        WebElement erro = driver.findElement(By.xpath("//*[contains(text(),'Epic sadface')]"));
        assertTrue(erro.isDisplayed());
        driver.quit();
    }
}