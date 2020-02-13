
package com.example.mvptraining.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseListRecipes {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("from")
    private Long mFrom;

    public List<Hit> getmHits() {
        return mHits;
    }

    public void setmHits(List<Hit> mHits) {
        this.mHits = mHits;
    }

    @SerializedName("hits")
    private List<Hit> mHits;
    @SerializedName("more")
    private Boolean mMore;
    @SerializedName("q")
    private String mQ;
    @SerializedName("to")
    private Long mTo;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public Long getFrom() {
        return mFrom;
    }

    public void setFrom(Long from) {
        mFrom = from;
    }

    public Boolean getMore() {
        return mMore;
    }

    public void setMore(Boolean more) {
        mMore = more;
    }

    public String getQ() {
        return mQ;
    }

    public void setQ(String q) {
        mQ = q;
    }

    public Long getTo() {
        return mTo;
    }

    public void setTo(Long to) {
        mTo = to;
    }

}
