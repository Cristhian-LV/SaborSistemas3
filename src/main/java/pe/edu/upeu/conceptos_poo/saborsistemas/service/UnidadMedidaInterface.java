package pe.edu.upeu.conceptos_poo.saborsistemas.service;

import pe.edu.upeu.conceptos_poo.saborsistemas.dto.ComboBoxOption;
import pe.edu.upeu.conceptos_poo.saborsistemas.modelos.UnidadMedida;

import java.util.List;

public interface UnidadMedidaInterface extends CRUD_Generico_Interface<UnidadMedida, Long> {
    List<ComboBoxOption> listarCombobox();
}
