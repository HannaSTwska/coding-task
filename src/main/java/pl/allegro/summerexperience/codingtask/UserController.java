package pl.allegro.summerexperience.codingtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public User read(@RequestParam(value = "name", defaultValue = "octocat") String name) {
        var repositories = getRepositoriesForUserWith(name);
        return new User(name, repositories);
    }

    private List<Repository> getRepositoriesForUserWith(String name) {
        String url = "https://api.github.com/users/" + name + "/repos";
        Class<Repository[]> responseType = Repository[].class;

        try {
            ResponseEntity<Repository[]> response = restTemplate.getForEntity(url, responseType);

            return Arrays.asList(response.getBody());
        }
        catch (Exception exception) {
            System.out.println(name + "not found");

            return Collections.emptyList();
        }
    }
}

