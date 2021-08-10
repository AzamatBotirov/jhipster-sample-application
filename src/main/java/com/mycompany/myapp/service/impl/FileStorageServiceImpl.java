package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.FileStorage;
import com.mycompany.myapp.repository.FileStorageRepository;
import com.mycompany.myapp.service.FileStorageService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link FileStorage}.
 */
@Service
@Transactional
public class FileStorageServiceImpl implements FileStorageService {

    private final Logger log = LoggerFactory.getLogger(FileStorageServiceImpl.class);

    private final FileStorageRepository fileStorageRepository;

    public FileStorageServiceImpl(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
    }

    @Override
    public FileStorage save(FileStorage fileStorage) {
        log.debug("Request to save FileStorage : {}", fileStorage);
        return fileStorageRepository.save(fileStorage);
    }

    @Override
    public Optional<FileStorage> partialUpdate(FileStorage fileStorage) {
        log.debug("Request to partially update FileStorage : {}", fileStorage);

        return fileStorageRepository
            .findById(fileStorage.getId())
            .map(
                existingFileStorage -> {
                    if (fileStorage.getName() != null) {
                        existingFileStorage.setName(fileStorage.getName());
                    }
                    if (fileStorage.getCountryName() != null) {
                        existingFileStorage.setCountryName(fileStorage.getCountryName());
                    }
                    if (fileStorage.getExtension() != null) {
                        existingFileStorage.setExtension(fileStorage.getExtension());
                    }
                    if (fileStorage.getFileSize() != null) {
                        existingFileStorage.setFileSize(fileStorage.getFileSize());
                    }
                    if (fileStorage.getHashId() != null) {
                        existingFileStorage.setHashId(fileStorage.getHashId());
                    }
                    if (fileStorage.getContentType() != null) {
                        existingFileStorage.setContentType(fileStorage.getContentType());
                    }
                    if (fileStorage.getUploadPath() != null) {
                        existingFileStorage.setUploadPath(fileStorage.getUploadPath());
                    }
                    if (fileStorage.getFileStorageStatus() != null) {
                        existingFileStorage.setFileStorageStatus(fileStorage.getFileStorageStatus());
                    }

                    return existingFileStorage;
                }
            )
            .map(fileStorageRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FileStorage> findAll() {
        log.debug("Request to get all FileStorages");
        return fileStorageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FileStorage> findOne(Long id) {
        log.debug("Request to get FileStorage : {}", id);
        return fileStorageRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete FileStorage : {}", id);
        fileStorageRepository.deleteById(id);
    }
}
