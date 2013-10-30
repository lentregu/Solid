package com.solid.isegregation.wrong;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;


/**
 * This provider manages electronic cards for allowing access to buildings
 */


public class TisBuildingAccessProvider implements ISupplierProvider
{
	private String serverRoot;


	public TisBuildingAccessProvider()
	{
		
	}


	@Override
	public int activateCard(String serviceId,
							String msisdn,
							Map<String, String> params)
	{
		System.out.println("Tis Activating Card....");
		return 0;
	}


	@Override
	public int acceptCardRenew(String serviceId, Object... args)
	{
        System.out.println("Tis accepting card renew.....");
        return 134234;
    }


	@Override
	public int deactivateCard(String serviceId, Object... args)
	{
		System.out.println("Tis Deactivating Card....");
		return 0;
	}


	@Override
	public int getBalance(Map<String, Object> params)
	{
		throw new NotImplementedException();
	}


	@Override
	public String transfer(Map<String, Object> params)
	{
		throw new NotImplementedException();
	}

    @Override
    public List<String> getTransactions(Map<String, Object> params)
    {
        throw new NotImplementedException();
    }


}
