package com.ocsvelte.clinica.controller

import com.ocsvelte.clinica.repository.StatusRepository
import com.ocsvelte.clinica.services.StudyService
import com.ocsvelte.clinica.services.StudySubjectService
import com.ocsvelte.clinica.services.SubjectService
import com.ocsvelte.clinica.services.UserAccountService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class StudySubjectControllerTest {
    @MockBean private lateinit var studySubjectServiceImpl: StudySubjectService
    @MockBean private lateinit var subjectServiceImpl: SubjectService
    @MockBean private lateinit var userAccountServiceImpl: UserAccountService
    @MockBean private lateinit var studyServiceImpl: StudyService
    @MockBean private lateinit var statusRepository: StatusRepository
    //SUT
    @Autowired
    private lateinit var studySubjectController: StudySubjectController

    @Test
    fun contextLoad(){
        Assertions.assertThat(studySubjectController).isNotNull
    }

    @Test
    fun addStudySubject() {

    }
}