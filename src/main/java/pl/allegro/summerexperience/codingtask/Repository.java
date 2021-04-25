package pl.allegro.summerexperience.codingtask;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Repository {

    private String name;

    @JsonProperty("stargazers_count")
    private int numberOfStars;

    public Repository(String name, int numberOfStars) {
        this.name = name;
        this.numberOfStars = numberOfStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
}

