// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.dddml.suiinfinitesea.sui.contract.*;

import java.math.*;
import java.util.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class IslandAdded {
    private String id;

    private BigInteger version;

    private CoordinatesForEvent coordinates;

    private ItemIdQuantityPairsForEvent resources;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public CoordinatesForEvent getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(CoordinatesForEvent coordinates) {
        this.coordinates = coordinates;
    }

    public ItemIdQuantityPairsForEvent getResources() {
        return resources;
    }

    public void setResources(ItemIdQuantityPairsForEvent resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "IslandAdded{" +
                "id=" + '\'' + id + '\'' +
                ", version=" + version +
                ", coordinates=" + coordinates +
                ", resources=" + resources +
                '}';
    }

}