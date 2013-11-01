package com.solid.isegregation.wrong;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

/**
 * This provider manages electronic cards associated to an SVA
 */

public class ThreeVCreditCardProvider implements ISupplierProvider {

	@Override
	public int activateCard(String serviceId,
							String msisdn,
							Map<String, String> params) {
		System.out.println("ThreeV Activating Card.....");
		return 0;
	}

	@Override
	public int acceptCardRenew(String serviceId, Object... args) {
        System.out.println("ThreeV accepting card renew.....");
        return 134234;
    }

	@Override
	public int deactivateCard(String serviceId, Object... args) {
		System.out.println("ThreeV Deactivating Card.....");
		return 0;
	}

	@Override
	public int getBalance(Map<String, Object> params) {
		System.out.println("ThreeV Getting Balance....");
		return 0;
	}

	@Override
	public String transfer(Map<String, Object> params) {
		System.out.println("ThreeV Transferring....");
		return null;
	}

    @Override
    public List<String> getTransactions(Map<String, Object> params) {
        System.out.println("ThreeV Getting Transactions....");
        return null;
    }

}
