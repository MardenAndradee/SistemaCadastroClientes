import com.mysql.cj.x.protobuf.MysqlxPrepare;
import db.DB;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private int idade;
    private int cpf;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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

    public Cliente(){}

    public Cliente(int id,String nome, int idade, int cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }



    public void salvar(Cliente cliente){

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();


            st = conn.prepareStatement(
                    "INSERT INTO clientes " +
                            "(nome,idade,cpf,email,senha)" +
                            "VALUES" +
                            "(?,?,?,?,?)"
            );
            st.setString(1, cliente.nome);
            st.setInt(2,cliente.idade);
            st.setInt(3,cliente.cpf);
            st.setString(4,cliente.email);
            st.setString(5,cliente.senha);

            st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }



}
