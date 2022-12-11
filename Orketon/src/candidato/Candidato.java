package candidato;


import conexao.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Candidato {
    private String nome;
    private String email;
    private String senha;
    private Date data_nascimento;
    private String cpf;
    private String telefone;
    private boolean status = false;

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Candidato(){}
    public Candidato(String nome, String email, String senha, Date data_nascimento, String cpf, String telefone, boolean status){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void fazLogin(){
        try {
            Connection con = Conexao.faz_conexao();
            String sql = "insert into candidato(nome, email, senha, data_nascimento, cpf, telefone) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, getNome());
            stmt.setString(2, getEmail());
            stmt.setString(3, getSenha());
            stmt.setDate(4, getData_nascimento());
            stmt.setString(5, getCpf());
            stmt.setString(6, getTelefone());
            stmt.execute();
            stmt.close();
            con.close();
            setStatus(true);
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

}
