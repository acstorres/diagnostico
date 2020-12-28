package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Nfce {

  private String chave;
  private LocalDate dataCompetencia;

}
