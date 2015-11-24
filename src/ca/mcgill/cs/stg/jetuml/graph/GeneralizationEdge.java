/*******************************************************************************
 * JetUML - A desktop application for fast UML diagramming.
 *
 * Copyright (C) 2015 by the contributors of the JetUML project.
 *
 * See: https://github.com/prmr/JetUML
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
 *******************************************************************************/

/**
 * @author Martin P. Robillard
 */

package ca.mcgill.cs.stg.jetuml.graph;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import ca.mcgill.cs.stg.jetuml.framework.ArrowHead;
import ca.mcgill.cs.stg.jetuml.framework.BentStyle;
import ca.mcgill.cs.stg.jetuml.framework.LineStyle;

/**
 *  An edge that that represents a UML generalization (inheritance
 *  or implementation), with optional labels.
 */
public class GeneralizationEdge extends ClassRelationshipEdge2
{
	private boolean aImplementation = false;
	
	/**
	 * Creates a generalization edge by specifying if it 
	 * is an implementation edge.
	 * 
	 * @param pImplementation True if this represents interface implementation
	 */
	public GeneralizationEdge( boolean pImplementation )
	{
		aImplementation = pImplementation;
	}
	
	/**
	 * Creates an inheritance edge.
	 */
	public GeneralizationEdge()
	{}
	
	public boolean isImplementation()
	{
		return aImplementation;
	}
	
	public void setImplementation(boolean pImplementation)
	{
		aImplementation = pImplementation;
	}
	
	@Override
	protected ArrowHead obtainEndArrowHead()
	{
		return ArrowHead.TRIANGLE;
	}
	
	@Override
	protected LineStyle obtainLineStyle()
	{
		if( aImplementation )
		{
			return LineStyle.DOTTED;
		}
		else
		{
			return LineStyle.SOLID;
		}
	}
	
	@Override
	public ArrayList<Point2D> getPoints()
	{
		return BentStyle.VHV.getPath(getStart().getBounds(), getEnd().getBounds());
   }
}