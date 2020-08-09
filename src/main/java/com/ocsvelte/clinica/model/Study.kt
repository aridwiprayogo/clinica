package com.ocsvelte.clinica.model

import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.persistence.*

@Entity
@Table(name="study")
@EnableJpaRepositories
data class Study(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "study_id", unique = true, nullable = false)
        private val studyId: Int = 0
)