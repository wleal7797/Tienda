package co.edu.unbosque.tienda.Service;

import co.edu.unbosque.tienda.Objects.Empleado;
import co.edu.unbosque.tienda.Repository.RepositoryEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    public Iterable<Empleado> listarTodos() {
        return repositoryEmpleado.findAll();
    }

    public Empleado guardar(Empleado empleado) {
        return repositoryEmpleado.save(empleado);
    }

    public Empleado buscarPorId(Long id) {
        return repositoryEmpleado.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositoryEmpleado.deleteById(id);
    }
}
