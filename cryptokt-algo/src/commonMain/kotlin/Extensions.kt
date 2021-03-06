/*
 * SPDX-FileCopyrightText: 2020 William Swartzendruber <wswartzendruber@gmail.com>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.cryptokt.algo

import kotlin.math.ceil

internal inline fun forEachSegment(
    destination: ByteArray,
    destinationOffset: Int,
    source: ByteArray,
    sourceOffset: Int,
    length: Int,
    block: () -> Unit,
): Int {

    var ldo = destinationOffset
    var lso = sourceOffset
    var ll = length

    while (ll > 0) {

        val size = minOf(ll, destination.size - ldo)

        source.copyInto(destination, ldo, lso, lso + size)
        lso += size
        ldo += size
        ll -= size

        if (ldo == destination.size) {
            ldo = 0
            block()
        }
    }

    return ldo
}

//
// ByteArray
//

internal fun ByteArray.beIntAt(index: Int) =
    (this[index].toInt() shl 24) or
        (this[index + 1].toInt() and 255 shl 16) or
        (this[index + 2].toInt() and 255 shl 8) or
        (this[index + 3].toInt() and 255)

internal fun ByteArray.beLongAt(index: Int) =
    (this[index].toLong() shl 56) or
        (this[index + 1].toLong() and 255 shl 48) or
        (this[index + 2].toLong() and 255 shl 40) or
        (this[index + 3].toLong() and 255 shl 32) or
        (this[index + 4].toLong() and 255 shl 24) or
        (this[index + 5].toLong() and 255 shl 16) or
        (this[index + 6].toLong() and 255 shl 8) or
        (this[index + 7].toLong() and 255)

internal fun ByteArray.leIntAt(index: Int) =
    (this[index].toInt() and 255) or
        (this[index + 1].toInt() and 255 shl 8) or
        (this[index + 2].toInt() and 255 shl 16) or
        (this[index + 3].toInt() shl 24)

internal fun ByteArray.leLongAt(index: Int) =
    (this[index].toLong() and 255) or
        (this[index + 1].toLong() and 255 shl 8) or
        (this[index + 2].toLong() and 255 shl 16) or
        (this[index + 3].toLong() and 255 shl 24) or
        (this[index + 4].toLong() and 255 shl 32) or
        (this[index + 5].toLong() and 255 shl 40) or
        (this[index + 6].toLong() and 255 shl 48) or
        (this[index + 7].toLong() shl 56)

//
// Int
//

internal fun Int.copyIntoBe(buffer: ByteArray, offset: Int) {
    buffer[offset] = this.ushr(24).toByte()
    buffer[offset + 1] = this.ushr(16).toByte()
    buffer[offset + 2] = this.ushr(8).toByte()
    buffer[offset + 3] = this.toByte()
}

internal fun Int.copyIntoLe(buffer: ByteArray, offset: Int) {
    buffer[offset] = this.toByte()
    buffer[offset + 1] = this.ushr(8).toByte()
    buffer[offset + 2] = this.ushr(16).toByte()
    buffer[offset + 3] = this.ushr(24).toByte()
}

internal infix fun Int.rl(count: Int) = (this shl count) or (this ushr (32 - count))

internal infix fun Int.rr(count: Int) = (this ushr count) or (this shl (32 - count))

//
// Long
//

internal fun Long.copyIntoBe(buffer: ByteArray, offset: Int) {
    buffer[offset] = this.ushr(56).toByte()
    buffer[offset + 1] = this.ushr(48).toByte()
    buffer[offset + 2] = this.ushr(40).toByte()
    buffer[offset + 3] = this.ushr(32).toByte()
    buffer[offset + 4] = this.ushr(24).toByte()
    buffer[offset + 5] = this.ushr(16).toByte()
    buffer[offset + 6] = this.ushr(8).toByte()
    buffer[offset + 7] = this.toByte()
}

internal fun Long.copyIntoLe(buffer: ByteArray, offset: Int) {
    buffer[offset] = this.toByte()
    buffer[offset + 1] = this.ushr(8).toByte()
    buffer[offset + 2] = this.ushr(16).toByte()
    buffer[offset + 3] = this.ushr(24).toByte()
    buffer[offset + 4] = this.ushr(32).toByte()
    buffer[offset + 5] = this.ushr(40).toByte()
    buffer[offset + 6] = this.ushr(48).toByte()
    buffer[offset + 7] = this.ushr(56).toByte()
}

internal infix fun Long.rl(count: Int) = (this shl count) or (this ushr (64 - count))

internal infix fun Long.rr(count: Int) = (this ushr count) or (this shl (64 - count))
