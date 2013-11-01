package com.solid.isegregation.ok;

import java.util.Map;

public interface IServiceProvider {
	int activateCard(Map<String, Object> params);

	int acceptCardRenew(String serviceId, Object... args);

	int deactivateCard(String serviceId, Object... args);

}
