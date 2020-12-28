package com.example.demo.model.diagnostico;

import com.example.demo.mapper.NossoMapper;
import com.example.demo.model.Etapa;
import com.example.demo.model.Nfce;

import java.util.List;

public class EtapaConcluidoDiagNodo extends DiagNodo {

  private static final String DIAGNOSTICO = "a nota está como concluída, aguarde...";

  public EtapaConcluidoDiagNodo(DiagNodo prox) {
    super(Diagnostico.builder()
        .mensagem(DIAGNOSTICO)
        .build(), prox);
  }

  @Override
  public boolean test() {
    NossoMapper mapper = (NossoMapper) args[0];
    Nfce nfce = (Nfce) args[1];

    List<Etapa> etapas = mapper.etapas(nfce.getChave());
    if (!etapas.isEmpty() && etapas.get(0).getNome().equals("concluido")) {
      this.diagnostico.setEtapas(etapas);
      return false;
    }
    proxArgs = new Object[]{etapas};
    return true;
  }
}
