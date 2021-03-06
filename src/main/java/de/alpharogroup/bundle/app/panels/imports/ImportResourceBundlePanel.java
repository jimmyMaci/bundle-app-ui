package de.alpharogroup.bundle.app.panels.imports;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.Properties;

import com.google.common.eventbus.Subscribe;

import de.alpharogroup.bundle.app.MainApplication;
import de.alpharogroup.bundle.app.MainFrame;
import de.alpharogroup.bundle.app.panels.dashboard.ApplicationDashboardBean;
import de.alpharogroup.bundle.app.spring.SpringApplicationContext;
import de.alpharogroup.db.resource.bundles.entities.BundleApplications;
import de.alpharogroup.db.resource.bundles.entities.BundleNames;
import de.alpharogroup.model.BaseModel;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.resourcebundle.locale.LocaleExtensions;
import de.alpharogroup.resourcebundle.locale.LocaleResolver;
import de.alpharogroup.swing.base.BasePanel;
import de.alpharogroup.swing.table.model.properties.PropertiesTableModel;
import de.alpharogroup.swing.table.model.properties.StringKeyValueTableModel;
import lombok.Getter;

@Getter
public class ImportResourceBundlePanel extends BasePanel<ApplicationDashboardBean>
{

	private static final long serialVersionUID = 1L;

    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancelUp;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnImportUp;
    private javax.swing.JLabel lblHeaderOverview;
    private javax.swing.JScrollPane srcBundles;
    private javax.swing.JTable tblBundles;

    private StringKeyValueTableModel tableModel;

	ImportResourceBundlePanel()
	{
		super(BaseModel.<ApplicationDashboardBean> of(ApplicationDashboardBean.builder().build()));
	}

	public ImportResourceBundlePanel(final Model<ApplicationDashboardBean> model)
	{
		super(model);
	}


	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

        lblHeaderOverview = new javax.swing.JLabel();
        srcBundles = new javax.swing.JScrollPane();
        tblBundles = new javax.swing.JTable();
        btnCancelUp = new javax.swing.JButton();
        btnImportUp = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();

        lblHeaderOverview.setText("Overview of resource bundle to import");

        tableModel = new StringKeyValueTableModel();
        tblBundles.setModel(tableModel);
        srcBundles.setViewportView(tblBundles);

        btnCancelUp.setText("Cancel");
        btnCancelUp.addActionListener(e -> onCancel(e));

        btnImportUp.setText("Import");
        btnImportUp.addActionListener(e -> onImport(e));

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(e -> onCancel(e));

        btnImport.setText("Import");
        btnImport.addActionListener(e -> onImport(e));
	}

	@Override
	protected void onBeforeInitialize()
	{
		super.onBeforeInitialize();
		MainApplication.get().getApplicationEventBus().register(this);
	}

	protected void onCancel(final ActionEvent e)
	{
		// TODO return to bundle app view...
	}
	protected void onImport(final ActionEvent e)
	{
		// <dimport the properties to the db...

		final String baseName = LocaleResolver.resolveBundlename(getModelObject().getResourceBundleToImport());
		final Locale locale = LocaleResolver.resolveLocale(getModelObject().getResourceBundleToImport());
		final BundleNames bundleName = SpringApplicationContext.get().getResourcebundlesService().updateProperties(getModelObject().getImportedProperties(), baseName, locale, true);
		final BundleApplications bundleApplication = getModelObject().getBundleApplication();
		bundleApplication.addBundleName(bundleName);
		SpringApplicationContext.get().getBundleApplicationsService().merge(bundleApplication);
	}

	@Subscribe
	public void onReloadProperties(final ApplicationDashboardBean applicationDashboardBean) {
		tableModel.getData().clear();
		tableModel.addList(applicationDashboardBean.getImportedKeyValuePairs());
		revalidate();
	}


	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();

        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeaderOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srcBundles, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelUp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImportUp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImport, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblHeaderOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelUp)
                    .addComponent(btnImportUp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(srcBundles, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnImport))
                .addContainerGap(48, Short.MAX_VALUE))
        );
	}

}
