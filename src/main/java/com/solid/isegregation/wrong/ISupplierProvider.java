package com.solid.isegregation.wrong;

import java.util.List;
import java.util.Map;

/**
 * The interface define all the operations implemented by the card providers (Credit card, SVA, e-money Card, Transport,
 * Building Access..)
 */

public interface ISupplierProvider {

    // Common to all type of cards
	int activateCard(String serviceId, String msisdn, Map<String, String> params);
	int acceptCardRenew(String serviceId, Object... args);
	int deactivateCard(String serviceId, Object... args);

   // Only for cards which can have a balance: e-money, transport, SVA, etc.
	int getBalance(Map<String, Object> params);

    // Only for SVA
	String transfer(Map<String, Object> params);
}
