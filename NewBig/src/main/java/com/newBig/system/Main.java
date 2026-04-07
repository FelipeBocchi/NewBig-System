package com.newBig.system;

import com.newBig.system.application.usecase.AtualizarUsuario;
import com.newBig.system.application.usecase.CadastroUsuario;
import com.newBig.system.domain.model.Funcionario;
import com.newBig.system.domain.repository.CustomizerFactory;
import com.newBig.system.domain.repository.FuncionarioRepo;
import com.newBig.system.presentation.view.ClienteView;
import com.newBig.system.presentation.view.FuncionarioView;
import com.newBig.system.presentation.view.UsuariosView;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        UsuariosView usuariosView = new UsuariosView();
        usuariosView.print();

    }
}