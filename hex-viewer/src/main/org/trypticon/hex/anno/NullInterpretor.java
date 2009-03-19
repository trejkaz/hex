/*
 * Hex - a hex viewer and annotator
 * Copyright (C) 2009  Trejkaz, Hex Project
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

package org.trypticon.hex.anno;

import org.trypticon.binary.Binary;

/**
 * An interpretor which can mark a range as meaning nothing.  Useful for
 * when you have a non-semantic comment with no value, such as "reserved",
 * or "I don't know what this is."
 *
 * @author trejkaz
 */
public class NullInterpretor implements Interpretor<NullValue> {
    private final int length;

    public NullInterpretor(int length) {
        this.length = length;
    }

    public Class<NullValue> getType() {
        return NullValue.class;
    }

    public NullValue interpret(Binary binary, long position) {
        return new NullValue(length);
    }
}
