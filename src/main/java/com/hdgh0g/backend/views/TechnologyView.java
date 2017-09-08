package com.hdgh0g.backend.views;

public interface TechnologyView {

    interface DefaultView extends
            IdView,
            CaptionView,
            ImageView {}

    interface IdView {}
    interface CaptionView {}
    interface ImageView extends com.hdgh0g.backend.views.ImageView.DefaultView {}
}
