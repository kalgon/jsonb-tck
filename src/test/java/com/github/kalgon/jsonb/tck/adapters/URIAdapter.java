package com.github.kalgon.jsonb.tck.adapters;

import java.net.URI;

public class URIAdapter extends AbstractToStringAdapter<URI> {

    @Override
    public URI nullSafeAdaptFromJson(String obj) throws Exception {
        return new URI(obj);
    }
}
