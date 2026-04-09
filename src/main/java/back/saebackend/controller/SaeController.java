package back.saebackend.controller;
import back.saebackend.model.Sae;
import back.saebackend.service.SaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saes")
@CrossOrigin(origins = "*") // INDISPENSABLE pour que ton mobile puisse se connecter
public class SaeController {

    @Autowired
    private SaeService service;

    @GetMapping
    public List<Sae> getSaes() {
        return service.getAllSaesSorted();
    }

    @PostMapping
    public Sae addSae(@RequestBody Sae sae) {
        return service.saveSae(sae);
    }
}