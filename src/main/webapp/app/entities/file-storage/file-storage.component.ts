import { mixins } from 'vue-class-component';

import { Component, Vue, Inject } from 'vue-property-decorator';
import Vue2Filters from 'vue2-filters';
import { IFileStorage } from '@/shared/model/file-storage.model';

import FileStorageService from './file-storage.service';

@Component({
  mixins: [Vue2Filters.mixin],
})
export default class FileStorage extends Vue {
  @Inject('fileStorageService') private fileStorageService: () => FileStorageService;
  private removeId: number = null;

  public fileStorages: IFileStorage[] = [];

  public isFetching = false;

  public mounted(): void {
    this.retrieveAllFileStorages();
  }

  public clear(): void {
    this.retrieveAllFileStorages();
  }

  public retrieveAllFileStorages(): void {
    this.isFetching = true;
    this.fileStorageService()
      .retrieve()
      .then(
        res => {
          this.fileStorages = res.data;
          this.isFetching = false;
        },
        err => {
          this.isFetching = false;
        }
      );
  }

  public handleSyncList(): void {
    this.clear();
  }

  public prepareRemove(instance: IFileStorage): void {
    this.removeId = instance.id;
    if (<any>this.$refs.removeEntity) {
      (<any>this.$refs.removeEntity).show();
    }
  }

  public removeFileStorage(): void {
    this.fileStorageService()
      .delete(this.removeId)
      .then(() => {
        const message = this.$t('jhipsterSampleApplicationApp.fileStorage.deleted', { param: this.removeId });
        this.$bvToast.toast(message.toString(), {
          toaster: 'b-toaster-top-center',
          title: 'Info',
          variant: 'danger',
          solid: true,
          autoHideDelay: 5000,
        });
        this.removeId = null;
        this.retrieveAllFileStorages();
        this.closeDialog();
      });
  }

  public closeDialog(): void {
    (<any>this.$refs.removeEntity).hide();
  }
}
