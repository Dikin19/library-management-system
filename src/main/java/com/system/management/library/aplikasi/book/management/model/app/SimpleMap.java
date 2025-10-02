package com.system.management.library.aplikasi.book.management.model.app;

import java.util.HashMap;
import java.util.Map;

public class SimpleMap extends HashMap<String, Object> {

    public static SimpleMap createMap() {
        return new SimpleMap();
    }

    public static SimpleMap createMap(String key, Object val) {
        return createMap().add(key, val);
    }

    public SimpleMap add(String key, Object val) {
        this.put(key, val);
        return this;
    }

    public SimpleMap addIfNoExist(String key, Object val) {

            // cek jika map key tidak ada, key ditambahkan
        if (!this.containsKey(key)) {
            this.put(key, val);
        }

        return this;
    }

    public <T> T get(String key, Class<T> tClass) {

        if (!this.containsKey(key))
            return null;
        return tClass.cast(this.get(key));
    }

    public <T> T getOrDefault(String key, T defaultValue, Class<T> tClass) {

        if (!this.containsKey(key))
            return defaultValue;

        return tClass.cast(this.get(key));
    }

    public static SimpleMap from(Map<String, Object> origin) {
        SimpleMap map = new SimpleMap();
        map.putAll(origin);
        return map;
    }

//    Map<String, Object> origin = new HashMap<>();
//    origin.put("nama", "Budi");
//    origin.put("umur", 25);
//
//    SimpleMap map = SimpleMap.from(origin);
//  sekarang `map` berisi {"nama":"Budi", "umur":25}


}
