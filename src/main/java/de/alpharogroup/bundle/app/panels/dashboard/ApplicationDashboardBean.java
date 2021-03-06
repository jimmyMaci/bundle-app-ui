package de.alpharogroup.bundle.app.panels.dashboard;

import java.io.File;
import java.util.List;
import java.util.Properties;

import de.alpharogroup.collections.pairs.KeyValuePair;
import de.alpharogroup.db.resource.bundles.entities.BundleApplications;
import de.alpharogroup.db.resource.bundles.entities.BundleNames;
import de.alpharogroup.db.resource.bundles.entities.Resourcebundles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ApplicationDashboardBean
{

	private BundleApplications bundleApplication;

	private BundleNames selectedBundleName;

	private Resourcebundles selectedResourcebundle;

	private File resourceBundleToImport;

	private Properties importedProperties;

	private List<KeyValuePair<String, String>> importedKeyValuePairs;

}
