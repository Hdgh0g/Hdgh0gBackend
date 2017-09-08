package com.hdgh0g.backend.views;

public interface ErrorView {

    interface DefaultView extends
            TitleView,
            DescriptionView,
            DataView {}

    interface TitleView {}
    interface DescriptionView {}
    interface DataView {}
}
