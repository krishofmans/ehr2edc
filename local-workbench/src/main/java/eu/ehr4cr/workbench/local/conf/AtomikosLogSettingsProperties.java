package eu.ehr4cr.workbench.local.conf;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "atomikos.log")
class AtomikosLogSettingsProperties implements AtomikosLogSettings {
	@NotBlank
	private String dir = "./";
	@NotBlank
	private String name = "tmlog";

	@Override
	public String getDir() {
		return dir;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setName(String name) {
		this.name = name;
	}
}
