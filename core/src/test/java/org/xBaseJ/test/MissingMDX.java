/**
 * xBaseJ - Java access to dBase files
 *<p>Copyright 1997-2014 - American Coders, LTD  - Raleigh NC USA
 *<p>All rights reserved
 *<p>Currently supports only dBase III format DBF, DBT and NDX files
 *<p>                        dBase IV format DBF, DBT, MDX and NDX files
 *<p>American Coders, Ltd
 *<br>P. O. Box 97462
 *<br>Raleigh, NC  27615  USA
 *<br>1-919-846-2014
 *<br>http://www.americancoders.com
@author Joe McVerry, American Coders Ltd.
@Version 20140310
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library Lesser General Public
 * License along with this library; if not, write to the Free
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package org.xBaseJ.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.xBaseJ.DBF;
import org.xBaseJ.DBFTypes;
import org.xBaseJ.Util;
import org.xBaseJ.xBaseJException;
import org.xBaseJ.fields.CharField;

import de.topobyte.system.utils.SystemPaths;
import junit.framework.TestCase;

public class MissingMDX extends TestCase
{

	public void testMissingMDX() throws xBaseJException, IOException
	{
		Util.setxBaseJProperty("ignoreMissingMDX", "");
		assertEquals(Util.getxBaseJProperty("ignoreMissingMDX"), "");

		Path dir = SystemPaths.CWD.resolve("../testfiles");
		Path testDbf = dir.resolve("test.dbf");
		Path testMdx = dir.resolve("test.mdx");

		Files.deleteIfExists(testDbf);
		Files.deleteIfExists(testMdx);

		DBF d = new DBF(testDbf.toString(), DBFTypes.DBASEIV, true);
		d.addField(new CharField("one", 10));
		d.close();
		Files.deleteIfExists(testMdx);
		try {
			d = new DBF(testDbf.toString());
			d.write();
			d.close();
		} catch (xBaseJException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testSetPropertyMissingMDXTrue()
			throws xBaseJException, IOException
	{
		Path dir = SystemPaths.CWD.resolve("../testfiles");
		Path testDbf = dir.resolve("test.dbf");
		Path testMdx = dir.resolve("test.mdx");

		Files.deleteIfExists(testDbf);
		Files.deleteIfExists(testMdx);
		DBF d = new DBF(testDbf.toString(), DBFTypes.DBASEIV, true);
		d.addField(new CharField("one", 10));
		d.close();
		Files.deleteIfExists(testMdx);
		try {
			Util.setxBaseJProperty("ignoreMissingMDX", "true");
			assertEquals(Util.getxBaseJProperty("ignoreMissingMDX"), "true");
			d = new DBF(testDbf.toString());
			d.write();
			d.close();
		} catch (xBaseJException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void testSetPropertyMissingMDXFalse()
			throws xBaseJException, IOException
	{
		Path dir = SystemPaths.CWD.resolve("../testfiles");
		Path testDbf = dir.resolve("test.dbf");
		Path testMdx = dir.resolve("test.mdx");

		Files.deleteIfExists(testDbf);
		Files.deleteIfExists(testMdx);
		DBF d = new DBF(testDbf.toString(), DBFTypes.DBASEIV, true);
		d.addField(new CharField("one", 10));
		d.close();
		Files.deleteIfExists(testMdx);
		try {
			Util.setxBaseJProperty("ignoreMissingMDX", "false");
			assertEquals(Util.getxBaseJProperty("ignoreMissingMDX"), "false");
			d = new DBF(testDbf.toString());
			d.write();
			d.close();
		} catch (xBaseJException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
