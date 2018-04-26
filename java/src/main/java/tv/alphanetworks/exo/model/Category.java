package tv.alphanetworks.exo.model;

import tv.alphanetworks.exo.dto.AssetDTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "category_id", unique = true )
    private long           id;
    @Column( name = "category_name" )
    private String         name;

    @ManyToMany(cascade= { CascadeType.ALL })
    @JoinTable(
            name= "category_asset",
            joinColumns = {@JoinColumn(name = "category_id")},
            inverseJoinColumns = {@JoinColumn(name = "asset_id")}
    )
    private List<Asset> assets;

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

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets( List<Asset> assets ) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", assets=" + assets +
                '}';
    }
}
