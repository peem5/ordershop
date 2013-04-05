package at.edu.hti.shop;

import at.edu.hti.shop.domain.Order;
import at.edu.hti.shop.domain.OrderLine;
import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.domain.Tool;
import at.edu.hti.shop.specificationpattern.ISpecification;
import at.edu.hti.shop.specifications.DeliveryDateSpecification;
import at.edu.hti.shop.specifications.ProductGroupSpecification;
import at.edu.hti.shop.specifications.WeightSpecification;

public class App {
	public static void main(String[] args) {

		Order shopOrder = new Order();

		OrderLine line1 = new OrderLine(new Product(1, "�pfel", 1.2, 3, 0.2), 4);
		OrderLine line2 = new OrderLine(new Product(2, "Birnen", 1.5, 3, 0.15), 2);

		OrderLine line3 = new OrderLine(new Product(3, "Pfirsich", 2.2, 5 , 0.1), 5);
		OrderLine line4 = new OrderLine(new Tool   (4, "Hammer"  , 3.5, 12, 12.0, "DIN4711"), 6);

		shopOrder.addOrderLine(line1);
		shopOrder.addOrderLine(line2);
		shopOrder.addOrderLine(line3);
		shopOrder.addOrderLine(line4);
		
		shopOrder.setAmount(1, 5);
		
		System.out.println(shopOrder);

		System.out.println(shopOrder.size());

		System.out.println(shopOrder.calcPrize());

		shopOrder.setAmount(2, 0);

		System.out.println(shopOrder.calcPrize());
		
		System.out.println(shopOrder.getOrderLine(2));
		
		Order[] splitOrders = shopOrder.splitOrder(shopOrder);
		
		System.out.println("splitOrder 1:" + splitOrders[0]);
		System.out.println("splitOrder 2:" + splitOrders[1]);
		
		Order combineOrders = shopOrder.combineOrders(splitOrders);

		System.out.println("shopOrder:" + combineOrders);

	}
}
