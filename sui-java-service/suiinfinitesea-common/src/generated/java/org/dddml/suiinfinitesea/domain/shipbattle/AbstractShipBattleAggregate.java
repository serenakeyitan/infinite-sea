// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.shipbattle;

import java.util.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;

public abstract class AbstractShipBattleAggregate extends AbstractAggregate implements ShipBattleAggregate {
    private ShipBattleState.MutableShipBattleState state;

    private List<Event> changes = new ArrayList<Event>();

    public AbstractShipBattleAggregate(ShipBattleState state) {
        this.state = (ShipBattleState.MutableShipBattleState)state;
    }

    public ShipBattleState getState() {
        return this.state;
    }

    public List<Event> getChanges() {
        return this.changes;
    }

    public void throwOnInvalidStateTransition(Command c) {
        ShipBattleCommand.throwOnInvalidStateTransition(this.state, c);
    }

    protected void apply(Event e) {
        onApplying(e);
        state.mutate(e);
        changes.add(e);
    }


    ////////////////////////

    public static class SimpleShipBattleAggregate extends AbstractShipBattleAggregate {
        public SimpleShipBattleAggregate(ShipBattleState state) {
            super(state);
        }

        @Override
        public void initiateBattle(RosterId initiator, RosterId responder, String clock, Long offChainVersion, String commandId, String requesterId, ShipBattleCommands.InitiateBattle c) {
            java.util.function.Supplier<ShipBattleEvent.ShipBattleInitiated> eventFactory = () -> newShipBattleInitiated(initiator, responder, clock, offChainVersion, commandId, requesterId);
            ShipBattleEvent.ShipBattleInitiated e;
            try {
                e = verifyInitiateBattle(eventFactory, initiator, responder, c);
            } catch (Exception ex) {
                throw new DomainError("VerificationFailed", ex);
            }

            apply(e);
        }

        protected ShipBattleEvent.ShipBattleInitiated verifyInitiateBattle(java.util.function.Supplier<ShipBattleEvent.ShipBattleInitiated> eventFactory, RosterId initiator, RosterId responder, ShipBattleCommands.InitiateBattle c) {
            RosterId Initiator = initiator;
            RosterId Responder = responder;

            ShipBattleEvent.ShipBattleInitiated e = (ShipBattleEvent.ShipBattleInitiated) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.shipbattle.InitiateBattleLogic",
                    "verify",
                    new Class[]{java.util.function.Supplier.class, ShipBattleState.class, VerificationContext.class},
                    new Object[]{eventFactory, getState(), initiator, responder, VerificationContext.forCommand(c)}
            );

//package org.dddml.suiinfinitesea.domain.shipbattle;
//
//public class InitiateBattleLogic {
//    public static ShipBattleEvent.ShipBattleInitiated verify(java.util.function.Supplier<ShipBattleEvent.ShipBattleInitiated> eventFactory, ShipBattleState shipBattleState, RosterId initiator, RosterId responder, VerificationContext verificationContext) {
//    }
//}

            return e;
        }
           

        protected AbstractShipBattleEvent.ShipBattleInitiated newShipBattleInitiated(RosterId initiator, RosterId responder, String clock, Long offChainVersion, String commandId, String requesterId) {
            ShipBattleEventId eventId = new ShipBattleEventId(getState().getId(), null);
            AbstractShipBattleEvent.ShipBattleInitiated e = new AbstractShipBattleEvent.ShipBattleInitiated();

            e.setInitiatorId(null);
            e.setResponderId(null);
            e.setStartedAt(null);
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

            e.setShipBattleEventId(eventId);
            return e;
        }

    }

}

