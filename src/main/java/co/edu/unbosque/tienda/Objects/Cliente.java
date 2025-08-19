package co.edu.unbosque.tienda.Objects;


import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name = "clientes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 100)
    public String nombre;

    @Column(nullable = false, unique = true, length = 50)
    public String documento;

    @Column(nullable = false, length = 100)
    public String email;

    @Column(length = 15)
    public String telefono;
}