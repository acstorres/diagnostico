package com.example.demo.service;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Nfce;
import com.example.demo.model.diagnostico.*;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoService {

  private final NossoMapper mapper;

  private DiagNodo raiz;

  public DiagnosticoService(NossoMapper mapper) {
    DiagNodo semDiagnosticoDiagnodo = new SemDiagnosticoDiagnodo();
    DiagNodo etapaComErrosDiagNodo = new EtapaComErrosDiagNodo(semDiagnosticoDiagnodo);
    DiagNodo etapaConcluidoDiagNodo = new EtapaConcluidoDiagNodo(etapaComErrosDiagNodo);
    DiagNodo notaProcessadaDiagNodo = new NotaProcessadaDiagNodo(etapaConcluidoDiagNodo);
    DiagNodo notaRecebidaDiagNodo = new NotaRecebidaDiagNodo(notaProcessadaDiagNodo);
    raiz = new ExisteInconsistenciaDiagNodo(notaRecebidaDiagNodo);
    this.mapper = mapper;
  }

  public Diagnostico diagnosticar(String chave) {
    return raiz.get(mapper, chave);
  }


}
