require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc


LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
    git://github.com/u-boot/u-boot.git;protocol=https;branch=master \
"

# v2023.04-rc3
SRCREV = "e8c80ac0f7a13bf0fc016ce324b870c0cff7a2b8"
SRC_URI[sha256sum] = "a29704a4ed1f5da901286226485358b26c45ddbd68372872362e7dd826cb53bb"
DEPENDS:append:riscv64 = " opensbi"

DEPENDS:append = " \
    u-boot-tools-native \
    python3-setuptools-native \
"

do_configure[depends] += "${@bb.utils.contains('EXTRA_IMAGEDEPENDS', 'opensbi', 'opensbi:do_deploy', '',d)}"

do_compile:prepend:riscv64() {
    export OPENSBI=${DEPLOY_DIR_IMAGE}/fw_dynamic.bin
}

UBOOT_MACHINE ?= "sifive_unmatched_defconfig"
TOOLCHAIN = "gcc"
COMPATIBLE_MACHINE = "(sifive-unmatched)"
