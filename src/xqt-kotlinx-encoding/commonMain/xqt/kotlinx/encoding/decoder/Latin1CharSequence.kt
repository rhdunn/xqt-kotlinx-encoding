// Copyright (C) 2022 Reece H. Dunn. SPDX-License-Identifier: Apache-2.0
package xqt.kotlinx.encoding.decoder

import kotlin.experimental.and

/**
 * Creates an ASCII/Latin-1 character sequence over a byte array.
 *
 * Note that this is not the windows-1252 remapping of ISO-8859-1 as specified
 * in the WHATWG Encoding specification for HTML5, but is instead the first 256
 * Unicode characters per the original ISO-8859-1 codepage.
 *
 * @param data The underlying byte array.
 * @param offset The offset of the first byte to read from.
 * @param length The number of bytes in this sequence.
 */
class Latin1CharSequence private constructor(
    private val data: ByteArray,
    private val offset: Int,
    override val length: Int
) : CharSequence {
    constructor(data: ByteArray) : this(data, 0, data.size)

    override fun get(index: Int): Char = when {
        index < 0 || index >= length -> throw IndexOutOfBoundsException(index.toString())
        else -> (data[offset + index] and 0xFF.toByte()).toInt().toChar()
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence = when {
        startIndex < 0 -> throw IndexOutOfBoundsException(startIndex.toString())
        endIndex > length -> throw IndexOutOfBoundsException(endIndex.toString())
        startIndex > endIndex -> throw IllegalArgumentException("$startIndex > $endIndex")
        else -> Latin1CharSequence(data, offset + startIndex, endIndex - startIndex)
    }

    override fun toString(): String = toCharArray().concatToString()
}
