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

import com.liferay.commerce.price.list.model.CommercePriceListAccountRel;
import com.liferay.commerce.price.list.model.CommercePriceListAccountRelModel;
import com.liferay.commerce.price.list.model.CommercePriceListAccountRelSoap;
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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommercePriceListAccountRel service. Represents a row in the &quot;CommercePriceListAccountRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommercePriceListAccountRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommercePriceListAccountRelImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommercePriceListAccountRelImpl
 * @generated
 */
@JSON(strict = true)
public class CommercePriceListAccountRelModelImpl
	extends BaseModelImpl<CommercePriceListAccountRel>
	implements CommercePriceListAccountRelModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce price list account rel model instance should use the <code>CommercePriceListAccountRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommercePriceListAccountRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR},
		{"commercePriceListAccountRelId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"commerceAccountId", Types.BIGINT},
		{"commercePriceListId", Types.BIGINT}, {"order_", Types.INTEGER},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commercePriceListAccountRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceAccountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commercePriceListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommercePriceListAccountRel (uuid_ VARCHAR(75) null,commercePriceListAccountRelId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceAccountId LONG,commercePriceListId LONG,order_ INTEGER,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommercePriceListAccountRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commercePriceListAccountRel.order ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommercePriceListAccountRel.order_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceListAccountRel"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.price.list.model.CommercePriceListAccountRel"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.price.list.model.CommercePriceListAccountRel"),
		true);

	public static final long COMMERCEACCOUNTID_COLUMN_BITMASK = 1L;

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
	public static CommercePriceListAccountRel toModel(
		CommercePriceListAccountRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommercePriceListAccountRel model =
			new CommercePriceListAccountRelImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommercePriceListAccountRelId(
			soapModel.getCommercePriceListAccountRelId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceAccountId(soapModel.getCommerceAccountId());
		model.setCommercePriceListId(soapModel.getCommercePriceListId());
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
	public static List<CommercePriceListAccountRel> toModels(
		CommercePriceListAccountRelSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommercePriceListAccountRel> models =
			new ArrayList<CommercePriceListAccountRel>(soapModels.length);

		for (CommercePriceListAccountRelSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.price.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.price.list.model.CommercePriceListAccountRel"));

	public CommercePriceListAccountRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commercePriceListAccountRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommercePriceListAccountRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commercePriceListAccountRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommercePriceListAccountRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommercePriceListAccountRel.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommercePriceListAccountRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommercePriceListAccountRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListAccountRel, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommercePriceListAccountRel)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommercePriceListAccountRel, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommercePriceListAccountRel, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommercePriceListAccountRel)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommercePriceListAccountRel, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommercePriceListAccountRel, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommercePriceListAccountRel>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommercePriceListAccountRel.class.getClassLoader(),
			CommercePriceListAccountRel.class, ModelWrapper.class);

		try {
			Constructor<CommercePriceListAccountRel> constructor =
				(Constructor<CommercePriceListAccountRel>)
					proxyClass.getConstructor(InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map
		<String, Function<CommercePriceListAccountRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommercePriceListAccountRel, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommercePriceListAccountRel, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommercePriceListAccountRel, Object>>();
		Map<String, BiConsumer<CommercePriceListAccountRel, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommercePriceListAccountRel, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object uuidObject) {

					commercePriceListAccountRel.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"commercePriceListAccountRelId",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.
						getCommercePriceListAccountRelId();
				}

			});
		attributeSetterBiConsumers.put(
			"commercePriceListAccountRelId",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object commercePriceListAccountRelIdObject) {

					commercePriceListAccountRel.
						setCommercePriceListAccountRelId(
							(Long)commercePriceListAccountRelIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object companyIdObject) {

					commercePriceListAccountRel.setCompanyId(
						(Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object userIdObject) {

					commercePriceListAccountRel.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object userNameObject) {

					commercePriceListAccountRel.setUserName(
						(String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object createDateObject) {

					commercePriceListAccountRel.setCreateDate(
						(Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object modifiedDateObject) {

					commercePriceListAccountRel.setModifiedDate(
						(Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceAccountId",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getCommerceAccountId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceAccountId",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object commerceAccountIdObject) {

					commercePriceListAccountRel.setCommerceAccountId(
						(Long)commerceAccountIdObject);
				}

			});
		attributeGetterFunctions.put(
			"commercePriceListId",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getCommercePriceListId();
				}

			});
		attributeSetterBiConsumers.put(
			"commercePriceListId",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object commercePriceListIdObject) {

					commercePriceListAccountRel.setCommercePriceListId(
						(Long)commercePriceListIdObject);
				}

			});
		attributeGetterFunctions.put(
			"order",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getOrder();
				}

			});
		attributeSetterBiConsumers.put(
			"order",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object orderObject) {

					commercePriceListAccountRel.setOrder((Integer)orderObject);
				}

			});
		attributeGetterFunctions.put(
			"lastPublishDate",
			new Function<CommercePriceListAccountRel, Object>() {

				@Override
				public Object apply(
					CommercePriceListAccountRel commercePriceListAccountRel) {

					return commercePriceListAccountRel.getLastPublishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			new BiConsumer<CommercePriceListAccountRel, Object>() {

				@Override
				public void accept(
					CommercePriceListAccountRel commercePriceListAccountRel,
					Object lastPublishDateObject) {

					commercePriceListAccountRel.setLastPublishDate(
						(Date)lastPublishDateObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
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
		_columnBitmask |= UUID_COLUMN_BITMASK;

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
	public long getCommercePriceListAccountRelId() {
		return _commercePriceListAccountRelId;
	}

	@Override
	public void setCommercePriceListAccountRelId(
		long commercePriceListAccountRelId) {

		_commercePriceListAccountRelId = commercePriceListAccountRelId;
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
	public long getCommerceAccountId() {
		return _commerceAccountId;
	}

	@Override
	public void setCommerceAccountId(long commerceAccountId) {
		_columnBitmask |= COMMERCEACCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAccountId) {
			_setOriginalCommerceAccountId = true;

			_originalCommerceAccountId = _commerceAccountId;
		}

		_commerceAccountId = commerceAccountId;
	}

	public long getOriginalCommerceAccountId() {
		return _originalCommerceAccountId;
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
		return new StagedModelType(
			PortalUtil.getClassNameId(
				CommercePriceListAccountRel.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommercePriceListAccountRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommercePriceListAccountRel toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommercePriceListAccountRel>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommercePriceListAccountRelImpl commercePriceListAccountRelImpl =
			new CommercePriceListAccountRelImpl();

		commercePriceListAccountRelImpl.setUuid(getUuid());
		commercePriceListAccountRelImpl.setCommercePriceListAccountRelId(
			getCommercePriceListAccountRelId());
		commercePriceListAccountRelImpl.setCompanyId(getCompanyId());
		commercePriceListAccountRelImpl.setUserId(getUserId());
		commercePriceListAccountRelImpl.setUserName(getUserName());
		commercePriceListAccountRelImpl.setCreateDate(getCreateDate());
		commercePriceListAccountRelImpl.setModifiedDate(getModifiedDate());
		commercePriceListAccountRelImpl.setCommerceAccountId(
			getCommerceAccountId());
		commercePriceListAccountRelImpl.setCommercePriceListId(
			getCommercePriceListId());
		commercePriceListAccountRelImpl.setOrder(getOrder());
		commercePriceListAccountRelImpl.setLastPublishDate(
			getLastPublishDate());

		commercePriceListAccountRelImpl.resetOriginalValues();

		return commercePriceListAccountRelImpl;
	}

	@Override
	public int compareTo(
		CommercePriceListAccountRel commercePriceListAccountRel) {

		int value = 0;

		if (getOrder() < commercePriceListAccountRel.getOrder()) {
			value = -1;
		}
		else if (getOrder() > commercePriceListAccountRel.getOrder()) {
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

		if (!(obj instanceof CommercePriceListAccountRel)) {
			return false;
		}

		CommercePriceListAccountRel commercePriceListAccountRel =
			(CommercePriceListAccountRel)obj;

		long primaryKey = commercePriceListAccountRel.getPrimaryKey();

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
		CommercePriceListAccountRelModelImpl
			commercePriceListAccountRelModelImpl = this;

		commercePriceListAccountRelModelImpl._originalUuid =
			commercePriceListAccountRelModelImpl._uuid;

		commercePriceListAccountRelModelImpl._originalCompanyId =
			commercePriceListAccountRelModelImpl._companyId;

		commercePriceListAccountRelModelImpl._setOriginalCompanyId = false;

		commercePriceListAccountRelModelImpl._setModifiedDate = false;

		commercePriceListAccountRelModelImpl._originalCommerceAccountId =
			commercePriceListAccountRelModelImpl._commerceAccountId;

		commercePriceListAccountRelModelImpl._setOriginalCommerceAccountId =
			false;

		commercePriceListAccountRelModelImpl._originalCommercePriceListId =
			commercePriceListAccountRelModelImpl._commercePriceListId;

		commercePriceListAccountRelModelImpl._setOriginalCommercePriceListId =
			false;

		commercePriceListAccountRelModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommercePriceListAccountRel> toCacheModel() {
		CommercePriceListAccountRelCacheModel
			commercePriceListAccountRelCacheModel =
				new CommercePriceListAccountRelCacheModel();

		commercePriceListAccountRelCacheModel.uuid = getUuid();

		String uuid = commercePriceListAccountRelCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commercePriceListAccountRelCacheModel.uuid = null;
		}

		commercePriceListAccountRelCacheModel.commercePriceListAccountRelId =
			getCommercePriceListAccountRelId();

		commercePriceListAccountRelCacheModel.companyId = getCompanyId();

		commercePriceListAccountRelCacheModel.userId = getUserId();

		commercePriceListAccountRelCacheModel.userName = getUserName();

		String userName = commercePriceListAccountRelCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commercePriceListAccountRelCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commercePriceListAccountRelCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commercePriceListAccountRelCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commercePriceListAccountRelCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commercePriceListAccountRelCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commercePriceListAccountRelCacheModel.commerceAccountId =
			getCommerceAccountId();

		commercePriceListAccountRelCacheModel.commercePriceListId =
			getCommercePriceListId();

		commercePriceListAccountRelCacheModel.order = getOrder();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			commercePriceListAccountRelCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			commercePriceListAccountRelCacheModel.lastPublishDate =
				Long.MIN_VALUE;
		}

		return commercePriceListAccountRelCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommercePriceListAccountRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommercePriceListAccountRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListAccountRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommercePriceListAccountRel)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommercePriceListAccountRel, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommercePriceListAccountRel, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommercePriceListAccountRel, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommercePriceListAccountRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommercePriceListAccountRel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _commercePriceListAccountRelId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceAccountId;
	private long _originalCommerceAccountId;
	private boolean _setOriginalCommerceAccountId;
	private long _commercePriceListId;
	private long _originalCommercePriceListId;
	private boolean _setOriginalCommercePriceListId;
	private int _order;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private CommercePriceListAccountRel _escapedModel;

}