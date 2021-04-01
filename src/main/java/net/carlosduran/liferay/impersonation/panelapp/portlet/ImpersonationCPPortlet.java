package net.carlosduran.liferay.impersonation.panelapp.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import net.carlosduran.liferay.impersonation.sb.service.ImpersonationRegistryLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import net.carlosduran.liferay.impersonation.panelapp.constants.ImpersonationCPPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author cadudu
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
		"javax.portlet.display-name=ImpersonationCP",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ImpersonationCPPortletKeys.IMPERSONATIONCP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",

	},
	service = Portlet.class
)
public class ImpersonationCPPortlet extends MVCPortlet {
	
	private static Log _log = LogFactoryUtil.getLog(ImpersonationCPPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
				
		renderRequest.setAttribute(ImpersonationCPPortletKeys.ATTR_IMPERSONATIONS,
		ImpersonationRegistryLocalServiceUtil.getImpersonationRegistries(0,
				ImpersonationRegistryLocalServiceUtil.getImpersonationRegistriesCount()));
		
		super.doView(renderRequest, renderResponse);
	}
	
}