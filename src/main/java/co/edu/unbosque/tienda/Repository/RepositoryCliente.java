package co.edu.unbosque.tienda.Repository;

import co.edu.unbosque.tienda.Objects.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente extends CrudRepository<Cliente, Long> {


}
