package at.edu.hti.shop.specificationpattern;


public class OrSpecification<T> extends AbstractSpecification<T> {

	private ISpecification<T> spec1;
	private ISpecification<T> spec2;
	
	public OrSpecification(ISpecification<T> spec1, ISpecification<T> spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}
	@Override
	public boolean IsSatisfiedBy(T t) {

		return spec1.IsSatisfiedBy(t) || spec2.IsSatisfiedBy(t);
	}
}
