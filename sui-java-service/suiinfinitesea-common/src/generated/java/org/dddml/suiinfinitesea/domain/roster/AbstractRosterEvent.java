// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.roster;

import java.util.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.AbstractEvent;

public abstract class AbstractRosterEvent extends AbstractEvent implements RosterEvent.SqlRosterEvent, SuiEventEnvelope.MutableSuiEventEnvelope, SuiMoveEvent.MutableSuiMoveEvent, HasEventStatus.MutableHasEventStatus {
    private RosterEventId rosterEventId = new RosterEventId();

    public RosterEventId getRosterEventId() {
        return this.rosterEventId;
    }

    public void setRosterEventId(RosterEventId eventId) {
        this.rosterEventId = eventId;
    }
    
    public RosterId getRosterId() {
        return getRosterEventId().getRosterId();
    }

    public void setRosterId(RosterId rosterId) {
        getRosterEventId().setRosterId(rosterId);
    }

    private boolean eventReadOnly;

    public boolean getEventReadOnly() { return this.eventReadOnly; }

    public void setEventReadOnly(boolean readOnly) { this.eventReadOnly = readOnly; }

    public BigInteger getVersion() {
        return getRosterEventId().getVersion();
    }
    
    public void setVersion(BigInteger version) {
        getRosterEventId().setVersion(version);
    }

    private String id_;

    public String getId_() {
        return this.id_;
    }
    
    public void setId_(String id) {
        this.id_ = id;
    }

    private Long suiTimestamp;

    public Long getSuiTimestamp() {
        return this.suiTimestamp;
    }
    
    public void setSuiTimestamp(Long suiTimestamp) {
        this.suiTimestamp = suiTimestamp;
    }

    private String suiTxDigest;

    public String getSuiTxDigest() {
        return this.suiTxDigest;
    }
    
    public void setSuiTxDigest(String suiTxDigest) {
        this.suiTxDigest = suiTxDigest;
    }

    private BigInteger suiEventSeq;

    public BigInteger getSuiEventSeq() {
        return this.suiEventSeq;
    }
    
    public void setSuiEventSeq(BigInteger suiEventSeq) {
        this.suiEventSeq = suiEventSeq;
    }

    private String suiPackageId;

    public String getSuiPackageId() {
        return this.suiPackageId;
    }
    
    public void setSuiPackageId(String suiPackageId) {
        this.suiPackageId = suiPackageId;
    }

    private String suiTransactionModule;

    public String getSuiTransactionModule() {
        return this.suiTransactionModule;
    }
    
    public void setSuiTransactionModule(String suiTransactionModule) {
        this.suiTransactionModule = suiTransactionModule;
    }

    private String suiSender;

    public String getSuiSender() {
        return this.suiSender;
    }
    
    public void setSuiSender(String suiSender) {
        this.suiSender = suiSender;
    }

    private String suiType;

    public String getSuiType() {
        return this.suiType;
    }
    
    public void setSuiType(String suiType) {
        this.suiType = suiType;
    }

    private String eventStatus;

    public String getEventStatus() {
        return this.eventStatus;
    }
    
    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    private String commandId;

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    private String commandType;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    protected AbstractRosterEvent() {
    }

    protected AbstractRosterEvent(RosterEventId eventId) {
        this.rosterEventId = eventId;
    }

    protected RosterShipsItemEventDao getRosterShipsItemEventDao() {
        return (RosterShipsItemEventDao)ApplicationContext.current.get("rosterShipsItemEventDao");
    }

    protected RosterShipsItemEventId newRosterShipsItemEventId(String key)
    {
        RosterShipsItemEventId eventId = new RosterShipsItemEventId(this.getRosterEventId().getRosterId(), 
            key, 
            this.getRosterEventId().getVersion());
        return eventId;
    }

    protected void throwOnInconsistentEventIds(RosterShipsItemEvent.SqlRosterShipsItemEvent e)
    {
        throwOnInconsistentEventIds(this, e);
    }

    public static void throwOnInconsistentEventIds(RosterEvent.SqlRosterEvent oe, RosterShipsItemEvent.SqlRosterShipsItemEvent e)
    {
        if (!oe.getRosterEventId().getRosterId().equals(e.getRosterShipsItemEventId().getRosterId()))
        { 
            throw DomainError.named("inconsistentEventIds", "Outer Id RosterId %1$s but inner id RosterId %2$s", 
                oe.getRosterEventId().getRosterId(), e.getRosterShipsItemEventId().getRosterId());
        }
    }


    public abstract String getEventType();

    public static class RosterClobEvent extends AbstractRosterEvent {

        protected Map<String, Object> getDynamicProperties() {
            return dynamicProperties;
        }

        protected void setDynamicProperties(Map<String, Object> dynamicProperties) {
            if (dynamicProperties == null) {
                throw new IllegalArgumentException("dynamicProperties is null.");
            }
            this.dynamicProperties = dynamicProperties;
        }

        private Map<String, Object> dynamicProperties = new HashMap<>();

        protected String getDynamicPropertiesLob() {
            return ApplicationContext.current.getClobConverter().toString(getDynamicProperties());
        }

        protected void setDynamicPropertiesLob(String text) {
            getDynamicProperties().clear();
            Map<String, Object> ps = ApplicationContext.current.getClobConverter().parseLobProperties(text);
            if (ps != null) {
                for (Map.Entry<String, Object> kv : ps.entrySet()) {
                    getDynamicProperties().put(kv.getKey(), kv.getValue());
                }
            }
        }

        @Override
        public String getEventType() {
            return "RosterClobEvent";
        }

    }

    public static class RosterCreated extends RosterClobEvent implements RosterEvent.RosterCreated {

        @Override
        public String getEventType() {
            return "RosterCreated";
        }

        public Integer getStatus() {
            Object val = getDynamicProperties().get("status");
            if (val instanceof Integer) {
                return (Integer) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Integer.class);
        }

        public void setStatus(Integer value) {
            getDynamicProperties().put("status", value);
        }

        public Long getSpeed() {
            Object val = getDynamicProperties().get("speed");
            if (val instanceof Long) {
                return (Long) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Long.class);
        }

        public void setSpeed(Long value) {
            getDynamicProperties().put("speed", value);
        }

        public Coordinates getUpdatedCoordinates() {
            Object val = getDynamicProperties().get("updatedCoordinates");
            if (val instanceof Coordinates) {
                return (Coordinates) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Coordinates.class);
        }

        public void setUpdatedCoordinates(Coordinates value) {
            getDynamicProperties().put("updatedCoordinates", value);
        }

        public BigInteger getCoordinatesUpdatedAt() {
            Object val = getDynamicProperties().get("coordinatesUpdatedAt");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCoordinatesUpdatedAt(BigInteger value) {
            getDynamicProperties().put("coordinatesUpdatedAt", value);
        }

        public Coordinates getTargetCoordinates() {
            Object val = getDynamicProperties().get("targetCoordinates");
            if (val instanceof Coordinates) {
                return (Coordinates) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Coordinates.class);
        }

        public void setTargetCoordinates(Coordinates value) {
            getDynamicProperties().put("targetCoordinates", value);
        }

        public String getShipBattleId() {
            Object val = getDynamicProperties().get("shipBattleId");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setShipBattleId(String value) {
            getDynamicProperties().put("shipBattleId", value);
        }

    }

    public static class RosterShipAdded extends RosterClobEvent implements RosterEvent.RosterShipAdded {

        @Override
        public String getEventType() {
            return "RosterShipAdded";
        }

        public String getShip() {
            Object val = getDynamicProperties().get("ship");
            if (val instanceof String) {
                return (String) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, String.class);
        }

        public void setShip(String value) {
            getDynamicProperties().put("ship", value);
        }

        public BigInteger getPosition() {
            Object val = getDynamicProperties().get("position");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setPosition(BigInteger value) {
            getDynamicProperties().put("position", value);
        }

    }

    public static class RosterSetSail extends RosterClobEvent implements RosterEvent.RosterSetSail {

        @Override
        public String getEventType() {
            return "RosterSetSail";
        }

        public Coordinates getTargetCoordinates() {
            Object val = getDynamicProperties().get("targetCoordinates");
            if (val instanceof Coordinates) {
                return (Coordinates) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Coordinates.class);
        }

        public void setTargetCoordinates(Coordinates value) {
            getDynamicProperties().put("targetCoordinates", value);
        }

        public BigInteger getSetSailAt() {
            Object val = getDynamicProperties().get("setSailAt");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setSetSailAt(BigInteger value) {
            getDynamicProperties().put("setSailAt", value);
        }

        public Coordinates getUpdatedCoordinates() {
            Object val = getDynamicProperties().get("updatedCoordinates");
            if (val instanceof Coordinates) {
                return (Coordinates) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Coordinates.class);
        }

        public void setUpdatedCoordinates(Coordinates value) {
            getDynamicProperties().put("updatedCoordinates", value);
        }

    }

    public static class RosterLocationUpdated extends RosterClobEvent implements RosterEvent.RosterLocationUpdated {

        @Override
        public String getEventType() {
            return "RosterLocationUpdated";
        }

        public Coordinates getUpdatedCoordinates() {
            Object val = getDynamicProperties().get("updatedCoordinates");
            if (val instanceof Coordinates) {
                return (Coordinates) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Coordinates.class);
        }

        public void setUpdatedCoordinates(Coordinates value) {
            getDynamicProperties().put("updatedCoordinates", value);
        }

        public BigInteger getCoordinatesUpdatedAt() {
            Object val = getDynamicProperties().get("coordinatesUpdatedAt");
            if (val instanceof BigInteger) {
                return (BigInteger) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, BigInteger.class);
        }

        public void setCoordinatesUpdatedAt(BigInteger value) {
            getDynamicProperties().put("coordinatesUpdatedAt", value);
        }

        public Integer getNewStatus() {
            Object val = getDynamicProperties().get("newStatus");
            if (val instanceof Integer) {
                return (Integer) val;
            }
            return ApplicationContext.current.getTypeConverter().convertValue(val, Integer.class);
        }

        public void setNewStatus(Integer value) {
            getDynamicProperties().put("newStatus", value);
        }

    }


}

