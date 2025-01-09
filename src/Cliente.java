import db.DB;

import java.io.Serializable;
import java.sql.*;
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

//CRUD


    public void salvar(Cliente c){

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
            st.setString(1, c.nome);
            st.setInt(2,c.idade);
            st.setInt(3,c.cpf);
            st.setString(4,c.email);
            st.setString(5,c.senha);

            st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public void listar(){

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();


            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM clientes ");

            while (rs.next()){
                System.out.println(
                        "id: " + rs.getInt(1) +
                                "\nNome: " + rs.getString(2) +
                                "\nIdade:" + rs.getInt(3) +
                                "\nCPF: " + rs.getInt(4) +
                                "\nE-mail: " + rs.getString(5) +
                                "\n----------------------"

                );
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }
    }

    public void editar(Cliente c){

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE clientes " +
                            "SET nome= ?, " +
                            "idade = ?, " +
                            "cpf = ?, " +
                            "email = ?, " +
                            "senha = ? " +
                            "WHERE id = ?"
            );
            st.setString(1, c.nome);
            st.setInt(2,c.idade);
            st.setInt(3,c.cpf);
            st.setString(4,c.email);
            st.setString(5,c.senha);
            st.setInt(6,c.id);

            st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public void excluir(int id){

        Connection conn = null;
        PreparedStatement st = null;

        try{
            conn = DB.getConnection();



            st = conn.prepareStatement(
                    "DELETE FROM clientes WHERE id = ?"
            );
            st.setInt(1, id);


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
