package lbe.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageCoordinates {

	public static class Coordinate {
		
		private String nodeName;
		private List<Long> activeInstances;

		public Coordinate(String nodeName, List<Long> activeInstances) {
			this.nodeName = nodeName;
			if (activeInstances!=null) {
				this.activeInstances = activeInstances;
			} else {
				this.activeInstances = Collections.EMPTY_LIST;
			}
		}

		public String getNodeName() {
			return nodeName;
		}

		public List<Long> getActiveInstances() {
			return activeInstances;
		}
		
		@Override
		public String toString() {
			if (activeInstances.size()==0) {
				return nodeName;
			}
			StringBuilder sb = new StringBuilder(nodeName);
			sb.append('[');
			boolean first = true;
			for (Long activeInstance: activeInstances) {
				if (first) {
					first = false;
				} else {
					sb.append(',');
				}
				sb.append(activeInstance);
			}
			sb.append(']');
			return sb.toString();
		}
	}
	
	private static final Pattern coordinate = Pattern.compile("\\.?(\\w+)(\\[([\\d,]*)\\])?");
	
	public static PageCoordinates parse(String in) {
		PageCoordinates result = new PageCoordinates();
		Matcher matcher = coordinate.matcher(in);
		while (matcher.find()) {
			String nodeName = matcher.group(1);
			String indices = matcher.group(3);
			List<Long> activeInstances=null;
			if (indices!=null) {
				String[] split = indices.split(",");
				activeInstances = new ArrayList<Long>(split.length);
				for (String item:split) {
					activeInstances.add(Long.parseLong(item));
				}
			}
			result.addCoordinate(new Coordinate(nodeName, activeInstances));
		}
		return result;
	}

	private final List<Coordinate> path = new ArrayList<Coordinate>();
	
	public String format() {
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		for (Coordinate coordinate: path) {
			if (first) {
				first = false;
			} else {
				sb.append('.');
			}
			sb.append(coordinate);
		}
		return sb.toString();
	}

	public List<Coordinate> getPath() {
		return path;
	}
	
	public void addCoordinate(Coordinate coordinate) {
		path.add(coordinate);
	}
	
	public Coordinate popCoordinate() {
		return path.remove(path.size()-1);
	}
}
