 
package sistemaInventario.SistemaInventario.controlador;

//import ch.qos.logback.core.model.Model;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/eliminarProducto")
    public ResponseEntity<String> eliminarProducto(@RequestParam("id") Long id) {
        JSONObject response = new JSONObject();
        try {
            productoServicio.eliminarProducto(id);
            response.put("success", true);
            response.put("message", "Producto eliminado exitosamente.");
        } catch (JSONException e) {
            response.put("success", false);
            response.put("message", "No se pudo eliminar el producto");
        }
        return ResponseEntity.ok(response.toString());
    }
}
