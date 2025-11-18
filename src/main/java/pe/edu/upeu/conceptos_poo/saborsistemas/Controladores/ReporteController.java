package pe.edu.upeu.conceptos_poo.saborsistemas.Controladores;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.StackPane;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.conceptos_poo.saborsistemas.service.IVentaService;
import win.zqxu.jrviewer.JRViewerFX;

import java.time.format.DateTimeFormatter;

@Controller
public class ReporteController {
    @FXML
    DatePicker txtFechaI, txtFechaF;
    private JasperPrint jasperPrint;
    @FXML
    StackPane paneRepo;
    DateTimeFormatter fechaFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Autowired
    IVentaService daoV;

    @FXML
    void generarReporte(){
        if (txtFechaI.getValue() == null || txtFechaF.getValue() == null) {
            System.out.println("Debe seleccionar ambas fechas.");
            return;
        }
        String fechaI = txtFechaI.getValue().format(fechaFmt);
        String fechaF = txtFechaF.getValue().format(fechaFmt);
        try {
            System.out.println("1111111111");
            jasperPrint = daoV.runReportVentas(fechaI, fechaF);
            System.out.println("2222222222");
            JRViewerFX viewer = new JRViewerFX(jasperPrint);
            paneRepo.getChildren().clear();
            paneRepo.getChildren().add(viewer);
            StackPane.setAlignment(viewer, Pos.CENTER);
        } catch (Exception e) {
            System.out.println("VER:" + e.getMessage());
        }
    }
}
