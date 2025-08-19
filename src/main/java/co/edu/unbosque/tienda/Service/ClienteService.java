package co.edu.unbosque.tienda.Service;

import co.edu.unbosque.tienda.Objects.Cliente;
import co.edu.unbosque.tienda.Repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private RepositoryCliente repositoryCliente;

    public Iterable<Cliente> listarTodos() {
        return repositoryCliente.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repositoryCliente.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryCliente.deleteById(id);
    }
}

