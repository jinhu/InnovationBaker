package dev.chimera.innovation

import android.content.Context

class BakerActivitySpec extends UnitSpec {

  it should "have default value when Uninitialized" in {
    var activity = new BakerActivity(mock[Context])
    activity should not be (null)
  }

  //	public void testGetInitializedValue() {
  //		PowerMeasurement measurement = new PowerMeasurement();
  //		measurement.setChannel(7);
  //		measurement.setMacAddress("asdasd");
  //		List<Integer> powerData = new ArrayList<Integer>();
  //		powerData.add(8);
  //		measurement.setPowerDatas(powerData);
  //		measurement.setTimestamp(1234l);
  //
  //		assertEquals(7, measurement.getChannel());
  //		assertEquals("asdasd", measurement.getMacAddress());
  //		assertEquals(8, powerData.get(0).intValue());
  //		assertEquals(1234l, measurement.getTimestamp());
  //	}
}