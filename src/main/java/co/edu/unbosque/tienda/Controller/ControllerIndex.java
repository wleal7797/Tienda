package co.edu.unbosque.tienda.Controller;

import co.edu.unbosque.tienda.Service.ClienteService;
import co.edu.unbosque.tienda.Service.EmpleadoService;
import co.edu.unbosque.tienda.Service.ProductoService;
import co.edu.unbosque.tienda.Service.InventarioService;
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
    private InventarioService bodegaService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("mensaje", "¡Bienvenido a Tienda Spring Boot!");

        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("productos", productoService.listarTodos());
        model.addAttribute("inventarios", bodegaService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        return "index";
    }
}
