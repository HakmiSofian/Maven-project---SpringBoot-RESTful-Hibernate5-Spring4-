package tv.alphanetworks.exo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tv.alphanetworks.exo.dto.AssetDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "asset")
public class Asset implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "asset_id", unique = true )
    private long   id;
    @Column( name = "asset_name" )
    private String name;

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



    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
