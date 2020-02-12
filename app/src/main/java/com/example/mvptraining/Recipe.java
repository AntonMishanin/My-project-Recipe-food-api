
package com.example.mvptraining;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Recipe {

    @SerializedName("calories")
    private Double mCalories;
    @SerializedName("cautions")
    private List<String> mCautions;
    @SerializedName("dietLabels")
    private List<Object> mDietLabels;
  //  @SerializedName("digest")
   // private List<Digest> mDigest;
    @SerializedName("healthLabels")
    private List<String> mHealthLabels;
    @SerializedName("image")
    private String mImage;
    @SerializedName("ingredientLines")
    private List<String> mIngredientLines;
   // @SerializedName("ingredients")
   // private List<Ingredient> mIngredients;
    @SerializedName("label")
    private String mLabel;
    @SerializedName("shareAs")
    private String mShareAs;
    @SerializedName("source")
    private String mSource;
   // @SerializedName("totalDaily")
    //private TotalDaily mTotalDaily;
   // @SerializedName("totalNutrients")
    //private TotalNutrients mTotalNutrients;
    @SerializedName("totalTime")
    private Double mTotalTime;
    @SerializedName("totalWeight")
    private Double mTotalWeight;
    @SerializedName("uri")
    private String mUri;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("yield")
    private Double mYield;

    public Double getCalories() {
        return mCalories;
    }

    public void setCalories(Double calories) {
        mCalories = calories;
    }

    public List<String> getCautions() {
        return mCautions;
    }

    public void setCautions(List<String> cautions) {
        mCautions = cautions;
    }

    public List<Object> getDietLabels() {
        return mDietLabels;
    }

    public void setDietLabels(List<Object> dietLabels) {
        mDietLabels = dietLabels;
    }

  //

    public List<String> getHealthLabels() {
        return mHealthLabels;
    }

    public void setHealthLabels(List<String> healthLabels) {
        mHealthLabels = healthLabels;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public List<String> getIngredientLines() {
        return mIngredientLines;
    }

    public void setIngredientLines(List<String> ingredientLines) {
        mIngredientLines = ingredientLines;
    }

   //

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public String getShareAs() {
        return mShareAs;
    }

    public void setShareAs(String shareAs) {
        mShareAs = shareAs;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String source) {
        mSource = source;
    }

  //

   //

    public Double getTotalTime() {
        return mTotalTime;
    }

    public void setTotalTime(Double totalTime) {
        mTotalTime = totalTime;
    }

    public Double getTotalWeight() {
        return mTotalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        mTotalWeight = totalWeight;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        mUri = uri;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Double getYield() {
        return mYield;
    }

    public void setYield(Double yield) {
        mYield = yield;
    }

}
