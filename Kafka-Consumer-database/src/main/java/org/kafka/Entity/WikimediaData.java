package org.kafka.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="wikimedia_recent_date")
@Getter
@Setter
public class WikimediaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column( length = 100000 )
    private String wikimediaData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWikimediaData() {
        return wikimediaData;
    }

    public void setWikimediaData(String wikimediaData) {
        this.wikimediaData = wikimediaData;
    }
}
