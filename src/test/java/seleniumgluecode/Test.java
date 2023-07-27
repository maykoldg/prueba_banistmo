package seleniumgluecode;

import cucumber.api.PendingException;
import org.openqa.selenium.JavascriptExecutor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    private ChromeDriver driver;

    @Given("^El usuario esta en el sitio en la seccion de empresa$")
    public void el_usuario_esta_en_el_sitio_en_la_seccion_de_empresa() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.banistmo.com/wps/portal/banistmo/empresas");
        driver.manage().window().maximize();
    }

    @When("^Hace click en las opciones necesarias para llegar al PDF$")
    public void hace_click_en_las_opciones_necesarias_para_llegar_al_PDF() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Navegación en el sitio
        // Clic en aceptar coockies
        WebElement entendido = driver.findElement(By.id("btn-aceptar-cookies"));
        entendido.click();
        // Clic en productos y servicios
        driver.findElement(By.className("dropdown-toggle")).click();
        // Clic en depósitos
        driver.findElement(By.linkText("Depósitos")).click();
        // Clic en imagen de cuenta de ahorro comercial
        driver.findElement(By.xpath("//*[@id=\"none\"]/div/div/div[2]/div[2]/div/div[1]")).click();
        // Swipe hasta la opción de beneficios y servicios para tener visibilidad de las opciones
        WebElement element = driver.findElement(By.linkText("Beneficios y servicios"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        // Pausa y clic en la opción de Documentos
        driver.findElement(By.linkText("Documentos")).click();
        // Clic al PDF
        driver.findElement(By.xpath("//a[@title='Contrato Único de Productos y Servicios Bancarios']")).click();
    }

    @Then("^Debe mostrar el PDF$")
    public void debe_mostrar_el_PDF() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
