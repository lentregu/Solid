package com.solid.isegregation.ok;

import java.util.Map;

public class TisBuildingAccessProvider implements IServiceProvider
{

	@Override
	public int activateCard(Map<String, Object> params)
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

}
