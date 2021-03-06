/*
 * Hex - a hex viewer and annotator
 * Copyright (C) 2009-2014  Trejkaz, Hex Project
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

package org.trypticon.hex.gui;

import java.util.logging.Level;
import javax.swing.UIManager;

import org.trypticon.hex.util.LoggerUtils;

/**
 * Utility class for bootstrapping LAF-specific settings.
 *
 * @author trejkaz
 */
class PLAFBootstrap {

    void init(HexApplication application) {
        String systemLAF = UIManager.getSystemLookAndFeelClassName();

        try {
            // com.apple.laf is definitely the case on SnowLeopard.  I think apple.laf must have been from Leopard.
            if ("com.apple.laf.AquaLookAndFeel".equals(systemLAF) ||
                "apple.laf.AquaLookAndFeel".equals(systemLAF)) {
                new MacPLAFBootstrap().init(application);
                return;
            }

            // Other special cases go here as needed.

        } catch (Exception e) {
            LoggerUtils.get().log(Level.WARNING, "Unexpected error initialising custom LAF, falling back to generic", e);
        }

        initGeneric();
    }


    /**
     * Initialises the generic look and feel.
     */
    private void initGeneric() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LoggerUtils.get().log(Level.WARNING, "Unexpected error initialising platform LAF, falling back to default", e);
        }
    }
}
