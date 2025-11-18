package pe.edu.upeu.conceptos_poo.saborsistemas.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.upeu.conceptos_poo.saborsistemas.modelos.Perfil;
import pe.edu.upeu.conceptos_poo.saborsistemas.repository.ICrudGenericoRepository;
import pe.edu.upeu.conceptos_poo.saborsistemas.repository.IPerfilRepository;
import pe.edu.upeu.conceptos_poo.saborsistemas.service.PerfilInterface;

@RequiredArgsConstructor
@Service
public class PerfilServiceImp extends CRUD_Generico_ServiceImp<Perfil, Long> implements PerfilInterface {

    private final IPerfilRepository perfilRepository;

    @Override
    protected ICrudGenericoRepository<Perfil, Long> getRepository() {
        return perfilRepository;
    }
}
