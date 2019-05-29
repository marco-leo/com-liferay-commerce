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

package com.liferay.commerce.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the CommerceCountry service. Represents a row in the &quot;CommerceCountry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.commerce.model.impl.CommerceCountryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.commerce.model.impl.CommerceCountryImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceCountry
 * @see com.liferay.commerce.model.impl.CommerceCountryImpl
 * @see com.liferay.commerce.model.impl.CommerceCountryModelImpl
 * @generated
 */
@ProviderType
public interface CommerceCountryModel extends BaseModel<CommerceCountry>,
	LocalizedModel, ShardedModel, StagedAuditedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a commerce country model instance should use the {@link CommerceCountry} interface instead.
	 */

	/**
	 * Returns the primary key of this commerce country.
	 *
	 * @return the primary key of this commerce country
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this commerce country.
	 *
	 * @param primaryKey the primary key of this commerce country
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this commerce country.
	 *
	 * @return the uuid of this commerce country
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this commerce country.
	 *
	 * @param uuid the uuid of this commerce country
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the commerce country ID of this commerce country.
	 *
	 * @return the commerce country ID of this commerce country
	 */
	public long getCommerceCountryId();

	/**
	 * Sets the commerce country ID of this commerce country.
	 *
	 * @param commerceCountryId the commerce country ID of this commerce country
	 */
	public void setCommerceCountryId(long commerceCountryId);

	/**
	 * Returns the company ID of this commerce country.
	 *
	 * @return the company ID of this commerce country
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this commerce country.
	 *
	 * @param companyId the company ID of this commerce country
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this commerce country.
	 *
	 * @return the user ID of this commerce country
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this commerce country.
	 *
	 * @param userId the user ID of this commerce country
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this commerce country.
	 *
	 * @return the user uuid of this commerce country
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this commerce country.
	 *
	 * @param userUuid the user uuid of this commerce country
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this commerce country.
	 *
	 * @return the user name of this commerce country
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this commerce country.
	 *
	 * @param userName the user name of this commerce country
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this commerce country.
	 *
	 * @return the create date of this commerce country
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this commerce country.
	 *
	 * @param createDate the create date of this commerce country
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this commerce country.
	 *
	 * @return the modified date of this commerce country
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this commerce country.
	 *
	 * @param modifiedDate the modified date of this commerce country
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this commerce country.
	 *
	 * @return the name of this commerce country
	 */
	public String getName();

	/**
	 * Returns the localized name of this commerce country in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this commerce country
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this commerce country in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this commerce country. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this commerce country in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this commerce country
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this commerce country in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this commerce country
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this commerce country.
	 *
	 * @return the locales and localized names of this commerce country
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this commerce country.
	 *
	 * @param name the name of this commerce country
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this commerce country in the language.
	 *
	 * @param name the localized name of this commerce country
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this commerce country in the language, and sets the default locale.
	 *
	 * @param name the localized name of this commerce country
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this commerce country from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this commerce country
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this commerce country from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this commerce country
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the billing allowed of this commerce country.
	 *
	 * @return the billing allowed of this commerce country
	 */
	public boolean getBillingAllowed();

	/**
	 * Returns <code>true</code> if this commerce country is billing allowed.
	 *
	 * @return <code>true</code> if this commerce country is billing allowed; <code>false</code> otherwise
	 */
	public boolean isBillingAllowed();

	/**
	 * Sets whether this commerce country is billing allowed.
	 *
	 * @param billingAllowed the billing allowed of this commerce country
	 */
	public void setBillingAllowed(boolean billingAllowed);

	/**
	 * Returns the shipping allowed of this commerce country.
	 *
	 * @return the shipping allowed of this commerce country
	 */
	public boolean getShippingAllowed();

	/**
	 * Returns <code>true</code> if this commerce country is shipping allowed.
	 *
	 * @return <code>true</code> if this commerce country is shipping allowed; <code>false</code> otherwise
	 */
	public boolean isShippingAllowed();

	/**
	 * Sets whether this commerce country is shipping allowed.
	 *
	 * @param shippingAllowed the shipping allowed of this commerce country
	 */
	public void setShippingAllowed(boolean shippingAllowed);

	/**
	 * Returns the two letters iso code of this commerce country.
	 *
	 * @return the two letters iso code of this commerce country
	 */
	@AutoEscape
	public String getTwoLettersISOCode();

	/**
	 * Sets the two letters iso code of this commerce country.
	 *
	 * @param twoLettersISOCode the two letters iso code of this commerce country
	 */
	public void setTwoLettersISOCode(String twoLettersISOCode);

	/**
	 * Returns the three letters iso code of this commerce country.
	 *
	 * @return the three letters iso code of this commerce country
	 */
	@AutoEscape
	public String getThreeLettersISOCode();

	/**
	 * Sets the three letters iso code of this commerce country.
	 *
	 * @param threeLettersISOCode the three letters iso code of this commerce country
	 */
	public void setThreeLettersISOCode(String threeLettersISOCode);

	/**
	 * Returns the numeric iso code of this commerce country.
	 *
	 * @return the numeric iso code of this commerce country
	 */
	public int getNumericISOCode();

	/**
	 * Sets the numeric iso code of this commerce country.
	 *
	 * @param numericISOCode the numeric iso code of this commerce country
	 */
	public void setNumericISOCode(int numericISOCode);

	/**
	 * Returns the subject to vat of this commerce country.
	 *
	 * @return the subject to vat of this commerce country
	 */
	public boolean getSubjectToVAT();

	/**
	 * Returns <code>true</code> if this commerce country is subject to vat.
	 *
	 * @return <code>true</code> if this commerce country is subject to vat; <code>false</code> otherwise
	 */
	public boolean isSubjectToVAT();

	/**
	 * Sets whether this commerce country is subject to vat.
	 *
	 * @param subjectToVAT the subject to vat of this commerce country
	 */
	public void setSubjectToVAT(boolean subjectToVAT);

	/**
	 * Returns the priority of this commerce country.
	 *
	 * @return the priority of this commerce country
	 */
	public double getPriority();

	/**
	 * Sets the priority of this commerce country.
	 *
	 * @param priority the priority of this commerce country
	 */
	public void setPriority(double priority);

	/**
	 * Returns the active of this commerce country.
	 *
	 * @return the active of this commerce country
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this commerce country is active.
	 *
	 * @return <code>true</code> if this commerce country is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this commerce country is active.
	 *
	 * @param active the active of this commerce country
	 */
	public void setActive(boolean active);

	/**
	 * Returns the last publish date of this commerce country.
	 *
	 * @return the last publish date of this commerce country
	 */
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this commerce country.
	 *
	 * @param lastPublishDate the last publish date of this commerce country
	 */
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(CommerceCountry commerceCountry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<CommerceCountry> toCacheModel();

	@Override
	public CommerceCountry toEscapedModel();

	@Override
	public CommerceCountry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}