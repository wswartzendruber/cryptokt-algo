/*
 * SPDX-FileCopyrightText: 2020 William Swartzendruber <wswartzendruber@gmail.com>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.cryptokt.algo

/**
 * Represents the possible digest sizes for SHA2-512.
 */
public enum class Sha512DigestSize(
    internal val digestSize: Int,
    internal val rc: Int,
    internal val cr: LongArray,
) {
    /** SHA2-512/224. The digest size is 28 bytes. */
    _224(
        28,
        3,
        longArrayOf(
            -8341449602262348382, 8350123849800275158,
            2160240930085379202, 7466358040605728719,
            1111592415079452072, 8638871050018654530,
            4583966954114332360, 1230299281376055969,
        ),
    ),
    /** SHA2-512/256. The digest size is 32 bytes. */
    _256(
        32,
        3,
        longArrayOf(
            2463787394917988140, -6965556091613846334,
            2563595384472711505, -7622211418569250115,
            -7626776825740460061, -4729309413028513390,
            3098927326965381290, 1060366662362279074,
        ),
    ),
    /** SHA2-384. The digest size is 48 bytes. */
    _384(
        48,
        5,
        longArrayOf(
            -3766243637369397544, 7105036623409894663,
            -7973340178411365097, 1526699215303891257,
            7436329637833083697, -8163818279084223215,
            -2662702644619276377, 5167115440072839076,
        ),
    ),
    /** SHA2-512. The digest size is 64 bytes. */
    _512(
        64,
        7,
        longArrayOf(
            7640891576956012808, -4942790177534073029,
            4354685564936845355, -6534734903238641935,
            5840696475078001361, -7276294671716946913,
            2270897969802886507, 6620516959819538809,
        ),
    ),
}
