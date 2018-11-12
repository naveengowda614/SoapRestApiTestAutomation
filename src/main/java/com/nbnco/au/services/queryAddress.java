package com.nbnco.au.services;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import java.io.File;

public class queryAddress {

    XmlPath responseXML = null;

    public queryAddress(XmlPath queryAddressResponse){
        responseXML = queryAddressResponse;
    }

    public queryAddress(File file){
        responseXML = new XmlPath(file);
    }

    public queryAddress(Response queryAddressResponse){
        responseXML = new XmlPath(queryAddressResponse.asString());
    }

    public String getLocationId(){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.ID").toString();
    }

    public boolean getLocationIdNode(){
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.ID.size()");
        return count > 0;
    }

    public boolean getActivityStatusNode(String status){
        return  responseXML.get("Envelope.Header.MessageHeader.activityStatus").toString().equals(status);
    }

    public String getIncorrectIdNode(){
        return  responseXML.get("Envelope.Body.Fault.detail.ValidationException.Exception.ID").toString();
    }

    public boolean getPhysicalAddressSecondaryComplexName()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.secondaryComplexName.size()");
        return count > 0;
    }

    public boolean getPhysicalAddressRoadNumber()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.roadNumber1.size()");
        return count > 0;
    }

    public boolean getPhysicalAddressRoadName()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.roadName.size()");
        return count > 0;
    }

    public boolean getPhysicalAddressRoadTypeCode()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.roadTypeCode.size()");
        return count > 0;
    }

    public boolean getPhysicalAddressLocalityName()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.localityName.size()");
        return count > 0;
    }

    public boolean getPhysicalAddressStateTerritoryCode()
    {
        int count = responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.stateTerritoryCode.size()");
        return count > 0;
    }

    public boolean getLevelNumberValue(String value){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.levelNumber").toString().equals(value);
    }

    public boolean getRoadNumber1Value(String value){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.roadNumber1").toString().equals(value);
    }

    public boolean getRoadNumber2Value(String value){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.roadNumber2").toString().equals(value);
    }

    public boolean getUnitNumberValue(String value){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.unitNumber").toString().equals(value);
    }

    public boolean getLotNumberValue(String value){
        return  responseXML.get("Envelope.Body.ManageAddressResponse.AddressSearch.AddressMatchComprisedOf.ItemInvolvesLocation.Place.PhysicalAddress.lotNumber").toString().equals(value);
    }
}
