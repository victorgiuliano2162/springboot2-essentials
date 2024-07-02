package academy.devdojo.springboot2.controller;


import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController //adiciona responsebody a todos os métodos
@RequestMapping("animes") //o path da url
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    //Injeção de dependências na prática
    //@Autowired o ideal é fazer através do construtor
    private final DateUtil dateUtil; // = new DateUtil();
    private final AnimeService animeService;
    //Não parece ser boa ideia instanciar o objeto aqui, especialmente se este objeto chamar outros objetos

    //Este seria o procedimento correto,
    //mas usar a anotação AllArgsConstructor funcionaria
    //public AnimeController(DateUtil dateUtil) {
    //    this.dateUtil = new DateUtil();
    //}
    //No entanto, podemos usar a @RequiredArgsConstructor

    //localhost:8080/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list") depreciado
    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDataTimeToDataBaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
        //Isso ainda não é suficiente para devolver um json a solicitações feitas pelo navegador
    }

    @GetMapping(path = "{id}") //vamos usar path variables
    public ResponseEntity<Anime> findById(@PathVariable long id) {
        log.info(dateUtil.formatLocalDataTimeToDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED) outra opção para retornar o status
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED); //status 201
    }
}
