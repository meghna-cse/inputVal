package com.inputvalidation.springphonebook.repository;

import com.inputvalidation.springphonebook.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    //retrieve all audit logs
    List<AuditLog> findAll();
}
