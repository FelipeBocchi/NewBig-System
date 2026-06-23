package com.newBig.system.controller.caixa;

import com.newBig.system.model.entity.DadosCaixa;

public interface CaixaControllerInterface {

    DadosCaixa caixaAberto();

    void update(DadosCaixa dadosCaixa);

}
