package com.example.demo.mapper;

import com.example.demo.model.Etapa;
import com.example.demo.model.Nfce;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface NossoMapper {

  Nfce buscarInconsistencia(String chave);

  Optional<Boolean> notaRecebida(String chave);

  Optional<Boolean> notaProcessada(String chave, LocalDate particao);

  List<Etapa> etapas(String chave);

}
