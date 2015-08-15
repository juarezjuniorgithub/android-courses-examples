package com.juarezjunior.maps;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.juarezjunior.maps.R;

public class MapsActivity extends MapActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		MapView mapView = (MapView) findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);

		// mapView.setSatellite(true); // Satellite View
		// mapView.setStreetView(true); // Street View
		// mapView.setTraffic(true); // Traffic view

		MapController mc = mapView.getController();
		double lat = Double.parseDouble("48.85827758964043");
		double lon = Double.parseDouble("2.294543981552124");
		GeoPoint geoPoint = new GeoPoint((int) (lat * 1E6), (int) (lon * 1E6));
		mc.animateTo(geoPoint);
		mc.setZoom(15);
		mapView.invalidate();

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources()
				.getDrawable(R.drawable.mark_red);
		AddItemizedOverlay itemizedOverlay = new AddItemizedOverlay(drawable,
				this);

		OverlayItem overlayitem = new OverlayItem(geoPoint, "Overlay",
				"Simple Overlay Item");

		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);

	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}