package co.edu.unbosque.tienda.Service;


import co.edu.unbosque.tienda.Objects.Usuario;
import co.edu.unbosque.tienda.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public Iterable<Usuario> listarTodos() {
        return repositoryUsuario.findAll();
    }

    public Usuario guardar(Usuario empleado) {
        return repositoryUsuario.save(empleado);
    }

    public Usuario buscarPorId(Long id) {
        return repositoryUsuario.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryUsuario.deleteById(id);
    }
}
