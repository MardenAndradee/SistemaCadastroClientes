import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        boolean menus = true;
        Scanner scanner = new Scanner(System.in);

        while(menus == true){
            System.out.println("""
                      Clientes
                      
                      1- Cadastrar 
                      2- Listar 
                      3- Editar 
                      4- Excluir
                      
                       """);
            int menu = scanner.nextInt();

            if(menu == 1){
                try{
                    cliente.salvar();
                    System.out.println("Salvo com sucesso!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }if(menu == 2){
                cliente.Listar();
            }
            if(menu == 3){

            }
            if(menu == 4){

            }

        }




    }
}