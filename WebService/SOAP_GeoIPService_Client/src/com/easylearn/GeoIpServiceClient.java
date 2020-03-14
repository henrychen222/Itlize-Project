package com.easylearn;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class GeoIpServiceClient {

	public static void main(String[] args) throws JAXBException {
		
		GeoIPService service = new GeoIPService();
		
		GeoIPServiceSoap serviceEndpoint = service.getGeoIPServiceSoap();
		
		 System.out.println("************** Amazon : 54.239.26.128 ********************");
		 GeoIP geoIP = serviceEndpoint.getGeoIP("54.239.26.128");		 
		 System.out.println(geoIP);
		 //javaToXml(geoIP);
		 
		 System.out.println("************** BBC : 123.176.40.70 ********************");
		 geoIP = serviceEndpoint.getGeoIP("123.176.40.70");		 
		 System.out.println(geoIP);
		 //javaToXml(geoIP);

	}
	
	public static void javaToXml(GeoIP geoIP) throws JAXBException{
		JAXBContext jaxbContext = JAXBContext.newInstance(GeoIP.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(geoIP, System.out); //Generates XML Message
	}
	
	

}
