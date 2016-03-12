package com.rajat.e_subzi.Objects;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceObject implements Parcelable {
    String token="";
    String deviceType;
    String email;
    String  deviceId;

    public DeviceObject(String token, String deviceType, String email, String deviceId) {
        this.token = token;
        this.deviceType = deviceType;
        this.email = email;
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    protected DeviceObject(Parcel in) {
        token = in.readString();
        deviceType = in.readString();
        email = in.readString();
        deviceId = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
        dest.writeString(deviceType);
        dest.writeString(email);
        dest.writeString(deviceId);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DeviceObject> CREATOR = new Parcelable.Creator<DeviceObject>() {
        @Override
        public DeviceObject createFromParcel(Parcel in) {
            return new DeviceObject(in);
        }

        @Override
        public DeviceObject[] newArray(int size) {
            return new DeviceObject[size];
        }
    };
}