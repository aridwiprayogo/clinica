package com.ocsvelte.clinica.model

import org.hibernate.annotations.CreationTimestamp
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "study_subject", uniqueConstraints = [UniqueConstraint(columnNames = ["oc_oid"])])
@EnableJpaRepositories
data class StudySubject(
        @Id
        @Column(name = "study_subject_id", unique = true, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var studySubjectId: Int = 0,

        @ManyToOne
        @JoinColumn(name = "owner_id",nullable = true)
        var ownerId: UserAccount? = null,

        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "study_id", nullable = true)
        var study: Study? = null,

        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "status_id", nullable = true)
        var status: Status? = null,

        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "subject_id", nullable = true)
        var subject: Subject? = null,

        @Column(name = "label")
        var label: String = "",

        @Column(name = "secondary_label")
        var secondaryLabel: String = "",

        @Column(name = "date_updated")
        var dateUpdated: LocalDateTime = LocalDateTime.now(),

        @Column(name = "update_id")
        var updateId: Int = 0,

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "enrollment_date",nullable = true)
        var enrollmentDate: Date? = null,

        @CreationTimestamp
        @Temporal(TemporalType.TIMESTAMP)
        var dateCreated: Date? = null,

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = true)
        var userId: UserAccount? = null,

        @Column(name = "oc_oid", unique = true, nullable = false, length = 40)
        var ocOid: String? = null
)