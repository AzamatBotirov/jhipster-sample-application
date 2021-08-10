import { FileStorageStatus } from '@/shared/model/enumerations/file-storage-status.model';
export interface IFileStorage {
  id?: number;
  name?: string | null;
  countryName?: string | null;
  extension?: string | null;
  fileSize?: number | null;
  hashId?: string | null;
  contentType?: string | null;
  uploadPath?: string | null;
  fileStorageStatus?: FileStorageStatus | null;
}

export class FileStorage implements IFileStorage {
  constructor(
    public id?: number,
    public name?: string | null,
    public countryName?: string | null,
    public extension?: string | null,
    public fileSize?: number | null,
    public hashId?: string | null,
    public contentType?: string | null,
    public uploadPath?: string | null,
    public fileStorageStatus?: FileStorageStatus | null
  ) {}
}
