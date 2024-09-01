import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Login extends BaseTest {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 6);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void criandoConta() {
        criarConta("Rodrigo", "Oliveira", "email.teste1@gmail.com", "teste123", "Brasil", "Rio de Janeiro");
    }

    @Test
    public void loginValido() {
        realizarLogin("Starkstorezoficial@gmail.com", "Teste123");

        esperarElementoVisivel(By.cssSelector(".h-ybrhvy > .h-v73dmn"));
        assertThat(driver.findElement(By.cssSelector(".h-ybrhvy > .h-v73dmn")).getText(), is("Rodrigo"));
    }

    @Test
    public void loginInvalido() {
        realizarLogin("email_invalido@test.com", "SenhaErrada");

        esperarElementoVisivel(By.cssSelector(".h-1c50034"));
        assertThat(driver.findElement(By.cssSelector(".h-1c50034")).getText(), is("Não foi possível realizar o login. Email e/ou senha incorretos."));
    }

    @Test
    public void logOut() {
        loginValido();
        esperarElementoVisivel(By.cssSelector(".c-header"));

        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.cssSelector(".h-ybrhvy > .h-v73dmn")).click();
        driver.findElement(By.cssSelector(".h-rpb3wr > .h-13o8myy")).click();
        assertThat(driver.findElement(By.linkText("Entrar")).getText(), is("Entrar"));
    }

    @Test
    public void buscaPacoteExistente() {
        loginValido();
        esperarElementoVisivel(By.cssSelector(".c-header"));

        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.cssSelector(".h-3jn65r:nth-child(2)")).click();
        driver.findElement(By.id("destination-input")).sendKeys("Londres");
        driver.findElement(By.cssSelector(".h-cziypv")).click();

        esperarElementoVisivel(By.cssSelector(".ResultsCardsContainer_ResultsCardContainer__CDDwR:nth-child(1)"));
    }

    @Test
    public void buscaPacoteInexistente() {
        loginValido();
        esperarElementoVisivel(By.cssSelector(".c-header"));

        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.cssSelector(".h-3jn65r:nth-child(2)")).click();
        driver.findElement(By.id("destination-input")).sendKeys("testeteste");
        driver.findElement(By.cssSelector(".h-cziypv")).click();

        esperarElementoVisivel(By.cssSelector(".h-4b0qhm"));
        assertThat(driver.findElement(By.cssSelector(".h-4b0qhm")).getText(), is("Ops, sem pacotes disponíveis para este destino!"));
    }
}
