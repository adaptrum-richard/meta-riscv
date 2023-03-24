SUMMARY = "Mount EXT4 partition for overlayfs"
DESCRIPTION = "Script to mount a writable partition to a folder in the squashfs, then mount overlayfs"
LICENSE = "PD"
PR = "r3"

SRC_URI = " \
    file://mount-overlayfs.service \
    file://COPYING \
"

LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=1c3a7fb45253c11c74434676d84fe7dd"

do_install () {
    install -d ${D}${systemd_unitdir}/system/
    install -d ${D}/media/data
    install -m 0644 ${WORKDIR}/mount-overlayfs.service ${D}${systemd_unitdir}/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mount-overlayfs.service"

inherit allarch systemd

FILES_${PN} = "/media/data"
