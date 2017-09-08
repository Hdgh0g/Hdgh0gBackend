package com.hdgh0g.backend.views;

public interface ImageView {

    interface DefaultView extends
            IdView,
            UrlView,
            ThumbnailUrlView {}

    interface IdView{}
    interface UrlView{}
    interface ThumbnailUrlView{}
}
