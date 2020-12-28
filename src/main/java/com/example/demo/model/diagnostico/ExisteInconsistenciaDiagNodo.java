package com.example.demo.model.diagnostico;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Nfce;

public class ExisteInconsistenciaDiagNodo extends DiagNodo {

  public static final String DIAGNOSTICO = "não existe inconsistência registrada para esta nota";

  public ExisteInconsistenciaDiagNodo(DiagNodo prox) {
    super(Diagnostico.builder()
        .mensagem(DIAGNOSTICO)
        .build(), prox);
  }

  @Override
  public boolean test() {
    NossoMapper mapper = (NossoMapper) args[0];
    String chave = (String) args[1];

    Nfce nfce = mapper.buscarInconsistencia(chave);
    if (nfce != null) {
      proxArgs = new Object[]{mapper, nfce};
      return true;
    }
    return false;
  }
}
