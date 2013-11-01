package com.solid.isegregation.ok;


import java.util.List;
import java.util.Map;

public class ThreeVCreditCardProvider implements IServiceProvider, IPaymentProvider {

	@Override
	public int getBalance(Map<String, Object> params) {
		System.out.println("ThreeV Getting Balance....");
		return 0;
	}

	@Override
	public String transfer(Map<String, Object> params) {
		System.out.println("ThreeV Transfering....");
		return null;
	}

	@Override
	public List<String> getTransactions(Map<String, Object> params)
	{
		System.out.println("ThreeV Getting Transactions....");
		return null;
	}

	@Override
	public int activateCard(Map<String, Object> params)
	{
		System.out.println("ThreeV Activating Card.....");
		return 0;
	}

    @Override
    public int acceptCardRenew(String serviceId, Object... args) {
        System.out.println("ThreeV accepting card renew.....");
        return 134234;
    }

    @Override
	public int deactivateCard(String serviceId, Object... args)
	{
		System.out.println("ThreeV Deactivating Card.....");
		return 0;
	}

}
