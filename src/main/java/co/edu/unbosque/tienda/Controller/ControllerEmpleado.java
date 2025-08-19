package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Empleado;
import co.edu.unbosque.tienda.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class ControllerEmpleado {

    @Autowired
    private EmpleadoService serviceEmpleado;

    @GetMapping
    public Iterable<Empleado> listarTodos() {
        return serviceEmpleado.listarTodos();
    }

    @GetMapping("/{id}")
    public Empleado buscarPorId(@PathVariable Long id) {
        return serviceEmpleado.buscarPorId(id);
    }

    @PostMapping
    public Empleado guardar(@RequestBody Empleado empleado) {
        return serviceEmpleado.guardar(empleado);
    }
/*
    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        Empleado existente = serviceEmpleado.buscarPorId(id);
        if (existente != null) {
            empleado.setId(id);
            return serviceEmpleado.guardar(empleado);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceEmpleado.eliminar(id);
    }

 */
}
