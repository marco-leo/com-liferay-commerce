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

import com.liferay.commerce.inventory.exception.CommerceInventoryWarehouseItemQuantityException;
import com.liferay.commerce.inventory.model.CommerceInventoryWarehouseItem;
import com.liferay.commerce.inventory.service.base.CommerceInventoryWarehouseItemLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Luca Pellizzon
 */
public class CommerceInventoryWarehouseItemLocalServiceImpl
	extends CommerceInventoryWarehouseItemLocalServiceBaseImpl {

	@Override
	public CommerceInventoryWarehouseItem addCommerceInventoryWarehouseItem(
			long userId, long commerceInventoryWarehouseId, String sku,
			int quantity)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long commerceInventoryWarehouseItemId = counterLocalService.increment();

		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem =
			commerceInventoryWarehouseItemPersistence.create(
				commerceInventoryWarehouseItemId);

		commerceInventoryWarehouseItem.setCompanyId(user.getCompanyId());
		commerceInventoryWarehouseItem.setUserId(user.getUserId());
		commerceInventoryWarehouseItem.setUserName(user.getFullName());
		commerceInventoryWarehouseItem.setCommerceInventoryWarehouseId(
			commerceInventoryWarehouseId);
		commerceInventoryWarehouseItem.setSku(sku);
		commerceInventoryWarehouseItem.setQuantity(quantity);

		return commerceInventoryWarehouseItemPersistence.update(
			commerceInventoryWarehouseItem);
	}

	@Override
	public CommerceInventoryWarehouseItem updateCommerceInventoryWarehouseItem(
			long commerceInventoryWarehouseItemId, int quantity)
		throws PortalException {

		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem =
			commerceInventoryWarehouseItemPersistence.findByPrimaryKey(
				commerceInventoryWarehouseItemId);

		commerceInventoryWarehouseItem.setQuantity(quantity);

		return commerceInventoryWarehouseItemPersistence.update(
			commerceInventoryWarehouseItem);
	}

	@Override
	public CommerceInventoryWarehouseItem upsertCommerceInventoryWarehouseItem(
			long userId, long commerceInventoryWarehouseId, String sku,
			int quantity)
		throws PortalException {

		CommerceInventoryWarehouseItem commerceInventoryWarehouseItem =
			commerceInventoryWarehouseItemPersistence.fetchByC_S(
				commerceInventoryWarehouseId, sku);

		if(commerceInventoryWarehouseItem == null){
			return commerceInventoryWarehouseItemLocalService.
				addCommerceInventoryWarehouseItem(
					userId, commerceInventoryWarehouseId, sku, quantity);
		}

		return commerceInventoryWarehouseItemLocalService.
			updateCommerceInventoryWarehouseItem(
				commerceInventoryWarehouseItem.
					getCommerceInventoryWarehouseItemId(), quantity);
	}

	@Override
	public CommerceInventoryWarehouseItem
			fetchCommerceInventoryWarehouseItemByC_S(
				long commerceInventoryWarehouseId, String sku)
		throws PortalException {

		return commerceInventoryWarehouseItemPersistence.fetchByC_S(
			commerceInventoryWarehouseId, sku);
	}

	@Override
	public void deleteCommerceInventoryWarehouseItemsByInventoryWarehouseId(
		long commerceInventoryWarehouseId){

		commerceInventoryWarehouseItemPersistence.
			removeByCommerceInventoryWarehouseId(commerceInventoryWarehouseId);
	}


	@Override
	public List<CommerceInventoryWarehouseItem>
		getCommerceInventoryWarehousesByCommerceInventoryWarehouseId(
			long commerceInventoryWarehouseId, int start, int end) {

		return commerceInventoryWarehouseItemPersistence.
			findByCommerceInventoryWarehouseId(
				commerceInventoryWarehouseId, start, end);
	}

	@Override
	public int getStockQuantityByG_S(
		long companyId, long groupId, String sku) {

		return commerceInventoryWarehouseItemFinder.sumStockQuantityByG_S(
			companyId, groupId, sku);
	}

	@Override
	public int getStockQuantityBySku(long companyId, String sku) {

		return commerceInventoryWarehouseItemFinder.sumStockQuantityBySKu(
			companyId, sku);
	}

}