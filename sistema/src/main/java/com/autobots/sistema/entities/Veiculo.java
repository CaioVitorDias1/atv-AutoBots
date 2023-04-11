package com.autobots.sistema.entities;

import java.util.ArrayList;
import java.util.List;

import com.autobots.sistema.enums.TipoVeiculo;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Veiculo {
    private Long id;
    private TipoVeiculo tipoVeiculo;
    private String modelo;
    private String placa;
    private Usuario proprietario;
    private List<Venda> vendas = new ArrayList<>() ;
}
