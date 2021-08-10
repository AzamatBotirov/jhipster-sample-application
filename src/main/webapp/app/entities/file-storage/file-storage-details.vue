<template>
  <div class="row justify-content-center">
    <div class="col-8">
      <div v-if="fileStorage">
        <h2 class="jh-entity-heading" data-cy="fileStorageDetailsHeading">
          <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.detail.title')">FileStorage</span> {{ fileStorage.id }}
        </h2>
        <dl class="row jh-entity-details">
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.name')">Name</span>
          </dt>
          <dd>
            <span>{{ fileStorage.name }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.countryName')">Country Name</span>
          </dt>
          <dd>
            <span>{{ fileStorage.countryName }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.extension')">Extension</span>
          </dt>
          <dd>
            <span>{{ fileStorage.extension }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.fileSize')">File Size</span>
          </dt>
          <dd>
            <span>{{ fileStorage.fileSize }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.hashId')">Hash Id</span>
          </dt>
          <dd>
            <span>{{ fileStorage.hashId }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.contentType')">Content Type</span>
          </dt>
          <dd>
            <span>{{ fileStorage.contentType }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.uploadPath')">Upload Path</span>
          </dt>
          <dd>
            <span>{{ fileStorage.uploadPath }}</span>
          </dd>
          <dt>
            <span v-text="$t('jhipsterSampleApplicationApp.fileStorage.fileStorageStatus')">File Storage Status</span>
          </dt>
          <dd>
            <span v-text="$t('jhipsterSampleApplicationApp.FileStorageStatus.' + fileStorage.fileStorageStatus)">{{
              fileStorage.fileStorageStatus
            }}</span>
          </dd>
        </dl>
        <button type="submit" v-on:click.prevent="previousState()" class="btn btn-info" data-cy="entityDetailsBackButton">
          <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
        </button>
        <router-link
          v-if="fileStorage.id"
          :to="{ name: 'FileStorageEdit', params: { fileStorageId: fileStorage.id } }"
          custom
          v-slot="{ navigate }"
        >
          <button @click="navigate" class="btn btn-primary">
            <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
          </button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script lang="ts" src="./file-storage-details.component.ts"></script>
