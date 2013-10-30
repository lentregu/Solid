package com.solid.isegregation.ok;

import java.util.List;
import java.util.Map;

public interface IPaymentProvider {
	int getBalance(Map<String, Object> params);
	String transfer(Map<String, Object> params);
	List<String> getTransactions(Map<String, Object> params);

}
