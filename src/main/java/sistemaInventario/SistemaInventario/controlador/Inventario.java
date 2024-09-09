package sistemaInventario.SistemaInventario.controlador;

//import ch.qos.logback.core.model.Model;
import java.time.LocalDateTime;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sistemaInventario.SistemaInventario.modelo.MovimientosInventario;
import sistemaInventario.SistemaInventario.modelo.Producto;
import sistemaInventario.SistemaInventario.modelo.Ubicacion;
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
            Producto producto = productoServicio.obtenerProductoPorId(id);
            if (producto == null) {
                response.put("success", false);
                response.put("message", "Producto no encontrado.");
                return ResponseEntity.ok(response.toString());
            }
            productoServicio.eliminarProducto(id);
 
            MovimientosInventario movimiento = new MovimientosInventario();
            movimiento.setFecha(LocalDateTime.now());
            movimiento.setTipo_movimiento(0); // Tipo de movimiento para eliminación
            movimiento.setCantidad(producto.getCantidad_stock());

            movimiento.setIdubicacion(Long.valueOf(producto.getUbicacion().getIdubicacion()));

            productoServicio.guardarMovimiento(movimiento);

            response.put("success", true);
            response.put("message", "Producto eliminado y movimiento registrado correctamente.");

            response.put("success", true);

        } catch (JSONException e) {
            response.put("success", false);
        }
        return ResponseEntity.ok(response.toString());
    }

    @GetMapping("/formularioAgregarProducto")
    public String formularioAgregarProducto(Model model) {
        model.addAttribute("ubicaciones", productoServicio.obtenerTodasUbicaciones());
        return "agregarProducto";
    }

    @GetMapping("/formularioEditarProducto")
    public String formularioEditarProducto(@RequestParam Long id, Model model) {
        Producto producto = productoServicio.obtenerProductoPorId(id);
        List<Ubicacion> ubicaciones = productoServicio.obtenerTodasUbicaciones();
        model.addAttribute("producto", producto);
        model.addAttribute("ubicaciones", ubicaciones);
        return "editarProducto"; // Nombre de la plantilla 
    }

    @PostMapping("/productos/editar")
    public ResponseEntity<String> editarProducto(@RequestParam Long idproducto,
            @RequestParam String nombre,
            @RequestParam String codigo,
            @RequestParam String descripcion,
            @RequestParam int cantidad_stock,
            @RequestParam double precio,
            @RequestParam Long ubicacionId) {
        JSONObject response = new JSONObject();
        try {
            Producto producto = productoServicio.obtenerProductoPorId(idproducto);
            Ubicacion ubicacion = productoServicio.obtenerUbicacionPorId(ubicacionId);

            producto.setNombre(nombre);
            producto.setCodigo(codigo);
            producto.setDescripcion(descripcion);
            producto.setCantidad_stock(cantidad_stock);
            producto.setPrecio(precio);
            producto.setUbicacion(ubicacion);

            productoServicio.guardarProducto(producto);

            response.put("success", true);
        } catch (JSONException e) {
            response.put("success", false);
            response.put("message", "Error al actualizar el producto");
        }
        return ResponseEntity.ok(response.toString());
    }

}
