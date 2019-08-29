package com.mbps.cd.fileservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ShenggeFan
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
