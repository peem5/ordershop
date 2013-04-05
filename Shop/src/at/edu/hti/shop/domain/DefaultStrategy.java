package at.edu.hti.shop.domain;

import java.util.ArrayList;

public class DefaultStrategy implements ICalcPrice{

	@Override
	public double calcPrice(ArrayList<OrderLine> orders) {

		double sum = 0;
		for (OrderLine ol : orders) {
			
			sum += ol.calcPrize();
		}
		
		if (sum < 10) {sum = sum + 5;}
		return sum;
	}

}
