package com.example.webapp.utility;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class ImagesPath {

    public static Map<Integer, String> images = new HashMap<>();
    public static Map<Integer, String> reactionImages = new HashMap<>();

    static {
        images.put(1, "/img/niko01_circle.png");
        images.put(2, "/img/niko02_circle.png");
        images.put(3, "/img/niko03_circle.png");
        images.put(4, "/img/niko04_circle.png");
        images.put(5, "/img/niko05_circle.png");
        reactionImages.put(1, "/img/Good.png");
        reactionImages.put(2, "/img/heart.png");
        reactionImages.put(3, "/img/niko05_circle.png");
    }

}
