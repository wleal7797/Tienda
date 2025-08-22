package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Cliente;
import co.edu.unbosque.tienda.Objects.Producto;
import co.edu.unbosque.tienda.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ControllerProducto {

    @Autowired
    private ProductoService serviceProducto;

    @GetMapping
    public Iterable<Producto> listarTodos() {
        return serviceProducto.listarTodos();
    }

    @GetMapping("/{id}")
    public Producto buscarPorId(@PathVariable Long id) {
        return serviceProducto.buscarPorId(id);
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return serviceProducto.guardar(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return serviceProducto.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceProducto.eliminar(id);
    }

}

