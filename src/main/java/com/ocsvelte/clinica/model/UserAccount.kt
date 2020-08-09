package com.ocsvelte.clinica.model

import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.persistence.*

@Entity
@Table(name="user_account")
@EnableJpaRepositories
data class UserAccount(
        @Id
        @Column(name = "user_id", unique = true, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val userId: Int = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "owner_id")
        val userAccount: UserAccount? = null

        // @OneToMany(mappedBy = "ownerId")
        //    private List<StudySubject> studySubjectList;
)