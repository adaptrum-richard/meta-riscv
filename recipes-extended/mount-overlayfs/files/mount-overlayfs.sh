#!/bin/sh
mountpoint -q /mnt
if [ "$?" == 0 ]; then
    if [ ! -e /mnt/etc/upper ]; then
        mkdir -p /mnt/etc/upper
    fi
    if [ ! -e /mnt/etc/work ]; then
        mkdir -p /mnt/etc/work
    fi
    mount -t overlay -o lowerdir=/etc,upperdir=/mnt/etc/upper,workdir=/mnt/etc/work overlay /etc
fi