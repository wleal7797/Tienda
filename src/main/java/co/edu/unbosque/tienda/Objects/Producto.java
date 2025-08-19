package co.edu.unbosque.tienda.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 150)
    public String nombre;

    @Column(nullable = false)
    public Double precio;

    @Column(nullable = false)
    public Integer stockMinimo;

    @Column(nullable = false)
    public Boolean activo = true;
}