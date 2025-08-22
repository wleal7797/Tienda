// Proveedor.java - MANTENIENDO NOMBRES ORIGINALES
package co.edu.unbosque.tienda.Objects;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String Nombre;  // MANTENER con mayúscula como en BD

    @Column(nullable = false, length = 15)
    public String Telefono;  // MANTENER como String pero con mayúscula

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto_id", nullable = false)
    public Producto producto;
}