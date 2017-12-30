package inn.shopping.api.entity;


public class ExpertTop {
	private String id;
	private String userId;
	private String topTitle;
	private String expertName;
	private String expertDiscriptionShort;
	private String expertPortraitUrl;
	private String expertWechatNumber;
	private String expertExperience;
	private String expertTelNumber;
	private String motto;
	private String expertDisplayPicList;
	private String expertDiscriptionDetail;
	private Integer deleteFlag;
	private String insertTime;
	private String updateTime;

	// private List<String> displayPicList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getTopTitle() {
		return topTitle;
	}

	public void setTopTitle(String topTitle) {
		this.topTitle = topTitle == null ? null : topTitle.trim();
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName == null ? null : expertName.trim();
	}

	public String getExpertDiscriptionShort() {
		return expertDiscriptionShort;
	}

	public void setExpertDiscriptionShort(String expertDiscriptionShort) {
		this.expertDiscriptionShort = expertDiscriptionShort == null ? null
				: expertDiscriptionShort.trim();
	}

	public String getExpertPortraitUrl() {
		return expertPortraitUrl;
	}

	public void setExpertPortraitUrl(String expertPortraitUrl) {
		this.expertPortraitUrl = expertPortraitUrl;
	}

	public String getExpertWechatNumber() {
		return expertWechatNumber;
	}

	public void setExpertWechatNumber(String expertWechatNumber) {
		this.expertWechatNumber = expertWechatNumber == null ? null
				: expertWechatNumber.trim();
	}

	public String getExpertExperience() {
		return expertExperience;
	}

	public void setExpertExperience(String expertExperience) {
		this.expertExperience = expertExperience == null ? null
				: expertExperience.trim();
	}

	public String getExpertTelNumber() {
		return expertTelNumber;
	}

	public void setExpertTelNumber(String expertTelNumber) {
		this.expertTelNumber = expertTelNumber == null ? null : expertTelNumber
				.trim();
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto == null ? null : motto.trim();
	}

	public String getExpertDisplayPicList() {
		return expertDisplayPicList;
	}

	public void setExpertDisplayPicList(String expertDisplayPicList) {
		this.expertDisplayPicList = expertDisplayPicList;
		// this.displayPicList = (expertDisplayPicList == null) ? null :
		// Arrays.asList(expertDisplayPicList.split(","));
	}

	public String getExpertDiscriptionDetail() {
		return expertDiscriptionDetail;
	}

	public void setExpertDiscriptionDetail(String expertDiscriptionDetail) {
		this.expertDiscriptionDetail = expertDiscriptionDetail == null ? null
				: expertDiscriptionDetail.trim();
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	// public List<String> getDisplayPicList() {
	// return displayPicList;
	// }
	//
	// public void setDisplayPicList(List<String> displayPicList) {
	// this.displayPicList = displayPicList;
	// }
}