package net.sigmainfo.lf.automation.portal.function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by : Shaishav.s on 22-04-2018. Test class :
 * PortalPropertiesReader.java Description : Reads portal.properties key values
 * declared Includes : 1. Declaration of keys declared in property file 2.
 * Getter and setter methods
 */
@Component
public class PortalPropertiesReader {

	@Value(value = "${Client}")
	private String ClientName;
	@Value(value = "${lenderUrl}")
	private String lenderUrl;
	@Value(value = "${borrowerUrl}")
	private String borrowerUrl;
	@Value(value = "${custom_report_location}")
	private String custom_report_location;
	@Value(value = "${upload_file_location}")
	private String upload_file_location;
	@Value(value = "${browser}")
	private String browser;
	@Value(value = "${lenderUserName}")
	private String lenderUserName;
	@Value(value = "${lenderPassword}")
	private String lenderPassword;
	@Value(value = "${borrowerUsername}")
	private String borrowerUsername;
	@Value(value = "${testdataSourceName}")
	private String testdataSourceName;
	@Value(value = "${mongoHost}")
	private String mongoHost;
	@Value(value = "${mongoPort}")
	private String mongoPort;
	@Value(value = "${mongoDbUser}")
	private String mongoDbUser;
	@Value(value = "${mongoDbPwd}")
	private String mongoDbPwd;
	@Value(value = "${mongoDb}")
	private String mongoDb;
	@Value(value = "${spouceUsername}")
	private String spouceUsername;
	@Value(value = "${nonSpouceUsername}")
	private String nonSpouceUsername;
	@Value(value = "${plaidUsername}")
	private String plaidUsername;
	@Value(value = "${plaidPassword}")
	private String plaidPassword;
	@Value(value = "${platform}")
	private String platform;
	@Value(value = "${Base64Pictures}")
	private String linux_pictures;
	@Value(value = "${Base64Open}")
	private String linux_open;

	public String getClientName() {
		return ClientName;
	}

	public void setClientName(String clientName) {
		ClientName = clientName;
	}

	public String getLinux_pictures() {
		return linux_pictures;
	}

	public void setLinux_pictures(String linux_pictures) {
		this.linux_pictures = linux_pictures;
	}

	public String getLinux_open() {
		return linux_open;
	}

	public void setLinux_open(String linux_open) {
		this.linux_open = linux_open;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlaidUsername() {
		return plaidUsername;
	}

	public void setPlaidUsername(String plaidUsername) {
		this.plaidUsername = plaidUsername;
	}

	public String getPlaidPassword() {
		return plaidPassword;
	}

	public void setPlaidPassword(String plaidPassword) {
		this.plaidPassword = plaidPassword;
	}

	public String getNonSpouceUsername() {
		return nonSpouceUsername;
	}

	public void setNonSpouceUsername(String nonSpouceUsername) {
		this.nonSpouceUsername = nonSpouceUsername;
	}

	public String getSpouceUsername() {
		return spouceUsername;
	}

	public void setSpouceUsername(String spouceUsername) {
		this.spouceUsername = spouceUsername;
	}

	public String getBorrowerUrl() {
		return borrowerUrl;
	}

	public void setBorrowerUrl(String borrowerUrl) {
		this.borrowerUrl = borrowerUrl;
	}

	public String getMongoHost() {
		return mongoHost;
	}

	public void setMongoHost(String mongoHost) {
		this.mongoHost = mongoHost;
	}

	public String getMongoPort() {
		return mongoPort;
	}

	public void setMongoPort(String mongoPort) {
		this.mongoPort = mongoPort;
	}

	public String getMongoDbUser() {
		return mongoDbUser;
	}

	public void setMongoDbUser(String mongoDbUser) {
		this.mongoDbUser = mongoDbUser;
	}

	public String getMongoDbPwd() {
		return mongoDbPwd;
	}

	public void setMongoDbPwd(String mongoDbPwd) {
		this.mongoDbPwd = mongoDbPwd;
	}

	public String getMongoDb() {
		return mongoDb;
	}

	public void setMongoDb(String mongoDb) {
		this.mongoDb = mongoDb;
	}

	public String getTestdataSourceName() {
		return testdataSourceName;
	}

	public void setTestdataSourceName(String testdataSourceName) {
		this.testdataSourceName = testdataSourceName;
	}

	public String getBorrowerUsername() {
		return borrowerUsername;
	}

	public void setBorrowerUsername(String borrowerUsername) {
		this.borrowerUsername = borrowerUsername;
	}

	public String getLenderUserName() {
		return lenderUserName;
	}

	public void setLenderUserName(String lenderUserName) {
		this.lenderUserName = lenderUserName;
	}

	public String getLenderPassword() {
		return lenderPassword;
	}

	public void setLenderPassword(String lenderPassword) {
		this.lenderPassword = lenderPassword;
	}

	public String getLenderUrl() {
		return lenderUrl;
	}

	public void setLenderUrl(String lenderUrl) {
		this.lenderUrl = lenderUrl;
	}

	public String getCustom_report_location() {
		return custom_report_location;
	}

	public void setCustom_report_location(String custom_report_location) {
		this.custom_report_location = custom_report_location;
	}

	public String getUpload_file_location() {
		return upload_file_location;
	}

	public void setUpload_file_location(String upload_file_location) {
		this.upload_file_location = upload_file_location;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
}
