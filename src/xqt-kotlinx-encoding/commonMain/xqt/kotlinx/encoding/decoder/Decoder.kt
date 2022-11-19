// Copyright (C) 2022 Reece H. Dunn. SPDX-License-Identifier: Apache-2.0
package xqt.kotlinx.encoding.decoder

import xqt.kotlinx.encoding.CharacterEncoding

/**
 * Returns a character sequence over the byte array for the specified encoding.
 */
fun ByteArray.toCharSequence(encoding: CharacterEncoding): CharSequence = when (encoding) {
    CharacterEncoding.ISO_8859_1 -> Latin1CharSequence(this)
    CharacterEncoding.US_ASCII -> Latin1CharSequence(this)
}

/**
 * Returns a character array from the specified character encoding.
 */
fun ByteArray.toCharArray(encoding: CharacterEncoding): CharArray {
    return toCharSequence(encoding).toCharArray()
}

/**
 * Returns a character array from the specified character encoding.
 */
fun ByteArray.toString(encoding: CharacterEncoding): String = toCharArray(encoding).concatToString()

/**
 * Returns a [CharArray] containing characters of this sequence.
 */
fun CharSequence.toCharArray(): CharArray = CharArray(length) { i -> this[i] }

/**
 * Returns a [CharArray] containing characters of this sequence or its substring.
 *
 * @param startIndex the beginning (inclusive) of the substring, 0 by default.
 * @param endIndex the end (exclusive) of the substring, length of this sequence by default.
 *
 * @throws IndexOutOfBoundsException if [startIndex] is less than zero or [endIndex] is greater than the length of this sequence.
 * @throws IllegalArgumentException if [startIndex] is greater than [endIndex].
 */
fun CharSequence.toCharArray(startIndex: Int = 0, endIndex: Int = this.length): CharArray = when {
    startIndex < 0 -> throw IndexOutOfBoundsException(startIndex.toString())
    endIndex > length -> throw IndexOutOfBoundsException(endIndex.toString())
    startIndex > endIndex -> throw IllegalArgumentException("$startIndex > $endIndex")
    else -> CharArray(endIndex - startIndex) { i -> this[startIndex + i] }
}
