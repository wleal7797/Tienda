package co.edu.unbosque.tienda.Repository;



import co.edu.unbosque.tienda.Objects.Ventas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVentas extends CrudRepository<Ventas, Long> {


}
