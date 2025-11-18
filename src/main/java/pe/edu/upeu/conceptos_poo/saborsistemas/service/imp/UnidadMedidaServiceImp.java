package pe.edu.upeu.conceptos_poo.saborsistemas.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.conceptos_poo.saborsistemas.dto.ComboBoxOption;
import pe.edu.upeu.conceptos_poo.saborsistemas.modelos.UnidadMedida;
import pe.edu.upeu.conceptos_poo.saborsistemas.repository.IUnidadMedidaRepository;
import pe.edu.upeu.conceptos_poo.saborsistemas.service.UnidadMedidaInterface;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnidadMedidaServiceImp extends CRUD_Generico_ServiceImp<UnidadMedida, Long> implements UnidadMedidaInterface {
    private final IUnidadMedidaRepository unidadmedidaRepository;
    @Override
    protected IUnidadMedidaRepository getRepository() {
        return unidadmedidaRepository;
    }
    @Override
    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(UnidadMedida cate : unidadmedidaRepository.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getId_unidad()));
            cb.setValue(cate.getNombre_Medida());
            listar.add(cb);
        }
        return listar;
    }
}
