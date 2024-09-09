package sistemaInventario.SistemaInventario.controlador;

import java.time.LocalDateTime;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sistemaInventario.SistemaInventario.modelo.MovimientosInventario;
import sistemaInventario.SistemaInventario.modelo.Producto;
import sistemaInventario.SistemaInventario.modelo.Ubicacion;
import sistemaInventario.SistemaInventario.servicio.ProductoServicio;

/**
 *
 * @author joel_
 */
@RestController
public class Productos {

    @Autowired
    private ProductoServicio productoServicio;

    @PostMapping("/productos")
    public ResponseEntity<String> agregarProducto(
            @RequestParam String nombre,
            @RequestParam String codigo,
            @RequestParam String descripcion,
            @RequestParam int cantidad_stock,
            @RequestParam double precio,
            @RequestParam Long ubicacionId,
            @RequestParam int tipo_movimiento) {

        JSONObject response = new JSONObject();

        try {

            Ubicacion ubicacion = productoServicio.obtenerUbicacionPorId(ubicacionId);

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setCodigo(codigo);
            producto.setDescripcion(descripcion);
            producto.setCantidad_stock(cantidad_stock);
            producto.setPrecio(precio);
            producto.setUbicacion(ubicacion);
            productoServicio.guardarProducto(producto);

            MovimientosInventario movimiento = new MovimientosInventario();
            movimiento.setFecha(LocalDateTime.now());
            movimiento.setTipo_movimiento(tipo_movimiento);
            movimiento.setIdproducto(producto.getIdproducto());
            movimiento.setIdubicacion(ubicacionId);
            movimiento.setCantidad(cantidad_stock);
            productoServicio.guardarMovimiento(movimiento);

            response.put("success", true);
        } catch (JSONException e) {
            response.put("success", false);
        }
        return ResponseEntity.ok(response.toString());
    }
}
