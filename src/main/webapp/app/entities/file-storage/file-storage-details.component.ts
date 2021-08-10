import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFileStorage } from '@/shared/model/file-storage.model';
import FileStorageService from './file-storage.service';

@Component
export default class FileStorageDetails extends Vue {
  @Inject('fileStorageService') private fileStorageService: () => FileStorageService;
  public fileStorage: IFileStorage = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fileStorageId) {
        vm.retrieveFileStorage(to.params.fileStorageId);
      }
    });
  }

  public retrieveFileStorage(fileStorageId) {
    this.fileStorageService()
      .find(fileStorageId)
      .then(res => {
        this.fileStorage = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
