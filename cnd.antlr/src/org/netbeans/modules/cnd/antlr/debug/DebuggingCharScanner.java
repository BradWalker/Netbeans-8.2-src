/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
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
 *
 * Contributor(s):
 *
 * Portions Copyrighted 2016 Sun Microsystems, Inc.
 */
package org.netbeans.modules.cnd.antlr.debug;

import org.netbeans.modules.cnd.antlr.*;
import org.netbeans.modules.cnd.antlr.collections.*;
import org.netbeans.modules.cnd.antlr.collections.impl.*;
import java.io.*;

public abstract class DebuggingCharScanner extends CharScanner implements DebuggingParser {
	private ParserEventSupport parserEventSupport = new ParserEventSupport(this);
	private boolean _notDebugMode = false;
	protected String ruleNames[];
	protected String semPredNames[];


	public DebuggingCharScanner(InputBuffer cb) {
		super(cb);
	}
	public void addMessageListener(MessageListener l) {
		parserEventSupport.addMessageListener(l);
	}
	public void addNewLineListener(NewLineListener l) {
		parserEventSupport.addNewLineListener(l);
	}
	public void addParserListener(ParserListener l) {
		parserEventSupport.addParserListener(l);
	}
	public void addParserMatchListener(ParserMatchListener l) {
		parserEventSupport.addParserMatchListener(l);
	}
	public void addParserTokenListener(ParserTokenListener l) {
		parserEventSupport.addParserTokenListener(l);
	}
	public void addSemanticPredicateListener(SemanticPredicateListener l) {
		parserEventSupport.addSemanticPredicateListener(l);
	}
	public void addSyntacticPredicateListener(SyntacticPredicateListener l) {
		parserEventSupport.addSyntacticPredicateListener(l);
	}
	public void addTraceListener(TraceListener l) {
		parserEventSupport.addTraceListener(l);
	}
	public void consume() {
		int la_1 = -99;
                //try
		la_1 = LA(1);
		//catch (CharStreamException ignoreAnIOException) {}
		super.consume();
		parserEventSupport.fireConsume(la_1);		
	}
	protected void fireEnterRule(int num, int data) {
		if (isDebugMode())
			parserEventSupport.fireEnterRule(num,guessing,data);
	}
	protected void fireExitRule(int num, int ttype) {
		if (isDebugMode())
			parserEventSupport.fireExitRule(num,guessing, ttype);
	}
	protected boolean fireSemanticPredicateEvaluated(int type, int num, boolean condition) {
		if (isDebugMode())
			return parserEventSupport.fireSemanticPredicateEvaluated(type,num,condition,guessing);
		else
			return condition;
	}
	protected void fireSyntacticPredicateFailed() {
		if (isDebugMode())
			parserEventSupport.fireSyntacticPredicateFailed(guessing);
	}
	protected void fireSyntacticPredicateStarted() {
		if (isDebugMode())
			parserEventSupport.fireSyntacticPredicateStarted(guessing);
	}
	protected void fireSyntacticPredicateSucceeded() {
		if (isDebugMode())
			parserEventSupport.fireSyntacticPredicateSucceeded(guessing);
	}
	public String getRuleName(int num) {
		return ruleNames[num];
	}
	public String getSemPredName(int num) {
		return semPredNames[num];
	}
	public synchronized void goToSleep() {
		try {wait();}
		catch (InterruptedException e) {	}		
	}
	public boolean isDebugMode() {
		return !_notDebugMode;
	}
	public char LA(int i) {
		char la = super.LA(i);
		parserEventSupport.fireLA(i, la);
		return la;
	}
	protected Token makeToken(int t) {
		// do something with char buffer???
//		try {
//			Token tok = (Token)tokenObjectClass.newInstance();
//			tok.setType(t);
//			// tok.setText(getText()); done in generated lexer now
//			tok.setLine(line);
//			return tok;
//		}
//		catch (InstantiationException ie) {
//			panic("can't instantiate a Token");
//		}
//		catch (IllegalAccessException iae) {
//			panic("Token class is not accessible");
//		}
		return super.makeToken(t);
	}
	public void match(char c) throws MismatchedCharException {
		char la_1 = LA(1);
		try {
			super.match(c);
			parserEventSupport.fireMatch(c, guessing);
		}
		catch (MismatchedCharException e) {
			if (guessing == 0)
				parserEventSupport.fireMismatch(la_1, c, guessing);
			throw e;
		}
	}
	public void match(BitSet b) throws MismatchedCharException {
		String text = this.text.toString();
		char la_1 = LA(1);
		try {
			super.match(b);
			parserEventSupport.fireMatch(la_1, b, text, guessing);
		}
		catch (MismatchedCharException e) {
			if (guessing == 0)
				parserEventSupport.fireMismatch(la_1, b, text, guessing);
			throw e;
		}
	}
	public void match(String s) throws MismatchedCharException {
		StringBuffer la_s = new StringBuffer("");
		int len = s.length();
		// peek at the next len worth of characters
		try {
			for(int i = 1; i <= len; i++) {
				la_s.append(super.LA(i));
			}
		}
		catch(Exception ignoreMe) {}

		try {
			super.match(s);
			parserEventSupport.fireMatch(s, guessing);
		}
		catch (MismatchedCharException e) {
			if (guessing == 0)
				parserEventSupport.fireMismatch(la_s.toString(), s, guessing);
			throw e;
		}

	}
	public void matchNot(char c) throws MismatchedCharException {
		char la_1 = LA(1);
		try {
			super.matchNot(c);
			parserEventSupport.fireMatchNot(la_1, c, guessing);
		}
		catch (MismatchedCharException e) {
			if (guessing == 0)
				parserEventSupport.fireMismatchNot(la_1, c, guessing);
			throw e;
		}

	}
	public void matchRange(char c1, char c2) throws MismatchedCharException {
		char la_1 = LA(1);
		try {
			super.matchRange(c1,c2);
			parserEventSupport.fireMatch(la_1, ""+c1+c2, guessing);
		}
		catch (MismatchedCharException e) {
			if (guessing == 0)
				parserEventSupport.fireMismatch(la_1, ""+c1+c2, guessing);
			throw e;
		}

	}
	public void newline() {
		super.newline();
		parserEventSupport.fireNewLine(getLine());
	}
	public void removeMessageListener(MessageListener l) {
		parserEventSupport.removeMessageListener(l);
	}
	public void removeNewLineListener(NewLineListener l) {
		parserEventSupport.removeNewLineListener(l);
	}
	public void removeParserListener(ParserListener l) {
		parserEventSupport.removeParserListener(l);
	}
	public void removeParserMatchListener(ParserMatchListener l) {
		parserEventSupport.removeParserMatchListener(l);
	}
	public void removeParserTokenListener(ParserTokenListener l) {
		parserEventSupport.removeParserTokenListener(l);
	}
	public void removeSemanticPredicateListener(SemanticPredicateListener l) {
		parserEventSupport.removeSemanticPredicateListener(l);
	}
	public void removeSyntacticPredicateListener(SyntacticPredicateListener l) {
		parserEventSupport.removeSyntacticPredicateListener(l);
	}
	public void removeTraceListener(TraceListener l) {	
		parserEventSupport.removeTraceListener(l);
	}
	/** Report exception errors caught in nextToken() */
	public void reportError(MismatchedCharException e) {
		parserEventSupport.fireReportError(e);
		super.reportError(e);
	}
	/** Parser error-reporting function can be overridden in subclass */
	public void reportError(String s) {
		parserEventSupport.fireReportError(s);
		super.reportError(s);
	}
	/** Parser warning-reporting function can be overridden in subclass */
	public void reportWarning(String s) {
		parserEventSupport.fireReportWarning(s);
		super.reportWarning(s);
	}
	public void setDebugMode(boolean value) {
		_notDebugMode = !value;
	}
	public void setupDebugging() {
	}
	public synchronized void wakeUp() {
		notify();
	}
}