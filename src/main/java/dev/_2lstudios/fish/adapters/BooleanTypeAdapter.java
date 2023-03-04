package dev._2lstudios.fish.adapters;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class BooleanTypeAdapter extends TypeAdapter<Boolean> {
    @Override
    public void write(JsonWriter out, Boolean value) throws IOException {
        if (value) {
            out.value(value);
        } else {
            out.nullValue();
        }
    }

    @Override
    public Boolean read(JsonReader in) throws IOException {
        return in.nextBoolean();
    }

}
