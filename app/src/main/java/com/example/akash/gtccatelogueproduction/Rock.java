package com.example.akash.gtccatelogueproduction;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Akash on 7/29/2017.
 */

 public  class Rock implements Parcelable {
 String name;
     int image;
    public Rock(String vName, int vImage){
        this.name=vName;
        this.image=vImage;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.image);
    }

    protected Rock(Parcel in) {
        this.name = in.readString();
        this.image = in.readInt();
    }

    public static final Parcelable.Creator<Rock> CREATOR = new Parcelable.Creator<Rock>() {
        @Override
        public Rock createFromParcel(Parcel source) {
            return new Rock(source);
        }

        @Override
        public Rock[] newArray(int size) {
            return new Rock[size];
        }
    };
}
