package com.retrolad.ch07.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "developer")
@NamedQueries({
        @NamedQuery(name = "Developer.findAllWithGame",
                    query = "select distinct d from Developer d " +
                            "left join fetch d.games g " +
                            "left join fetch d.cities c"),
        @NamedQuery(name = "Developer.findById",
                    query = "select d from Developer d " +
                            "left join fetch d.games g " +
                            "left join fetch d.cities c " +
                            "where d.id = :id")
})
public class Developer implements Serializable {

    private Long id;
    private String name;
    private Date founded;
    private int version;
    private Set<Game> games = new HashSet<>();
    private Set<City> cities = new HashSet<>();
    
    // IDENTITY means id is generated by RDBMS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Temporal allows to use java.util.Date which
    // will farther be converted to java.sql.Date
    @Temporal(TemporalType.DATE)
    @Column(name = "founded")
    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    // mappedBy point's to 'developer' property of 'Game' class
    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL,
                orphanRemoval = true)
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    // joinColumns - foreign key column of the join table, which
    // references entity owning this association (developer)
    // inverseJoinColumns - foreign key references entity, that
    // this association does not own
    @ManyToMany
    @JoinTable(name = "developer_city",
            joinColumns = @JoinColumn(name="developer_id"),
            inverseJoinColumns = @JoinColumn(name="city_id"))
    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", founded=" + founded +
                ", version=" + version +
                '}';
    }
}
