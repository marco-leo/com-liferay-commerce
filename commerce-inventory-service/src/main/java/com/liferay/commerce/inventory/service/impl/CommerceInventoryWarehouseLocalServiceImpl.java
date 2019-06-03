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

package com.liferay.commerce.inventory.service.impl;

import com.liferay.commerce.inventory.constants.CommerceInventoryConstants;
import com.liferay.commerce.inventory.exception.CommerceInventoryWarehouseActiveException;
import com.liferay.commerce.inventory.exception.CommerceInventoryWarehouseNameException;
import com.liferay.commerce.inventory.exception.NoSuchInventoryWarehouseException;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseGroupRel;
import com.liferay.commerce.inventory.service.base.CommerceInventoryWarehouseLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

/**
 * @author Luca Pellizzon
 */
public class CommerceInventoryWarehouseLocalServiceImpl
	extends CommerceInventoryWarehouseLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceInventoryWarehouse addCommerceInventoryWarehouse(
			String name, String description, boolean active, String street1,
			String street2, String street3, String city, String zip,
			String commerceRegionCode, String commerceCountryCode,
			double latitude, double longitude, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(serviceContext.getUserId());

		validate(name, active, latitude, longitude);

		long commerceInventoryWarehouseId = counterLocalService.increment();

		CommerceInventoryWarehouse commerceInventoryWarehouse =
			commerceInventoryWarehousePersistence.create(commerceInventoryWarehouseId);

		commerceInventoryWarehouse.setCompanyId(user.getCompanyId());
		commerceInventoryWarehouse.setUserId(user.getUserId());
		commerceInventoryWarehouse.setUserName(user.getFullName());
		commerceInventoryWarehouse.setName(name);
		commerceInventoryWarehouse.setDescription(description);
		commerceInventoryWarehouse.setActive(active);
		commerceInventoryWarehouse.setStreet1(street1);
		commerceInventoryWarehouse.setStreet2(street2);
		commerceInventoryWarehouse.setStreet3(street3);
		commerceInventoryWarehouse.setCity(city);
		commerceInventoryWarehouse.setZip(zip);
		commerceInventoryWarehouse.setCommerceRegionCode(commerceRegionCode);
		commerceInventoryWarehouse.setCountryTwoLettersISOCode(commerceCountryCode);
		commerceInventoryWarehouse.setLatitude(latitude);
		commerceInventoryWarehouse.setLongitude(longitude);
		commerceInventoryWarehouse.setExpandoBridgeAttributes(serviceContext);

		commerceInventoryWarehousePersistence.update(commerceInventoryWarehouse);

		// Resources

		resourceLocalService.addResources(
			user.getCompanyId(), GroupConstants.DEFAULT_LIVE_GROUP_ID,
			user.getUserId(), CommerceInventoryWarehouse.class.getName(),
			commerceInventoryWarehouse.getCommerceInventoryWarehouseId(),
			false, false, false);

		return commerceInventoryWarehouse;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public CommerceInventoryWarehouse deleteCommerceInventoryWarehouse(
			CommerceInventoryWarehouse commerceInventoryWarehouse)
		throws PortalException {

		commerceInventoryWarehousePersistence.remove(
			commerceInventoryWarehouse);

		// Commerce warehouse items

		commerceInventoryWarehouseItemLocalService.
			deleteCommerceInventoryWarehouseItemsByInventoryWarehouseId(
				commerceInventoryWarehouse.getCommerceInventoryWarehouseId());

		// Expando

		expandoRowLocalService.deleteRows(
			commerceInventoryWarehouse.getCommerceInventoryWarehouseId());

		// Resources

		resourceLocalService.deleteResource(
			commerceInventoryWarehouse, ResourceConstants.SCOPE_INDIVIDUAL);

		return commerceInventoryWarehouse;
	}
	

	@Override
	public CommerceInventoryWarehouse geolocateCommerceInventoryWarehouse(
			long commerceInventoryWarehouseId, double latitude,
			double longitude)
		throws PortalException {

		CommerceInventoryWarehouse commerceInventoryWarehouse =
			commerceInventoryWarehousePersistence.findByPrimaryKey(
				commerceInventoryWarehouseId);

		commerceInventoryWarehouse.setLatitude(latitude);
		commerceInventoryWarehouse.setLongitude(longitude);

		return commerceInventoryWarehousePersistence.update(
			commerceInventoryWarehouse);
	}

	@Override
	public List<CommerceInventoryWarehouse> getCommerceInventoryWarehouses(
		long companyId, long groupId, boolean active,
		String commerceCountryCode) {

		return commerceInventoryWarehouseFinder.
			findWarehousesByGroupIdAndActiveAndCountryISOCode(
				companyId, groupId, active, commerceCountryCode);
	}

	@Override
	public List<CommerceInventoryWarehouse> getCommerceInventoryWarehousesByGroupId(
		long companyId, long groupId) {

		return commerceInventoryWarehouseFinder.findWarehousesByGroupId(
			companyId, groupId);
	}

	@Override
	public List<CommerceInventoryWarehouse>
		getCommerceInventoryWarehousesByGroupIdAndActive(
			long companyId, long groupId, boolean active) {

		return commerceInventoryWarehouseFinder.
			findWarehousesByGroupIdAndActive(companyId, groupId, active);
	}

	@Override
	public List<CommerceInventoryWarehouse>
		getCommerceInventoryWarehousesByGroupIdAndSku(
			long companyId, long groupId, String sku) {

		return commerceInventoryWarehouseFinder.findWarehousesByGroupIdAndSku(
			companyId, groupId, sku);
	}

	@Override
	public int getCommerceInventoryWarehousesCount(
		long companyId, long groupId, boolean active) {

		return commerceInventoryWarehouseFinder.countByG_A(
			companyId, groupId, active);
	}

	@Override
	public int getCommerceInventoryWarehousesCount(
		long companyId, long groupId, boolean active,
		String commerceCountryCode) {

		if (commerceCountryCode != null) {
			return commerceInventoryWarehouseFinder.countByG_A_C(
				companyId, groupId, active, commerceCountryCode);
		}

		return getCommerceInventoryWarehousesCount(companyId, groupId, active);
	}



	@Override
	public List<CommerceInventoryWarehouse> search(
		long companyId,  String keywords, Boolean active,
		String commerceCountryCode, int start, int end,
		OrderByComparator<CommerceInventoryWarehouse> orderByComparator) {

		return commerceInventoryWarehouseFinder.findByKeywords(
			companyId, keywords, active, commerceCountryCode, start,
			end, orderByComparator);
	}

	@Override
	public int searchCount(
		long companyId, String keywords, Boolean active,
		String commerceCountryCode) {

		return commerceInventoryWarehouseFinder.countByKeywords(
			companyId, keywords, active, commerceCountryCode);
	}

	@Override
	public CommerceInventoryWarehouse setActive(
			long commerceInventoryWarehouseId, boolean active)
		throws PortalException {

		CommerceInventoryWarehouse commerceInventoryWarehouse =
			commerceInventoryWarehousePersistence.findByPrimaryKey(
				commerceInventoryWarehouseId);

		commerceInventoryWarehouse.setActive(active);

		commerceInventoryWarehousePersistence.update(commerceInventoryWarehouse);

		return commerceInventoryWarehouse;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CommerceInventoryWarehouse updateCommerceInventoryWarehouse(
			long commerceInventoryWarehouseId, String name, String description,
			boolean active, String street1, String street2, String street3,
			String city, String zip, String commerceRegionCode,
			String commerceCountryCode, double latitude, double longitude,
			ServiceContext serviceContext)
		throws PortalException {

		validate(name, active, latitude, longitude);

		CommerceInventoryWarehouse commerceInventoryWarehouse =
			commerceInventoryWarehousePersistence.findByPrimaryKey(
				commerceInventoryWarehouseId);

		commerceInventoryWarehouse.setName(name);
		commerceInventoryWarehouse.setDescription(description);
		commerceInventoryWarehouse.setActive(active);
		commerceInventoryWarehouse.setStreet1(street1);
		commerceInventoryWarehouse.setStreet2(street2);
		commerceInventoryWarehouse.setStreet3(street3);
		commerceInventoryWarehouse.setCity(city);
		commerceInventoryWarehouse.setZip(zip);
		commerceInventoryWarehouse.setCommerceRegionCode(commerceRegionCode);
		commerceInventoryWarehouse.setCountryTwoLettersISOCode(commerceCountryCode);
		commerceInventoryWarehouse.setLatitude(latitude);
		commerceInventoryWarehouse.setLongitude(longitude);
		commerceInventoryWarehouse.setExpandoBridgeAttributes(serviceContext);

		commerceInventoryWarehousePersistence.update(commerceInventoryWarehouse);

		return commerceInventoryWarehouse;
	}

	protected void validate(
			String name, boolean active, double latitude, double longitude)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new CommerceInventoryWarehouseNameException();
		}

		if (active && (latitude == 0) && (longitude == 0)) {
			throw new CommerceInventoryWarehouseActiveException();
		}
	}
}