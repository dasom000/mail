package com.main.dasom.email


import com.main.dasom.email.dto.ContactForm
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val mailSender: JavaMailSender
) {
    @Value("\${mail.to}") // application.yml 또는 .properties에 설정
    private lateinit var toAddress: String

    // 이메일 발송 함수
    fun sendEmail(form: ContactForm){
        val message = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, false, "UTF-8")

        helper.setTo(toAddress)
        helper.setFrom("gysoft.gy@gmail.com")
        helper.setSubject("배달 플러스 문의 : ${form.name}")
        helper.setText(
            """
            이름 : ${form.name}
            연락처 : ${form.tel}
            문의 내용 : ${form.inquiry}
            지역 : ${form.region}
            """.trimIndent(),
            false // HTML 아님
        )

        mailSender.send (message)
    }
}