package application;

import e.enums.OrderStatus;
import entities.Cliente;
import entities.Pedido;
import entities.PedirItem;
import entities.Produto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrar com dados do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de nascimento (DD/MM/YYYY): ");
        Date dataNascimento = sdf.parse(sc.next());
        Cliente cliente = new Cliente(nome, email, dataNascimento);

        System.out.println("Entrar com dados do pedido:");
        System.out.print("Status do pedido: ");
        OrderStatus statusPedido = OrderStatus.valueOf(sc.next());

        Pedido pedido = new Pedido(new Date(), statusPedido, cliente);

        System.out.print("Quantos itens? ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("Inserir dados do pedido #" + i + ":");
            System.out.print("Nome: ");
            String nomeProduto = sc.next();
            System.out.print("Preço: ");
            double precoProduto = sc.nextDouble();

            Produto produto = new Produto(nomeProduto, precoProduto);

            System.out.print("Quantidade: ");
            int quantidadeProduto = sc.nextInt();
            PedirItem pedidoItem = new PedirItem(quantidadeProduto, precoProduto, produto);

            pedido.addItem(pedidoItem);
        }
        System.out.println();
        System.out.println("Resumo do pedido:");
        System.out.println(pedido);

    }

}
