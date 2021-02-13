package uz.Koica.Hotels.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tour {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private int ticketCount;
    private String name;
    @Column(columnDefinition= "TEXT")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachment;
    @ManyToOne(fetch =  FetchType.LAZY)
    private Type type;
    private Double price;
    private Boolean isActual;

}
