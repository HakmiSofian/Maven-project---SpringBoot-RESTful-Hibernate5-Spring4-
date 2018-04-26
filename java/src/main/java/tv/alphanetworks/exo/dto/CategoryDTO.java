package tv.alphanetworks.exo.dto;

import java.util.List;


public class CategoryDTO {

    private long           id;
    private String         name;

    private List<AssetDTO> assets;

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<AssetDTO> getAssets() {
        return assets;
    }

    public void setAssets( List<AssetDTO> assets ) {
        this.assets = assets;
    }

    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assets=" + assets +
                '}';
    }
}
