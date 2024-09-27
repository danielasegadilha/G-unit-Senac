package dao;

import entities.Contact;

public class ContactManager {

    private List<Contact> contactList;

    public GerenciadoraClientes(List<Cliente> clientesDoBanco) {
        this.clientesDoBanco = clientesDoBanco;
    }

    public List<Cliente> getClientesDoBanco() {
        return this.clientesDoBanco;
    }

    public Cliente pesquisaCliente(int idCliente) {
        Iterator var3 = this.clientesDoBanco.iterator();

        while(var3.hasNext()) {
            Cliente cliente = (Cliente)var3.next();
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }

        return null;
    }

    public void adicionaCliente(Cliente novoCliente) {
        this.clientesDoBanco.add(novoCliente);
    }

    public boolean removeCliente(int idCliente) {
        boolean clienteRemovido = false;

        for(int i = 0; i < this.clientesDoBanco.size(); ++i) {
            Cliente cliente = (Cliente)this.clientesDoBanco.get(i);
            if (cliente.getId() == idCliente) {
                this.clientesDoBanco.remove(i);
                clienteRemovido = true;
                break;
            }
        }

        return clienteRemovido;
    }

    public boolean clienteAtivo(int idCliente) {
        boolean clienteAtivo = false;

        for(int i = 0; i < this.clientesDoBanco.size(); ++i) {
            Cliente cliente = (Cliente)this.clientesDoBanco.get(i);
            if (cliente.getId() == idCliente && cliente.isAtivo()) {
                clienteAtivo = true;
                break;
            }
        }

        return clienteAtivo;
    }

    public void limpa() {
        this.clientesDoBanco.clear();
    }

    public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
        if (idade >= 18 && idade <= 65) {
            return true;
        } else {
            throw new IdadeNaoPermitidaException(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA);
        }
    }


}
