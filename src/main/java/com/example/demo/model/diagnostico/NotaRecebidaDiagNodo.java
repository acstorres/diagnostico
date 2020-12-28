package com.example.demo.model.diagnostico;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Nfce;

import java.util.Optional;

public class NotaRecebidaDiagNodo extends DiagNodo {

  public static final String DIAGNOSTICO = "a nota não foi recebida no fiscal";

  public NotaRecebidaDiagNodo(DiagNodo prox) {
    super(Diagnostico.builder()
        .mensagem(DIAGNOSTICO)
        .build(), prox);
  }

  @Override
  public boolean test() {
    NossoMapper mapper = (NossoMapper) args[0];
    Nfce nfce = (Nfce) args[1];

    Optional<Boolean> optional = mapper.notaRecebida(nfce.getChave());
    if (optional.orElse(false)) {
      proxArgs = new Object[]{mapper, nfce};
      return true;
    }
    return false;
  }
}
