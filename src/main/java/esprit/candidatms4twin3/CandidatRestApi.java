package esprit.candidatms4twin3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidats")
public class CandidatRestApi {
    public String title="Hello from candidat4TWIN3";
    @Autowired
    private ICandidat _candidat;
    @RequestMapping("/hello")
    public String getTitle()    {
        return title;
    }
    @GetMapping
    public List<Candidat> allCandidat(){
        return  _candidat.allCandidat();
    }
    @PostMapping
    public Candidat saveCandidat(@RequestBody  Candidat c) {
        return _candidat.addCandidat(c);
    }
    // GET http://localhost:8080/candidats/{id}
    @GetMapping("/{id}")
    public Candidat getCandidat(@PathVariable int id) {
        return _candidat.getCandidatById(id);
    }



    // PUT http://localhost:8080/candidats/{id}
    @PutMapping("/{id}")
    public Candidat updateCandidat(@PathVariable int id,
                                   @RequestBody Candidat c) {
        return _candidat.updateCandidat(id, c);
    }

    // DELETE http://localhost:8080/candidats/{id}
    @DeleteMapping("/{id}")
    public void deleteCandidat(@PathVariable int id) {
        _candidat.deleteCandidat(id);
    }
}
