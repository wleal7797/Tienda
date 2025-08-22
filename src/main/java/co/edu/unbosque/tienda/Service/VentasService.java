package co.edu.unbosque.tienda.Service;




import co.edu.unbosque.tienda.Objects.Ventas;
import co.edu.unbosque.tienda.Repository.RepositoryVentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasService {

    @Autowired
    private RepositoryVentas repositoryVentas;

    public Iterable<Ventas> listarTodos() {
        return repositoryVentas.findAll();
    }

    public Ventas guardar(Ventas Ventas) {
        return repositoryVentas.save(Ventas);
    }

    public Ventas buscarPorId(Long id) {
        return repositoryVentas.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryVentas.deleteById(id);
    }
}
