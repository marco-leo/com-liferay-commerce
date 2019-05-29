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

package com.liferay.commerce.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.model.CPDAvailabilityEstimate;
import com.liferay.commerce.model.CPDAvailabilityEstimateModel;
import com.liferay.commerce.model.CPDAvailabilityEstimateSoap;

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
 * The base model implementation for the CPDAvailabilityEstimate service. Represents a row in the &quot;CPDAvailabilityEstimate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CPDAvailabilityEstimateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CPDAvailabilityEstimateImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CPDAvailabilityEstimateImpl
 * @see CPDAvailabilityEstimate
 * @see CPDAvailabilityEstimateModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CPDAvailabilityEstimateModelImpl extends BaseModelImpl<CPDAvailabilityEstimate>
	implements CPDAvailabilityEstimateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cpd availability estimate model instance should use the {@link CPDAvailabilityEstimate} interface instead.
	 */
	public static final String TABLE_NAME = "CPDAvailabilityEstimate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "CPDAvailabilityEstimateId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "commerceAvailabilityEstimateId", Types.BIGINT },
			{ "CProductId", Types.BIGINT },
			{ "lastPublishDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CPDAvailabilityEstimateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceAvailabilityEstimateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table CPDAvailabilityEstimate (uuid_ VARCHAR(75) null,CPDAvailabilityEstimateId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceAvailabilityEstimateId LONG,CProductId LONG,lastPublishDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table CPDAvailabilityEstimate";
	public static final String ORDER_BY_JPQL = " ORDER BY cpdAvailabilityEstimate.CPDAvailabilityEstimateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CPDAvailabilityEstimate.CPDAvailabilityEstimateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.model.CPDAvailabilityEstimate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.model.CPDAvailabilityEstimate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.commerce.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.model.CPDAvailabilityEstimate"),
			true);
	public static final long CPRODUCTID_COLUMN_BITMASK = 1L;
	public static final long COMMERCEAVAILABILITYESTIMATEID_COLUMN_BITMASK = 2L;
	public static final long COMPANYID_COLUMN_BITMASK = 4L;
	public static final long UUID_COLUMN_BITMASK = 8L;
	public static final long CPDAVAILABILITYESTIMATEID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CPDAvailabilityEstimate toModel(
		CPDAvailabilityEstimateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CPDAvailabilityEstimate model = new CPDAvailabilityEstimateImpl();

		model.setUuid(soapModel.getUuid());
		model.setCPDAvailabilityEstimateId(soapModel.getCPDAvailabilityEstimateId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceAvailabilityEstimateId(soapModel.getCommerceAvailabilityEstimateId());
		model.setCProductId(soapModel.getCProductId());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CPDAvailabilityEstimate> toModels(
		CPDAvailabilityEstimateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CPDAvailabilityEstimate> models = new ArrayList<CPDAvailabilityEstimate>(soapModels.length);

		for (CPDAvailabilityEstimateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.commerce.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.model.CPDAvailabilityEstimate"));

	public CPDAvailabilityEstimateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCPDAvailabilityEstimateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CPDAvailabilityEstimate.class;
	}

	@Override
	public String getModelClassName() {
		return CPDAvailabilityEstimate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("CPDAvailabilityEstimateId",
			getCPDAvailabilityEstimateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("commerceAvailabilityEstimateId",
			getCommerceAvailabilityEstimateId());
		attributes.put("CProductId", getCProductId());
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

		Long CPDAvailabilityEstimateId = (Long)attributes.get(
				"CPDAvailabilityEstimateId");

		if (CPDAvailabilityEstimateId != null) {
			setCPDAvailabilityEstimateId(CPDAvailabilityEstimateId);
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

		Long commerceAvailabilityEstimateId = (Long)attributes.get(
				"commerceAvailabilityEstimateId");

		if (commerceAvailabilityEstimateId != null) {
			setCommerceAvailabilityEstimateId(commerceAvailabilityEstimateId);
		}

		Long CProductId = (Long)attributes.get("CProductId");

		if (CProductId != null) {
			setCProductId(CProductId);
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
	public long getCPDAvailabilityEstimateId() {
		return _CPDAvailabilityEstimateId;
	}

	@Override
	public void setCPDAvailabilityEstimateId(long CPDAvailabilityEstimateId) {
		_CPDAvailabilityEstimateId = CPDAvailabilityEstimateId;
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
	public long getCommerceAvailabilityEstimateId() {
		return _commerceAvailabilityEstimateId;
	}

	@Override
	public void setCommerceAvailabilityEstimateId(
		long commerceAvailabilityEstimateId) {
		_columnBitmask |= COMMERCEAVAILABILITYESTIMATEID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAvailabilityEstimateId) {
			_setOriginalCommerceAvailabilityEstimateId = true;

			_originalCommerceAvailabilityEstimateId = _commerceAvailabilityEstimateId;
		}

		_commerceAvailabilityEstimateId = commerceAvailabilityEstimateId;
	}

	public long getOriginalCommerceAvailabilityEstimateId() {
		return _originalCommerceAvailabilityEstimateId;
	}

	@JSON
	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		_columnBitmask |= CPRODUCTID_COLUMN_BITMASK;

		if (!_setOriginalCProductId) {
			_setOriginalCProductId = true;

			_originalCProductId = _CProductId;
		}

		_CProductId = CProductId;
	}

	public long getOriginalCProductId() {
		return _originalCProductId;
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
				CPDAvailabilityEstimate.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CPDAvailabilityEstimate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CPDAvailabilityEstimate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CPDAvailabilityEstimate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CPDAvailabilityEstimateImpl cpdAvailabilityEstimateImpl = new CPDAvailabilityEstimateImpl();

		cpdAvailabilityEstimateImpl.setUuid(getUuid());
		cpdAvailabilityEstimateImpl.setCPDAvailabilityEstimateId(getCPDAvailabilityEstimateId());
		cpdAvailabilityEstimateImpl.setCompanyId(getCompanyId());
		cpdAvailabilityEstimateImpl.setUserId(getUserId());
		cpdAvailabilityEstimateImpl.setUserName(getUserName());
		cpdAvailabilityEstimateImpl.setCreateDate(getCreateDate());
		cpdAvailabilityEstimateImpl.setModifiedDate(getModifiedDate());
		cpdAvailabilityEstimateImpl.setCommerceAvailabilityEstimateId(getCommerceAvailabilityEstimateId());
		cpdAvailabilityEstimateImpl.setCProductId(getCProductId());
		cpdAvailabilityEstimateImpl.setLastPublishDate(getLastPublishDate());

		cpdAvailabilityEstimateImpl.resetOriginalValues();

		return cpdAvailabilityEstimateImpl;
	}

	@Override
	public int compareTo(CPDAvailabilityEstimate cpdAvailabilityEstimate) {
		long primaryKey = cpdAvailabilityEstimate.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CPDAvailabilityEstimate)) {
			return false;
		}

		CPDAvailabilityEstimate cpdAvailabilityEstimate = (CPDAvailabilityEstimate)obj;

		long primaryKey = cpdAvailabilityEstimate.getPrimaryKey();

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
		CPDAvailabilityEstimateModelImpl cpdAvailabilityEstimateModelImpl = this;

		cpdAvailabilityEstimateModelImpl._originalUuid = cpdAvailabilityEstimateModelImpl._uuid;

		cpdAvailabilityEstimateModelImpl._originalCompanyId = cpdAvailabilityEstimateModelImpl._companyId;

		cpdAvailabilityEstimateModelImpl._setOriginalCompanyId = false;

		cpdAvailabilityEstimateModelImpl._setModifiedDate = false;

		cpdAvailabilityEstimateModelImpl._originalCommerceAvailabilityEstimateId = cpdAvailabilityEstimateModelImpl._commerceAvailabilityEstimateId;

		cpdAvailabilityEstimateModelImpl._setOriginalCommerceAvailabilityEstimateId = false;

		cpdAvailabilityEstimateModelImpl._originalCProductId = cpdAvailabilityEstimateModelImpl._CProductId;

		cpdAvailabilityEstimateModelImpl._setOriginalCProductId = false;

		cpdAvailabilityEstimateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CPDAvailabilityEstimate> toCacheModel() {
		CPDAvailabilityEstimateCacheModel cpdAvailabilityEstimateCacheModel = new CPDAvailabilityEstimateCacheModel();

		cpdAvailabilityEstimateCacheModel.uuid = getUuid();

		String uuid = cpdAvailabilityEstimateCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cpdAvailabilityEstimateCacheModel.uuid = null;
		}

		cpdAvailabilityEstimateCacheModel.CPDAvailabilityEstimateId = getCPDAvailabilityEstimateId();

		cpdAvailabilityEstimateCacheModel.companyId = getCompanyId();

		cpdAvailabilityEstimateCacheModel.userId = getUserId();

		cpdAvailabilityEstimateCacheModel.userName = getUserName();

		String userName = cpdAvailabilityEstimateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cpdAvailabilityEstimateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cpdAvailabilityEstimateCacheModel.createDate = createDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cpdAvailabilityEstimateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cpdAvailabilityEstimateCacheModel.commerceAvailabilityEstimateId = getCommerceAvailabilityEstimateId();

		cpdAvailabilityEstimateCacheModel.CProductId = getCProductId();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			cpdAvailabilityEstimateCacheModel.lastPublishDate = lastPublishDate.getTime();
		}
		else {
			cpdAvailabilityEstimateCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return cpdAvailabilityEstimateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", CPDAvailabilityEstimateId=");
		sb.append(getCPDAvailabilityEstimateId());
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
		sb.append(", commerceAvailabilityEstimateId=");
		sb.append(getCommerceAvailabilityEstimateId());
		sb.append(", CProductId=");
		sb.append(getCProductId());
		sb.append(", lastPublishDate=");
		sb.append(getLastPublishDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.commerce.model.CPDAvailabilityEstimate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CPDAvailabilityEstimateId</column-name><column-value><![CDATA[");
		sb.append(getCPDAvailabilityEstimateId());
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
			"<column><column-name>commerceAvailabilityEstimateId</column-name><column-value><![CDATA[");
		sb.append(getCommerceAvailabilityEstimateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CProductId</column-name><column-value><![CDATA[");
		sb.append(getCProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = CPDAvailabilityEstimate.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			CPDAvailabilityEstimate.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _CPDAvailabilityEstimateId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceAvailabilityEstimateId;
	private long _originalCommerceAvailabilityEstimateId;
	private boolean _setOriginalCommerceAvailabilityEstimateId;
	private long _CProductId;
	private long _originalCProductId;
	private boolean _setOriginalCProductId;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private CPDAvailabilityEstimate _escapedModel;
}