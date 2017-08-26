package youtudedemo.app.com.logindemomvp.model;


import android.os.Parcel;
import android.os.Parcelable;

public class LoginListResponse implements Parcelable{

    private String id;
    private String name;
    private String phone_number;
    private String subject;

    protected LoginListResponse(Parcel in) {
        id = in.readString();
        name = in.readString();
        phone_number = in.readString();
        subject = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(phone_number);
        dest.writeString(subject);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LoginListResponse> CREATOR = new Creator<LoginListResponse>() {
        @Override
        public LoginListResponse createFromParcel(Parcel in) {
            return new LoginListResponse(in);
        }

        @Override
        public LoginListResponse[] newArray(int size) {
            return new LoginListResponse[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
