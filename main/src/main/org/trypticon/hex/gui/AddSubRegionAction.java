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

import java.awt.event.ActionEvent;

import org.trypticon.hex.HexViewer;
import org.trypticon.hex.anno.MutableAnnotation;
import org.trypticon.hex.anno.MutableAnnotationCollection;
import org.trypticon.hex.anno.OverlappingAnnotationException;
import org.trypticon.hex.gui.anno.DefaultExtendedGroupAnnotation;
import org.trypticon.hex.gui.notebook.NotebookPane;
import org.trypticon.hex.gui.undo.AddEdit;
import org.trypticon.hex.gui.util.ActionException;

/**
 * Action to add a sub-region.
 *
 * @author trejkaz
 */
public class AddSubRegionAction extends NotebookPaneAction {
    public AddSubRegionAction() {
        Resources.localiseAction(this, "AddSubRegion");
    }

    @Override
    protected void doAction(ActionEvent event, NotebookPane notebookPane) throws Exception {
        HexViewer viewer = notebookPane.getViewer();

        // TODO: Check that it's legal, or have the model throw an exception if it isn't.

        long position = viewer.getSelectionModel().getSelectionStart();
        int length = (int) (viewer.getSelectionModel().getSelectionEnd() - position) + 1;

        MutableAnnotationCollection annotationCollection = notebookPane.getNotebook().getAnnotations();
        MutableAnnotation annotation = new DefaultExtendedGroupAnnotation(position, length, null);

        try {
            annotationCollection.add(annotation);
        } catch (OverlappingAnnotationException e) {
            throw new ActionException(Resources.getMessage("AddSubRegion.Errors.overlap"), e);
        }

        notebookPane.addEdit(new AddEdit(annotationCollection, annotation));
    }
}
