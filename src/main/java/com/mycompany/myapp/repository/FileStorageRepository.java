package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.FileStorage;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the FileStorage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Long> {}
