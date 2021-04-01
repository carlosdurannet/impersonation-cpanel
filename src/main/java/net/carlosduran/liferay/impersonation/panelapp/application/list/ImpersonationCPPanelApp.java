package net.carlosduran.liferay.impersonation.panelapp.application.list;

import net.carlosduran.liferay.impersonation.panelapp.constants.ImpersonationCPPanelCategoryKeys;
import net.carlosduran.liferay.impersonation.panelapp.constants.ImpersonationCPPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author cadudu
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + ImpersonationCPPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class ImpersonationCPPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return ImpersonationCPPortletKeys.IMPERSONATIONCP;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + ImpersonationCPPortletKeys.IMPERSONATIONCP + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}