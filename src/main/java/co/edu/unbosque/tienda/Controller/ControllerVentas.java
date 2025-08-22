package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Ventas;
import co.edu.unbosque.tienda.Service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas")
public class ControllerVentas {

    @Autowired
    private VentasService serviceVentas;

    @GetMapping
    public Iterable<Ventas> listarTodos() {
        return serviceVentas.listarTodos();
    }

    @GetMapping("/{id}")
    public Ventas buscarPorId(@PathVariable Long id) {
        return serviceVentas.buscarPorId(id);
    }

    @PostMapping
    public Ventas guardar(@RequestBody Ventas ventas) {
        return serviceVentas.guardar(ventas);
    }

    @PutMapping("/{id}")
    public Ventas actualizar(@PathVariable Long id, @RequestBody Ventas ventas) {
        return serviceVentas.guardar(ventas);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceVentas.eliminar(id);
    }
}