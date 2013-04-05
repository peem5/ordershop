package at.edu.hti.shop.specificationpattern;

public interface ISpecification<T> {

	boolean IsSatisfiedBy(T t);
	ISpecification<T> and(ISpecification<T> specification);
	ISpecification<T> or(ISpecification<T> specification);
	ISpecification<T> not(ISpecification<T> specification);
}
