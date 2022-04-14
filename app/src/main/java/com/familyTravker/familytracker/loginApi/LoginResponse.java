package com.familyTravker.familytracker.loginApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {


@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("active_status")
@Expose
private Boolean activeStatus;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private Integer data;
@SerializedName("status_code")
@Expose
private Integer statusCode;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public Boolean getActiveStatus() {
return activeStatus;
}

public void setActiveStatus(Boolean activeStatus) {
this.activeStatus = activeStatus;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public Integer getData() {
return data;
}

public void setData(Integer data) {
this.data = data;
}

public Integer getStatusCode() {
return statusCode;
}

public void setStatusCode(Integer statusCode) {
this.statusCode = statusCode;
}


}
