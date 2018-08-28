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

package com.liferay.commerce.cart.taglib.servlet.taglib;

import com.liferay.commerce.cart.taglib.servlet.taglib.internal.servlet.ServletContextUtil;
import com.liferay.commerce.constants.CPDefinitionInventoryConstants;
import com.liferay.commerce.constants.CommerceOrderActionKeys;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.commerce.constants.CommerceWebKeys;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CPDefinitionInventory;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CPDefinitionInventoryLocalServiceUtil;
import com.liferay.frontend.taglib.soy.servlet.taglib.ComponentRendererTag;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import javax.servlet.jsp.PageContext;

/**
 * @author Marco Leo
 * @author Alessio Antonio Rendina
 */
public class AddToCartTag extends ComponentRendererTag {

	@Override
	public int doStartTag() {
		try {
			CommerceContext commerceContext =
				(CommerceContext)request.getAttribute(
					CommerceWebKeys.COMMERCE_CONTEXT);
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
				WebKeys.THEME_DISPLAY);

			CommerceOrder commerceOrder = commerceContext.getCommerceOrder();

			if (commerceOrder == null) {
				long groupId = themeDisplay.getScopeGroupId();

				Organization organization = commerceContext.getOrganization();

				if (organization != null) {
					groupId = organization.getGroupId();
				}

				if (!portletResourcePermission.contains(
						themeDisplay.getPermissionChecker(), groupId,
						CommerceOrderActionKeys.ADD_COMMERCE_ORDER)) {

					return SKIP_BODY;
				}
			}
			else {
				if (!commerceOrderModelResourcePermission.contains(
						themeDisplay.getPermissionChecker(), commerceOrder,
						ActionKeys.UPDATE)) {

					return SKIP_BODY;
				}
			}

			String randomNamespace =
				StringUtil.randomId() + StringPool.UNDERLINE;

			int minOrderQuantity =
				CPDefinitionInventoryConstants.DEFAULT_MIN_ORDER_QUANTITY;

			Map<String, Object> context = getContext();

			putValue("id", randomNamespace + "id");

			long cpDefinitionId = GetterUtil.getLong(
				context.get("cpDefinitionId"));

			CPDefinitionInventory cpDefinitionInventory =
				CPDefinitionInventoryLocalServiceUtil.
					fetchCPDefinitionInventoryByCPDefinitionId(cpDefinitionId);

			if (cpDefinitionInventory != null) {
				minOrderQuantity = cpDefinitionInventory.getMinOrderQuantity();
			}

			String quantity = GetterUtil.getString(
				context.get("quantity"), String.valueOf(minOrderQuantity));

			putValue("quantity", quantity);

			String label = GetterUtil.getString(
				context.get("label"), LanguageUtil.get(request, "add-to-cart"));

			putValue("label", label);

			putValue(
				"portletNamespace",
				PortalUtil.getPortletNamespace(
					CommercePortletKeys.COMMERCE_CART_CONTENT));

			putValue("uri", _getURI());
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}

		setTemplateNamespace("AddToCart.render");

		return super.doStartTag();
	}

	@Override
	public String getModule() {
		return "commerce-cart-taglib/add_to_cart/AddToCart.es";
	}

	public void setCPDefinitionId(long cpDefinitionId) {
		putValue("cpDefinitionId", String.valueOf(cpDefinitionId));
	}

	public void setCPInstanceId(long cpInstanceId) {
		putValue("cpInstanceId", String.valueOf(cpInstanceId));
	}

	public void setElementClasses(String elementClasses) {
		putValue("elementClasses", elementClasses);
	}

	public void setLabel(String label) {
		putValue("label", LanguageUtil.get(request, label));
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		commerceOrderModelResourcePermission =
			ServletContextUtil.getCommerceOrderModelResourcePermission();
		portletResourcePermission =
			ServletContextUtil.getPortletResourcePermission();
	}

	public void setProductContentId(String productContentId) {
		putValue("productContentId", productContentId);
	}

	public void setQuantity(String quantity) {
		putValue("quantity", quantity);
	}

	public void setTaglibQuantityInputId(String taglibQuantityInputId) {
		putValue("taglibQuantityInputId", taglibQuantityInputId);
	}

	protected ModelResourcePermission<CommerceOrder>
		commerceOrderModelResourcePermission;
	protected PortletResourcePermission portletResourcePermission;

	private String _getURI() throws WindowStateException {
		PortletURL portletURL = PortletURLFactoryUtil.create(
			request, CommercePortletKeys.COMMERCE_CART_CONTENT,
			PortletRequest.ACTION_PHASE);

		portletURL.setParameter(
			ActionRequest.ACTION_NAME, "addCommerceOrderItem");

		return portletURL.toString();
	}

	private static final Log _log = LogFactoryUtil.getLog(AddToCartTag.class);

}