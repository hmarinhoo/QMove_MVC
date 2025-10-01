package br.com.fiap.QMove_MVC.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @NotBlank(message = "O campo 'placa' é obrigatório")
    @Size(min = 7, max = 7, message = "O campo 'placa' deve ter 7 caracteres")
    private String placa;

    @NotBlank(message = "O campo 'modelo' é obrigatório")
    private String modelo;

    @NotBlank(message = "O campo 'status' é obrigatório")
    private String status;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;


}