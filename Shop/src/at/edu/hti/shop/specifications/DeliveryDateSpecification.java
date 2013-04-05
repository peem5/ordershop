package at.edu.hti.shop.specifications;

import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.specificationpattern.AbstractSpecification;

public class DeliveryDateSpecification extends AbstractSpecification<Product>{

	final int maxDeliveryDate;
	
	public DeliveryDateSpecification(int maxDeliveryDate) {
		super();
		this.maxDeliveryDate = maxDeliveryDate;
	}

	@Override
	public boolean IsSatisfiedBy(Product product) {
		return product.getDelivery() <= maxDeliveryDate;
	}

}
