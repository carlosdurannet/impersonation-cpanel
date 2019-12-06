package net.carlosduran.liferay.impersonation.application.list;

import net.carlosduran.liferay.impersonation.constants.ImpersonationAdminPanelCategoryKeys;
import net.carlosduran.liferay.impersonation.constants.ImpersonationAdminPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author carlos
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + ImpersonationAdminPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class ImpersonationAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return ImpersonationAdminPortletKeys.IMPERSONATIONADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + ImpersonationAdminPortletKeys.IMPERSONATIONADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}