package co.edu.unbosque.tienda.Repository;



import co.edu.unbosque.tienda.Objects.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProveedor extends CrudRepository<Proveedor, Long> {


}
