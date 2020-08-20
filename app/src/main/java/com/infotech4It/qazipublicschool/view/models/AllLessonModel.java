package com.infotech4It.qazipublicschool.view.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 18/07/2020.
 */
public class AllLessonModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("border_color")
    @Expose
    private String borderColor;
    @SerializedName("care")
    @Expose
    private String care;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("design")
    @Expose
    private String design;
    @SerializedName("designer")
    @Expose
    private String designer;
    @SerializedName("ground_color")
    @Expose
    private String groundColor;
    @SerializedName("image_1")
    @Expose
    private Object image1;
    @SerializedName("image_2")
    @Expose
    private Object image2;
    @SerializedName("image_3")
    @Expose
    private Object image3;
    @SerializedName("image_4")
    @Expose
    private Object image4;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin")
    @Expose
    private Object origin;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("quantity")
    @Expose
    private Object quantity;
    @SerializedName("shape")
    @Expose
    private Object shape;
    @SerializedName("size_cm")
    @Expose
    private Object sizeCm;
    @SerializedName("size_feet")
    @Expose
    private Object sizeFeet;
    @SerializedName("sku")
    @Expose
    private Object sku;
    @SerializedName("style")
    @Expose
    private String style;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("shipping_info")
    @Expose
    private String shippingInfo;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("chapter")
    @Expose
    private Chapter chapter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getCare() {
        return care;
    }

    public void setCare(String care) {
        this.care = care;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getGroundColor() {
        return groundColor;
    }

    public void setGroundColor(String groundColor) {
        this.groundColor = groundColor;
    }

    public Object getImage1() {
        return image1;
    }

    public void setImage1(Object image1) {
        this.image1 = image1;
    }

    public Object getImage2() {
        return image2;
    }

    public void setImage2(Object image2) {
        this.image2 = image2;
    }

    public Object getImage3() {
        return image3;
    }

    public void setImage3(Object image3) {
        this.image3 = image3;
    }

    public Object getImage4() {
        return image4;
    }

    public void setImage4(Object image4) {
        this.image4 = image4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Object getQuantity() {
        return quantity;
    }

    public void setQuantity(Object quantity) {
        this.quantity = quantity;
    }

    public Object getShape() {
        return shape;
    }

    public void setShape(Object shape) {
        this.shape = shape;
    }

    public Object getSizeCm() {
        return sizeCm;
    }

    public void setSizeCm(Object sizeCm) {
        this.sizeCm = sizeCm;
    }

    public Object getSizeFeet() {
        return sizeFeet;
    }

    public void setSizeFeet(Object sizeFeet) {
        this.sizeFeet = sizeFeet;
    }

    public Object getSku() {
        return sku;
    }

    public void setSku(Object sku) {
        this.sku = sku;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }
}
