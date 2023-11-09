package com.inputvalidation.springphonebook.auditing;

import com.inputvalidation.springphonebook.model.AuditLog;
import com.inputvalidation.springphonebook.repository.AuditLogRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AuditLogAspect {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Pointcut("@annotation(com.inputvalidation.springphonebook.auditing.Auditable)")
    public void auditable(){

    }

    @Around("auditable()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        String ipAddress = request.getRemoteAddr();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();

        String username = request.getUserPrincipal() == null ? "anonymous" : request.getUserPrincipal().getName();
        String action = "User " + username + " called " + className + "." + methodName + "()";
        LocalDateTime timestamp = LocalDateTime.now();
        String processedData = result.toString();

        AuditLog auditLog = new AuditLog(ipAddress,username,processedData,action,timestamp);
        auditLogRepository.save(auditLog);

        return joinPoint.proceed();
    }
}
