package net.carlosduran.liferay.impersonation.portlet;

import net.carlosduran.liferay.impersonation.constants.ImpersonationAdminPortletKeys;
import net.carlosduran.liferay.impersonation.sb.service.ImpersonationRegistryLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author carlos
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true",
		"javax.portlet.display-name=ImpersonationAdmin",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ImpersonationAdminPortletKeys.IMPERSONATIONADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class ImpersonationAdminPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(ImpersonationAdminPortletKeys.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
				
		renderRequest.setAttribute(ImpersonationAdminPortletKeys.ATTR_IMPERSONATIONS,
		ImpersonationRegistryLocalServiceUtil.getImpersonationRegistries(0,
				ImpersonationRegistryLocalServiceUtil.getImpersonationRegistriesCount()));
		
		super.doView(renderRequest, renderResponse);
	}
	
	
	
}