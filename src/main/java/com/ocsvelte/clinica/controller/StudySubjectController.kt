package com.ocsvelte.clinica.controller

import com.ocsvelte.clinica.dto.StudySubjectDto
import com.ocsvelte.clinica.exception.ResourceNotFoundException
import com.ocsvelte.clinica.model.*
import com.ocsvelte.clinica.repository.StatusRepository
import com.ocsvelte.clinica.services.StudyService
import com.ocsvelte.clinica.services.StudySubjectService
import com.ocsvelte.clinica.services.SubjectService
import com.ocsvelte.clinica.services.UserAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
open class StudySubjectController @Autowired constructor(
        private val studySubjectServiceImpl: StudySubjectService,
        private val subjectServiceImpl: SubjectService,
        private val userAccountServiceImpl: UserAccountService,
        private val studyServiceImpl: StudyService,
        private val statusRepository: StatusRepository
) {

    @GetMapping(value = ["/participant"])
    fun getAllStudySubjects(): List<StudySubject?>? = studySubjectServiceImpl.getAllStudySubjects()

    @GetMapping(value = ["/participant/{studySubjectId}"])
    fun getStudySubjectId(@PathVariable("studySubjectId") studySubjectId: Int): StudySubject? {
        return studySubjectServiceImpl.findById(studySubjectId)
                ?.orElseThrow { ResourceNotFoundException("Study subject $studySubjectId not found") }
    }

    @PostMapping(value = ["/participant/subject/{subjectId}/study/{studyId}/status/{statusId}/user/{userId}"])
    fun addStudySubject(
            @RequestBody studySubjectDto: StudySubjectDto?,
            @PathVariable("subjectId") subjectId: Int,
            @PathVariable("studyId") studyId: Int,
            @PathVariable("statusId") statusId: Int,
            @PathVariable("userId") userId: Int
    ): StudySubject? {
        val subject: Subject? = subjectServiceImpl.findById(subjectId = subjectId).orElseThrow {
            ResourceNotFoundException("Subject $subjectId not found")
        }
        val study: Study? = studyServiceImpl.findById(studyId).orElseThrow {
            ResourceNotFoundException("Study $studyId not found")
        }
        val status: Status? = statusRepository.findById(statusId).orElseThrow {
            ResourceNotFoundException("Status $statusId not found")
        }
        val userAccount: UserAccount? = userAccountServiceImpl.findById(userId).orElseThrow {
            ResourceNotFoundException("User Accounts $userId not found")
        }
        val studySubjects = StudySubject(
                label = studySubjectDto?.label!!,
                secondaryLabel = "",
                subject = subject,
                study = study,
                status = status,
                ownerId = userAccount,
                ocOid = studySubjectDto.ocOid
        )
        return studySubjectServiceImpl.save(studySubjects)
    }

    @PutMapping(value = ["/participant/{studySubjectId}"])
    fun updateStudySubject(@PathVariable(value = "studySubjectId") studySubjectId: Int, @RequestBody studySubject: StudySubject?): StudySubject? {
        val studySubjectUpdate = studySubjectServiceImpl.findById(studySubjectId)
                ?.orElseThrow {
                    ResourceNotFoundException("Study subject $studySubjectId not found")
                }
        //need update
        return studySubjectServiceImpl.save(studySubjectUpdate)
    }

    @DeleteMapping(value = ["/participant/{studySubjectId}"])
    fun deleteStudySubject(@PathVariable("studySubjectId") studySubjectId: Int): String {
        val studySubject = studySubjectServiceImpl.findById(studySubjectId)
                ?.orElseThrow { ResourceNotFoundException("Study subject $studySubjectId not found") }
        studySubject?.studySubjectId?.let { studySubjectServiceImpl.deleteById(it) }
        return "Study subject with ID = $studySubjectId deleted"
    }

}