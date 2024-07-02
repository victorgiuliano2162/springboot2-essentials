package academy.devdojo.springboot2.controller;


import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;


@RestController //adiciona responsebody a todos os métodos
@RequestMapping("anime") //o path da url
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    //Injeção de dependências na prática
    //@Autowired o ideal é fazer através do construtor
    private final DateUtil dateUtil; // = new DateUtil();
    //Não parece ser boa ideia instanciar o objeto aqui, especialmente se este objeto chamar outros objetos

    //Este seria o procedimento correto,
    //mas usar a anotação AllArgsConstructor funcionaria
    //public AnimeController(DateUtil dateUtil) {
    //    this.dateUtil = new DateUtil();
    //}
    //No entanto, podemos usar a @RequiredArgsConstructor

    //localhost:8080/anime/list
    //@RequestMapping(method = RequestMethod.GET, path = "list") depreciado
    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDataTimeToDataBaseStyle(LocalDateTime.now()));
        return List.of(new Anime("DBZ"), new Anime("Berserk"));
        //Isso ainda não é suficiente para devolver um json a solicitações feitas pelo navegador
    }
}
