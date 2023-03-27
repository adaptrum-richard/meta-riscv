SUMMARY = "Mount EXT4 partition for overlayfs"
DESCRIPTION = "Script to mount a writable partition to a folder in the squashfs, then mount overlayfs"
LICENSE = "GPL-2.0-only"
PV = "1"
PR = "r0"

SRC_URI = " \
    file://mount-overlayfs.service \
    file://mount-overlayfs.sh \
    file://COPYING \
"

LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=bfc6ebee232840149bb284eb334816e2"

do_install () {
    install -d ${D}${systemd_unitdir}/system/
    install -d ${D}/${sbindir}
    install -m 644 ${WORKDIR}/mount-overlayfs.service ${D}${systemd_system_unitdir}
    install -m 0777 ${WORKDIR}/mount-overlayfs.sh ${D}${sbindir}
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "mount-overlayfs.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

inherit systemd

FILES:${PN} += " \
    ${systemd_system_unitdir}/mount-overlayfs.service \
    ${systemd_unitdir}/system/mount-overlayfs.sh \
"
