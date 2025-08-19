package co.edu.unbosque.tienda.Repository;

import co.edu.unbosque.tienda.Objects.Inventario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInventario extends CrudRepository<Inventario, Long> {


}
