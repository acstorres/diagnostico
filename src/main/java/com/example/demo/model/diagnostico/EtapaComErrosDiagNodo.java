package com.example.demo.model.diagnostico;

import com.example.demo.model.Etapa;

import java.util.List;

public class EtapaComErrosDiagNodo extends DiagNodo {

  private static final String DIAGNOSTICO = "foram encontrados erros nas etapas";

  public EtapaComErrosDiagNodo(DiagNodo prox) {
    super(Diagnostico.builder()
        .mensagem(DIAGNOSTICO)
        .build(), prox);
  }

  @Override
  public boolean test() {
    List<Etapa> etapas = (List<Etapa>) args[0];

    if (etapas.stream().anyMatch(x -> x.getErro() != null)) {
      this.diagnostico.setEtapas(etapas);
      return false;
    }
    proxArgs = null;
    return true;
  }
}
