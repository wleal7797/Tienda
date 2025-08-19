package co.edu.unbosque.tienda.Service;

import co.edu.unbosque.tienda.Objects.Producto;
import co.edu.unbosque.tienda.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private RepositoryProducto repositoryProducto;

    public Iterable<Producto> listarTodos() {
        return repositoryProducto.findAll();
    }

    public Producto guardar(Producto producto) {
        return repositoryProducto.save(producto);
    }

    public Producto buscarPorId(Long id) {
        return repositoryProducto.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryProducto.deleteById(id);
    }
}
