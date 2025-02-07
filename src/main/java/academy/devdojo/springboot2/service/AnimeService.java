package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AnimeService {

    private static List<Anime> animes;
    //O service sera responsável pela regra de negócio

    static {
        animes = new ArrayList<>(List.of(new Anime(1l, "DBZ"), new Anime(2l, "Berserk")));
    }

    //private final AnimeRepository animeRepository
    public List<Anime> listAll() {
        return animes;
    }

    public Anime findById(long id) {
        return animes
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 1_000_000));
        animes.add(anime);
        return anime;
    }
}
