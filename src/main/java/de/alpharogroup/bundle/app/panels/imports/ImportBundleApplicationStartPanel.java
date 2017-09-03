/*
 * Copyright 2017 Alpha Ro Group UG (haftungsbeschrängt).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.alpharogroup.bundle.app.panels.imports;

import de.alpharogroup.design.pattern.state.wizard.model.WizardModelStateMachine;
import de.alpharogroup.model.api.Model;
import de.alpharogroup.swing.wizard.BaseWizardContentPanel;

/**
 *
 * @author astrapi69
 */
public class ImportBundleApplicationStartPanel extends BaseWizardContentPanel<ImportWizardModel>
{

	private static final long serialVersionUID = 1L;

	private javax.swing.JButton btnChooseRootDir;
	private javax.swing.JLabel lblBundleAppName;
	private javax.swing.JLabel lblChooseRootDir;
	private javax.swing.JLabel lblHeaderChooseBundleAppName;
	private javax.swing.JLabel lblWelcomeImportHeader;
	private javax.swing.JTextField txtBundleAppName;

	public ImportBundleApplicationStartPanel(
		Model<WizardModelStateMachine<ImportWizardModel>> model)
	{
		super(model);
	}

	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();

		lblWelcomeImportHeader = new javax.swing.JLabel();
		lblBundleAppName = new javax.swing.JLabel();
		txtBundleAppName = new javax.swing.JTextField();
		lblHeaderChooseBundleAppName = new javax.swing.JLabel();
		btnChooseRootDir = new javax.swing.JButton();
		lblChooseRootDir = new javax.swing.JLabel();

		lblWelcomeImportHeader
			.setText("Import of an existing application with the bundle-manager ");

		lblBundleAppName.setText("Application name");

		lblHeaderChooseBundleAppName.setText("Give your imported bundle-application a name");

		btnChooseRootDir.setText("Choose root directory");

		lblChooseRootDir.setText("Choose the root directory of your project");
	};

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();

		final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
					.createSequentialGroup()
					.addComponent(lblHeaderChooseBundleAppName,
						javax.swing.GroupLayout.PREFERRED_SIZE, 395,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addGap(0, 0, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGroup(layout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
					.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(lblWelcomeImportHeader,
							javax.swing.GroupLayout.PREFERRED_SIZE, 473,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(lblBundleAppName, javax.swing.GroupLayout.PREFERRED_SIZE,
								236, javax.swing.GroupLayout.PREFERRED_SIZE)
							.addGap(18, 18, 18).addComponent(txtBundleAppName,
								javax.swing.GroupLayout.PREFERRED_SIZE, 460,
								javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addGroup(layout.createSequentialGroup()
						.addComponent(lblChooseRootDir, javax.swing.GroupLayout.PREFERRED_SIZE, 309,
							javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
							javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChooseRootDir, javax.swing.GroupLayout.PREFERRED_SIZE, 271,
							javax.swing.GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
				.addComponent(lblWelcomeImportHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
					javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(lblHeaderChooseBundleAppName, javax.swing.GroupLayout.PREFERRED_SIZE,
					24, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(txtBundleAppName, javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
					.addComponent(lblBundleAppName, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
						javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(btnChooseRootDir).addComponent(lblChooseRootDir))
				.addContainerGap(113, Short.MAX_VALUE)));
	};
}
