package co.edu.unbosque.tienda.Service;



import co.edu.unbosque.tienda.Objects.Proveedor;
import co.edu.unbosque.tienda.Repository.RepositoryProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    @Autowired
    private RepositoryProveedor repositoryProveedor;

    public Iterable<Proveedor> listarTodos() {
        return repositoryProveedor.findAll();
    }

    public Proveedor guardar(Proveedor proveedor) {
        return repositoryProveedor.save(proveedor);
    }

    public Proveedor buscarPorId(Long id) {
        return repositoryProveedor.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryProveedor.deleteById(id);
    }
}
