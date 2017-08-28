package de.alpharogroup.bundle.app.panels.dashboard;

import de.alpharogroup.db.resource.bundles.entities.BundleApplications;
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
	/** The flag that signals if next is valid or not. */
//	private boolean validNext;

	private BundleApplications bundleApplication;

}