package co.edu.unbosque.tienda.Repository;

import co.edu.unbosque.tienda.Objects.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpleado extends CrudRepository<Empleado, Long> {


}