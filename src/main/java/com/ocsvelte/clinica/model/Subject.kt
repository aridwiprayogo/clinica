package com.ocsvelte.clinica.model

import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.persistence.*

@Entity
@Table(name = "study")
@EnableJpaRepositories
data class Subject(
        @Id
        @Column(name = "subject_id", unique = true, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val subjectId: Int = 0
//        @OneToMany(mappedBy = "subject")
//        val studySubject: List<StudySubject> = listOf()
        //    @ManyToOne(fetch = FetchType.LAZY)
        //    @JoinColumn(name = "owner_id")
        //    private UserAccount ownerId;
)