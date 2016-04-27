package com.kewen.example.util;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/4/26.
 * 实现Parcelable传递数据比Serializable快
 *
 * FristActivity中
 * Stuff stuff = new Stuff();
 * stuff.setId(1);
 * stuff.setName("Tom");
 * stuff.setVersion(1);
 * Intent intent = new Intent(FristActivity.this, SecondActivity.class);
 * intent.putExtra("stuff_data", stuff);
 * startActivity(intent);
 *
 *SecondActivity中
 * Stuff stuff = (Stuff)getIntent().getPercelableExtra("stuff_data");
 *
 *
 *
 */
public class Stuff implements Parcelable{

    private String id;
    private String name;
    private String version;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(version);
    }

    public static final Creator<Stuff> CREATOR = new Creator<Stuff>() {
        @Override
        public Stuff createFromParcel(Parcel in) {
            return new Stuff(in);
        }

        @Override
        public Stuff[] newArray(int size) {
            return new Stuff[size];
        }
    };

    protected Stuff(Parcel in) {
        id = in.readString();
        name = in.readString();
        version = in.readString();
    }

}
