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

package com.liferay.commerce.inventory.service.base;

import com.liferay.commerce.inventory.model.CommerceInventoryWarehouse;
import com.liferay.commerce.inventory.service.CommerceInventoryWarehouseService;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryAuditPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryBookedQuantityPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryReplenishmentItemFinder;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryReplenishmentItemPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseFinder;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseGroupRelPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseItemFinder;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehouseItemPersistence;
import com.liferay.commerce.inventory.service.persistence.CommerceInventoryWarehousePersistence;

import com.liferay.expando.kernel.service.persistence.ExpandoRowPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commerce inventory warehouse remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseServiceImpl}.
 * </p>
 *
 * @author Luca Pellizzon
 * @see com.liferay.commerce.inventory.service.impl.CommerceInventoryWarehouseServiceImpl
 * @see com.liferay.commerce.inventory.service.CommerceInventoryWarehouseServiceUtil
 * @generated
 */
public abstract class CommerceInventoryWarehouseServiceBaseImpl
	extends BaseServiceImpl implements CommerceInventoryWarehouseService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.commerce.inventory.service.CommerceInventoryWarehouseServiceUtil} to access the commerce inventory warehouse remote service.
	 */

	/**
	 * Returns the commerce inventory audit local service.
	 *
	 * @return the commerce inventory audit local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryAuditLocalService getCommerceInventoryAuditLocalService() {
		return commerceInventoryAuditLocalService;
	}

	/**
	 * Sets the commerce inventory audit local service.
	 *
	 * @param commerceInventoryAuditLocalService the commerce inventory audit local service
	 */
	public void setCommerceInventoryAuditLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryAuditLocalService commerceInventoryAuditLocalService) {
		this.commerceInventoryAuditLocalService = commerceInventoryAuditLocalService;
	}

	/**
	 * Returns the commerce inventory audit remote service.
	 *
	 * @return the commerce inventory audit remote service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryAuditService getCommerceInventoryAuditService() {
		return commerceInventoryAuditService;
	}

	/**
	 * Sets the commerce inventory audit remote service.
	 *
	 * @param commerceInventoryAuditService the commerce inventory audit remote service
	 */
	public void setCommerceInventoryAuditService(
		com.liferay.commerce.inventory.service.CommerceInventoryAuditService commerceInventoryAuditService) {
		this.commerceInventoryAuditService = commerceInventoryAuditService;
	}

	/**
	 * Returns the commerce inventory audit persistence.
	 *
	 * @return the commerce inventory audit persistence
	 */
	public CommerceInventoryAuditPersistence getCommerceInventoryAuditPersistence() {
		return commerceInventoryAuditPersistence;
	}

	/**
	 * Sets the commerce inventory audit persistence.
	 *
	 * @param commerceInventoryAuditPersistence the commerce inventory audit persistence
	 */
	public void setCommerceInventoryAuditPersistence(
		CommerceInventoryAuditPersistence commerceInventoryAuditPersistence) {
		this.commerceInventoryAuditPersistence = commerceInventoryAuditPersistence;
	}

	/**
	 * Returns the commerce inventory booked quantity local service.
	 *
	 * @return the commerce inventory booked quantity local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityLocalService getCommerceInventoryBookedQuantityLocalService() {
		return commerceInventoryBookedQuantityLocalService;
	}

	/**
	 * Sets the commerce inventory booked quantity local service.
	 *
	 * @param commerceInventoryBookedQuantityLocalService the commerce inventory booked quantity local service
	 */
	public void setCommerceInventoryBookedQuantityLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityLocalService commerceInventoryBookedQuantityLocalService) {
		this.commerceInventoryBookedQuantityLocalService = commerceInventoryBookedQuantityLocalService;
	}

	/**
	 * Returns the commerce inventory booked quantity remote service.
	 *
	 * @return the commerce inventory booked quantity remote service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityService getCommerceInventoryBookedQuantityService() {
		return commerceInventoryBookedQuantityService;
	}

	/**
	 * Sets the commerce inventory booked quantity remote service.
	 *
	 * @param commerceInventoryBookedQuantityService the commerce inventory booked quantity remote service
	 */
	public void setCommerceInventoryBookedQuantityService(
		com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityService commerceInventoryBookedQuantityService) {
		this.commerceInventoryBookedQuantityService = commerceInventoryBookedQuantityService;
	}

	/**
	 * Returns the commerce inventory booked quantity persistence.
	 *
	 * @return the commerce inventory booked quantity persistence
	 */
	public CommerceInventoryBookedQuantityPersistence getCommerceInventoryBookedQuantityPersistence() {
		return commerceInventoryBookedQuantityPersistence;
	}

	/**
	 * Sets the commerce inventory booked quantity persistence.
	 *
	 * @param commerceInventoryBookedQuantityPersistence the commerce inventory booked quantity persistence
	 */
	public void setCommerceInventoryBookedQuantityPersistence(
		CommerceInventoryBookedQuantityPersistence commerceInventoryBookedQuantityPersistence) {
		this.commerceInventoryBookedQuantityPersistence = commerceInventoryBookedQuantityPersistence;
	}

	/**
	 * Returns the commerce inventory replenishment item local service.
	 *
	 * @return the commerce inventory replenishment item local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemLocalService getCommerceInventoryReplenishmentItemLocalService() {
		return commerceInventoryReplenishmentItemLocalService;
	}

	/**
	 * Sets the commerce inventory replenishment item local service.
	 *
	 * @param commerceInventoryReplenishmentItemLocalService the commerce inventory replenishment item local service
	 */
	public void setCommerceInventoryReplenishmentItemLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemLocalService commerceInventoryReplenishmentItemLocalService) {
		this.commerceInventoryReplenishmentItemLocalService = commerceInventoryReplenishmentItemLocalService;
	}

	/**
	 * Returns the commerce inventory replenishment item remote service.
	 *
	 * @return the commerce inventory replenishment item remote service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemService getCommerceInventoryReplenishmentItemService() {
		return commerceInventoryReplenishmentItemService;
	}

	/**
	 * Sets the commerce inventory replenishment item remote service.
	 *
	 * @param commerceInventoryReplenishmentItemService the commerce inventory replenishment item remote service
	 */
	public void setCommerceInventoryReplenishmentItemService(
		com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemService commerceInventoryReplenishmentItemService) {
		this.commerceInventoryReplenishmentItemService = commerceInventoryReplenishmentItemService;
	}

	/**
	 * Returns the commerce inventory replenishment item persistence.
	 *
	 * @return the commerce inventory replenishment item persistence
	 */
	public CommerceInventoryReplenishmentItemPersistence getCommerceInventoryReplenishmentItemPersistence() {
		return commerceInventoryReplenishmentItemPersistence;
	}

	/**
	 * Sets the commerce inventory replenishment item persistence.
	 *
	 * @param commerceInventoryReplenishmentItemPersistence the commerce inventory replenishment item persistence
	 */
	public void setCommerceInventoryReplenishmentItemPersistence(
		CommerceInventoryReplenishmentItemPersistence commerceInventoryReplenishmentItemPersistence) {
		this.commerceInventoryReplenishmentItemPersistence = commerceInventoryReplenishmentItemPersistence;
	}

	/**
	 * Returns the commerce inventory replenishment item finder.
	 *
	 * @return the commerce inventory replenishment item finder
	 */
	public CommerceInventoryReplenishmentItemFinder getCommerceInventoryReplenishmentItemFinder() {
		return commerceInventoryReplenishmentItemFinder;
	}

	/**
	 * Sets the commerce inventory replenishment item finder.
	 *
	 * @param commerceInventoryReplenishmentItemFinder the commerce inventory replenishment item finder
	 */
	public void setCommerceInventoryReplenishmentItemFinder(
		CommerceInventoryReplenishmentItemFinder commerceInventoryReplenishmentItemFinder) {
		this.commerceInventoryReplenishmentItemFinder = commerceInventoryReplenishmentItemFinder;
	}

	/**
	 * Returns the commerce inventory warehouse local service.
	 *
	 * @return the commerce inventory warehouse local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService getCommerceInventoryWarehouseLocalService() {
		return commerceInventoryWarehouseLocalService;
	}

	/**
	 * Sets the commerce inventory warehouse local service.
	 *
	 * @param commerceInventoryWarehouseLocalService the commerce inventory warehouse local service
	 */
	public void setCommerceInventoryWarehouseLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService commerceInventoryWarehouseLocalService) {
		this.commerceInventoryWarehouseLocalService = commerceInventoryWarehouseLocalService;
	}

	/**
	 * Returns the commerce inventory warehouse remote service.
	 *
	 * @return the commerce inventory warehouse remote service
	 */
	public CommerceInventoryWarehouseService getCommerceInventoryWarehouseService() {
		return commerceInventoryWarehouseService;
	}

	/**
	 * Sets the commerce inventory warehouse remote service.
	 *
	 * @param commerceInventoryWarehouseService the commerce inventory warehouse remote service
	 */
	public void setCommerceInventoryWarehouseService(
		CommerceInventoryWarehouseService commerceInventoryWarehouseService) {
		this.commerceInventoryWarehouseService = commerceInventoryWarehouseService;
	}

	/**
	 * Returns the commerce inventory warehouse persistence.
	 *
	 * @return the commerce inventory warehouse persistence
	 */
	public CommerceInventoryWarehousePersistence getCommerceInventoryWarehousePersistence() {
		return commerceInventoryWarehousePersistence;
	}

	/**
	 * Sets the commerce inventory warehouse persistence.
	 *
	 * @param commerceInventoryWarehousePersistence the commerce inventory warehouse persistence
	 */
	public void setCommerceInventoryWarehousePersistence(
		CommerceInventoryWarehousePersistence commerceInventoryWarehousePersistence) {
		this.commerceInventoryWarehousePersistence = commerceInventoryWarehousePersistence;
	}

	/**
	 * Returns the commerce inventory warehouse finder.
	 *
	 * @return the commerce inventory warehouse finder
	 */
	public CommerceInventoryWarehouseFinder getCommerceInventoryWarehouseFinder() {
		return commerceInventoryWarehouseFinder;
	}

	/**
	 * Sets the commerce inventory warehouse finder.
	 *
	 * @param commerceInventoryWarehouseFinder the commerce inventory warehouse finder
	 */
	public void setCommerceInventoryWarehouseFinder(
		CommerceInventoryWarehouseFinder commerceInventoryWarehouseFinder) {
		this.commerceInventoryWarehouseFinder = commerceInventoryWarehouseFinder;
	}

	/**
	 * Returns the commerce inventory warehouse group rel local service.
	 *
	 * @return the commerce inventory warehouse group rel local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelLocalService getCommerceInventoryWarehouseGroupRelLocalService() {
		return commerceInventoryWarehouseGroupRelLocalService;
	}

	/**
	 * Sets the commerce inventory warehouse group rel local service.
	 *
	 * @param commerceInventoryWarehouseGroupRelLocalService the commerce inventory warehouse group rel local service
	 */
	public void setCommerceInventoryWarehouseGroupRelLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelLocalService commerceInventoryWarehouseGroupRelLocalService) {
		this.commerceInventoryWarehouseGroupRelLocalService = commerceInventoryWarehouseGroupRelLocalService;
	}

	/**
	 * Returns the commerce inventory warehouse group rel remote service.
	 *
	 * @return the commerce inventory warehouse group rel remote service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelService getCommerceInventoryWarehouseGroupRelService() {
		return commerceInventoryWarehouseGroupRelService;
	}

	/**
	 * Sets the commerce inventory warehouse group rel remote service.
	 *
	 * @param commerceInventoryWarehouseGroupRelService the commerce inventory warehouse group rel remote service
	 */
	public void setCommerceInventoryWarehouseGroupRelService(
		com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelService commerceInventoryWarehouseGroupRelService) {
		this.commerceInventoryWarehouseGroupRelService = commerceInventoryWarehouseGroupRelService;
	}

	/**
	 * Returns the commerce inventory warehouse group rel persistence.
	 *
	 * @return the commerce inventory warehouse group rel persistence
	 */
	public CommerceInventoryWarehouseGroupRelPersistence getCommerceInventoryWarehouseGroupRelPersistence() {
		return commerceInventoryWarehouseGroupRelPersistence;
	}

	/**
	 * Sets the commerce inventory warehouse group rel persistence.
	 *
	 * @param commerceInventoryWarehouseGroupRelPersistence the commerce inventory warehouse group rel persistence
	 */
	public void setCommerceInventoryWarehouseGroupRelPersistence(
		CommerceInventoryWarehouseGroupRelPersistence commerceInventoryWarehouseGroupRelPersistence) {
		this.commerceInventoryWarehouseGroupRelPersistence = commerceInventoryWarehouseGroupRelPersistence;
	}

	/**
	 * Returns the commerce inventory warehouse item local service.
	 *
	 * @return the commerce inventory warehouse item local service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService getCommerceInventoryWarehouseItemLocalService() {
		return commerceInventoryWarehouseItemLocalService;
	}

	/**
	 * Sets the commerce inventory warehouse item local service.
	 *
	 * @param commerceInventoryWarehouseItemLocalService the commerce inventory warehouse item local service
	 */
	public void setCommerceInventoryWarehouseItemLocalService(
		com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService commerceInventoryWarehouseItemLocalService) {
		this.commerceInventoryWarehouseItemLocalService = commerceInventoryWarehouseItemLocalService;
	}

	/**
	 * Returns the commerce inventory warehouse item remote service.
	 *
	 * @return the commerce inventory warehouse item remote service
	 */
	public com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemService getCommerceInventoryWarehouseItemService() {
		return commerceInventoryWarehouseItemService;
	}

	/**
	 * Sets the commerce inventory warehouse item remote service.
	 *
	 * @param commerceInventoryWarehouseItemService the commerce inventory warehouse item remote service
	 */
	public void setCommerceInventoryWarehouseItemService(
		com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemService commerceInventoryWarehouseItemService) {
		this.commerceInventoryWarehouseItemService = commerceInventoryWarehouseItemService;
	}

	/**
	 * Returns the commerce inventory warehouse item persistence.
	 *
	 * @return the commerce inventory warehouse item persistence
	 */
	public CommerceInventoryWarehouseItemPersistence getCommerceInventoryWarehouseItemPersistence() {
		return commerceInventoryWarehouseItemPersistence;
	}

	/**
	 * Sets the commerce inventory warehouse item persistence.
	 *
	 * @param commerceInventoryWarehouseItemPersistence the commerce inventory warehouse item persistence
	 */
	public void setCommerceInventoryWarehouseItemPersistence(
		CommerceInventoryWarehouseItemPersistence commerceInventoryWarehouseItemPersistence) {
		this.commerceInventoryWarehouseItemPersistence = commerceInventoryWarehouseItemPersistence;
	}

	/**
	 * Returns the commerce inventory warehouse item finder.
	 *
	 * @return the commerce inventory warehouse item finder
	 */
	public CommerceInventoryWarehouseItemFinder getCommerceInventoryWarehouseItemFinder() {
		return commerceInventoryWarehouseItemFinder;
	}

	/**
	 * Sets the commerce inventory warehouse item finder.
	 *
	 * @param commerceInventoryWarehouseItemFinder the commerce inventory warehouse item finder
	 */
	public void setCommerceInventoryWarehouseItemFinder(
		CommerceInventoryWarehouseItemFinder commerceInventoryWarehouseItemFinder) {
		this.commerceInventoryWarehouseItemFinder = commerceInventoryWarehouseItemFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the expando row local service.
	 *
	 * @return the expando row local service
	 */
	public com.liferay.expando.kernel.service.ExpandoRowLocalService getExpandoRowLocalService() {
		return expandoRowLocalService;
	}

	/**
	 * Sets the expando row local service.
	 *
	 * @param expandoRowLocalService the expando row local service
	 */
	public void setExpandoRowLocalService(
		com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService) {
		this.expandoRowLocalService = expandoRowLocalService;
	}

	/**
	 * Returns the expando row persistence.
	 *
	 * @return the expando row persistence
	 */
	public ExpandoRowPersistence getExpandoRowPersistence() {
		return expandoRowPersistence;
	}

	/**
	 * Sets the expando row persistence.
	 *
	 * @param expandoRowPersistence the expando row persistence
	 */
	public void setExpandoRowPersistence(
		ExpandoRowPersistence expandoRowPersistence) {
		this.expandoRowPersistence = expandoRowPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CommerceInventoryWarehouseService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CommerceInventoryWarehouse.class;
	}

	protected String getModelClassName() {
		return CommerceInventoryWarehouse.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = commerceInventoryWarehousePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryAuditLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryAuditLocalService commerceInventoryAuditLocalService;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryAuditService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryAuditService commerceInventoryAuditService;
	@BeanReference(type = CommerceInventoryAuditPersistence.class)
	protected CommerceInventoryAuditPersistence commerceInventoryAuditPersistence;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityLocalService commerceInventoryBookedQuantityLocalService;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryBookedQuantityService commerceInventoryBookedQuantityService;
	@BeanReference(type = CommerceInventoryBookedQuantityPersistence.class)
	protected CommerceInventoryBookedQuantityPersistence commerceInventoryBookedQuantityPersistence;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemLocalService commerceInventoryReplenishmentItemLocalService;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryReplenishmentItemService commerceInventoryReplenishmentItemService;
	@BeanReference(type = CommerceInventoryReplenishmentItemPersistence.class)
	protected CommerceInventoryReplenishmentItemPersistence commerceInventoryReplenishmentItemPersistence;
	@BeanReference(type = CommerceInventoryReplenishmentItemFinder.class)
	protected CommerceInventoryReplenishmentItemFinder commerceInventoryReplenishmentItemFinder;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryWarehouseLocalService commerceInventoryWarehouseLocalService;
	@BeanReference(type = CommerceInventoryWarehouseService.class)
	protected CommerceInventoryWarehouseService commerceInventoryWarehouseService;
	@BeanReference(type = CommerceInventoryWarehousePersistence.class)
	protected CommerceInventoryWarehousePersistence commerceInventoryWarehousePersistence;
	@BeanReference(type = CommerceInventoryWarehouseFinder.class)
	protected CommerceInventoryWarehouseFinder commerceInventoryWarehouseFinder;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelLocalService commerceInventoryWarehouseGroupRelLocalService;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryWarehouseGroupRelService commerceInventoryWarehouseGroupRelService;
	@BeanReference(type = CommerceInventoryWarehouseGroupRelPersistence.class)
	protected CommerceInventoryWarehouseGroupRelPersistence commerceInventoryWarehouseGroupRelPersistence;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemLocalService commerceInventoryWarehouseItemLocalService;
	@BeanReference(type = com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemService.class)
	protected com.liferay.commerce.inventory.service.CommerceInventoryWarehouseItemService commerceInventoryWarehouseItemService;
	@BeanReference(type = CommerceInventoryWarehouseItemPersistence.class)
	protected CommerceInventoryWarehouseItemPersistence commerceInventoryWarehouseItemPersistence;
	@BeanReference(type = CommerceInventoryWarehouseItemFinder.class)
	protected CommerceInventoryWarehouseItemFinder commerceInventoryWarehouseItemFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.expando.kernel.service.ExpandoRowLocalService.class)
	protected com.liferay.expando.kernel.service.ExpandoRowLocalService expandoRowLocalService;
	@ServiceReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;
}