SUMMARY = "start a test demo"
DESCRIPTION = "launch the demo after overlay folder is mounted"
LICENSE = "PD"
PR = "r3"

SRC_URI = " \
    file://test-app.service \
    file://COPYING \
"

LIC_FILES_CHKSUM = "file://${WORKDIR}/COPYING;md5=1c3a7fb45253c11c74434676d84fe7dd"

do_install () {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/test-app.service ${D}${systemd_unitdir}/system
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "test-app.service"

inherit allarch systemd
