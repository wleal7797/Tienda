package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Objects.Cliente;
import co.edu.unbosque.tienda.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {

    @Autowired
    private ClienteService serviceCliente;

    @GetMapping
    public Iterable<Cliente> listarTodos() {
        return serviceCliente.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return serviceCliente.buscarPorId(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return serviceCliente.guardar(cliente);
    }

    @PutMapping("/{id}")
    public Cliente actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return serviceCliente.guardar(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceCliente.eliminar(id);
    }

}
