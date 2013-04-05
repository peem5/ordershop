package at.edu.hti.shop.specificationpattern;


public class NotSpecification<T> extends AbstractSpecification<T> {

	private ISpecification<T> spec1;
	
	public NotSpecification(ISpecification<T> specification) {
		spec1 = specification;
	}
	
	@Override
	public boolean IsSatisfiedBy(T t) {
		return !spec1.IsSatisfiedBy(t);
	}
}
