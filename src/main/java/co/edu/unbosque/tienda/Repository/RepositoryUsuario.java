package co.edu.unbosque.tienda.Repository;



import co.edu.unbosque.tienda.Objects.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends CrudRepository<Usuario, Long> {


}