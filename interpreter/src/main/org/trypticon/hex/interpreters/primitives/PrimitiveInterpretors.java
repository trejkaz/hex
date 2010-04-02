/*
 * Hex - a hex viewer and annotator
 * Copyright (C) 2009-2010  Trejkaz, Hex Project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.trypticon.hex.interpreters.primitives;

import org.trypticon.hex.interpreters.Interpretor;

/**
 * Convenience class holding a bunch of instances to primitive interpretors.
 *
 * @author trejkaz
 */
public class PrimitiveInterpretors {
    public static final Interpretor<UShort> UINT16_BE = new UShortInterpretorBE();
    public static final Interpretor<UShort> UINT16_LE = new UShortInterpretorLE();
    public static final Interpretor<UInt> UINT32_BE = new UIntInterpretorBE();
    public static final Interpretor<UInt> UINT32_LE = new UIntInterpretorLE();
    public static final Interpretor<ULong> UINT64_BE = new ULongInterpretorBE();
    public static final Interpretor<ULong> UINT64_LE = new ULongInterpretorLE();
}