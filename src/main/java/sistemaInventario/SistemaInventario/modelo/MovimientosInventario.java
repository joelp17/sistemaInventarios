package sistemaInventario.SistemaInventario.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 *
 * @author joel_
 */
@Entity
@Table(name = "movimientosinventario")
public class MovimientosInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmovimiento;
    private LocalDateTime fecha;
    private int tipo_movimiento;
    private int cantidad;
    private int idproducto;
    private Long idubicacion;

    public int getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(int tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public Long getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(Long idubicacion) {
        this.idubicacion = idubicacion;
    }

   
}
