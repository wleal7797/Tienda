package co.edu.unbosque.tienda.Repository;

import co.edu.unbosque.tienda.Objects.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends CrudRepository<Producto, Long> {


}
