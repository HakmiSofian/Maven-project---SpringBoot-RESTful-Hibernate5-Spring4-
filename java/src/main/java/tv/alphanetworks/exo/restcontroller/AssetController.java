package tv.alphanetworks.exo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.alphanetworks.exo.dto.AssetDTO;
import tv.alphanetworks.exo.service.AssetManager;

import java.util.List;


@RestController
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetManager assetManager;


    @GetMapping("/assets")
    public ResponseEntity<List<AssetDTO>> getListAsset() {

        List<AssetDTO> assets = assetManager.lister();
        return new ResponseEntity<>(assets, HttpStatus.OK);

    }


    @GetMapping("/{id}")
    public ResponseEntity<AssetDTO> getAssetById(@PathVariable("id") long id) {
        AssetDTO assetDTO = assetManager.trouver(id);
        return new ResponseEntity<>(assetDTO, HttpStatus.OK);

    }

    @PostMapping("/asset")
    public ResponseEntity<?> postAsset(@RequestBody AssetDTO assetDTO){
        assetManager.creer(assetDTO);
        return ResponseEntity.ok().body("New asset has been added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssetById(@PathVariable("id") long id ){
        assetManager.supprimer(id);
        return ResponseEntity.ok().body("asset was deleted by the ID : " + Long.toString(id));
    }




}
