package com.daon.onorder;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

@GlideModule
public class MyGlide extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}

