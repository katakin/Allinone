package com.example.allinone.network;

import com.example.allinone.util.ErrorException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by katakin on 22/07/17.
 */

public class CustomTypeAdapterFactory implements TypeAdapterFactory {

    private static final String ERROR = "error";

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementTypeAdapter = gson.getAdapter(JsonElement.class);


        return new TypeAdapter<T>() {
            @Override
            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            @Override
            public T read(JsonReader in) throws IOException {
                JsonElement jsonElement = elementTypeAdapter.read(in);
                if (jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has(ERROR)) {
                        String errorJson = jsonObject.get(ERROR).toString();
                        throw new ErrorException(errorJson);
                    }
                }
                return delegate.fromJsonTree(jsonElement);
            }

        }.nullSafe();
    }
}