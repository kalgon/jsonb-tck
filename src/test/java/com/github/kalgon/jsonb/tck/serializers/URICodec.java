package com.github.kalgon.jsonb.tck.serializers;

import java.net.URI;

public class URICodec implements Codec<URI>, ToStringSerializer<URI>, FromStringDeserializer<URI> {

    @Override
    public URI deserialize(String obj) {
        return URI.create(obj);
    }
}
