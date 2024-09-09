 
package sistemaInventario.SistemaInventario.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import sistemaInventario.SistemaInventario.modelo.Ubicacion;

/**
 *
 * @author joel_
 */
public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Long > {
   
}