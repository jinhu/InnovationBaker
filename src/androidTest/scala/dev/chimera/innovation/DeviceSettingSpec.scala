package dev.chimera.innovation

/**
 * Created by jin on 3/16/15.
 */
class DeviceSettingSpec extends UnitSpec {

  var mSetting = new DeviceSetting

  it should "contain null object on init" in {
    mSetting.paramSet should be(null)
    mSetting.context should be(null)
    mSetting.activity should be(null)
  }
}
