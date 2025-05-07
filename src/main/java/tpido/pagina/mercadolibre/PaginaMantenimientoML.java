package tpido.pagina.mercadolibre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import tpido.helper.TpidoHelper;
import tpido.pagina.base.PaginaBase;

import java.util.List;

public class PaginaMantenimientoML extends PaginaBase {

    @FindBy(id = "cb1-edit")
    WebElement txtFilter;

    @FindBy(xpath = "//*[@class='nav-search-btn']")
    WebElement btnBuscar;

    @FindBy(xpath = "//div[contains(@class, 'cookie-consent-banner-opt-out__container')]//button")
    WebElement btnAceptarCookie;

    @FindBy(xpath = "//a[span[@class=\"ui-search-filter-name\" and text()=\"Nuevo\"]]")
    WebElement filterNuevo;

    @FindBy(xpath = "//a[span[@class=\"ui-search-filter-name\" and text()=\"Distrito Federal\"]]")
    WebElement filterLocation;

    @FindBy(xpath = "//button[contains(@class, 'andes-dropdown__trigger')]")
    WebElement orderSelect;

    @FindBy(xpath = "//ul[contains(@class, 'andes-list--default')]//li[.//span[normalize-space(text())='Mayor precio']]")
    WebElement typeOrder;

    @FindBy(xpath = "//ol[contains(@class, 'ui-search-layout')]//li")
    List<WebElement> elementos;

    public PaginaMantenimientoML(WebDriver driver) {
        super(driver);
    }

    public void buscarProducto(String nombreProducto) throws InterruptedException {
        escribir(txtFilter, nombreProducto);
        Thread.sleep(1000);
        click(btnBuscar);
        Thread.sleep(1000);

    }

    public void filtrarNuevo() throws InterruptedException {
        btnAceptarCookie.click();
        Thread.sleep(2000);
        click(filterNuevo);
        Thread.sleep(1000);
    }

    public void filtrarLocation() throws InterruptedException {
        click(filterLocation);
        Thread.sleep(1000);
    }

    public void ordenarMayorMenor() throws InterruptedException {
        click(orderSelect);
        Thread.sleep(1000);
        click(typeOrder);
        Thread.sleep(2000);
    }

    public int listar5Elementos() throws InterruptedException{
        int y=0;
        for (int i = 0; i < 5 && i < elementos.size(); i++) {
            // Buscar dentro del <li> el enlace que contiene el título del producto.
            WebElement titleElement = elementos.get(i).findElement(By.xpath(".//a[contains(@class, 'poly-component__title')]"));
            String productTitle = titleElement.getText();

            WebElement priceElement = elementos.get(i).findElement(By.xpath(".//div[contains(@class, 'poly-price__current')]//span[contains(@class, 'andes-money-amount__fraction')]"));
            String productPrice = priceElement.getText();

            System.out.println("Producto " + (i+1) + ": " + productTitle + " - Precio: $" + productPrice);
            y++;
        }
        return y;
    }

    public String mensajeRespuesta(){
        TpidoHelper.pausar();
        return "Test";
    }
}
