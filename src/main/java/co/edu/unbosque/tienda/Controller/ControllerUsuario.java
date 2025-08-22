package co.edu.unbosque.tienda.Controller;


import co.edu.unbosque.tienda.Objects.Producto;
import co.edu.unbosque.tienda.Objects.Usuario;
import co.edu.unbosque.tienda.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private UsuarioService UsuarioService;

    @GetMapping
    public Iterable<Usuario> listarTodos() {
        return UsuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return UsuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return UsuarioService.guardar(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return UsuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        UsuarioService.eliminar(id);
    }

}
