package tv.alphanetworks.exo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.exo.dto.CategoryDTO;
import tv.alphanetworks.exo.service.CategoryManager;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryCotroller {
    @Autowired
    private CategoryManager categoryManager;


    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getListAsset() {

        List<CategoryDTO> category = categoryManager.lister();
        return new ResponseEntity<>(category, HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getAssetById(@PathVariable("id") long id) {
        CategoryDTO categoryDTO = categoryManager.trouver(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);

    }

    @PostMapping("/category")
    public ResponseEntity<?> postAsset(@RequestBody CategoryDTO categoryDTO){
        categoryManager.creer(categoryDTO);
        return ResponseEntity.ok().body("New category has been added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssetById(@PathVariable("id") long id ){
        categoryManager.supprimer(id);
        return ResponseEntity.ok().body("category was deleted by the ID : " + Long.toString(id));
    }
}
