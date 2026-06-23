package com.newBig.system.controller.caixa.impl;

import com.newBig.system.controller.caixa.CaixaControllerInterface;
import com.newBig.system.model.entity.DadosCaixa;
import com.newBig.system.model.service.caixa.Caixa;

public class CaixaControllerImpl implements CaixaControllerInterface {

    private Caixa caixa;

    public CaixaControllerImpl(Caixa caixa) {
        this.caixa = caixa;
    }

    @Override
    public DadosCaixa caixaAberto() {
        return caixa.getObjeto();
    }

    @Override
    public void update(DadosCaixa dadosCaixa) {
        caixa.update(dadosCaixa);
    }
}
