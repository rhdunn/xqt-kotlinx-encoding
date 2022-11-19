// Copyright (C) 2022 Reece H. Dunn. SPDX-License-Identifier: Apache-2.0
package kotlinx.encoding.test.decoder

import kotlinx.encoding.decoder.Latin1CharSequence
import xqt.kotlinx.test.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@Suppress("JoinDeclarationAndAssignment")
@DisplayName("The ASCII/Latin 1 CharSequence decoder")
class TheAsciiLatin1CharSequenceDecoder {
    @Test
    @DisplayName("can be constructed from a byte sequence")
    fun can_be_constructed_from_a_byte_sequence() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq = Latin1CharSequence(data)

        assertEquals(10, seq.length)
        assertEquals("0123456789", seq.toString())

        assertEquals('0', seq[0])
        assertEquals('9', seq[9])
    }

    @Test
    @DisplayName("can return subsequences of the original sequence")
    fun can_return_subsequences_of_the_original_sequence() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq1 = Latin1CharSequence(data)
        val seq2 = seq1.subSequence(2, 8)

        assertEquals(6, seq2.length)
        assertEquals("234567", seq2.toString())

        assertEquals('2', seq2[0])
        assertEquals('7', seq2[5])

        assertEquals(0, seq1.subSequence(10, 10).length)
        assertEquals("", seq1.subSequence(10, 10).toString())
    }

    @Test
    @DisplayName("can return subsequences of a subsequence")
    fun can_return_subsequences_of_a_subsequence() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq1 = Latin1CharSequence(data)
        val seq2 = seq1.subSequence(2, 8)
        val seq3 = seq2.subSequence(2, 5)

        assertEquals(3, seq3.length)
        assertEquals("456", seq3.toString())

        assertEquals('4', seq3[0])
        assertEquals('6', seq3[2])
    }

    @Test
    @DisplayName("throws IndexOutOfBoundsException for invalid subsequence arguments")
    fun throws_index_out_of_bounds_exception_for_invalid_subsequence_arguments() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq = Latin1CharSequence(data)
        var e: Throwable

        e = assertFailsWith<IndexOutOfBoundsException> { seq.subSequence(-1, 0) }
        assertEquals("-1", e.message)

        e = assertFailsWith<IndexOutOfBoundsException> { seq.subSequence(11, 11) }
        assertEquals("11", e.message)

        e = assertFailsWith<IndexOutOfBoundsException> { seq.subSequence(0, 11) }
        assertEquals("11", e.message)

        e = assertFailsWith<IndexOutOfBoundsException> { seq.subSequence(1, 11) }
        assertEquals("11", e.message)

        e = assertFailsWith<IllegalArgumentException> { seq.subSequence(6, 4) }
        assertEquals("6 > 4", e.message)
    }

    @Test
    @DisplayName("throws IndexOutOfBoundsException for invalid indices")
    fun throws_index_out_of_bounds_exception_for_invalid_indices() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq = Latin1CharSequence(data)
        var e: IndexOutOfBoundsException

        e = assertFailsWith { seq[-1] }
        assertEquals("-1", e.message)

        e = assertFailsWith { seq[10] }
        assertEquals("10", e.message)
    }

    @Test
    @DisplayName("throws IndexOutOfBoundsException for invalid indices on subsequences")
    fun throws_index_out_of_bounds_exception_for_invalid_indices_on_subsequences() {
        val data = byteArrayOf(0x30, 0x31, 0x32, 0x33, 0x34, 0x35, 0x36, 0x37, 0x38, 0x39)
        val seq1 = Latin1CharSequence(data)
        val seq2 = seq1.subSequence(2, 8)
        var e: IndexOutOfBoundsException

        e = assertFailsWith { seq2[-1] }
        assertEquals("-1", e.message)

        e = assertFailsWith { seq2[6] }
        assertEquals("6", e.message)
    }
}
