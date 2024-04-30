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

public abstract class AbstractRosterAggregate extends AbstractAggregate implements RosterAggregate {
    private RosterState.MutableRosterState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractRosterAggregate(RosterState state) {
        this.state = (RosterState.MutableRosterState)state;
    }

    public RosterState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        RosterCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimpleRosterAggregate extends AbstractRosterAggregate {
        public SimpleRosterAggregate(RosterState state) {
            super(state);
        }

        @Override
        public void create(Integer status, Long speed, Coordinates updatedCoordinates, BigInteger coordinatesUpdatedAt, Coordinates targetCoordinates, String shipBattleId, Long offChainVersion, String commandId, String requesterId, RosterCommands.Create c) {
            java.util.function.Supplier<RosterEvent.RosterCreated> eventFactory = () -> newRosterCreated(status, speed, updatedCoordinates, coordinatesUpdatedAt, targetCoordinates, shipBattleId, offChainVersion, commandId, requesterId);
            RosterEvent.RosterCreated e;
            try {
                e = verifyCreate(eventFactory, status, speed, updatedCoordinates, coordinatesUpdatedAt, targetCoordinates, shipBattleId, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void addShip(String ship, BigInteger position, Long offChainVersion, String commandId, String requesterId, RosterCommands.AddShip c) {
            java.util.function.Supplier<RosterEvent.RosterShipAdded> eventFactory = () -> newRosterShipAdded(ship, position, offChainVersion, commandId, requesterId);
            RosterEvent.RosterShipAdded e;
            try {
                e = verifyAddShip(eventFactory, ship, position, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void setSail(Coordinates targetCoordinates, String clock, Long offChainVersion, String commandId, String requesterId, RosterCommands.SetSail c) {
            java.util.function.Supplier<RosterEvent.RosterSetSail> eventFactory = () -> newRosterSetSail(targetCoordinates, clock, offChainVersion, commandId, requesterId);
            RosterEvent.RosterSetSail e;
            try {
                e = verifySetSail(eventFactory, targetCoordinates, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        @Override
        public void updateLocation(String clock, Long offChainVersion, String commandId, String requesterId, RosterCommands.UpdateLocation c) {
            java.util.function.Supplier<RosterEvent.RosterLocationUpdated> eventFactory = () -> newRosterLocationUpdated(clock, offChainVersion, commandId, requesterId);
            RosterEvent.RosterLocationUpdated e;
            try {
                e = verifyUpdateLocation(eventFactory, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        protected RosterEvent.RosterCreated verifyCreate(java.util.function.Supplier<RosterEvent.RosterCreated> eventFactory, Integer status, Long speed, Coordinates updatedCoordinates, BigInteger coordinatesUpdatedAt, Coordinates targetCoordinates, String shipBattleId, RosterCommands.Create c) {
            Integer Status = status;
            Long Speed = speed;
            Coordinates UpdatedCoordinates = updatedCoordinates;
            BigInteger CoordinatesUpdatedAt = coordinatesUpdatedAt;
            Coordinates TargetCoordinates = targetCoordinates;
            String ShipBattleId = shipBattleId;

            RosterEvent.RosterCreated e = (RosterEvent.RosterCreated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.roster.CreateLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, Integer.class, Long.class, Coordinates.class, BigInteger.class, Coordinates.class, String.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), status, speed, updatedCoordinates, coordinatesUpdatedAt, targetCoordinates, shipBattleId, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.roster;
//
//public class CreateLogic {
//    public static RosterEvent.RosterCreated verify(java.util.function.Supplier<RosterEvent.RosterCreated> eventFactory, RosterState rosterState, Integer status, Long speed, Coordinates updatedCoordinates, BigInteger coordinatesUpdatedAt, Coordinates targetCoordinates, String shipBattleId, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected RosterEvent.RosterShipAdded verifyAddShip(java.util.function.Supplier<RosterEvent.RosterShipAdded> eventFactory, String ship, BigInteger position, RosterCommands.AddShip c) {
            String Ship = ship;
            BigInteger Position = position;

            RosterEvent.RosterShipAdded e = (RosterEvent.RosterShipAdded) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.roster.AddShipLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, String.class, BigInteger.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), ship, position, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.roster;
//
//public class AddShipLogic {
//    public static RosterEvent.RosterShipAdded verify(java.util.function.Supplier<RosterEvent.RosterShipAdded> eventFactory, RosterState rosterState, String ship, BigInteger position, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected RosterEvent.RosterSetSail verifySetSail(java.util.function.Supplier<RosterEvent.RosterSetSail> eventFactory, Coordinates targetCoordinates, RosterCommands.SetSail c) {
            Coordinates TargetCoordinates = targetCoordinates;

            RosterEvent.RosterSetSail e = (RosterEvent.RosterSetSail) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.roster.SetSailLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, Coordinates.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), targetCoordinates, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.roster;
//
//public class SetSailLogic {
//    public static RosterEvent.RosterSetSail verify(java.util.function.Supplier<RosterEvent.RosterSetSail> eventFactory, RosterState rosterState, Coordinates targetCoordinates, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected RosterEvent.RosterLocationUpdated verifyUpdateLocation(java.util.function.Supplier<RosterEvent.RosterLocationUpdated> eventFactory, RosterCommands.UpdateLocation c) {

            RosterEvent.RosterLocationUpdated e = (RosterEvent.RosterLocationUpdated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.roster.UpdateLocationLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, RosterState.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.roster;
//
//public class UpdateLocationLogic {
//    public static RosterEvent.RosterLocationUpdated verify(java.util.function.Supplier<RosterEvent.RosterLocationUpdated> eventFactory, RosterState rosterState, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected AbstractRosterEvent.RosterCreated newRosterCreated(Integer status, Long speed, Coordinates updatedCoordinates, BigInteger coordinatesUpdatedAt, Coordinates targetCoordinates, String shipBattleId, Long offChainVersion, String commandId, String requesterId) {
            RosterEventId eventId = new RosterEventId(getState().getRosterId(), null);
            AbstractRosterEvent.RosterCreated e = new AbstractRosterEvent.RosterCreated();

            e.setStatus(status);
            e.setSpeed(speed);
            e.setUpdatedCoordinates(updatedCoordinates);
            e.setCoordinatesUpdatedAt(coordinatesUpdatedAt);
            e.setTargetCoordinates(targetCoordinates);
            e.setShipBattleId(shipBattleId);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setRosterEventId(eventId);
            return e;
        }

        protected AbstractRosterEvent.RosterShipAdded newRosterShipAdded(String ship, BigInteger position, Long offChainVersion, String commandId, String requesterId) {
            RosterEventId eventId = new RosterEventId(getState().getRosterId(), null);
            AbstractRosterEvent.RosterShipAdded e = new AbstractRosterEvent.RosterShipAdded();

            e.setShip(ship);
            e.setPosition(position);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setRosterEventId(eventId);
            return e;
        }

        protected AbstractRosterEvent.RosterSetSail newRosterSetSail(Coordinates targetCoordinates, String clock, Long offChainVersion, String commandId, String requesterId) {
            RosterEventId eventId = new RosterEventId(getState().getRosterId(), null);
            AbstractRosterEvent.RosterSetSail e = new AbstractRosterEvent.RosterSetSail();

            e.setTargetCoordinates(targetCoordinates);
            e.setSetSailAt(null);
            e.setUpdatedCoordinates(null);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setRosterEventId(eventId);
            return e;
        }

        protected AbstractRosterEvent.RosterLocationUpdated newRosterLocationUpdated(String clock, Long offChainVersion, String commandId, String requesterId) {
            RosterEventId eventId = new RosterEventId(getState().getRosterId(), null);
            AbstractRosterEvent.RosterLocationUpdated e = new AbstractRosterEvent.RosterLocationUpdated();

            e.setUpdatedCoordinates(null);
            e.setCoordinatesUpdatedAt(null);
            e.setNewStatus(null);
            e.setSuiTimestamp(null);
            e.setSuiTxDigest(null);
            e.setSuiEventSeq(null);
            e.setSuiPackageId(null);
            e.setSuiTransactionModule(null);
            e.setSuiSender(null);
            e.setSuiType(null);
            e.setEventStatus(null);

            e.setCommandId(commandId);
            e.setCreatedBy(requesterId);
            e.setCreatedAt((java.util.Date)ApplicationContext.current.getTimestampService().now(java.util.Date.class));

            e.setRosterEventId(eventId);
            return e;
        }

    }

}
