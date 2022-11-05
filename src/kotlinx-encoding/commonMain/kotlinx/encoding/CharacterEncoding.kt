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
            "csASCII" to US_ASCII,
            "IBM367" to US_ASCII,
            "ISO_646.irv:1991" to US_ASCII,
            "iso-ir-6" to US_ASCII,
            "ISO646-US" to US_ASCII,
            "us" to US_ASCII,
            "US-ASCII" to US_ASCII,
        )
    }
}
