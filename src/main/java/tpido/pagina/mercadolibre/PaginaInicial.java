package tpido.pagina.mercadolibre;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tpido.pagina.base.PaginaBase;

public class PaginaInicial extends PaginaBase {

    @FindBy(id = "MX")
    WebElement txtPais;

    @FindBy( id = "txtClave")
    WebElement txtClave;

    @FindBy( id = "btnIniciarSesion")
    WebElement btnIniciarSesion;

    @FindBy(id = "j_idt16_header")
    WebElement lblMnesajeBienvenida;

    public PaginaInicial(WebDriver driver) {
        super(driver);
    }

    public void cargarPagina() {
        driver.get("https://www.mercadolibre.com/");
    }

    public PaginaMantenimientoML cargarPaginaMantenimientoML() throws InterruptedException {
        txtPais.click();
        return new PaginaMantenimientoML(driver);
    }


    public String getMensajeBienvenida() {
        return lblMnesajeBienvenida.getText();
        //return driver.findElement(By.xpath("//div[@class='title-main']")).getText();
    }
}
