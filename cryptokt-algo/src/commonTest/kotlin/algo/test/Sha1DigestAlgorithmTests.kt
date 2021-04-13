/*
 * Any copyright is dedicated to the Public Domain.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package org.cryptokt.algo.test

import org.cryptokt.algo.Sha1DigestAlgorithm

class Sha1DigestAlgorithmTests : DigestAlgorithmTests() {

    val digests = mapOf(

        "".toByteArrayFromAscii()
        to
        "da39a3ee5e6b4b0d3255bfef95601890afd80709",

        "a".toByteArrayFromAscii()
        to
        "86f7e437faa5a7fce15d1ddcb9eaeaea377667b8",

        "abc".toByteArrayFromAscii()
        to
        "a9993e364706816aba3e25717850c26c9cd0d89d",

        "message digest".toByteArrayFromAscii()
        to
        "c12252ceda8be8994d5fa0290a47231c1d16aae3",

        "abcdefghijklmnopqrstuvwxyz".toByteArrayFromAscii()
        to
        "32d10c7b8cf96570ca04ce37f2a19d84240d3a89",

        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toByteArrayFromAscii()
        to
        "761c457bf73b14d27e9e9265c46f4b4dda11f940",

        "12345678901234567890123456789012345678901234567890123456789012345678901234567890"
            .toByteArrayFromAscii()
        to
        "50abf5706a150990a08b2c5ea40fa0e585554732",
    )

    override val configurations = mapOf(
        DigestAlgorithmConfiguration({ Sha1DigestAlgorithm() }, "SHA-1") to digests,
    )
}
