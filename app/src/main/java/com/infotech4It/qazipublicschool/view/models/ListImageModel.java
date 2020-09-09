package com.infotech4It.qazipublicschool.view.models;

import java.util.List;

/**
 * Created by Bilal Zaman on 02/09/2020.
 */
public class ListImageModel {
    private List<String> image;

    public ListImageModel(List<String> image) {
        this.image = image;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
