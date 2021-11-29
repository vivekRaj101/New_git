
package com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


@SuppressWarnings("unused")
public class Setting {

    @SerializedName("exerciseaudio")
    private String mExerciseaudio;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("quotations")
    private List<String> mQuotations;
    @SerializedName("restaudio")
    private String mRestaudio;
    @SerializedName("splash")
    private String mSplash;
    @SerializedName("status")
    private String mStatus;

    public String getExerciseaudio() {
        return mExerciseaudio;
    }

    public void setExerciseaudio(String exerciseaudio) {
        mExerciseaudio = exerciseaudio;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<String> getQuotations() {
        return mQuotations;
    }

    public void setQuotations(List<String> quotations) {
        mQuotations = quotations;
    }

    public String getRestaudio() {
        return mRestaudio;
    }

    public void setRestaudio(String restaudio) {
        mRestaudio = restaudio;
    }

    public String getSplash() {
        return mSplash;
    }

    public void setSplash(String splash) {
        mSplash = splash;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
