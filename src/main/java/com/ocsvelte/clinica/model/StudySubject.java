package com.ocsvelte.clinica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "study_subject", uniqueConstraints = @UniqueConstraint(columnNames = "oc_oid"))
@Data
@EnableJpaRepositories
@NoArgsConstructor
@AllArgsConstructor
public class StudySubject {

    @Id
    @Column(name = "study_subject_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studySubjectId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private UserAccount userAccount;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "study_id")
    private Study study;

//    @Column(name = "status_id")
//    private int status;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private String label;
    private String secondaryLabel;
    private Date dateUpdated;
    private Integer updateId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date enrollmentDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userId;

    @Column(name = "oc_oid", unique = true, nullable = false, length = 40)
    private String ocOid;
}
