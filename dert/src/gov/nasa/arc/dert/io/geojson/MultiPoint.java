package gov.nasa.arc.dert.io.geojson;

import gov.nasa.arc.dert.io.geojson.json.JsonObject;

/**
 * Provides a GeoJSON MultiPoint object.
 *
 */
public class MultiPoint extends Geometry {

	private double[][] coordinate;

	/**
	 * Constructor
	 * 
	 * @param jsonObject
	 */
	public MultiPoint(JsonObject jsonObject, CoordinateReferenceSystem crs) {
		super(jsonObject, GeojsonType.MultiPoint);
		Object[] arrayN = jsonObject.getArray("coordinates");
		int n = arrayN.length;
		Object[] pos = (Object[])arrayN[0];
		int posLength = pos.length;
		coordinate = new double[n][posLength];
		for (int i = 0; i < n; ++i) {
			pos = (Object[])arrayN[i];
			for (int p = 0; p < posLength; ++p) {
				coordinate[i][p] = ((Double)pos[p]).doubleValue();
			}
			crs.translate(coordinate[i]);
		}
	}

	/**
	 * Get coordinates.
	 * 
	 * @return
	 */
	public double[][] getCoordinates() {
		return (coordinate);
	}

}
