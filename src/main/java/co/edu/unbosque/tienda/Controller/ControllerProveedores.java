package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Proveedor;
import co.edu.unbosque.tienda.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proveedores")  // Asegurar que sea /proveedores
public class ControllerProveedores {

    @Autowired
    private ProveedorService serviceProveedor;

    @GetMapping
    public Iterable<Proveedor> listarTodos() {
        return serviceProveedor.listarTodos();
    }

    @GetMapping("/{id}")
    public Proveedor buscarPorId(@PathVariable Long id) {
        return serviceProveedor.buscarPorId(id);
    }

    @PostMapping
    public Proveedor guardar(@RequestBody Proveedor proveedor) {
        return serviceProveedor.guardar(proveedor);
    }

    @PutMapping("/{id}")
    public Proveedor actualizar(@PathVariable Long id, @RequestBody Proveedor proveedor) {
        return serviceProveedor.guardar(proveedor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceProveedor.eliminar(id);
    }
}