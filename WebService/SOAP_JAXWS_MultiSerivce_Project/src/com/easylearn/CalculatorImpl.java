
package com.easylearn;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService
public class CalculatorImpl {

	@WebMethod
	public int addition(@WebParam(name = "first") int x, @WebParam(name = "second") int y) {

		return x + y;
	}

	@WebMethod(operationName = "substract")
	public int substration(int x, int y) {

		return x - y;
	}

	@WebMethod
	public int multiplication(int x, int y) {

		return x * y;
	}

	@WebMethod(exclude = true)
	public int division(int x, int y) {

		return x / y;
	}

	@WebMethod(operationName = "Calculator")
	public List<Integer> calc(Integer first, Integer second) {
		List<Integer> calcList = new ArrayList<>();
		
		calcList.add(addition(first, second));
		calcList.add(substration(first, second));
		calcList.add(multiplication(first, second));
		calcList.add(division(first, second));

		return calcList;

	}

}
