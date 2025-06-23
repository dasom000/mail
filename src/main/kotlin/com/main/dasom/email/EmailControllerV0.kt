package com.main.dasom.email

import com.main.dasom.email.dto.ContactForm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ContactController(
    private val mailService: EmailService
){
    @PostMapping("/contact")
    fun sendMail(@RequestBody form: ContactForm): ResponseEntity<String>{
        mailService.sendEmail(form)
        return ResponseEntity.ok("이메일이 전송되었습니다.")
    }
}