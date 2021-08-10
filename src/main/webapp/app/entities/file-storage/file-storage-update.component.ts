import { Component, Vue, Inject } from 'vue-property-decorator';

import { IFileStorage, FileStorage } from '@/shared/model/file-storage.model';
import FileStorageService from './file-storage.service';

const validations: any = {
  fileStorage: {
    name: {},
    countryName: {},
    extension: {},
    fileSize: {},
    hashId: {},
    contentType: {},
    uploadPath: {},
    fileStorageStatus: {},
  },
};

@Component({
  validations,
})
export default class FileStorageUpdate extends Vue {
  @Inject('fileStorageService') private fileStorageService: () => FileStorageService;
  public fileStorage: IFileStorage = new FileStorage();
  public isSaving = false;
  public currentLanguage = '';

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.fileStorageId) {
        vm.retrieveFileStorage(to.params.fileStorageId);
      }
    });
  }

  created(): void {
    this.currentLanguage = this.$store.getters.currentLanguage;
    this.$store.watch(
      () => this.$store.getters.currentLanguage,
      () => {
        this.currentLanguage = this.$store.getters.currentLanguage;
      }
    );
  }

  public save(): void {
    this.isSaving = true;
    if (this.fileStorage.id) {
      this.fileStorageService()
        .update(this.fileStorage)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.fileStorage.updated', { param: param.id });
          return this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Info',
            variant: 'info',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    } else {
      this.fileStorageService()
        .create(this.fileStorage)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('jhipsterSampleApplicationApp.fileStorage.created', { param: param.id });
          this.$root.$bvToast.toast(message.toString(), {
            toaster: 'b-toaster-top-center',
            title: 'Success',
            variant: 'success',
            solid: true,
            autoHideDelay: 5000,
          });
        });
    }
  }

  public retrieveFileStorage(fileStorageId): void {
    this.fileStorageService()
      .find(fileStorageId)
      .then(res => {
        this.fileStorage = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
