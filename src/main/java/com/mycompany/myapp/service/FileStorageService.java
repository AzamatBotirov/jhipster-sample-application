package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.FileStorage;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link FileStorage}.
 */
public interface FileStorageService {
    /**
     * Save a fileStorage.
     *
     * @param fileStorage the entity to save.
     * @return the persisted entity.
     */
    FileStorage save(FileStorage fileStorage);

    /**
     * Partially updates a fileStorage.
     *
     * @param fileStorage the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FileStorage> partialUpdate(FileStorage fileStorage);

    /**
     * Get all the fileStorages.
     *
     * @return the list of entities.
     */
    List<FileStorage> findAll();

    /**
     * Get the "id" fileStorage.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FileStorage> findOne(Long id);

    /**
     * Delete the "id" fileStorage.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
