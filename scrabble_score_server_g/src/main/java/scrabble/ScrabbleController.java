package scrabble;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScrabbleController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/word")
    public Scrabble word(@RequestParam(value="word", defaultValue="World") String word) {
        Scrabble newWord = new Scrabble(counter.incrementAndGet(), word);
        newWord.setScore();
        return newWord;
    }
}