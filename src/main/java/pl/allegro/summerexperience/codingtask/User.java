package pl.allegro.summerexperience.codingtask;

import java.util.Collection;

public class User {
    private String name;

    private Collection<Repository> repositories;

    public int getTotalStars() {
        int totalStars = 0;
        for (var repository : repositories) {
            totalStars += repository.getNumberOfStars();
        }
        return totalStars;
    }

    public String getName() {
        return name;
    }

    public Collection<Repository> getRepositories() {
        return repositories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRepositories(Collection<Repository> repositories) {
        this.repositories = repositories;
    }

    public User(String name, Collection<Repository> repositories) {
        this.name = name;
        this.repositories = repositories;
    }
}
