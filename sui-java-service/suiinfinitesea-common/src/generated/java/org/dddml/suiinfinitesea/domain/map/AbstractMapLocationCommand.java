// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.map;

import java.util.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.AbstractCommand;

public abstract class AbstractMapLocationCommand extends AbstractCommand implements MapLocationCommand {

    private Coordinates coordinates;

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    private String mapId;

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }


}

