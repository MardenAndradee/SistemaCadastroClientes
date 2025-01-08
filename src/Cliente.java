import com.mysql.cj.x.protobuf.MysqlxPrepare;
import db.DB;

import java.io.Serializable;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cliente implements Serializable {
    private int id;
    private String nome;
    private int idade;
    private int cpf;
    private String email;
    private String senha;

    ArrayList<Cliente> clientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

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



    public void salvar(){

        System.out.println("Nome: ");
        String nome = sc.nextLine();

        System.out.println("Idade: ");
        int idade = sc.nextInt();

        System.out.println("CPF: ");
        int cpf = sc.nextInt();

        System.out.println("E-mail: ");
        sc.nextLine();
        String email = sc.nextLine();

        System.out.println("Senha (4 Dígitos):");
        String senha = sc.nextLine();


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
            st.setString(1, nome);
            st.setInt(2,idade);
            st.setInt(3,cpf);
            st.setString(4,email);
            st.setString(5,senha);

            st.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    public void Listar(){

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
                                "\nCPF" + rs.getInt(4) +
                                "\nE-mail: " + rs.getString(5) +
                                "----------------------"

                );
            }

        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }



}
