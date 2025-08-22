package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerIndex {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VentasService ventasService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido a Tienda Spring Boot!");

        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("ventas", ventasService.listarTodos());


        return "index";
    }
}
