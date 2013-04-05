package at.edu.hti.shop.domain;

import java.util.ArrayList;

import at.edu.hti.shop.specificationpattern.ISpecification;
import at.edu.hti.shop.specifications.DeliveryDateSpecification;
import at.edu.hti.shop.specifications.ProductGroupSpecification;
import at.edu.hti.shop.specifications.WeightSpecification;

public class Order {

	private DefaultStrategy strategy = new DefaultStrategy();
	
	private ArrayList<OrderLine> orders = new ArrayList<OrderLine>();
	
	public int size() {
		return orders.size();
	}

	public ArrayList<OrderLine> getOrders() {
		return orders;
	}

	public OrderLine getOrderLine(int line) {
		return orders.get(line);
	}
	
	public void addOrderLine(OrderLine line) {
		if (line != null) {
			this.orders.add(line);
		}
	}
	
	public void removeOrderLine(OrderLine line) {
		if (line != null) {
			this.orders.remove(line);
		}
	}

	public double calcPrize() {
		return strategy.calcPrice(this.orders);
	}

	public boolean setAmount(long productId, int newAmount) {

		if (productId < 0) {
			return false;
		}
		if (newAmount < 0) {
			return false;
		}
		OrderLine foundLine = getOrderLineById(productId);
		if (foundLine != null) {
			foundLine.setAmount(newAmount);
			if (newAmount == 0) {
				removeOrderLine(foundLine);
			}
			return true;
		}
		return false;
	}

	public Order combineOrders( Order[] orders) {
		orders[0].getOrders().addAll(orders[1].getOrders());
		return orders[0];
		
	}
	public Order[] splitOrder(Order fullOrder) {
		
		DeliveryDateSpecification deliveryDate = new DeliveryDateSpecification(12);
		ProductGroupSpecification productGroup = new ProductGroupSpecification("Pfirsich");
		WeightSpecification weightSpecification = new WeightSpecification(12);
		
		ISpecification<Product> candidates = productGroup.and(deliveryDate).and(weightSpecification);
		
		Order splitOrder = new Order();
		for (OrderLine ol : fullOrder.getOrders()) {
			if (candidates.IsSatisfiedBy(ol.getProduct())) {
				splitOrder.addOrderLine(ol);
			}
		}
		
		fullOrder.getOrders().removeAll(splitOrder.getOrders());
		
		Order[] rv = new Order[2];
		rv[0] = splitOrder;
		rv[1] = fullOrder;
		
		return rv;
		

	}

	private OrderLine getOrderLineById(long productId) {

		for (OrderLine ol : this.orders) {
			if (productId == ol.getProduct().getId()) {
				return ol;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString() + " \n => " + getOrders() + " \n => " + calcPrize();
	}

}
