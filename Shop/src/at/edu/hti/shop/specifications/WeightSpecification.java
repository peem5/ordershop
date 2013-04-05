package at.edu.hti.shop.specifications;

import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.specificationpattern.AbstractSpecification;

public class WeightSpecification extends AbstractSpecification<Product>{

	private double weight;
	
	public WeightSpecification(double weight) {
		this.weight = weight;
	}
	@Override
	public boolean IsSatisfiedBy(Product product) {
		
		return product.getWeight() < weight;
	}

}
