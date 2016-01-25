package com.olivermaerz.grido;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by omaerz
 */
public class Trailer implements Parcelable {
    public String name;
    public String size;
    public String source;

    // write strings into parcel
    public Trailer(String name, String size, String source){
        this.name = name;
        this.size = size;
        this.source = source;

    }

    // receive the parcel
    private Trailer(Parcel in) {
        this.name = in.readString();
        this.size = in.readString();
        this.source = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.size);
        dest.writeString(this.source);
    }


    public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
        // calls our new constructor an pass along the un-marshaled `Parcel` and then return the new object
        @Override
        public Trailer createFromParcel(Parcel in) {
            return new Trailer(in);
        }

        @Override
        public Trailer[] newArray(int size) {
            return new Trailer[size];
        }
    };
}
