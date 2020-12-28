package com.example.demo.service;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Nfce;
import com.example.demo.model.diagnostico.Diagnostico;
import com.example.demo.model.diagnostico.ExisteInconsistenciaDiagNodo;
import com.example.demo.model.diagnostico.NotaRecebidaDiagNodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DiagnosticoServiceTest {

  NossoMapper mapper;

  DiagnosticoService service;

  @BeforeEach
  void before() {
    mapper = mock(NossoMapper.class);
    service = new DiagnosticoService(mapper);
  }

  @Test
  void deveRetornarExisteInconsistenciaDiagNodo() {
    when(mapper.buscarInconsistencia(anyString())).thenReturn(null);
    Diagnostico diagnostico = service.diagnosticar("chave_de_nfce");
    Assertions.assertEquals(ExisteInconsistenciaDiagNodo.DIAGNOSTICO, diagnostico.getMensagem());
  }

  @Test
  void deveRetornsarNotaRecebidaDiagNodo() {
    when(mapper.buscarInconsistencia(anyString())).thenReturn(
        Nfce.builder()
            .chave("chave")
            .dataCompetencia(LocalDate.of(2020, 12, 26))
            .build());
    when(mapper.notaRecebida(anyString())).thenReturn(Optional.empty());

    Diagnostico diagnostico = service.diagnosticar("chave_de_nfce");
    Assertions.assertEquals(NotaRecebidaDiagNodo.DIAGNOSTICO, diagnostico.getMensagem());
  }


}
