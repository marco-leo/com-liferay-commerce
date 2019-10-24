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

package com.liferay.commerce.product.type.virtual.order.model.impl;

import com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItem;
import com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItemModel;
import com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItemSoap;
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
import com.liferay.portal.kernel.util.DateUtil;
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
 * The base model implementation for the CommerceVirtualOrderItem service. Represents a row in the &quot;CommerceVirtualOrderItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceVirtualOrderItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceVirtualOrderItemImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceVirtualOrderItemImpl
 * @generated
 */
@JSON(strict = true)
public class CommerceVirtualOrderItemModelImpl
	extends BaseModelImpl<CommerceVirtualOrderItem>
	implements CommerceVirtualOrderItemModel {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce virtual order item model instance should use the <code>CommerceVirtualOrderItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceVirtualOrderItem";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"commerceVirtualOrderItemId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commerceOrderItemId", Types.BIGINT}, {"fileEntryId", Types.BIGINT},
		{"url", Types.VARCHAR}, {"activationStatus", Types.INTEGER},
		{"duration", Types.BIGINT}, {"usages", Types.INTEGER},
		{"maxUsages", Types.INTEGER}, {"active_", Types.BOOLEAN},
		{"startDate", Types.TIMESTAMP}, {"endDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commerceVirtualOrderItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceOrderItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("activationStatus", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("duration", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("usages", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("maxUsages", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("active_", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceVirtualOrderItem (uuid_ VARCHAR(75) null,commerceVirtualOrderItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceOrderItemId LONG,fileEntryId LONG,url VARCHAR(75) null,activationStatus INTEGER,duration LONG,usages INTEGER,maxUsages INTEGER,active_ BOOLEAN,startDate DATE null,endDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table CommerceVirtualOrderItem";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceVirtualOrderItem.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceVirtualOrderItem.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.type.virtual.order.service.util.
			ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItem"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.type.virtual.order.service.util.
			ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItem"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.type.virtual.order.service.util.
			ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItem"),
		true);

	public static final long COMMERCEORDERITEMID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceVirtualOrderItem toModel(
		CommerceVirtualOrderItemSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceVirtualOrderItem model = new CommerceVirtualOrderItemImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommerceVirtualOrderItemId(
			soapModel.getCommerceVirtualOrderItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceOrderItemId(soapModel.getCommerceOrderItemId());
		model.setFileEntryId(soapModel.getFileEntryId());
		model.setUrl(soapModel.getUrl());
		model.setActivationStatus(soapModel.getActivationStatus());
		model.setDuration(soapModel.getDuration());
		model.setUsages(soapModel.getUsages());
		model.setMaxUsages(soapModel.getMaxUsages());
		model.setActive(soapModel.isActive());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceVirtualOrderItem> toModels(
		CommerceVirtualOrderItemSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceVirtualOrderItem> models =
			new ArrayList<CommerceVirtualOrderItem>(soapModels.length);

		for (CommerceVirtualOrderItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.type.virtual.order.service.util.
			ServiceProps.get(
				"lock.expiration.time.com.liferay.commerce.product.type.virtual.order.model.CommerceVirtualOrderItem"));

	public CommerceVirtualOrderItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceVirtualOrderItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceVirtualOrderItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceVirtualOrderItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceVirtualOrderItem.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceVirtualOrderItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceVirtualOrderItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceVirtualOrderItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceVirtualOrderItem, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceVirtualOrderItem)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceVirtualOrderItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceVirtualOrderItem, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceVirtualOrderItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceVirtualOrderItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceVirtualOrderItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceVirtualOrderItem>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceVirtualOrderItem.class.getClassLoader(),
			CommerceVirtualOrderItem.class, ModelWrapper.class);

		try {
			Constructor<CommerceVirtualOrderItem> constructor =
				(Constructor<CommerceVirtualOrderItem>)
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

	private static final Map<String, Function<CommerceVirtualOrderItem, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<CommerceVirtualOrderItem, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceVirtualOrderItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CommerceVirtualOrderItem, Object>>();
		Map<String, BiConsumer<CommerceVirtualOrderItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CommerceVirtualOrderItem, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object uuidObject) {

					commerceVirtualOrderItem.setUuid((String)uuidObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceVirtualOrderItemId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.
						getCommerceVirtualOrderItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceVirtualOrderItemId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object commerceVirtualOrderItemIdObject) {

					commerceVirtualOrderItem.setCommerceVirtualOrderItemId(
						(Long)commerceVirtualOrderItemIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object groupIdObject) {

					commerceVirtualOrderItem.setGroupId((Long)groupIdObject);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object companyIdObject) {

					commerceVirtualOrderItem.setCompanyId(
						(Long)companyIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object userIdObject) {

					commerceVirtualOrderItem.setUserId((Long)userIdObject);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object userNameObject) {

					commerceVirtualOrderItem.setUserName(
						(String)userNameObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object createDateObject) {

					commerceVirtualOrderItem.setCreateDate(
						(Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object modifiedDateObject) {

					commerceVirtualOrderItem.setModifiedDate(
						(Date)modifiedDateObject);
				}

			});
		attributeGetterFunctions.put(
			"commerceOrderItemId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getCommerceOrderItemId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceOrderItemId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object commerceOrderItemIdObject) {

					commerceVirtualOrderItem.setCommerceOrderItemId(
						(Long)commerceOrderItemIdObject);
				}

			});
		attributeGetterFunctions.put(
			"fileEntryId",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getFileEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"fileEntryId",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object fileEntryIdObject) {

					commerceVirtualOrderItem.setFileEntryId(
						(Long)fileEntryIdObject);
				}

			});
		attributeGetterFunctions.put(
			"url",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getUrl();
				}

			});
		attributeSetterBiConsumers.put(
			"url",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object urlObject) {

					commerceVirtualOrderItem.setUrl((String)urlObject);
				}

			});
		attributeGetterFunctions.put(
			"activationStatus",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getActivationStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"activationStatus",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object activationStatusObject) {

					commerceVirtualOrderItem.setActivationStatus(
						(Integer)activationStatusObject);
				}

			});
		attributeGetterFunctions.put(
			"duration",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getDuration();
				}

			});
		attributeSetterBiConsumers.put(
			"duration",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object durationObject) {

					commerceVirtualOrderItem.setDuration((Long)durationObject);
				}

			});
		attributeGetterFunctions.put(
			"usages",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getUsages();
				}

			});
		attributeSetterBiConsumers.put(
			"usages",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object usagesObject) {

					commerceVirtualOrderItem.setUsages((Integer)usagesObject);
				}

			});
		attributeGetterFunctions.put(
			"maxUsages",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getMaxUsages();
				}

			});
		attributeSetterBiConsumers.put(
			"maxUsages",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object maxUsagesObject) {

					commerceVirtualOrderItem.setMaxUsages(
						(Integer)maxUsagesObject);
				}

			});
		attributeGetterFunctions.put(
			"active",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getActive();
				}

			});
		attributeSetterBiConsumers.put(
			"active",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object activeObject) {

					commerceVirtualOrderItem.setActive((Boolean)activeObject);
				}

			});
		attributeGetterFunctions.put(
			"startDate",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getStartDate();
				}

			});
		attributeSetterBiConsumers.put(
			"startDate",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object startDateObject) {

					commerceVirtualOrderItem.setStartDate(
						(Date)startDateObject);
				}

			});
		attributeGetterFunctions.put(
			"endDate",
			new Function<CommerceVirtualOrderItem, Object>() {

				@Override
				public Object apply(
					CommerceVirtualOrderItem commerceVirtualOrderItem) {

					return commerceVirtualOrderItem.getEndDate();
				}

			});
		attributeSetterBiConsumers.put(
			"endDate",
			new BiConsumer<CommerceVirtualOrderItem, Object>() {

				@Override
				public void accept(
					CommerceVirtualOrderItem commerceVirtualOrderItem,
					Object endDateObject) {

					commerceVirtualOrderItem.setEndDate((Date)endDateObject);
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
	public long getCommerceVirtualOrderItemId() {
		return _commerceVirtualOrderItemId;
	}

	@Override
	public void setCommerceVirtualOrderItemId(long commerceVirtualOrderItemId) {
		_commerceVirtualOrderItemId = commerceVirtualOrderItemId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
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
		_columnBitmask = -1L;

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
	public long getCommerceOrderItemId() {
		return _commerceOrderItemId;
	}

	@Override
	public void setCommerceOrderItemId(long commerceOrderItemId) {
		_columnBitmask |= COMMERCEORDERITEMID_COLUMN_BITMASK;

		if (!_setOriginalCommerceOrderItemId) {
			_setOriginalCommerceOrderItemId = true;

			_originalCommerceOrderItemId = _commerceOrderItemId;
		}

		_commerceOrderItemId = commerceOrderItemId;
	}

	public long getOriginalCommerceOrderItemId() {
		return _originalCommerceOrderItemId;
	}

	@JSON
	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@JSON
	@Override
	public int getActivationStatus() {
		return _activationStatus;
	}

	@Override
	public void setActivationStatus(int activationStatus) {
		_activationStatus = activationStatus;
	}

	@JSON
	@Override
	public long getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(long duration) {
		_duration = duration;
	}

	@JSON
	@Override
	public int getUsages() {
		return _usages;
	}

	@Override
	public void setUsages(int usages) {
		_usages = usages;
	}

	@JSON
	@Override
	public int getMaxUsages() {
		return _maxUsages;
	}

	@Override
	public void setMaxUsages(int maxUsages) {
		_maxUsages = maxUsages;
	}

	@JSON
	@Override
	public boolean getActive() {
		return _active;
	}

	@JSON
	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(
				CommerceVirtualOrderItem.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceVirtualOrderItem.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceVirtualOrderItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceVirtualOrderItem>
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
		CommerceVirtualOrderItemImpl commerceVirtualOrderItemImpl =
			new CommerceVirtualOrderItemImpl();

		commerceVirtualOrderItemImpl.setUuid(getUuid());
		commerceVirtualOrderItemImpl.setCommerceVirtualOrderItemId(
			getCommerceVirtualOrderItemId());
		commerceVirtualOrderItemImpl.setGroupId(getGroupId());
		commerceVirtualOrderItemImpl.setCompanyId(getCompanyId());
		commerceVirtualOrderItemImpl.setUserId(getUserId());
		commerceVirtualOrderItemImpl.setUserName(getUserName());
		commerceVirtualOrderItemImpl.setCreateDate(getCreateDate());
		commerceVirtualOrderItemImpl.setModifiedDate(getModifiedDate());
		commerceVirtualOrderItemImpl.setCommerceOrderItemId(
			getCommerceOrderItemId());
		commerceVirtualOrderItemImpl.setFileEntryId(getFileEntryId());
		commerceVirtualOrderItemImpl.setUrl(getUrl());
		commerceVirtualOrderItemImpl.setActivationStatus(getActivationStatus());
		commerceVirtualOrderItemImpl.setDuration(getDuration());
		commerceVirtualOrderItemImpl.setUsages(getUsages());
		commerceVirtualOrderItemImpl.setMaxUsages(getMaxUsages());
		commerceVirtualOrderItemImpl.setActive(isActive());
		commerceVirtualOrderItemImpl.setStartDate(getStartDate());
		commerceVirtualOrderItemImpl.setEndDate(getEndDate());

		commerceVirtualOrderItemImpl.resetOriginalValues();

		return commerceVirtualOrderItemImpl;
	}

	@Override
	public int compareTo(CommerceVirtualOrderItem commerceVirtualOrderItem) {
		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(), commerceVirtualOrderItem.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof CommerceVirtualOrderItem)) {
			return false;
		}

		CommerceVirtualOrderItem commerceVirtualOrderItem =
			(CommerceVirtualOrderItem)obj;

		long primaryKey = commerceVirtualOrderItem.getPrimaryKey();

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
		CommerceVirtualOrderItemModelImpl commerceVirtualOrderItemModelImpl =
			this;

		commerceVirtualOrderItemModelImpl._originalUuid =
			commerceVirtualOrderItemModelImpl._uuid;

		commerceVirtualOrderItemModelImpl._originalGroupId =
			commerceVirtualOrderItemModelImpl._groupId;

		commerceVirtualOrderItemModelImpl._setOriginalGroupId = false;

		commerceVirtualOrderItemModelImpl._originalCompanyId =
			commerceVirtualOrderItemModelImpl._companyId;

		commerceVirtualOrderItemModelImpl._setOriginalCompanyId = false;

		commerceVirtualOrderItemModelImpl._setModifiedDate = false;

		commerceVirtualOrderItemModelImpl._originalCommerceOrderItemId =
			commerceVirtualOrderItemModelImpl._commerceOrderItemId;

		commerceVirtualOrderItemModelImpl._setOriginalCommerceOrderItemId =
			false;

		commerceVirtualOrderItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceVirtualOrderItem> toCacheModel() {
		CommerceVirtualOrderItemCacheModel commerceVirtualOrderItemCacheModel =
			new CommerceVirtualOrderItemCacheModel();

		commerceVirtualOrderItemCacheModel.uuid = getUuid();

		String uuid = commerceVirtualOrderItemCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commerceVirtualOrderItemCacheModel.uuid = null;
		}

		commerceVirtualOrderItemCacheModel.commerceVirtualOrderItemId =
			getCommerceVirtualOrderItemId();

		commerceVirtualOrderItemCacheModel.groupId = getGroupId();

		commerceVirtualOrderItemCacheModel.companyId = getCompanyId();

		commerceVirtualOrderItemCacheModel.userId = getUserId();

		commerceVirtualOrderItemCacheModel.userName = getUserName();

		String userName = commerceVirtualOrderItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceVirtualOrderItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceVirtualOrderItemCacheModel.createDate =
				createDate.getTime();
		}
		else {
			commerceVirtualOrderItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceVirtualOrderItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			commerceVirtualOrderItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceVirtualOrderItemCacheModel.commerceOrderItemId =
			getCommerceOrderItemId();

		commerceVirtualOrderItemCacheModel.fileEntryId = getFileEntryId();

		commerceVirtualOrderItemCacheModel.url = getUrl();

		String url = commerceVirtualOrderItemCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			commerceVirtualOrderItemCacheModel.url = null;
		}

		commerceVirtualOrderItemCacheModel.activationStatus =
			getActivationStatus();

		commerceVirtualOrderItemCacheModel.duration = getDuration();

		commerceVirtualOrderItemCacheModel.usages = getUsages();

		commerceVirtualOrderItemCacheModel.maxUsages = getMaxUsages();

		commerceVirtualOrderItemCacheModel.active = isActive();

		Date startDate = getStartDate();

		if (startDate != null) {
			commerceVirtualOrderItemCacheModel.startDate = startDate.getTime();
		}
		else {
			commerceVirtualOrderItemCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			commerceVirtualOrderItemCacheModel.endDate = endDate.getTime();
		}
		else {
			commerceVirtualOrderItemCacheModel.endDate = Long.MIN_VALUE;
		}

		return commerceVirtualOrderItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceVirtualOrderItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceVirtualOrderItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceVirtualOrderItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CommerceVirtualOrderItem)this));
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
		Map<String, Function<CommerceVirtualOrderItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceVirtualOrderItem, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceVirtualOrderItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CommerceVirtualOrderItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, CommerceVirtualOrderItem>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _commerceVirtualOrderItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceOrderItemId;
	private long _originalCommerceOrderItemId;
	private boolean _setOriginalCommerceOrderItemId;
	private long _fileEntryId;
	private String _url;
	private int _activationStatus;
	private long _duration;
	private int _usages;
	private int _maxUsages;
	private boolean _active;
	private Date _startDate;
	private Date _endDate;
	private long _columnBitmask;
	private CommerceVirtualOrderItem _escapedModel;

}