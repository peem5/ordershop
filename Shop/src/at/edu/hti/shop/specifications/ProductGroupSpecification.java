package at.edu.hti.shop.specifications;

import at.edu.hti.shop.domain.Product;
import at.edu.hti.shop.specificationpattern.AbstractSpecification;

public class ProductGroupSpecification extends AbstractSpecification<Product>{

	private String productGroup;
	
	public ProductGroupSpecification(String productGroup) {
		super();
		this.productGroup = productGroup;
	}

	@Override
	public boolean IsSatisfiedBy(Product product) {
			return product.getName().equals(productGroup);
	}
}
