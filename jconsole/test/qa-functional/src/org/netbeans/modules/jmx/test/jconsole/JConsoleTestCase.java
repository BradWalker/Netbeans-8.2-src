/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 2004-2005 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */

package org.netbeans.modules.jmx.test.jconsole;

import javax.swing.Action;
import org.netbeans.core.output2.ui.AbstractOutputTab;
import org.netbeans.jellytools.Bundle;
import org.netbeans.jellytools.OutputTabOperator;
import org.netbeans.modules.jmx.test.helpers.JMXTestCase;

/**
 * Starting class for jconsole tests.
 */
public class JConsoleTestCase extends JMXTestCase {

    private static final String stopActionName =
                   Bundle.getString("org.netbeans.modules.extexecution.Bundle",
                                    "Stop");

    /** Need to be defined because of JUnit */
    public JConsoleTestCase(String name) {
        super(name);
    }

    protected OutputTabOperator checkOutputTabOperator(String title, String text) {

        OutputTabOperator oto = null;

        int maxToWait = 10;
        while (maxToWait > 0) {
            try {
                System.out.println("Waiting for OutputTabOperator " + title);
                oto = new OutputTabOperator(title);
                System.out.println("(OK) Displayed OutputTabOperator " + title);
                break;
            } catch (Exception e) {
                System.out.println("OutputTabOperator " + title + " not yet displayed");
                System.out.println(e.toString());
                maxToWait--;
            }
        }

        maxToWait = 10;
        while (maxToWait > 0) {
            try {
                System.out.println("Waiting for text " + text);
                oto.waitText(text);
                System.out.println("(OK) Displayed text " + text);
                break;
            } catch (Exception e) {
                System.out.println("Text " + text + " not yet displayed");
                System.out.println(e.toString());
                maxToWait--;
            }
        }
        return oto;
    }

    protected void terminateProcess(OutputTabOperator oto) {

        //Little tempo to kill once stabilized state
        sleep(2000);
        AbstractOutputTab tab = (AbstractOutputTab)oto.getSource();
        for (Action a : tab.getToolbarActions()) {
            if (stopActionName.equals(a.getValue(Action.SHORT_DESCRIPTION))) {
                a.actionPerformed(null);
                break;
            }
        }
    }
}