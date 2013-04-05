package at.edu.hti.shop.domain;

public class Product {
	private String name;
	private long id;
	private double prize;
	private int deliveryDays;
	private double weight;

	public Product( long id, String name, double prize, int deliveryDays, double weight) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.deliveryDays = deliveryDays;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	public int getDelivery() {
		return deliveryDays;
	}

	public void setDelivery(int deliveryDate) {
		this.deliveryDays = deliveryDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + "," + deliveryDays + "," + weight + "]";
	}

	// 1) erweitern produkt um lieferzeit (int in tage ) und gewicht (double in kg)
	
	// 2) von der basis-klasse kann geerbt werden (zB Lebensmittel, Werkzeug)
	// Berücksichtigen sie das im Shop (Generics) falls notwendig.
	
	// 3) bestellungen können nach verschiedenen kriterien aufgesplittet werden
	// (maxgewicht nach produktgruppen, lieferzeit und kombinationen.
	// dabei werden versandspesen pro teillieferung berechnet (specification pattern) "splitten".
	// die bestellung kann auch wieder zusammengefasst werden.
	
	// repository im git-hub anlegen, einchecken
}
