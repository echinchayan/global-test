package mercadolibre;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import tpido.pagina.mercadolibre.PaginaInicial;
import tpido.pagina.mercadolibre.PaginaMantenimientoML;

public class PaginaInicialStep {
    @Managed
    WebDriver driver;

    PaginaInicial paginaInicial;
    PaginaMantenimientoML paginaMantenimientoML;

    @Before
    public void configuracionInicial() {
        //driver =  VisorDriver.getDriver(Navegador.CHROME);
        paginaInicial = new PaginaInicial(driver);
        //paginaRegistarUsuario = new PaginaRegistarUsuario(driver);
        paginaMantenimientoML = new PaginaMantenimientoML(driver);
    }

    @After
    public void cerrarDriver() {
        driver.quit();
    }


    @Given("cargamos la pagina mercado libre")
    public void cargarPaginaVisor() {
        paginaInicial.cargarPagina();
    }

    @And("seleccionamos pais Mexico")
    public void seleccionarPais() throws InterruptedException {
        paginaInicial.cargarPaginaMantenimientoML();
    }


	/*
	@And("ingresamos al Menu")
	public void ingresamosMenu() {

		menuPrincipal.cargarPaginaMantenimientoPedido();

		}
*/

    @When("ingresamos en filtro de busqueda el producto {string} y el boton Buscar")
    public void seleccionarProductos(String producto) throws InterruptedException {
         paginaMantenimientoML.buscarProducto(producto);
    }

    @And("seleccionamos filtro Nuevo")
    public void seleccionarFiltroNuevo() throws InterruptedException {
        paginaMantenimientoML.filtrarNuevo();
        // Assertions.assertThat(paginaMantinimientoPedido.mensajeRespuesta()).contains(mensajeEsperado);

    }

    @And("filtrar location CDMX")
    public void seleccionarLocation() throws InterruptedException {
        paginaMantenimientoML.filtrarLocation();
    }

    @And("ordenar de MAYOR a MENOR")
    public void ordenarMayorMenor() throws InterruptedException {
        paginaMantenimientoML.ordenarMayorMenor();
    }
    @Then("Obtiene resultados y muestra en consola")
    public void obtieneResultados() throws InterruptedException{
        Assertions.assertThat(paginaMantenimientoML.listar5Elementos()).isEqualTo(5);
    }


}
