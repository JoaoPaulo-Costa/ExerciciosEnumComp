package application;

import e.enums.NivelFuncionario;
import entities.ContratoHora;
import entities.Departamento;
import entities.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {


    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Nome do departamente: ");
        String nomeDepartamento = sc.nextLine();
        System.out.println("Dados do funcionário: ");
        System.out.print("Nome: ");
        String nomeFuncionario = sc.nextLine();
        System.out.print("Nível: ");
        String nivelFuncionario = sc.nextLine();
        System.out.print("Salário base: ");
        double salarioBase = sc.nextDouble();
        Funcionario funcionario = new Funcionario(nomeFuncionario, NivelFuncionario.valueOf(nivelFuncionario), salarioBase, new Departamento(nomeDepartamento));

        System.out.print("Quantos contratos para esse funcionario? ");
        int n = sc.nextInt();

        for (int i = 1; i<=n; i++) {
            System.out.println("Entre com dados do contrato # " + i);
            System.out.print("Data (DD/MM/YYYY): ");
            Date data = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorPorHora = sc.nextDouble();
            System.out.print("Duração (horas): ");
            int horas = sc.nextInt();
            ContratoHora contrato = new ContratoHora(data, valorPorHora, horas);
            funcionario.addContrato(contrato);
        }

        System.out.println();
        System.out.print("Entre com mês e ano para calcular renda (MM/YYY): ");
        String mesAno = sc.next();
        int mes = Integer.parseInt(mesAno.substring(0,2));
        int ano = Integer.parseInt(mesAno.substring(3));
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Departamento: " + funcionario.getDepartamento().getNome());
        System.out.println("Renda para " + mesAno + ": " + String.format("%.2f", funcionario.renda(ano, mes)));

        sc.close();

    }
}
