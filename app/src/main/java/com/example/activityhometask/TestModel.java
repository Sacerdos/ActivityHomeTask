package com.example.activityhometask;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestModel implements Parcelable {


    private String firstString = "gdn";
    private String secondString;
    private List<String> firstList;
    private List<String> secondList;


    protected TestModel(Parcel in) {
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            String firstString = in.readString();
            String secondString = in.readString();
            ArrayList<String> firstList = in.readArrayList(String.class.getClassLoader());
            ArrayList<String> secondList = in.readArrayList(String.class.getClassLoader());
            return new TestModel(firstString, secondString, firstList, secondList);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    public TestModel(String firstString,
                     String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public TestModel(String firstString,
                     String secondString,
                     List<String> firstList,
                     List<String> secondList) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.firstList = (ArrayList<String>)firstList;
        this.secondList = (ArrayList<String>)secondList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getFirstString() {
        return firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public List<String> getFirstList() {
        return firstList;
    }

    public List<String> getSecondList() {
        return secondList;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstString);
        dest.writeString(secondString);

        dest.writeList(firstList);
        dest.writeList(secondList);
    }
}
