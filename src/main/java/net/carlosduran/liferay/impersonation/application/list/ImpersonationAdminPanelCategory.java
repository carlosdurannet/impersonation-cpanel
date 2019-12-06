package net.carlosduran.liferay.impersonation.application.list;

import net.carlosduran.liferay.impersonation.constants.ImpersonationAdminPanelCategoryKeys;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.Locale;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author carlos
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_USERS,
		"panel.category.order:Integer=100"
	},
	service = PanelCategory.class
)
public class ImpersonationAdminPanelCategory extends BasePanelCategory {

	@Override
	public String getKey() {
		return ImpersonationAdminPanelCategoryKeys.CONTROL_PANEL_CATEGORY;
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return LanguageUtil.get(resourceBundle, "category.tools.label");
	}

}