package com.balbaxmx.kubernetes.client.model;

import io.kubernetes.client.openapi.models.*;
import lombok.*;

/**
 * @Author: zhangyh
 * @ClassName: Volume
 * @Date: 2020/8/26 16:59
 * @Operation:
 * @Description: ${description}
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Volume {
    private V1AWSElasticBlockStoreVolumeSource awsElasticBlockStore;
    private V1AzureDiskVolumeSource azureDisk;
    private V1AzureFileVolumeSource azureFile;
    private V1CephFSVolumeSource cephfs;
    private V1CinderVolumeSource cinder;
    private V1ConfigMapVolumeSource configMap;
    private V1CSIVolumeSource csi;
    private V1DownwardAPIVolumeSource downwardAPI;
    private V1EmptyDirVolumeSource emptyDir;
    private V1FCVolumeSource fc;
    private V1FlexVolumeSource flexVolume;
    private V1FlockerVolumeSource flocker;
    private V1GCEPersistentDiskVolumeSource gcePersistentDisk;
    private V1GitRepoVolumeSource gitRepo;
    private V1GlusterfsVolumeSource glusterfs;
    private V1HostPathVolumeSource hostPath;
    private V1ISCSIVolumeSource iscsi;
    private String name;
    private V1NFSVolumeSource nfs;
    private V1PersistentVolumeClaimVolumeSource persistentVolumeClaim;
    private V1PhotonPersistentDiskVolumeSource photonPersistentDisk;
    private V1PortworxVolumeSource portworxVolume;
    private V1ProjectedVolumeSource projected;
    private V1QuobyteVolumeSource quobyte;
    private V1RBDVolumeSource rbd;
    private V1ScaleIOVolumeSource scaleIO;
    private V1SecretVolumeSource secret;
    private V1StorageOSVolumeSource storageos;
    private V1VsphereVirtualDiskVolumeSource vsphereVolume;
}
