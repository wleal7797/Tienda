package co.edu.unbosque.tienda.Objects;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empleados")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nombre;

    @Column(nullable = false, unique = true, length = 50)
    public String documento;

    @Column(nullable = false, length = 50)
    public String cargo;

    @Column(length = 15)
    public String telefono;
}
