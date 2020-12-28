package com.example.demo.model.diagnostico;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Nfce;

import java.util.Optional;

public class NotaProcessadaDiagNodo extends DiagNodo {

  private static final String DIAGNOSTICO = "a nota foi processada no fiscal, aguarde a proxima sintetização";

  public NotaProcessadaDiagNodo(DiagNodo prox) {
    super(Diagnostico.builder()
        .mensagem(DIAGNOSTICO)
        .build(), prox);
  }

  @Override
  public boolean test() {
    NossoMapper mapper = (NossoMapper) args[0];
    Nfce nfce = (Nfce) args[1];

    Optional<Boolean> optional = mapper.notaProcessada(nfce.getChave(), nfce.getDataCompetencia().withDayOfMonth(1));
    if (optional.orElse(false)) {
      return false;
    }
    proxArgs = new Object[]{mapper, nfce};
    return true;
  }
}
