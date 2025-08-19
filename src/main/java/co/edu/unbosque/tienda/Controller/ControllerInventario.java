package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Inventario;
import co.edu.unbosque.tienda.Service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventarios")
public class ControllerInventario {

    @Autowired
    private InventarioService serviceInventario;

    @GetMapping
    public Iterable<Inventario> listarTodos() {
        return serviceInventario.listarTodos();
    }

    @GetMapping("/{id}")
    public Inventario buscarPorId(@PathVariable Long id) {
        return serviceInventario.buscarPorId(id);
    }

    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario) {
        return serviceInventario.guardar(inventario);
    }
/*
    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario inventario) {
        Inventario existente = serviceInventario.buscarPorId(id);
        if (existente != null) {
            inventario.setId(id);
            return serviceInventario.guardar(inventario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceInventario.eliminar(id);
    }

 */
}
