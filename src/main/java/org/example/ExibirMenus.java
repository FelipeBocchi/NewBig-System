package org.example;

import org.example.dados.DadosUsuario;


public class ExibirMenus {
    AtualizarUsuario atualizar;
    Utilidades util = new Utilidades();

//    Pegar outras classes
    public void setAtualizar(AtualizarUsuario atualizar){
        this.atualizar = atualizar;
    }



    public void printUsarios(){
        util.limpar();
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-4s %-15s %-15s %-12s\n",
                "ID", "Nome", "CPF", "Acesso");

        System.out.println("-------------------------------------------------------------------");
        for (int i = 0; i < DadosUsuario.usuario.size(); i++) {
            System.out.println(DadosUsuario.usuario.get(i).toString());
        }

    }
    public void dadosComplementares(int id){
        id--;
        Usuario aux = DadosUsuario.usuario.get(id);
        if (aux instanceof Cliente) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n",
                    "ID", "Nome", "CPF", "Acesso");

            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Cliente) aux).toString());
            System.out.println(((Cliente) aux).getDadosCliente());
        } else if (aux instanceof Funcionario) {
            System.out.println("-------------------------------------------------------------------");
            System.out.printf("%-4s %-15s %-15s %-12s\n",
                    "ID", "Nome", "CPF", "Acesso");

            System.out.println("-------------------------------------------------------------------");
            System.out.println(((Funcionario) aux).toString());
            System.out.println(((Funcionario) aux).getDadosFuncionario());
        }
    }
    public void printOpAtualizar(int opId){
        System.out.println("--Alterar dados Usuario--");
        System.out.println("1 - Nome");
        System.out.println("2 - Cpf");
        if (DadosUsuario.usuario.get(opId) instanceof Cliente){
            System.out.println("3 - Cep");
            System.out.println("4 - rua");
            System.out.println("5 - Numero");
            System.out.println("6 - Bairro");
            System.out.println("7 - Telefone");
            atualizar.atualizarCliente(opId);
        }
        else if(DadosUsuario.usuario.get(opId) instanceof Funcionario){
            System.out.println("3 - Acesso");
            System.out.println("4 - Login");
            System.out.println("5 - Senha");
            atualizar.atualizarFuncionario(opId);
        }
    }
}
