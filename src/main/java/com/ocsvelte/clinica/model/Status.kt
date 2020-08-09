package com.ocsvelte.clinica.model

import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "status", uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("status_id"))])
@EnableJpaRepositories
data class Status(
        @Id
        @Column(name = "status_id", unique = true, nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val statusId: Int = 0,
        val name: String = "",
        val description: String = ""
) : Serializable {

}