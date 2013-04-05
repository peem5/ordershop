package at.edu.hti.shop.domain;

public class Tool extends Product{

	private String iso;

	public Tool(long id, String name, double prize, int deliveryDays,
			double weight, String iso) {
		super(id, name, prize, deliveryDays, weight);
		this.iso = iso;
	}

	public String getDin() {
		return iso;
	}

	public void setDin(String iso) {
		this.iso = iso;
	}

	@Override
	public String toString() {
		return super.toString() + "," + iso ;
	}

}
