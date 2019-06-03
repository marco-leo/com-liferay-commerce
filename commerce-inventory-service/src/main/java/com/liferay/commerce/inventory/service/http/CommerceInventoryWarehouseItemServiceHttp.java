/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.inventory.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link CommerceInventoryWarehouseItemServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Luca Pellizzon
 * @see CommerceInventoryWarehouseItemServiceSoap
 * @see HttpPrincipal
 * @see CommerceInventoryWarehouseItemServiceUtil
 * @generated
 */
@ProviderType
public class CommerceInventoryWarehouseItemServiceHttp {
	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem addCommerceInventoryWarehouseItem(
		HttpPrincipal httpPrincipal, long userId,
		long commerceInventoryWarehouseId, String sku, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CommerceInventoryWarehouseItemServiceUtil.class,
					"addCommerceInventoryWarehouseItem",
					_addCommerceInventoryWarehouseItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					commerceInventoryWarehouseId, sku, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem updateCommerceInventoryWarehouseItem(
		HttpPrincipal httpPrincipal, long commerceInventoryWarehouseItemId,
		int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CommerceInventoryWarehouseItemServiceUtil.class,
					"updateCommerceInventoryWarehouseItem",
					_updateCommerceInventoryWarehouseItemParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					commerceInventoryWarehouseItemId, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem upsertCommerceInventoryWarehouseItem(
		HttpPrincipal httpPrincipal, long userId,
		long commerceInventoryWarehouseId, String sku, int quantity)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CommerceInventoryWarehouseItemServiceUtil.class,
					"upsertCommerceInventoryWarehouseItem",
					_upsertCommerceInventoryWarehouseItemParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId,
					commerceInventoryWarehouseId, sku, quantity);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem> getCommerceInventoryWarehousesByCommerceInventoryWarehouseId(
		HttpPrincipal httpPrincipal, long commerceInventoryWarehouseId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(CommerceInventoryWarehouseItemServiceUtil.class,
					"getCommerceInventoryWarehousesByCommerceInventoryWarehouseId",
					_getCommerceInventoryWarehousesByCommerceInventoryWarehouseIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					commerceInventoryWarehouseId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CommerceInventoryWarehouseItemServiceHttp.class);
	private static final Class<?>[] _addCommerceInventoryWarehouseItemParameterTypes0 =
		new Class[] { long.class, long.class, String.class, int.class };
	private static final Class<?>[] _updateCommerceInventoryWarehouseItemParameterTypes1 =
		new Class[] { long.class, int.class };
	private static final Class<?>[] _upsertCommerceInventoryWarehouseItemParameterTypes2 =
		new Class[] { long.class, long.class, String.class, int.class };
	private static final Class<?>[] _getCommerceInventoryWarehousesByCommerceInventoryWarehouseIdParameterTypes3 =
		new Class[] { long.class, int.class, int.class };
}