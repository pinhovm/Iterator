package Projeto;

import java.util.ArrayList;

class Pessoa {
    private String nome, cartao_sus, cpf, identidade, celular, idade, sexo;

    Endereco endereco = new Endereco();

    private ArrayList<Pessoa> listaCidadaos = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nome, String cartao_sus, String cpf, String identidade, String celular, String data_nascimento, Endereco endereco, String sexo) {
        this.nome = nome;
        this.cartao_sus = cartao_sus;
        this.cpf = cpf;
        this.identidade = identidade;
        this.celular = celular;
        this.idade = data_nascimento;
        this.endereco = endereco;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCartao_sus() {
        return cartao_sus;
    }

    public void setCartao_sus(String cartao_sus) {
        this.cartao_sus = cartao_sus;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void addCidadao(Pessoa p){
        this.listaCidadaos.add(p);
    }

    public ArrayList<Pessoa> getListaCidadaos() {
        return listaCidadaos;
    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

public class Menu implements Iterator{

    Pessoa[] pessoas;
    int pos = 0;

    public Menu(ArrayList<Pessoa> pessoas){
        this.pessoas = pessoas.toArray(new Pessoa[0]);
    }

    public Object next() {
        Pessoa pessoa = pessoas[pos];
        pos++;
        return pessoa;
    }

    public boolean hasNext() {
        if(pos >= pessoas.length || pessoas[pos] == null){
            return false;
        }else{
            return true;
        }
    }


}
