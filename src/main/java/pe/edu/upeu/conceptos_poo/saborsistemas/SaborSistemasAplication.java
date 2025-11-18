package pe.edu.upeu.conceptos_poo.saborsistemas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pe.edu.upeu.conceptos_poo.saborsistemas.components.StageManager;
import pe.edu.upeu.conceptos_poo.saborsistemas.config.DataInitializer;
import pe.edu.upeu.conceptos_poo.saborsistemas.service.*;

@SpringBootApplication
public class SaborSistemasAplication extends Application {
    private ConfigurableApplicationContext context;
    private Parent parent;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void init() throws Exception {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SaborSistemasAplication.class);
        builder.application().setWebApplicationType(WebApplicationType.NONE);
        context = builder.run(getParameters().getRaw().toArray(new String[0]));

        // --- INICIALIZACIÓN DE DATOS ---
        // 2. Obtener la implementación del servicio (ProductoServiceImp) a través de su Interfaz.
        // Spring gestiona la inyección y devuelve la instancia Singleton.
        ProductoInterface productoInterface = context.getBean(ProductoInterface.class);
        CategoriaInterface categoriaInterface = context.getBean(CategoriaInterface.class);
        UsuarioInterface usuarioInterface = context.getBean(UsuarioInterface.class);
        PerfilInterface perfilInterface =context.getBean(PerfilInterface.class);
        UnidadMedidaInterface unidadMedidaInterface =context.getBean(UnidadMedidaInterface.class);
        // 3. Crear el DataInitializer inyectando el Service por Constructor.
        // Esto mantiene el diseño limpio (final) en DataInitializer.
        DataInitializer initializer = new DataInitializer(
                productoInterface,categoriaInterface,usuarioInterface,perfilInterface,unidadMedidaInterface);
        // 4. Ejecutar la inicialización
        initializer.initializeData();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        parent= fxmlLoader.load();
    }
    @Override
    public void start(Stage stage) throws Exception {
        StageManager.setPrimaryStage(stage);
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("SaborSistemas - Login");
        stage.show();

    }
}
