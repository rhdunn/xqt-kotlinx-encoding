// Copyright (C) 2022 Reece H. Dunn. SPDX-License-Identifier: Apache-2.0
package kotlinx.encoding

/**
 * A character encoding.
 *
 * @param mimeName The IANA preferred MIME name.
 * @param ianaName The registered IANA name.
 *
 * @see <a href="https://www.iana.org/assignments/character-sets/character-sets.xhtml">www.iana.org/assignments/character-sets/character-sets.xhtml</a>
 */
enum class CharacterEncoding(val mimeName: String, val ianaName: String) {
    /**
     * The latin 1 character encoding.
     *
     * @see <a href="https://www.iana.org/go/rfc1345">RFC1345</a>
     */
    ISO_8859_1("ISO-8859-1", "ISO-8859-1:1987"),
    /**
     * The ANSI X3.4-1986 character encoding.
     *
     * @see <a href="https://www.iana.org/go/rfc2046">RFC2046</a>
     */
    US_ASCII("US-ASCII", "US-ASCII");
    companion object {
        /**
         * A map of IANA character set aliases to the corresponding character encoding.
         *
         * This mapping is case-sensitive.
         *
         * @see <a href="https://www.iana.org/assignments/character-sets/character-sets.xhtml">www.iana.org/assignments/character-sets/character-sets.xhtml</a>
         */
        val ianaAliases = mapOf(
            "ANSI_X3.4-1968" to US_ASCII,
            "ANSI_X3.4-1986" to US_ASCII,
            "cp367" to US_ASCII,
            "CP819" to ISO_8859_1,
            "csASCII" to US_ASCII,
            "csISOLatin1" to ISO_8859_1,
            "IBM367" to US_ASCII,
            "IBM819" to ISO_8859_1,
            "ISO_646.irv:1991" to US_ASCII,
            "ISO_8859-1" to ISO_8859_1,
            "ISO-8859-1" to ISO_8859_1,
            "iso-ir-6" to US_ASCII,
            "iso-ir-100" to ISO_8859_1,
            "ISO646-US" to US_ASCII,
            "latin1" to ISO_8859_1,
            "l1" to ISO_8859_1,
            "us" to US_ASCII,
            "US-ASCII" to US_ASCII,
        )
    }
}
