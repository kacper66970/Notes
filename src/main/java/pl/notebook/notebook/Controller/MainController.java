package pl.notebook.notebook.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.notebook.notebook.Model.Note;
import pl.notebook.notebook.Repository.NoteRepository;

@Controller
public class MainController {
    
    @Autowired
    NoteRepository noteRepository;
    
    
    @GetMapping("/")
    public String start(Model model){
        List<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);
        model.addAttribute("note", new Note());
        return "index";
    }
    
    @PostMapping("/add")
    public String addForm(@ModelAttribute Note note, Model model){
        this.noteRepository.save(note);
        return "redirect:/";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam Long id){
        noteRepository.deleteById(id);
        System.getenv("PORT");
        return "redirect:/";
   }
    
}
