/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaInventario.SistemaInventario.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author joel_
 */
@Controller
public class Inventario {

    @GetMapping("/inventario")
    public String inventario() {
        return "inventario";
    }
}
