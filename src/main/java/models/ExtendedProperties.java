package models;

import lombok.Data;

@Data
public class ExtendedProperties{
	private String purchaseOption;
	private String displayNameLastUpdatedBy;
	private String subscriptionType;
	private String cdw;
	private String teamId;
	private String companyName;
	private long activatedAtMs;
	private String source;
	private String tsref;
}