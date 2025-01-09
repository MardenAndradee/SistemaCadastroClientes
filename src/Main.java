import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        boolean menus = true;
        Scanner sc = new Scanner(System.in);

        while(menus == true){
            System.out.println("""
                      Menu Clientes
                      
                      1- Cadastrar
                      2- Listar
                      3- Editar
                      4- Excluir
                      
                      """);
            int menu = sc.nextInt();

            if(menu == 1){
                System.out.println("Nome: ");
                sc.nextLine();
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

                Cliente cliente1 = new Cliente(0,nome,idade,cpf,email,senha);

                try{
                    cliente.salvar(cliente1);
                    System.out.println("Salvo com sucesso!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }if(menu == 2){
                cliente.listar();
            }
            if(menu == 3){
                cliente.listar();

                System.out.println("Id");
                int id = sc.nextInt();

                System.out.println("Nome: ");
                sc.nextLine();
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

                Cliente cliente1 = new Cliente(id,nome,idade,cpf,email,senha);

                try{
                    cliente.editar(cliente1);
                    System.out.println("Salvo com sucesso!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            if(menu == 4){
                cliente.listar();

                System.out.println("Digite o id do cliente que deseja excluir: ");
                int id = sc.nextInt();

                try{
                    cliente.excluir(id);
                    System.out.println("Excluido com sucesso!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }

        }




    }
}