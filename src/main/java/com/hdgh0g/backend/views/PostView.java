package com.hdgh0g.backend.views;

public interface PostView {

    interface ListView extends
            IdView,
            TitleView,
            CreationTimeView,
            TagsView,
            CutTextView {}

    interface FullView extends
            IdView,
            TitleView,
            CreationTimeView,
            TagsView,
            FullTextView {}

    interface IdView{}
    interface TitleView{}
    interface CreationTimeView{}
    interface FullTextView {}
    interface TagsView {}
    interface CutTextView {}
}
