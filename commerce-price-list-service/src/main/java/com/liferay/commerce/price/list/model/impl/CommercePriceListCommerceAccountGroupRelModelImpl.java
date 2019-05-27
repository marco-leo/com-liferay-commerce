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

package com.liferay.commerce.price.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel;
import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRelModel;
import com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRelSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommercePriceListCommerceAccountGroupRel service. Represents a row in the &quot;CPLCommerceGroupAccountRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CommercePriceListCommerceAccountGroupRelModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceListCommerceAccountGroupRelImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListCommerceAccountGroupRelImpl
 * @see CommercePriceListCommerceAccountGroupRel
 * @see CommercePriceListCommerceAccountGroupRelModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommercePriceListCommerceAccountGroupRelModelImpl
	extends BaseModelImpl<CommercePriceListCommerceAccountGroupRel>
	implements CommercePriceListCommerceAccountGroupRelModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list commerce account group rel model instance should use the {@link CommercePriceListCommerceAccountGroupRel} interface instead.
	 */
	public static final String TABLE_NAME = "CPLCommerceGroupAccountRel";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "CPLCommerceAccountGroupRelId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commercePriceListId", Types.BIGINT },
			{ "commerceAccountGroupId", Types.BIGINT },
			{ "order_", Types.INTEGER },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPLCommerceAccountGroupRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceAccountGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CPLCommerceGroupAccountRel (uuid_ VARCHAR(75) null,CPLCommerceAccountGroupRelId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commercePriceListId LONG,commerceAccountGroupId LONG,order_ INTEGER,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CPLCommerceGroupAccountRel";
	public static final String ORDER_BY_JPQL = " ORDER BY commercePriceListCommerceAccountGroupRel.order ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPLCommerceGroupAccountRel.order_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel"),
			true);
	public static final long COMMERCEACCOUNTGROUPID_COLUMN_BITMASK = 1L;
	public static final long COMMERCEPRICELISTID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long ORDER_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommercePriceListCommerceAccountGroupRel toModel(
		CommercePriceListCommerceAccountGroupRelSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommercePriceListCommerceAccountGroupRel model = new CommercePriceListCommerceAccountGroupRelImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommercePriceListCommerceAccountGroupRelId(soapModel.getCommercePriceListCommerceAccountGroupRelId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommercePriceListId(soapModel.getCommercePriceListId());
		model.setCommerceAccountGroupId(soapModel.getCommerceAccountGroupId());
		model.setOrder(soapModel.getOrder());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommercePriceListCommerceAccountGroupRel> toModels(
		CommercePriceListCommerceAccountGroupRelSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommercePriceListCommerceAccountGroupRel> models = new ArrayList<CommercePriceListCommerceAccountGroupRel>(soapModels.length);

		for (CommercePriceListCommerceAccountGroupRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.price.list.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel"));

	public CommercePriceListCommerceAccountGroupRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommercePriceListCommerceAccountGroupRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceListCommerceAccountGroupRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceListCommerceAccountGroupRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commercePriceListCommerceAccountGroupRelId",
			getCommercePriceListCommerceAccountGroupRelId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commercePriceListId", getCommercePriceListId());
		attributes.put("commerceAccountGroupId", getCommerceAccountGroupId());
		attributes.put("order", getOrder());
		attributes.put("lastPublishDate", getLastPublishDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commercePriceListCommerceAccountGroupRelId = (Long)attributes.get(
				"commercePriceListCommerceAccountGroupRelId");

		if (commercePriceListCommerceAccountGroupRelId != null) {
			setCommercePriceListCommerceAccountGroupRelId(commercePriceListCommerceAccountGroupRelId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long commercePriceListId = (Long)attributes.get("commercePriceListId");

		if (commercePriceListId != null) {
			setCommercePriceListId(commercePriceListId);
		}

		Long commerceAccountGroupId = (Long)attributes.get(
				"commerceAccountGroupId");

		if (commerceAccountGroupId != null) {
			setCommerceAccountGroupId(commerceAccountGroupId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCommercePriceListCommerceAccountGroupRelId() {
		return _commercePriceListCommerceAccountGroupRelId;
	}

	@Override
	public void setCommercePriceListCommerceAccountGroupRelId(
		long commercePriceListCommerceAccountGroupRelId) {
		_commercePriceListCommerceAccountGroupRelId = commercePriceListCommerceAccountGroupRelId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getCommercePriceListId() {
		return _commercePriceListId;
	}

	@Override
	public void setCommercePriceListId(long commercePriceListId) {
		_columnBitmask |= COMMERCEPRICELISTID_COLUMN_BITMASK;

		if (!_setOriginalCommercePriceListId) {
			_setOriginalCommercePriceListId = true;

			_originalCommercePriceListId = _commercePriceListId;
		}

		_commercePriceListId = commercePriceListId;
	}

	public long getOriginalCommercePriceListId() {
		return _originalCommercePriceListId;
	}

	@JSON
	@Override
	public long getCommerceAccountGroupId() {
		return _commerceAccountGroupId;
	}

	@Override
	public void setCommerceAccountGroupId(long commerceAccountGroupId) {
		_columnBitmask |= COMMERCEACCOUNTGROUPID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAccountGroupId) {
			_setOriginalCommerceAccountGroupId = true;

			_originalCommerceAccountGroupId = _commerceAccountGroupId;
		}

		_commerceAccountGroupId = commerceAccountGroupId;
	}

	public long getOriginalCommerceAccountGroupId() {
		return _originalCommerceAccountGroupId;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				CommercePriceListCommerceAccountGroupRel.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommercePriceListCommerceAccountGroupRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommercePriceListCommerceAccountGroupRel toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommercePriceListCommerceAccountGroupRel)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommercePriceListCommerceAccountGroupRelImpl commercePriceListCommerceAccountGroupRelImpl =
			new CommercePriceListCommerceAccountGroupRelImpl();

		commercePriceListCommerceAccountGroupRelImpl.setUuid(getUuid());
		commercePriceListCommerceAccountGroupRelImpl.setCommercePriceListCommerceAccountGroupRelId(getCommercePriceListCommerceAccountGroupRelId());
		commercePriceListCommerceAccountGroupRelImpl.setCompanyId(getCompanyId());
		commercePriceListCommerceAccountGroupRelImpl.setUserId(getUserId());
		commercePriceListCommerceAccountGroupRelImpl.setUserName(getUserName());
		commercePriceListCommerceAccountGroupRelImpl.setCreateDate(getCreateDate());
		commercePriceListCommerceAccountGroupRelImpl.setModifiedDate(getModifiedDate());
		commercePriceListCommerceAccountGroupRelImpl.setCommercePriceListId(getCommercePriceListId());
		commercePriceListCommerceAccountGroupRelImpl.setCommerceAccountGroupId(getCommerceAccountGroupId());
		commercePriceListCommerceAccountGroupRelImpl.setOrder(getOrder());
		commercePriceListCommerceAccountGroupRelImpl.setLastPublishDate(getLastPublishDate());

		commercePriceListCommerceAccountGroupRelImpl.resetOriginalValues();

		return commercePriceListCommerceAccountGroupRelImpl;
	}

	@Override
	public int compareTo(
		CommercePriceListCommerceAccountGroupRel commercePriceListCommerceAccountGroupRel) {
		int value = 0;

		if (getOrder() < commercePriceListCommerceAccountGroupRel.getOrder()) {
			value = -1;
		}
		else if (getOrder() > commercePriceListCommerceAccountGroupRel.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommercePriceListCommerceAccountGroupRel)) {
			return false;
		}

		CommercePriceListCommerceAccountGroupRel commercePriceListCommerceAccountGroupRel =
			(CommercePriceListCommerceAccountGroupRel)obj;

		long primaryKey = commercePriceListCommerceAccountGroupRel.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommercePriceListCommerceAccountGroupRelModelImpl commercePriceListCommerceAccountGroupRelModelImpl =
			this;

		commercePriceListCommerceAccountGroupRelModelImpl._originalUuid = commercePriceListCommerceAccountGroupRelModelImpl._uuid;

		commercePriceListCommerceAccountGroupRelModelImpl._originalCompanyId = commercePriceListCommerceAccountGroupRelModelImpl._companyId;

		commercePriceListCommerceAccountGroupRelModelImpl._setOriginalCompanyId = false;

		commercePriceListCommerceAccountGroupRelModelImpl._setModifiedDate = false;

		commercePriceListCommerceAccountGroupRelModelImpl._originalCommercePriceListId = commercePriceListCommerceAccountGroupRelModelImpl._commercePriceListId;

		commercePriceListCommerceAccountGroupRelModelImpl._setOriginalCommercePriceListId = false;

		commercePriceListCommerceAccountGroupRelModelImpl._originalCommerceAccountGroupId = commercePriceListCommerceAccountGroupRelModelImpl._commerceAccountGroupId;

		commercePriceListCommerceAccountGroupRelModelImpl._setOriginalCommerceAccountGroupId = false;

		commercePriceListCommerceAccountGroupRelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommercePriceListCommerceAccountGroupRel> toCacheModel() {
		CommercePriceListCommerceAccountGroupRelCacheModel commercePriceListCommerceAccountGroupRelCacheModel =
			new CommercePriceListCommerceAccountGroupRelCacheModel();

		commercePriceListCommerceAccountGroupRelCacheModel.uuid = getUuid();

		String uuid = commercePriceListCommerceAccountGroupRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commercePriceListCommerceAccountGroupRelCacheModel.uuid = null;
		}

		commercePriceListCommerceAccountGroupRelCacheModel.commercePriceListCommerceAccountGroupRelId = getCommercePriceListCommerceAccountGroupRelId();

		commercePriceListCommerceAccountGroupRelCacheModel.companyId = getCompanyId();

		commercePriceListCommerceAccountGroupRelCacheModel.userId = getUserId();

		commercePriceListCommerceAccountGroupRelCacheModel.userName = getUserName();

		String userName = commercePriceListCommerceAccountGroupRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commercePriceListCommerceAccountGroupRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.createDate = createDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commercePriceListCommerceAccountGroupRelCacheModel.commercePriceListId = getCommercePriceListId();

		commercePriceListCommerceAccountGroupRelCacheModel.commerceAccountGroupId = getCommerceAccountGroupId();

		commercePriceListCommerceAccountGroupRelCacheModel.order = getOrder();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commercePriceListCommerceAccountGroupRelCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			commercePriceListCommerceAccountGroupRelCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return commercePriceListCommerceAccountGroupRelCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", commercePriceListCommerceAccountGroupRelId=");
		sb.append(getCommercePriceListCommerceAccountGroupRelId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", commercePriceListId=");
		sb.append(getCommercePriceListId());
		sb.append(", commerceAccountGroupId=");
		sb.append(getCommerceAccountGroupId());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", lastPublishDate=");
		sb.append(getLastPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.commerce.price.list.model.CommercePriceListCommerceAccountGroupRel");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commercePriceListCommerceAccountGroupRelId</column-name><column-value><![CDATA[");
		sb.append(getCommercePriceListCommerceAccountGroupRelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commercePriceListId</column-name><column-value><![CDATA[");
		sb.append(getCommercePriceListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>commerceAccountGroupId</column-name><column-value><![CDATA[");
		sb.append(getCommerceAccountGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CommercePriceListCommerceAccountGroupRel.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CommercePriceListCommerceAccountGroupRel.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _commercePriceListCommerceAccountGroupRelId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commercePriceListId;
	private long _originalCommercePriceListId;
	private boolean _setOriginalCommercePriceListId;
	private long _commerceAccountGroupId;
	private long _originalCommerceAccountGroupId;
	private boolean _setOriginalCommerceAccountGroupId;
	private int _order;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private CommercePriceListCommerceAccountGroupRel _escapedModel;
}