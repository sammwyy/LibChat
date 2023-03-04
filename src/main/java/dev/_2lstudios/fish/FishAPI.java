package dev._2lstudios.fish;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dev._2lstudios.fish.adapters.BooleanTypeAdapter;

public class FishAPI {
    public final static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(Boolean.class, new BooleanTypeAdapter())
            .create();
}
