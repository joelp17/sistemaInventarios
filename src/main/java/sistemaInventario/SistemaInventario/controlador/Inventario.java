/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.controlador;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sistemaInventario.SistemaInventario.servicio.ProductoServicio;

/**
 *
 * @author joel_
 */
@Controller
public class Inventario {

    @Autowired

    private ProductoServicio productoServicio;

    @GetMapping("/inventario")
    public String mostrarInventario(Model model) {
        model.addAttribute("productos", productoServicio.obtenerTodosProductos());
        return "inventario";  
    }
}
