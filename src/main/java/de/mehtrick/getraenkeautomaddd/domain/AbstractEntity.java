package de.mehtrick.getraenkeautomaddd.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@SuperBuilder
public class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @CreatedDate
    private LocalDateTime defTime;

    @LastModifiedDate
    private LocalDateTime modTime;



}
