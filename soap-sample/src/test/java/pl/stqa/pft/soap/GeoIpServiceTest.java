package pl.stqa.pft.soap;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {

@Test
  public void testMyIp(){


  Geo IP geoIP = new GeoIPService().getGeoIpServiceSoap12().getGeoIP("25.72.100.191");
  assertEquals(geoIP.getCountryCode(), "POL");
}

  @Test
  public void testMyIp(){


    Geo IP geoIP = new GeoIPService().getGeoIpServiceSoap12().getGeoIP("25.72.100.xxx");
    assertEquals(geoIP.getCountryCode(), "POL");
}
