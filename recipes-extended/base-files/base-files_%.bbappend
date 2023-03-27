FILESEXTRAPATHS:append:sifive-unmatched := "${THISDIR}/files:"
SRC_URI:append:sifive-unmatched = " file://fstab"

do_install:append:sifive-unmatched() {
	install -m 0644 ${S}/fstab ${D}${sysconfdir}/fstab
}
