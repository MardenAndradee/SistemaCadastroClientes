import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();

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

        Cliente cliente = new Cliente(0,nome,idade,cpf,email,senha);

        cliente.salvar(cliente);

    }
}