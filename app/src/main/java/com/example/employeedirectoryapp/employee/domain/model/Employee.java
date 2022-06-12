package com.example.employeedirectoryapp.employee.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Employee implements Parcelable {

    @SerializedName("uuid")
    private String employeeId;
    @SerializedName("full_name")
    private String employeeName;
    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("photo_url_small")
    private String smallPicUrl;
    @SerializedName("team")
    private String employeeTeam;

    public Employee(String employeeId, String employeeName, String phoneNumber, String smallPicUrl,
                     String employeeTeam) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.smallPicUrl = smallPicUrl;
        this.employeeTeam = employeeTeam;
    }


    protected Employee(Parcel in) {
        employeeId = in.readString();
        employeeName = in.readString();
        phoneNumber = in.readString();
        smallPicUrl = in.readString();
        employeeTeam = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(employeeId);
        dest.writeString(employeeName);
        dest.writeString(phoneNumber);
        dest.writeString(smallPicUrl);
        dest.writeString(employeeTeam);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSmallPicUrl() {
        return smallPicUrl;
    }

    public void setSmallPicUrl(String smallPicUrl) {
        this.smallPicUrl = smallPicUrl;
    }

    public String getEmployeeTeam() {
        return employeeTeam;
    }

    public void setEmployeeTeam(String employeeTeam) {
        this.employeeTeam = employeeTeam;
    }

    public String getPhoneNumber() {
        return PhoneNumberUtils.formatNumber(phoneNumber, "US");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
