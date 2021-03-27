package enumeracao.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumeracao.entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private Integer status;	
	private Client client;	
	private List<OrderItem> items = new ArrayList<>();
		
	public Order(Date moment, Integer status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return OrderStatus.toEnum(status);
	}

	public void setStatus(OrderStatus status) {
		this.status = status.getCodigo();
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.remove(item);
	}
	
	public Double total() {
		double total = 0.0;
		for(OrderItem o : this.items) {
			total += o.subTotal();
		}
		return total;
	}
	
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");		
			sb.append("Order moment: "+sdf.format(moment)+"\n")
			.append("Order status: "+OrderStatus.toEnum(status).getDescricao()+"\n")
			.append("Client: "+ this.getClient().getName() +" ("+sdf2.format(this.getClient().getBirthDate())+") - "+this.getClient().getEmail());
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
