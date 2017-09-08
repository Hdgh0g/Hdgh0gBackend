package com.hdgh0g.backend.views;

public interface ContactView {

    interface DefaultView extends
            IdView,
            TitleView,
            DescriptionView,
            UrlView,
            ImageView {}

    interface IdView {}
    interface TitleView {}
    interface DescriptionView {}
    interface UrlView {}
    interface ImageView extends com.hdgh0g.backend.views.ImageView.DefaultView {}
}
