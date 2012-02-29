package lbe.engine;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import junit.framework.Assert;

import org.instantlogic.interaction.util.PageCoordinates;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;
import org.junit.Test;

public class PageCoordinatesTest extends Assert {

	@Test
	public void testParse() {
		PageCoordinates pageCoordinates = new PageCoordinates();
		assertEquals("", pageCoordinates.format());
		pageCoordinates.addCoordinate(new Coordinate("node1", Arrays.asList(new Long[]{})));
		assertEquals("node1", pageCoordinates.format());
		pageCoordinates.addCoordinate(new Coordinate("node2", Arrays.asList(new Long[]{12l, 21l})));
		assertEquals("node1.node2[12,21]", pageCoordinates.format());
		pageCoordinates = pageCoordinates.parse("node1.node2[12,21]");
		assertEquals(2, pageCoordinates.getPath().size());
		Coordinate coordinate = pageCoordinates.popCoordinate();
		assertEquals(2, coordinate.getActiveInstances().size());
	}

}
