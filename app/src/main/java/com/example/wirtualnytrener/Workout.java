package com.example.wirtualnytrener;

import androidx.annotation.NonNull;

public class Workout {
    private String name;
    private String description;

    private Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public static final Workout[] workouts = {
            new Workout("Siła podstawowa",
                    "10 pompek klasycznych, \n20 przysiadów, \n 30 brzuszków"),
            new Workout("Stretching dynamiczny",
                    "5 minut dynamicznych wymachów nóg, \n 15 krążeń ramion, \n" +
                            "10 powtórzeń skrętoskłonów"),
            new Workout("Rozluźnienie i regeneracja",
                    "5 minut lekkiego stretchingu, \n10 sekund deski, \n" +
                            "5 oddechów głębokich"),
            new Workout("Wytrzymałość górnych partii",
                    "5 pompek diamentowych, \n15 unoczeszeń ramion z ciężarem, \n" +
                            "20 sekund w pozycji deski")
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
