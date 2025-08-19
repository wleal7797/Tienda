package co.edu.unbosque.tienda.Service;

import co.edu.unbosque.tienda.Objects.Inventario;
import co.edu.unbosque.tienda.Repository.RepositoryInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

    @Autowired
    private RepositoryInventario repositoryInventario;

    public Iterable<Inventario> listarTodos() {
        return repositoryInventario.findAll();
    }

    public Inventario guardar(Inventario inventario) {
        return repositoryInventario.save(inventario);
    }

    public Inventario buscarPorId(Long id) {
        return repositoryInventario.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryInventario.deleteById(id);
    }
}
