package sistemaInventario.SistemaInventario.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sistemaInventario.SistemaInventario.modelo.Producto;

/**
 *
 * @author joel_
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

}
