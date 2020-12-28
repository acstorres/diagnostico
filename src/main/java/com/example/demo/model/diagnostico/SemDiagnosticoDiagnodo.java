package com.example.demo.model.diagnostico;

public class SemDiagnosticoDiagnodo extends DiagNodo {
  public static final String DIAGNOSTICO = "Não existe diagnóstico ainda";

  public SemDiagnosticoDiagnodo() {
    super(Diagnostico.builder().mensagem(DIAGNOSTICO).build());
  }

  @Override
  public boolean test() {
    return false;
  }
}
