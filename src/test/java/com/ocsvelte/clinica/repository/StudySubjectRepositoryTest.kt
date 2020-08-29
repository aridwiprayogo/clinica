package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.Study
import com.ocsvelte.clinica.model.StudySubject
import com.ocsvelte.clinica.model.UserAccount
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal open class StudySubjectRepositoryTest {
    @Autowired
    lateinit var studySubjectRepository: StudySubjectRepository

    @Test
    fun `doing whatever i want`(){
        val studySubject = StudySubject(
                ownerId = UserAccount(2),
                study = Study(4),
                status = null,
                subject = null,
                label = "5",
                secondaryLabel = "5",
                userId = UserAccount(2),
                ocOid = "SS_5"
        )
        val expected= studySubjectRepository.save(studySubject)
        assertThat(studySubjectRepository.findById(1)).isNotEmpty
        assertThat(expected).isEqualTo(studySubject)
    }
}