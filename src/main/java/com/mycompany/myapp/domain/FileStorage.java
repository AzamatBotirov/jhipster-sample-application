package com.mycompany.myapp.domain;

import com.mycompany.myapp.domain.enumeration.FileStorageStatus;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A FileStorage.
 */
@Entity
@Table(name = "file_storage")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class FileStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "hash_id")
    private String hashId;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "upload_path")
    private String uploadPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "file_storage_status")
    private FileStorageStatus fileStorageStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FileStorage id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public FileStorage name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public FileStorage countryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getExtension() {
        return this.extension;
    }

    public FileStorage extension(String extension) {
        this.extension = extension;
        return this;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public FileStorage fileSize(Long fileSize) {
        this.fileSize = fileSize;
        return this;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getHashId() {
        return this.hashId;
    }

    public FileStorage hashId(String hashId) {
        this.hashId = hashId;
        return this;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public FileStorage contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUploadPath() {
        return this.uploadPath;
    }

    public FileStorage uploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
        return this;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public FileStorageStatus getFileStorageStatus() {
        return this.fileStorageStatus;
    }

    public FileStorage fileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
        return this;
    }

    public void setFileStorageStatus(FileStorageStatus fileStorageStatus) {
        this.fileStorageStatus = fileStorageStatus;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FileStorage)) {
            return false;
        }
        return id != null && id.equals(((FileStorage) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "FileStorage{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", countryName='" + getCountryName() + "'" +
            ", extension='" + getExtension() + "'" +
            ", fileSize=" + getFileSize() +
            ", hashId='" + getHashId() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", uploadPath='" + getUploadPath() + "'" +
            ", fileStorageStatus='" + getFileStorageStatus() + "'" +
            "}";
    }
}
