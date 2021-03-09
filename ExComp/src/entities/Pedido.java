package entities;

import e.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private OrderStatus status;

    private Cliente cliente;

    private List<PedirItem> itens = new ArrayList<>();

    public Pedido(Date momento, OrderStatus status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(PedirItem item) {
        itens.add(item);
    }

    public void removeItem(PedirItem item) {
        itens.remove(item);
    }

    public double total () {
        double soma = 0.0;
        for(PedirItem i : itens) {
            soma += i.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Horário pedido: ");
        sb.append(sdf.format(momento) + "\n");
        sb.append("Status pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: ");
        sb.append(cliente + "\n");
        sb.append("Itens do pedido:\n");
        for (PedirItem item : itens) {
            sb.append(item + "\n");
        }
        sb.append("Preço total: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

}
