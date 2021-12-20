
package pl.notebook.notebook.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.notebook.notebook.Model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{
    
}
