package com.example.demo.model.diagnostico;

import com.example.demo.model.Etapa;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Diagnostico {

    private String mensagem;
    private List<Etapa> etapas;
}
