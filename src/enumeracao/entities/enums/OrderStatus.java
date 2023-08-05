package enumeracao.entities.enums;

public enum OrderStatus {
	
	PENDING_PAYMENT(0, "PENDING_PAYMENT"),
	PROCESSING(1, "PROCESSING"),
	SHIPPED(2, "SHIPPED"),
	DELIVERED(3, "DELIVERED");
	
	private Integer codigo;
	private String descricao;
	
	private OrderStatus(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static OrderStatus toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(OrderStatus x :  OrderStatus.values()) {
			if(x.getCodigo().equals(codigo)) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+ codigo);
	}

}
