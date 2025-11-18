package pe.edu.upeu.conceptos_poo.saborsistemas.service;

import pe.edu.upeu.conceptos_poo.saborsistemas.dto.ComboBoxOption;
import pe.edu.upeu.conceptos_poo.saborsistemas.modelos.Categoria;

import java.util.List;

public interface CategoriaInterface extends CRUD_Generico_Interface<Categoria, Long> {
    List<ComboBoxOption> listarCombobox();
}
