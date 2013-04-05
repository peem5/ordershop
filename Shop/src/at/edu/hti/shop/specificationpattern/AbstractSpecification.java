package at.edu.hti.shop.specificationpattern;


public abstract class AbstractSpecification<T> implements ISpecification<T> {
	
	@Override
	public abstract boolean IsSatisfiedBy(T t);
	
	public ISpecification<T> and (ISpecification<T> specification) {
		return new AndSpecification<T>(this, specification);
	}
	
	public ISpecification<T> or (ISpecification<T> specification) {
		return new OrSpecification<T>(this, specification);
	}
	
	public ISpecification<T> not(ISpecification<T> specification) {
		return new NotSpecification<T>(specification);
	}
}
