import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public void abrirPaginaInicial() {
        driver.get("https://www.hurb.com/br");
        driver.manage().window().maximize();
    }

    public void criarConta(String firstName, String lastName, String email, String password, String country, String state) {
        abrirPaginaInicial();
        navegarParaLogin();

        driver.findElement(By.linkText("Criar uma conta")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("passwordConfirmation")).sendKeys(password);

        selecionarDropdown(By.id("country"), country);
        selecionarDropdown(By.id("stateProvince"), state);

        driver.findElement(By.id("newsOptIn")).click();
        driver.findElement(By.cssSelector(".h-14h62bl")).click();

        esperarElementoVisivel(By.cssSelector(".AccountRequestActivation_Title__9cJ05"));
        assert driver.findElement(By.cssSelector(".AccountRequestActivation_Title__9cJ05")).getText().equals("Estamos quase lá...");
        assert driver.findElement(By.linkText("Continuar navegando")).getText().equals("Continuar navegando");
        driver.findElement(By.linkText("Continuar navegando")).click();
    }

    public void realizarLogin(String email, String senha) {
        abrirPaginaInicial();
        navegarParaLogin();

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.cssSelector(".h-acv6aj")).click();
    }

    protected void navegarParaLogin() {
        driver.findElement(By.linkText("Entrar")).click();
    }

    protected void selecionarDropdown(By locator, String valor) {
        WebElement dropdown = driver.findElement(locator);
        dropdown.findElement(By.xpath("//option[. = '" + valor + "']")).click();
    }

    protected void esperarElementoVisivel(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
