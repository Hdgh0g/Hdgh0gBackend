package com.hdgh0g.backend.views;

public interface ProjectView {

    interface DefaultView extends
            IdView,
            TitleView,
            DescriptionView,
            ImageView {}

    interface IdView {}
    interface TitleView {}
    interface DescriptionView {}
    interface ImageView extends com.hdgh0g.backend.views.ImageView.DefaultView {}

}
