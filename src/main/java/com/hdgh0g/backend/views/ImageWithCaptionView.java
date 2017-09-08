package com.hdgh0g.backend.views;

public interface ImageWithCaptionView {

    interface DefaultView extends
            IdView,
            ImageView,
            CaptionView {}

    interface IdView{}
    interface ImageView extends com.hdgh0g.backend.views.ImageView.DefaultView {}
    interface CaptionView {}
}
