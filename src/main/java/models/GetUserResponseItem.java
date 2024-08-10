package models;

import java.util.List;
import lombok.Data;

@Data
public class GetUserResponseItem{
	private long firstLoginTimeInMillis;
	private String tenantId;
	private List<String> privileges;
	private String preferredLocale;
	private String accountType;
	private int groupMask;
	private boolean onboardingExperienceCompleted;
	private List<UserInheritedGroupsItem> userInheritedGroups;
	private long creationTimeInMillis;
	private boolean hidden;
	private CurrentOrg currentOrg;
	private String ownerId;
	private boolean deprecated;
	private long modificationTimeInMillis;
	private String accountStatus;
	private Object homeLiveboard;
	private List<Object> favoriteMetadata;
	private int expirationTimeInMillis;
	private boolean superUser;
	private String id;
	private boolean systemUser;
	private List<Object> incompleteDetails;
	private Object extendedPreferences;
	private String email;
	private boolean welcomeEmailSent;
	private OrgPrivileges orgPrivileges;
	private String visibility;
	private String displayName;
	private String parentType;
	private boolean notifyOnShare;
	private List<Object> tags;
	private boolean showOnboardingExperience;
	private boolean isFirstLogin;
	private boolean external;
	private Object userParameters;
	private boolean deleted;
	private ExtendedProperties extendedProperties;
	private String name;
	private String modifierId;
	private boolean completeDetail;
	private List<OrgsItem> orgs;
	private String authorId;
	private boolean canChangePassword;
	private List<UserGroupsItem> userGroups;
}