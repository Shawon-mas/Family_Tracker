package com.familyTravker.familytracker.LoginApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("is_userexist")
    @Expose
    private Boolean isUserexist;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsUserexist() {
        return isUserexist;
    }

    public void setIsUserexist(Boolean isUserexist) {
        this.isUserexist = isUserexist;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
    public class Data {

        @SerializedName("child_user_id")
        @Expose
        private Integer childUserId;
        @SerializedName("child_user_name")
        @Expose
        private String childUserName;
        @SerializedName("child_user_number")
        @Expose
        private String childUserNumber;
        @SerializedName("child_user_gender")
        @Expose
        private String childUserGender;
        @SerializedName("child_user_email")
        @Expose
        private Object childUserEmail;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("user_number")
        @Expose
        private String userNumber;
        @SerializedName("child_user_created_user_id")
        @Expose
        private String childUserCreatedUserId;
        @SerializedName("child_user_created_time")
        @Expose
        private String childUserCreatedTime;
        @SerializedName("child_user_is_active")
        @Expose
        private String childUserIsActive;
        @SerializedName("child_user_device_id")
        @Expose
        private Object childUserDeviceId;
        @SerializedName("child_user_location_api_status")
        @Expose
        private String childUserLocationApiStatus;
        @SerializedName("child_user_apps_login_active")
        @Expose
        private Object childUserAppsLoginActive;
        @SerializedName("child_user_apps_location_status")
        @Expose
        private Object childUserAppsLocationStatus;
        @SerializedName("child_user_apps_net_status")
        @Expose
        private Object childUserAppsNetStatus;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;

        public Integer getChildUserId() {
            return childUserId;
        }

        public void setChildUserId(Integer childUserId) {
            this.childUserId = childUserId;
        }

        public String getChildUserName() {
            return childUserName;
        }

        public void setChildUserName(String childUserName) {
            this.childUserName = childUserName;
        }

        public String getChildUserNumber() {
            return childUserNumber;
        }

        public void setChildUserNumber(String childUserNumber) {
            this.childUserNumber = childUserNumber;
        }

        public String getChildUserGender() {
            return childUserGender;
        }

        public void setChildUserGender(String childUserGender) {
            this.childUserGender = childUserGender;
        }

        public Object getChildUserEmail() {
            return childUserEmail;
        }

        public void setChildUserEmail(Object childUserEmail) {
            this.childUserEmail = childUserEmail;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserNumber() {
            return userNumber;
        }

        public void setUserNumber(String userNumber) {
            this.userNumber = userNumber;
        }

        public String getChildUserCreatedUserId() {
            return childUserCreatedUserId;
        }

        public void setChildUserCreatedUserId(String childUserCreatedUserId) {
            this.childUserCreatedUserId = childUserCreatedUserId;
        }

        public String getChildUserCreatedTime() {
            return childUserCreatedTime;
        }

        public void setChildUserCreatedTime(String childUserCreatedTime) {
            this.childUserCreatedTime = childUserCreatedTime;
        }

        public String getChildUserIsActive() {
            return childUserIsActive;
        }

        public void setChildUserIsActive(String childUserIsActive) {
            this.childUserIsActive = childUserIsActive;
        }

        public Object getChildUserDeviceId() {
            return childUserDeviceId;
        }

        public void setChildUserDeviceId(Object childUserDeviceId) {
            this.childUserDeviceId = childUserDeviceId;
        }

        public String getChildUserLocationApiStatus() {
            return childUserLocationApiStatus;
        }

        public void setChildUserLocationApiStatus(String childUserLocationApiStatus) {
            this.childUserLocationApiStatus = childUserLocationApiStatus;
        }

        public Object getChildUserAppsLoginActive() {
            return childUserAppsLoginActive;
        }

        public void setChildUserAppsLoginActive(Object childUserAppsLoginActive) {
            this.childUserAppsLoginActive = childUserAppsLoginActive;
        }

        public Object getChildUserAppsLocationStatus() {
            return childUserAppsLocationStatus;
        }

        public void setChildUserAppsLocationStatus(Object childUserAppsLocationStatus) {
            this.childUserAppsLocationStatus = childUserAppsLocationStatus;
        }

        public Object getChildUserAppsNetStatus() {
            return childUserAppsNetStatus;
        }

        public void setChildUserAppsNetStatus(Object childUserAppsNetStatus) {
            this.childUserAppsNetStatus = childUserAppsNetStatus;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

    }
}
