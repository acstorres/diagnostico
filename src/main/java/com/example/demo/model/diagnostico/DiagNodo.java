package com.example.demo.model.diagnostico;

public abstract class DiagNodo {

    protected Diagnostico diagnostico;
    protected DiagNodo prox;
    protected Object[] args;
    protected Object[] proxArgs;

    protected DiagNodo() {
    }

    protected DiagNodo(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
        this.prox = null;
    }

    protected DiagNodo(DiagNodo prox) {
        this.prox = prox;
    }

    protected DiagNodo(Diagnostico diagnostico, DiagNodo prox) {
        this.diagnostico = diagnostico;
        this.prox = prox;
    }

    protected abstract boolean test();

    public Diagnostico get(Object... args) {
        this.args = args;
        if (!test())
            return diagnostico;
        return prox.get(proxArgs); // forte acoplamento de codigo
    }

}
