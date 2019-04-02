package server;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HeroesNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(HeroesNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String heroNotFoundHandler(HeroesNotFoundException ex){
        return ex.getMessage();
    }
}
